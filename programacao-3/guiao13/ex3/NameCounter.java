package aula13.ex3;

import java.util.HashMap;
import java.util.Map;

public class NameCounter {
	
	private Map<String, Integer> counter = new HashMap<>();
	
	/* Receives full name as argument
	 * Adds only the first name to the map */
	public void insert(String name) {
		String firstName = name.split(" ")[0];
		if(counter.containsKey(firstName)) {
			counter.put(firstName, counter.get(firstName) + 1);
		}else {
			counter.put(firstName, 1);
		}
	}

	public boolean remove(String name) {
		if(counter.containsKey(name)) {
			int nextCount = counter.get(name) - 1;
			if(nextCount == 0) {
				counter.remove(name);
				return true;
			}
			counter.put(name, nextCount);
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return counter.toString();
	}

}
