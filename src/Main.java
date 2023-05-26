
public class Main {
	
	public static void main(String args[]) {
		Garcon waiter1 = new Garcon ("Girlana", 1, "Barbosa Fillho");
		Garcon waiter2 = new Garcon ("Girlana", 2, "Barbosa Fillho");
		
		FunctionGarcon function = new FunctionGarcon();
		
		if (function.registerWaiter(waiter1)==true){
			System.out.println("consegui!");
		}
		else {
			System.out.println("não consegui!");
		}
		
		if (function.removeWaiter(waiter2.getId())==true){
			System.out.println("consegui!");
		}
		else {
			System.out.println("não consegui!");
		}
	}

}
