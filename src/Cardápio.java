import java.util.ArrayList;

public class Cardápio {
	ArrayList <Item> cardapio = new ArrayList<Item>();
	
	public boolean addItem(Item item) {
		if(!cardapio.contains(item)) {
			cardapio.add(item);
			return true;
		}
		return false;
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
	

	
	


}
