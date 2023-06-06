import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class CardapioInterface extends JFrame {
    private Cardapio cardapio;
    private ArrayList <Item> itens;
    private BancoMesas bancoMesas;
    private BancoGarcom  bancoGarcom;
    private BancoPedidos bancoPedidos;
    
    public CardapioInterface(Cardapio cardapio, BancoMesas bancoMesas, BancoGarcom bancoGarcons, BancoPedidos bancoPedidos) {
        super("Cardápio");
        itens = new ArrayList<Item>();
        this.cardapio = cardapio;
        this.bancoMesas=bancoMesas;
        this.bancoGarcom = bancoGarcons;
        this.bancoPedidos=bancoPedidos;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Dimension maxSize = new Dimension(800, 800);
        
        setSize(maxSize);

        setPreferredSize(maxSize);

        setResizable(true);
        
        // Color cor = new Color (255,192,203);
        Color corTopo = new Color(173,216,230);
        Color corCorpo = new Color (245,255,250);
        
        JPanel topoPanel = new JPanel();
        topoPanel.setBackground(corTopo);

        JLabel topoLabel = new JLabel("Cardápio");
        topoLabel.setBorder(BorderFactory.createEmptyBorder(50,0,0,0));

        JPanel corpoPanel = new JPanel();
        corpoPanel.setSize(500, 500);
        corpoPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        corpoPanel.setBackground(corCorpo);
        
        JPanel rodapePanel = new JPanel();
        rodapePanel.setBackground(Color.RED);
        rodapePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        rodapePanel.setBackground(corCorpo);



        if (cardapio != null) {
            ArrayList<Item> opcoesCardapio = cardapio.getCardapio();
            for (Item item : opcoesCardapio) {
                JCheckBox checkBox = new JCheckBox(item.toString());
                checkBox.isBackgroundSet();
                checkBox.setBackground(corCorpo);
                checkBox.setAlignmentX(Component.CENTER_ALIGNMENT);
                checkBox.setBorder(BorderFactory.createEmptyBorder(50  ,50,50,50));
                checkBox.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        controlaPedido();
                    }
                    private void controlaPedido(){
                        if(checkBox.isSelected()){
                            CardapioInterface.this.itens.add(item);
                        }else{
                            CardapioInterface.this.itens.remove(item);
                        }
                    }
                });
                corpoPanel.add(checkBox);
            }
        }

        JButton voltaMenuButton = new JButton("Voltar Menu", null);
        voltaMenuButton.setBounds(20, 55, 220, 25);

        voltaMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardapioInterface.this.setVisible(false);
               
            }
        });

        JButton realizarPedidoButton = new JButton("Realizar Pedido", null);
        realizarPedidoButton.setBounds(20, 55, 220, 25);
        realizarPedidoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(CardapioInterface.this.getItens().size()==0){
                    JOptionPane.showMessageDialog(null, "Selecione as opções desejadas!");
                }
                else{
                    ConfirmarPedidoInterface confirmarPedidoInterface =  new ConfirmarPedidoInterface(CardapioInterface.this.getItens(), CardapioInterface.this.getBancoMesas(),
                    CardapioInterface.this.getBancoGarcom(), CardapioInterface.this.getBancoPedidos());
                    System.out.println("todos os itens"+CardapioInterface.this.getItens().toString());
                    confirmarPedidoInterface.setVisible(true);
               
                }
            }
        });

        realizarPedidoButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                for(Item i: CardapioInterface.this.getItens()){
                    System.out.println(i.getDescribe());
                }
            }
        });

        topoPanel.add(topoLabel);
        rodapePanel.add(voltaMenuButton);
        rodapePanel.add(realizarPedidoButton);
        
        

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(topoPanel, BorderLayout.NORTH);
        getContentPane().add(corpoPanel, BorderLayout.CENTER);
        getContentPane().add(rodapePanel, BorderLayout.SOUTH);


        setLocationRelativeTo(null);
        setVisible(true);
    }
    public ArrayList<Item> getItens(){
        return this.itens;
    }

    public void setItens(ArrayList<Item> itens){
        this.itens=itens;
    }

    public Cardapio getCardapio(){
        return this.cardapio;
    }

    public BancoMesas getBancoMesas(){
        return this.bancoMesas;
    }

    public BancoGarcom getBancoGarcom(){
        return this.bancoGarcom;
    }
    public BancoPedidos getBancoPedidos(){
        return this.bancoPedidos;
    }
}
