/*
 * André Mourato
 * GitHub - https://github.com/andremourato
*/
import java.util.*;

public class G1E2 {
	
	static List<Pessoa> people = new ArrayList<>();
	
	public static void main (String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		while(true){
			
			int option = -1;
			
			System.out.println("------------------------------------------");
			System.out.println("|            Gestão de pessoas           |");
			System.out.println("------------------------------------------");
			System.out.println("|  1 - Introduzir pessoa na lista        |");
			System.out.println("|  2 - Apagar pessoa da lista            |");
			System.out.println("|  3 - Apresentar lista de pessoas       |");
			System.out.println("|  4 - Ordenar lista de pessoas pelo nome|");
			System.out.println("|  5 - Ordenar lista de pessoas pelo CC  |");
			System.out.println("|  0 - Sair do programa                  |");
			System.out.println("------------------------------------------");
			System.out.print("Opção: ");
			
			try{
				option = Integer.parseInt(sc.nextLine());
			}
			catch(NumberFormatException e){
				printError();
			}
			System.out.println("------------------------------------------");
			if(option == 1) addPerson();
			else if(option == 2) removePerson();
			else if(option == 3) printList();
			else if(option == 4) sortByName();
			else if(option == 5) sortByCC();
			else if(option == 0) break;
			else printError();
			System.out.println("\n##########################################\n");
		}
	}
	
	static void printList(){
		Pessoa[] array = peopleToArray();
		System.out.println("|     Nome     |      CC     | Data Nasc.|");
		System.out.println("------------------------------------------");
		for(Pessoa person : array){
			System.out.println("| "+person+" |");
		}
		System.out.println("------------------------------------------");
		
	}
	
	static void removePerson(){
		if(people.size() == 0){
			System.out.println("Não pode remover pessoas, porque a lista está vazia");
			return;
		}
		Scanner read = new Scanner(System.in);
		System.out.print("Nome da pessoa a remover: ");
		String name = read.nextLine();
		List<Pessoa> tmp = new ArrayList<>();
		for(Pessoa person : peopleToArray()){
			if(!person.nome().equals(name)){
				tmp.add(person);
			}
		}
		if(people.size() == tmp.size())
			System.out.println("O nome introduzido não foi encontrado");
		else
			System.out.println("Pessoa removida com sucesso!");
		people = tmp;
	}
	
	static void addPerson(){
		try{
			Scanner read = new Scanner(System.in);
			System.out.print("Nome: ");
			String name = read.nextLine();
			
			System.out.print("Cartão de cidadão: ");
			int cc = Integer.parseInt(read.nextLine());
			
			System.out.print("Data de nascimento(dd-mm-yyyy): ");
			String inputDate = read.nextLine();
			String[] data = inputDate.split("-");
			if(data.length != 3) throw new IllegalArgumentException();
			Data date = new Data(Integer.parseInt(data[0]),Integer.parseInt(data[1]),Integer.parseInt(data[2]));
			people.add(new Pessoa(name, cc, date));
			
		}catch(Exception e){
			System.out.println("Input Inválido");
			return;
		}
		System.out.println("Pessoa adicionada com sucesso!");
	}
	
	static void sortByName(){
		List<Pessoa> tmp = new ArrayList<>();
		for(String name : namesToArray()){
			for(Pessoa person : peopleToArray()){
				if(person.nome().equals(name)){
					tmp.add(person);
					break;
				}
			}
		}
		people = tmp;
		System.out.println("Lista ordenada pelo nome com sucesso!");
	}
	
	static void sortByCC(){
		List<Pessoa> tmp = new ArrayList<>();
		for(int cc : ccToArray()){
			for(Pessoa person : peopleToArray()){
				if(person.cc() == cc){
					tmp.add(person);
					break;
				}
			}
		}
		people = tmp;
		System.out.println("Lista ordenada pelo nome com sucesso!");
	}
	
	static void printError(){
		System.out.println("Input inválido");
		System.exit(1);
	}
	
	static Pessoa[] peopleToArray(){ return people.toArray(new Pessoa[0]); }
	static String[] namesToArray(){
		int index = 0;
		String[] namesArray = new String[people.size()];
		for(Pessoa person : peopleToArray()){
			namesArray[index++] = person.nome();
		}
		Arrays.sort(namesArray);
		return namesArray;
	}
	
	static int[] ccToArray(){
		int index = 0;
		int[] ccArray = new int[people.size()];
		for(Pessoa person : peopleToArray()){
			ccArray[index++] = person.cc();
		}
		Arrays.sort(ccArray);
		return ccArray;
	}
	
}

