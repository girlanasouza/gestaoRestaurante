import java.util.ArrayList;

public class Cardapio {
	ArrayList <Item> cardapio = new ArrayList<Item>();
	
	public boolean addItem(Item item) {
		if(!cardapio.contains(item)) {
			cardapio.add(item);
			return true;
		}
		return false;
	}

	public ArrayList<Item> getCardapio() {
		return cardapio;
	}
	
	public boolean removeItem(Item item) {
		if(!cardapio.contains(item)) {
			return false;
		}
		else {
			cardapio.remove(item);
		}

		return true;
	}
	
    public String describeMenu(){
        String retorno = "";

        for (Item item:cardapio){
            retorno = retorno + item.toString() + "\n";

        }

        return retorno;
    }

	
	


}
