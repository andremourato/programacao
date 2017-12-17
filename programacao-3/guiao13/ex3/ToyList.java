package aula13.ex3;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ToyList {

	private String prefix;
	private List<String> toys = new LinkedList<>();
	
	public ToyList(String workerName) {
		setName(workerName);
	}

	public Object addToy(String newToy) {
		return toys.add(newToy);
	}
	
	public void setName(String name) {
		prefix = name.split(" ")[0];
	}

	public boolean removeToy(String toy) {
		return toys.remove(toy);
	}

	@Override
	public String toString() {
		return toys.stream().map(x -> prefix.concat(" "+x)).collect(Collectors.toList()).toString();
	}
	
}
