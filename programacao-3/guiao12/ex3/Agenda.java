package aula12.ex3;
import java.util.*;

import java.io.*;

public class Agenda {

	private List<Pessoa> agenda = new ArrayList<>();
	private List<Plugin> plugins = new ArrayList<>();
	
	/* Loads teh plugins */
	public Agenda() throws Exception{
		loadPlugins("bin/aula12/plugins");
	}
	
	public void loadPlugins(String directoryName) throws Exception{
		for(File pluginFile : (new File(directoryName)).listFiles()) {
			String pluginName = "aula12.ex3."+pluginFile.getName().split("\\.")[0];
			plugins.add(PluginManager.load(pluginName));
		}
	}
	
	public void loadAgendaFromFile(String filename) throws Exception {
		Scanner read = new Scanner(new File(filename));
		Plugin pluginProxy = (Plugin)Class.forName("aula12.ex3."+read.nextLine()).newInstance();
		read.close();
		addContacts(pluginProxy.readFromFile(filename));
	}
	
	public void saveToFile(String filename, Plugin format) throws IOException{
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
	
	public List<Plugin> supportedPlugins(){
		return plugins;
	}
	
	@Override
	public String toString() {
		return agenda.toString();
	}
	
}
