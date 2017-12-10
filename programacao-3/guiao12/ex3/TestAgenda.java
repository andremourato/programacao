package aula12.ex3;

public class TestAgenda {

	public static void main(String[] args) throws Exception{
		
		Agenda agenda = new Agenda();
		
		System.out.println("Supported plugins:");
		agenda.supportedPlugins().forEach(System.out::println);
		System.out.println();
		
		//Nokia format
		agenda.loadAgendaFromFile("File1.txt");
		agenda.addContact(new Pessoa("Marco",12345678,new Data(),962789374));
		agenda.saveToFile("OutputFile1.txt", new Nokia());
		System.out.println("A agenda #1 tem "+agenda.numContacts()+" contactos:");
		System.out.println(agenda);
		System.out.println();
		
		//vCard format
		agenda = new Agenda();agenda.loadAgendaFromFile("File2.txt");
		agenda.addContacts(new Pessoa[] {
				new Pessoa("Jos� Martins",23123421,new Data(),931231322),
				new Pessoa("Andr� Mourato",23199421,new Data(),968231312),
				new Pessoa("Roberto Silva",23191421,new Data(),968222312),
				new Pessoa("Ludwig",23199421,new Data(),968231312),
		});
		agenda.addContact(new Pessoa("Maria Bornes",19945678,new Data(),962765474));
		agenda.saveToFile("OutputFile2.txt",new vCard());
		System.out.println("A agenda #2 tem "+agenda.numContacts()+" contactos:");
		System.out.println(agenda);
		System.out.println();
		
		//CSV format
		agenda = new Agenda();
		agenda.loadAgendaFromFile("File3.txt");
		agenda.addContact(new Pessoa("Ana Marques",12340078,new Data(),962222374));
		agenda.addContact(new Pessoa("Jo�o Nuno",16745678,new Data(),962282374));
		agenda.saveToFile("OutputFile3.txt", new CSV());
		System.out.println("A agenda #3 tem "+agenda.numContacts()+" contactos:");
		System.out.println(agenda);
		System.out.println();
		
	}

}
