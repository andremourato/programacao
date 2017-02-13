import java.util.*;
import java.io.*;
public class ex3_Teste {
	
	public static void main (String[] args) throws IOException{
		
		Scanner read = new Scanner(System.in);
		
		Robots[] robots = new Robots[1000];
		int option;
		int numRobots=0;
		do{
			System.out.println("Micro-Rato 2013 - Gestao da prova:");
			System.out.println("1 - Adicionar informacao relativa a um robo");
			System.out.println("2 - Imprimir informacao dos Robots em prova");
			System.out.println("3 - Vencedor da prova e tempos medios de prova");
			System.out.println("4 - Media do numero de elementos por equipa");
			System.out.println("5 - Mostrar o nome dos Robots em maiusculas");
			System.out.println("6 - Alterar informacao de um robo");
			System.out.println("7 - Remover Robots da competicao");
			System.out.println("8 - Gravar informacao da prova num ficheiro");
			System.out.println("9 - Terminar o programa");
			System.out.println();
			System.out.print("Opcao -> ");
			option = read.nextInt();
			System.out.println();
			System.out.println("------------------------------");
			System.out.println();
			switch(option){
				
				case 1: //Adds a new robot
					addRobot(robots, numRobots);
					numRobots++;
					System.out.println();
					System.out.println("------------------------------");
					System.out.println();
				break;
				
				case 2: //Prints the information about the competition
					printInfo(robots, numRobots);
					System.out.println();
					System.out.println("------------------------------");
					System.out.println();
				break;
				case 3: //Shows the winner
					showWinner(robots, numRobots);
					System.out.println();
					System.out.println("------------------------------");
					System.out.println();
				break;
				case 4: //shows the average time
					avgNumberElem(robots, numRobots);
					System.out.println();
					System.out.println("------------------------------");
					System.out.println();
				break;
				case 5: //prints the name of the robots
					printNames(robots,numRobots);
					System.out.println();
					System.out.println("------------------------------");
					System.out.println();
				break;
				case 6: //change the information of a specified robot
					changeInfo(robots,numRobots);
					System.out.println();
					System.out.println("------------------------------");
					System.out.println();
				break;
				case 7: //removes robots
					removeRobots(robots,numRobots);
					numRobots--;
					System.out.println();
					System.out.println("------------------------------");
					System.out.println();
				break;
				case 8: //writes to file
					writeToFile(robots,numRobots);
					System.out.println();
					System.out.println("------------------------------");
					System.out.println();
				break;
				case 9:
				//Terminar programa
				break;
				
			}
		}while(option!=9);//termina o programa se for introduzido o numero 9
	}
	public static void addRobot(Robots[] robots, int numRobots){
		Scanner read = new Scanner(System.in);
		robots[numRobots] = new Robots();
		robots[numRobots].time = new Time();
		System.out.print("Nome do robo: ");
		robots[numRobots].name = read.nextLine();
		System.out.print("Tempo de prova em segundo: ");
		robots[numRobots].time.totalSeconds = read.nextInt();
		System.out.print("Numero de elementos da equipa ");
		robots[numRobots].number = read.nextInt();
		robots[numRobots].time = convertToHMS(robots[numRobots].time, numRobots, robots[numRobots].time.totalSeconds);
	}
	public static void printInfo(Robots[] robots, int numRobots){
		for(int i=0;i<numRobots;i++){
			System.out.printf("Nome do robo: %s\n", robots[i].name);
			System.out.printf("Tempo de prova: %02d:%02d:%02d\n", robots[i].time.h, robots[i].time.m, robots[i].time.s);
			System.out.printf("Numero de elementos da equipa: %s\n", robots[i].number);
			System.out.println();
		}
	}
	public static Time convertToHMS(Time robots, int numRobots, int seconds){
		int h, m, s;
		robots.h = seconds/3600;
		h = seconds%3600;
		robots.m = h/60;
		m = h%60;
		robots.s = m%60;
		
		return robots;
	}
	public static void showWinner(Robots[] robots, int numRobots){
		int winnerIndex = 0; //we assume it's the first one
		int sum=0;
		Time avg = new Time();
		for (int i = 0; i < numRobots; i++){//if the element has a better time than the current best, it swaps the two
			if(robots[i].time.totalSeconds < robots[winnerIndex].time.totalSeconds) winnerIndex = i;
			sum+=robots[i].time.totalSeconds;
		}
		avg.totalSeconds = sum/numRobots;
		avg = convertToHMS(avg,numRobots,avg.totalSeconds);
		System.out.printf("Vencedor: %s\n", robots[winnerIndex].name);
		System.out.printf("Tempo de prova: %02d:%02d:%02d\n", robots[winnerIndex].time.h, robots[winnerIndex].time.m, robots[winnerIndex].time.s);
		System.out.printf("Numero de elementos da equipa: %s\n", robots[winnerIndex].number);
		System.out.println();
		System.out.printf("Tempo medio de prova: %02d:%02d:%02d\n", avg.h, avg.m, avg.s);
	}
	public static void avgNumberElem(Robots[] robots, int numRobots){
		int avgNumberElem;
		int sumNumberElem=0;
		for(int i=0;i<numRobots;i++) sumNumberElem+=robots[i].number;
		avgNumberElem = sumNumberElem/numRobots;
		System.out.printf("Numero medio de elementos por equipa: %d\n", avgNumberElem);
	}
	public static void printNames(Robots[] robots, int numRobots){
		String[] names = new String[numRobots]; //creates a new array of Strings with the names of the robots as elements
		for(int i=0; i<numRobots;i++){
			names[i] = robots[i].name.toUpperCase();
		}
		Arrays.sort(names); //sorts the names
		for(int i=0;i<names.length;i++) System.out.println(names[i]);
	}
	public static void changeInfo(Robots[] robots, int numRobots){
		Scanner read = new Scanner(System.in);
		int pos = -1;
		int n = 0;
		String name;
		do{ //keeps asking for the name of the robot until the user introduces a valid name
			System.out.print("Nome do robo: ");
			name = read.nextLine();
			if(!exists(robots,numRobots,name))System.out.println("Nao existe robo com o nome introduzido.");
		}while(!exists(robots,numRobots,name));
		do{
			if(robots[n++].name.equals(name)) pos = n - 1;
		}while(pos == -1 && n < numRobots);
		System.out.print("Tempo de prova em segundo: ");
		robots[pos].time.totalSeconds = read.nextInt();
		System.out.print("Numero de elementos da equipa ");
		robots[pos].number = read.nextInt();
		robots[pos].time = convertToHMS(robots[pos].time, numRobots, robots[pos].time.totalSeconds);
	}
	public static boolean exists(Robots[] robots, int numRobots, String name){
		for(int i=0;i<numRobots;i++) if(robots[i].name.equals(name)) return true;
		return false;
	}
	public static void removeRobots(Robots[] robots, int numRobots){
		Scanner read = new Scanner(System.in);
		int time;
		System.out.print("Tempo de eliminacao (em segundos): ");
		time = read.nextInt();
		for(int i=0;i<numRobots-1;i++){
			if(robots[i].time.totalSeconds>time){
				robots[i].name = robots[i+1].name;
				robots[i].time.h = robots[i+1].time.h;
				robots[i].time.m = robots[i+1].time.m;
				robots[i].time.s = robots[i+1].time.s;
				robots[i].number = robots[i+1].number;
			}
		}
	}
	public static void writeToFile(Robots[] robots,int numRobots) throws IOException{
		Scanner read = new Scanner(System.in);
		System.out.print("Nome do ficheiro: ");
		String fileName = read.nextLine(); //reads the name requested by the user
		File file = new File(fileName);
		PrintWriter pwf = new PrintWriter(file);
		for(int i=0;i<numRobots;i++){ //prints the information in the file
			pwf.printf("Nome do robo: %s\n", robots[i].name);
			pwf.println();
			pwf.printf("Tempo de prova: %02d:%02d:%02d\n", robots[i].time.h, robots[i].time.m, robots[i].time.s);
			pwf.println();
			pwf.printf("Numero de elementos da equipa: %s\n", robots[i].number);
			pwf.println();
			pwf.println();
		}
		pwf.close();
		System.out.println("Ficheiro lido!");
	}
}

class Robots {
	String name;
	Time time;
	int number;
	
}

class Time{
	int h;
	int m;
	int s;
	int totalSeconds;
	
}
