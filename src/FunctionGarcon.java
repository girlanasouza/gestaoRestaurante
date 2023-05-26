import java.util.ArrayList;

public class FunctionGarcon {
	
	private ArrayList<Garcon> waiters = new ArrayList<>();
	
	public boolean registerWaiter(Garcon g) {
		
		
		if (waiters.contains(g)) {
	        return false;
	    } else {
	        for (Garcon waiter : waiters) {
	            if (waiter.equals(g)) {
	                return false;
	            }
	        }
	        waiters.add(g);
	        return true;
	    }
		
		
	}
	
	public boolean removeWaiter(int id) {
	    for (Garcon g : waiters) {
	        if (g.getId()==id) {
	            waiters.remove(g);  
	            return true;
	        }
	    }
	    return false;  
	}

	
	public void changeWaiter() {
		
	}
	
	public void reportWaiter() {
		
	}
	
	
	

}
