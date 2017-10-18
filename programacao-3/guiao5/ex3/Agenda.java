package aula5.ex3;
import java.util.*;
import java.io.*;

public class Agenda {

	private List<Pessoa> agenda = new ArrayList<>(); 
	
	public void loadFromFile(String filename) throws IOException{
		Scanner read = new Scanner(new File(filename));
		String format = read.nextLine();
		read.close();
		AgendaFormat agendaFormat = null;
		if(format.equals("Nokia")) {
			agendaFormat = new Nokia();
		}else if(format.equals("vCard")){
			agendaFormat = new vCard();
		}else if(format.equals("CSV")){
			agendaFormat = new CSV();
		}
		addContacts(agendaFormat.readFromFile(filename));
	}
	
	public void saveToFile(String filename, AgendaFormat format) throws IOException{
		format.writeToFile(filename, agendaToArray());
	}
	
	public void addContacts(Pessoa[] pessoas) {
		for(Pessoa p : pessoas) {
			addContact(p);
		}
	}
	
	public void addContact(Pessoa pessoa) {
		agenda.add(pessoa);
	}
	
	public void removeContact(Pessoa pessoa) throws Exception{
		if(!agenda.contains(pessoa)) throw new Exception("Pessoa given doesn't exist in list");
		agenda.remove(pessoa);
	}
	
	private Pessoa[] agendaToArray() {
		return agenda.toArray(new Pessoa[0]);
	}
	
	public int numContacts() {
		return agenda.size();
	}
	
	@Override
	public String toString() {
		return agenda.toString();
	}
	
}
