package aula13.ex3;

import java.util.Arrays;

public class BrincaBeira {
	
	public static void main(String[] args) {
		
		System.out.println("------ Testing NameList ------");
		/* These string[] are used for testing purposes */
		String[] workers = {"Andre Mourato", "Manuel Silva", "Joao Martins", "Tiago Ferreira",
							"Joana Veiga", "Ana Marques","Tatiana Sousa", "Marco Oliveira",
							"Juliana Pereira", "Fabio Antunes", "Marcelo Frafa", "Miguel Costalini",
							"Andre Alves", "Fabio Ribeiro", "Joana Soares", "Miguel Muralha", "Andre Moreira"};
		String[] toys = {"Carro", "Comboio a vapor", "Power Ranger Amarelo", "LEGO City", 
								"Bola de futebol","Darth Vader - Boneco de Ação"};
		NameList names = new NameList();
		//Adds workers
		Arrays.stream(workers).forEach(x -> names.addWorker(x));
		//Prints the names of all the workers
		System.out.println(names);
		//Output: "Removed Manuel!"
		System.out.println(names.removeWorker("Manuel") ? "Removed Manuel!" : "Failed to remove Manuel");
		//Output: "Failed to remove Mariana"
		System.out.println(names.removeWorker("Mariana") ? "Removed Mariana!" : "Failed to remove Mariana!");
		
		System.out.println("\n------ Testing WorkerGifts (Worker,Gift) ------");
		WorkerGifts gifts = new WorkerGifts();
		//Simulates giving a gift to an employee every month for a year
		System.out.println("\nGiving gifts...\n");
		for(int i = 0; i < 12; i++) {
			int randWorkerIndex = (int)(Math.random() * workers.length);
			int randGiftIndex = (int)(Math.random() * toys.length);
			gifts.giveGift(toys[randGiftIndex],workers[randWorkerIndex]);
			System.out.println("'"+ toys[randGiftIndex] +"' given to "+workers[randWorkerIndex]);
		}
		System.out.println("\nPrinting lists of gifts...\n");
		System.out.println(gifts);
		System.out.println("\nTaking back gifts...\n");
		//Removes 1 gift from each workers. Workers can have more than 1 gift
		for(String worker : workers) {
			System.out.println(gifts.takeBackGift(worker) ? "Removed gift from "+worker : worker+" doesn't have a present");
		}
		System.out.println("\nPrinting lists of gifts...\n");
		System.out.println(gifts);
		
		System.out.println("\n------ Testing ToyList ------");
		String randomWorker = workers[(int)(Math.random() * workers.length)];
		ToyList toyList = new ToyList(randomWorker);
		//Adds all toys
		Arrays.stream(toys).forEach(x -> toyList.addToy(x));
		System.out.println(toyList);
		toyList.setName("Andre Mourato");
		System.out.println(toyList);
		System.out.println(toyList.removeToy("Carro") ? "Removed Carro!" : "Could not remove Carro");
		System.out.println(toyList.removeToy("Barbie") ? "Removed Barbie!" : "Could not remove Barbie");
		
		System.out.println("\n------ Testing Name Counter ------");
		NameCounter counter = new NameCounter();
		//Counts names
		Arrays.stream(workers).forEach(x -> counter.insert(x));
		System.out.println(counter);
		counter.remove("Andre"); //decrements by 1 the number of names Andre
		counter.remove("Joana"); //and so on...
		counter.remove("Joana");
		System.out.println(counter);
		
		System.out.println("\n------ Testing Ticket Manager ------\n");
		
		TicketManager manager = new TicketManager(workers);
		System.out.println("Given tickets to: \n");
		manager.giveTickets(4).forEach(System.out::println);
		System.out.println("\nGiven tickets to: \n");
		manager.giveTickets(3).forEach(System.out::println);
		System.out.println("\nGiven tickets to: \n");
		manager.giveTickets(1).forEach(System.out::println);
		System.out.println("\nGiven tickets to: \n");
		//Will rotate and give a ticket to the first worker
		manager.giveTickets(10).forEach(System.out::println);
	}
	
}
