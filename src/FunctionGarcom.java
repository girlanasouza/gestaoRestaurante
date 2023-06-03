import java.util.ArrayList;

public class FunctionGarcom {
	
	private ArrayList<Garcom> waiters = new ArrayList<>();
	
	public boolean registerWaiter(Garcom g) {
		
		
		if (waiters.contains(g)) {
	        return false;
	    } else {
	        for (Garcom waiter : waiters) {
	            if (waiter.equals(g)) {
	                return false;
	            }
	        }
	        waiters.add(g);
	        return true;
	    }
		
		
	}
	
	public boolean removeWaiter(int id) {
	    for (Garcom g : waiters) {
	        if (g.getId()==id) {
	            waiters.remove(g);  
	            return true;
	        }
	    }
	    return false;  
	}

	
	public boolean changeWaiter(int id, String name, String address) {
		for(Garcom w : waiters) {
			if(w.getId()==id) {
				w.setName(name);
				w.setAddress(address);
				return true;
			}
		}
		return false;
	}
	
	public void reportWaiter() {
		
	}
	
	
	

}
