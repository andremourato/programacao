import java.util.*;
import static java.lang.System.*;

public class Menu {
	
	public static void main (String args[]) {
		
		Scanner read = new Scanner(in);
		int option;
		Data anterior = new Data(); //inicia com a data atual (por análise do .jar fornecido)
		Data date = new Data(); //inicia com a data atual (por análise do .jar fornecido)
		
		printInfo();
		do{
			out.print("\nOpcao: ");
			option = read.nextInt();
			out.println();
			out.println();
			
			switch(option){
				case 1:
					//Cria novo objecto com a data actual
					anterior = date; //armazena data anterior
					date = new Data();
					date.printData();
					printInfo();
					break;
					
				case 2:
					//Cria novo objecto com uma qualquer data escolhida pelo utilizador
					anterior = date; //armazena data anterior
					out.print("Dia: ");
					int day = read.nextInt();
					out.print("Mês: ");
					int month = read.nextInt();
					out.print("Ano: ");
					int year = read.nextInt();
					date = new Data(year,month,day);
					out.println();
					date.printData();
					printInfo();
					break;
				
				case 3:
					//Indica se a data é válida
					date.printIsValid();
					date.printData();
					printInfo();
					break;
					
				case 4:
					//Escreve data
					date.printData();
					date.printData();
					printInfo();
					break;
					
				case 5:
					//Escreve data por extenso
					date.printFullData();
					date.printData();
					printInfo();
					break;
					
				case 6:
					//Dia anterior
					date.vaiParaOntem();
					out.println("Data configurada para o dia anterior!");
					date.printData();
					printInfo();
					break;
					
				case 7:
					//Dia seguinte
					date.vaiParaAmanha();
					out.println("Data configurada para o dia seguinte");
					date.printData();
					printInfo();
					break;
				
				case 8:
					//É igual à data anterior?
					date.printDateOnly();
					out.print(" = ");
					anterior.printDateOnly();
					out.print("? ");
					if(date.igualA(anterior)) out.println("VERDADEIRO");
					else out.println("FALSO");
					date.printData();
					printInfo();
					break;
				
				case 9:
					//É maior do que a anterior
					date.printDateOnly();
					out.print(" > ");
					anterior.printDateOnly();
					out.print("? ");
					if(date.maiorDoQue(anterior)) out.println("VERDADEIRO");
					else out.println("FALSO");
					date.printData();
					printInfo();
					break;
				
				case 10:
					//Dia seguinte
					date.printDateOnly();
					out.print(" < ");
					anterior.printDateOnly();
					out.print("? ");
					if(date.menorDoQue(anterior)) out.println("VERDADEIRO");
					else out.println("FALSO");
					date.printData();
					printInfo();
				
				case 11:
					//Dia seguinte
					date.printDateOnly();
					out.print(" - ");
					anterior.printDateOnly();
					out.printf(" = %d\n",anterior.daysBetween(date));
					printInfo();
					break;
					
				case 0:
					//termina o programa
					break;
			}
		}while(option!=0);
	}
	
	static void printInfo(){
		
		Scanner sc = new Scanner(in);
		
		out.print("<PRIMA ENTER>");
		sc.nextLine();
		out.println("\n1.  Cria novo objecto com a data actual");
		out.println("2.  Cria novo objecto com uma qualquer data");
		out.println("3.  Indica se a data é válida");
		out.println("4.  Escreve data");
		out.println("5.  Escreve data por extenso");
		out.println("6.  Dia anterior");
		out.println("7.  Dia seguinte");
		out.println("8.  Última data igual à penúltima");
		out.println("9.  Última data maior do que a penúltima");
		out.println("10. Última data menor do que a penúltima");
		out.println("11. (Última data) - (Penúltima data)");
		out.println("0.  Termina");
		out.println("\nNOTA: Se não houver outra indicação, todas as operações fazem-se sobre o último objecto criado");
	}
}

/*

De acordo com o ficheiro .jar fornecido
* 
1. Cria novo objecto com a data actual
2. Cria novo objecto com uma qualquer data
3. Indica se a data é válida
4. Escreve data
5. Escreve data por extenso
6. Dia anterior
7. Dia seguinte
8. Última data igual à penúltima
9. Última data maior do que a penúltima
10. Última data menor do que a penúltima
11. (Última data) - (Penúltima data)

0. Termina
 * */

