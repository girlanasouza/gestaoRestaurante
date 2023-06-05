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
        super("Realizar Pedido");
        itens = new ArrayList<Item>();
        this.cardapio = cardapio;
        this.bancoMesas=bancoMesas;
        this.bancoGarcom = bancoGarcons;
        this.bancoPedidos=bancoPedidos;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Dimension maxSize = new Dimension(500, 800);
        
        setSize(maxSize);

        setPreferredSize(maxSize);

        setResizable(true);
        
        Color cor = new Color (255,192,203);

        JPanel principal = new JPanel();
        principal.setSize(500, 500);
        principal.setLayout((new BoxLayout(principal, BoxLayout.Y_AXIS)));

        JLabel title = new JLabel("Cardápio");
        title.setBorder(BorderFactory.createEmptyBorder(50,0,0,0));

        JPanel painelCardapio = new JPanel();
        painelCardapio.setBackground(Color.BLUE);
        painelCardapio.add(title, BorderLayout.CENTER);
        painelCardapio.add(title);

        JPanel panelEsquerda = new JPanel();
        panelEsquerda.setBackground(cor);
        panelEsquerda.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JLabel labelEsquerda = new JLabel("Área Esquerda");
        labelEsquerda.setHorizontalAlignment(SwingConstants.CENTER);
        panelEsquerda.add(labelEsquerda, BorderLayout.CENTER);
        

        JPanel panelDireita = new JPanel();
        panelDireita.setBackground(cor);
        panelDireita.setLayout(new BorderLayout());

        JLabel labelDireita = new JLabel("Área Direita");
        labelDireita.setHorizontalAlignment(SwingConstants.CENTER);
        panelDireita.add(labelDireita, BorderLayout.CENTER);
        

        JPanel panelMeio = new JPanel();
        panelMeio.setBackground(cor);
        panelMeio.setLayout(new BoxLayout(panelMeio, BoxLayout.Y_AXIS));

        if (cardapio != null) {
            ArrayList<Item> opcoesCardapio = cardapio.getCardapio();
            for (Item item : opcoesCardapio) {
                JCheckBox checkBox = new JCheckBox(item.getDescribe());
                checkBox.isBackgroundSet();
                checkBox.setAlignmentX(Component.CENTER_ALIGNMENT);
                checkBox.setBorder(BorderFactory.createEmptyBorder(50  ,50,50,50));
                checkBox.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        controlaPedido();
                    }
                    private void controlaPedido(){
                        if(checkBox.isSelected()){
                            CardapioInterface.this.getItens().add(item);
                        }else{
                            CardapioInterface.this.getItens().remove(item);
                        }
                    }
                });
                panelMeio.add(checkBox);
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

        
        principal.add(painelCardapio);
        principal.add(panelMeio);
        panelEsquerda.add(voltaMenuButton);
        panelEsquerda.add(realizarPedidoButton);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(painelCardapio, BorderLayout.NORTH);
        getContentPane().add(principal, BorderLayout.CENTER);
        getContentPane().add(panelEsquerda, BorderLayout.SOUTH);

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
