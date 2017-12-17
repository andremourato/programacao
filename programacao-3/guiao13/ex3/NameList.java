package aula13.ex3;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class NameList {

	/*
	 * Since a TreeSet is used, there cannot be similar elements.
	 * The names are stored alphabetically
	 */
	private final Set<String> names = new TreeSet<>();
	
	public boolean addWorker(String workerName) {
		return names.add(workerName);
	}
	
	public boolean removeWorker(String workerName) {
		return names.remove(workerName);
	}

	@Override
	public String toString() {
		return names.stream().collect(Collectors.joining("\n"));
	}
	
}
