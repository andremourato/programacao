import java.util.*;
import java.io.*;
public class ex3 {
	
	public static void main (String[] args) throws IOException{
	
		Scanner read = new Scanner(System.in);
		int opcao;
		Robos robos[] = new Robos[100];
		int numRobos = 0;
		System.out.println("Micro-Rato 2013 - Gestao da prova:");
		System.out.println("1 - Adicionar informacao relativa a um robo");
		System.out.println("2 - Imprimir informacao dos robos em prova");
		System.out.println("3 - Vencedor da prova e tempos medios de prova");
		System.out.println("4 - Media do numero de elementos por equipa");
		System.out.println("5 - Mostrar o nome dos robos em maiusculas");
		System.out.println("6 - Alterar informacao e um robo");
		System.out.println("7 - Remover robos da competicao");
		System.out.println("8 - Gravar informacao da prova num ficheiro");
		System.out.println("9 - Terminar programa");
		System.out.println();
		System.out.println("----------------------------");
		System.out.println();
		do{
			System.out.print("Opcao -> ");
			opcao = Integer.parseInt(read.nextLine()); //é utilizado .parseInt() para evitar erros com na leitura do input que possam afetar o programa
			
			switch(opcao){
				
				case 1: //adiciona informação relativa ao robo
					robos[numRobos] = new Robos();
					robos[numRobos].time = new Time();
					System.out.printf("Nome do robo: ");
					robos[numRobos].name = read.nextLine();
					System.out.printf("Tempo de prova em segundos: ");
					robos[numRobos].time.totalSeconds = Integer.parseInt(read.nextLine());
					System.out.printf("Numero de elementos da equipa: ");
					robos[numRobos].number = Integer.parseInt(read.nextLine());
					numRobos++;
					for(int i=0;i<numRobos;i++){
						robos[i].time = convertToHMS(robos[i].time, robos[i].time.totalSeconds);
					}
					System.out.println();
					System.out.println("----------------------------");
					System.out.println();
					break;
				case 2:
					for(int i=0;i<numRobos;i++){
						if(numRobos==0){
							System.out.printf("Nao existem robos");
							break;
						}
						System.out.printf("Nome do robo: %s\n", robos[i].name);
						System.out.printf("Tempo de prova: %02d.%02d.%02d\n", robos[i].time.h, robos[i].time.m, robos[i].time.s);
						System.out.printf("Numero de elementos da equipa: %d\n", robos[i].number);
						System.out.println();
					}
					System.out.println();
					System.out.println("----------------------------");
					System.out.println();
					break;
				case 3:
					int winnerNumber=0;
					int sum=0;
					Time avg = new Time();
					int bestTime = robos[0].time.totalSeconds;
					for(int i=0;i<numRobos;i++){
						if(robos[i].time.totalSeconds<bestTime){
							winnerNumber = i;
							bestTime = robos[i].time.totalSeconds;
						}
						sum+=robos[i].time.totalSeconds;
					}
					avg = convertToHMS(avg,(sum/numRobos));
					System.out.printf("Vencedor: %s\n",robos[winnerNumber].name);
					System.out.printf("Tempo de prova: %02d.%02d.%02d\n", robos[winnerNumber].time.h, robos[winnerNumber].time.m, robos[winnerNumber].time.s);
					System.out.printf("Numero de elementos da equipa: %d\n", robos[winnerNumber].number);
					System.out.printf("Tempo medio de prova dos robos: %02d.%02d.%02d\n", avg.h, avg.m, avg.s);
					System.out.println();
					System.out.println("----------------------------");
					System.out.println();
					break;
				case 4:
					double avgNumberElem;
					int sumTeamElem=0;
					for(int i=0;i<numRobos;i++){
						sumTeamElem+=robos[i].number;
					}
					avgNumberElem = (double)(sumTeamElem)/numRobos;
					System.out.printf("Numero medio de elementos por equipa: %.2f", avgNumberElem);
					System.out.println();
					System.out.println("----------------------------");
					System.out.println();
					break;
				case 5:
					String names[] = new String[numRobos];
					for(int i=0;i<numRobos;i++){
						names[i] = robos[i].name.toUpperCase();
					}
					Arrays.sort(names);
					for(int i=0;i<numRobos;i++){
						System.out.println(names[i]);
					}
					System.out.println();
					System.out.println("----------------------------");
					System.out.println();
					break;
				case 6:
					int pos = -1;
					String name;
					Robos tmp = new Robos();
					do{
						System.out.printf("Nome do robo: ");
						name = read.nextLine();
						if(!isValidName(numRobos, robos, name)) System.out.printf("Nao existe robo com o nome introduzido!\n");
					}while(!isValidName(numRobos, robos, name));
					pos = findPosition(numRobos, robos, name);
					System.out.printf("Tempo de prova em segundos: ");
					robos[pos].time.totalSeconds = Integer.parseInt(read.nextLine());
					System.out.printf("Numero de elementos da equipa: ");
					robos[pos].number = Integer.parseInt(read.nextLine());
					for(int i=0;i<numRobos;i++){
						robos[i].time = convertToHMS(robos[i].time, robos[i].time.totalSeconds);
					}
					System.out.printf("Informacao alterada com sucesso!\n");
					System.out.println();
					System.out.println("----------------------------");
					System.out.println();
					break;
				case 7:
					int time;
					System.out.print("Tempo de rejeicao (em segundos): ");
					time = Integer.parseInt(read.nextLine());
					robos = removeRobots(numRobos, robos, time);
					numRobos--;
					System.out.println();
					System.out.println("----------------------------");
					System.out.println();
					break;
				case 8:
					System.out.printf("Nome do ficheiro: ");
					String fileName = read.nextLine();
					File file = new File(fileName);
					PrintWriter pwf = new PrintWriter(file);
					for(int i=0;i<numRobos;i++){
						if(numRobos==0){
							System.out.printf("Nao existem robos");
							break;
						}
						pwf.println("Nome do robo: "+ robos[i].name);
						pwf.println("Tempo de prova: "+ robos[i].time.h + robos[i].time.m + robos[i].time.s);
						pwf.println("Numero de elementos da equipa: " + robos[i].number);
						pwf.println();
					}
					pwf.close();
					System.out.printf("Informacao guardada com sucesso!\n");
					System.out.println();
					System.out.println("----------------------------");
					System.out.println();
					break;
				case 9:
					//Termina o programa
					break;
				
			}
			
		}while(opcao!=9);
	}
	public static Time convertToHMS(Time robos, int time){
		int hr,mr,s;
		robos.h = time/3600;// Valor das horas
		hr = time%3600;
		robos.m = hr/60;// Valor do minutos
		mr = hr%60;
		robos.s = mr%60;//valor dos segundos
		return robos; //devolve em tipo de dados Time
	}
	public static int findPosition(int numRobos, Robos robos[], String name){
		int pos = -1;
		int n = 0;
		do{
			if(name.equals(robos[n++].name)) pos = n-1;
		}while(pos == -1 && n<numRobos);
		return pos;
	}
	public static boolean isValidName(int numRobos, Robos robos[], String name){
		int n=0;
		do{
			if(name.equals(robos[n++].name)) return true;
		}while(n<numRobos);
		return false;
	}
	public static Robos[] removeRobots(int numRobos, Robos robos[], int time){
		for(int i=0;i<numRobos;i++){
			if(robos[i].time.totalSeconds>time){ //elimina o robo se o tempo for superior ao introduzido
				for(int j=i;j<numRobos-1;j++){
					robos[j].name = robos[j+1].name;
					robos[j].time.h = robos[j+1].time.h;
					robos[j].time.m = robos[j+1].time.m;
					robos[j].time.s = robos[j+1].time.s;
					robos[j].time.totalSeconds = robos[j+1].time.totalSeconds;
					robos[j].number = robos[j+1].number;
				}
			}
		}
		return robos;
	}
}

class Robos{
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

