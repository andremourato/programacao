import java.util.*;

public class Menu {
	
	public static void main (String args[]) {
		
		Scanner read = new Scanner(System.in);
		int option;
		Data date  = null;
		
		do{
			System.out.println("1. Cria novo objecto com a data actual");
			System.out.println("2. Cria novo objecto com uma qualquer data");
			System.out.println("3. Indica se a data é válida");
			System.out.println("4. Escreve data");
			System.out.println("5. Escreve data por extenso");
			System.out.println("6. Dia anterior");
			System.out.println("7. Dia seguinte");
			System.out.println("0. Termina");
			System.out.println("\nNOTA: Se não houver outra indicação, todas as operações fazem-se sobre o último objecto criado");
			System.out.print("\nOpcao: ");
			option = read.nextInt();
			System.out.println();
			System.out.println("--------------------------------------------");
			System.out.println();
			
			switch(option){
				case 1:
					//Cria novo objecto com a data actual
					date = new Data();
					System.out.println("Data configurada");
					System.out.println();
					System.out.println("--------------------------------------------");
					System.out.println();
					break;
					
				case 2:
					//Cria novo objecto com uma qualquer data escolhida pelo utilizador
					System.out.print("Dia: ");
					int day = read.nextInt();
					System.out.print("Mês: ");
					int month = read.nextInt();
					System.out.print("Ano: ");
					int year = read.nextInt();
					date = new Data(year,month,day);
					System.out.println("Data configurada");
					System.out.println();
					System.out.println("--------------------------------------------");
					System.out.println();
					break;
				
				case 3:
					//Indica se a data é válida
					if(Data.isValid(date.year(),date.month(),date.day())) System.out.println("A data é válida");
					else System.out.println("A data não é válida");
					System.out.println();
					System.out.println("--------------------------------------------");
					System.out.println();
					break;
					
				case 4:
					//Escreve data
					System.out.printf("Data: %02d-%02d-%04d\n",date.day(),date.month(),date.year());
					System.out.println();
					System.out.println("--------------------------------------------");
					System.out.println();
					break;
					
				case 5:
					//Escreve data por extenso
					date.printDate();
					System.out.println();
					System.out.println("--------------------------------------------");
					System.out.println();
					break;
					
				case 6:
					//Dia anterior
					date.vaiParaOntem();
					System.out.println("Data configurada para o dia anterior!");
					System.out.println();
					System.out.println("--------------------------------------------");
					System.out.println();
					break;
					
				case 7:
					//Dia seguinte
					date.vaiParaAmanha();
					System.out.println("Data configurada para o dia seguinte");
					System.out.println();
					System.out.println("--------------------------------------------");
					System.out.println();
					break;
					
				case 0:
					//termina o programa
					break;
			}	
			
		}while(option!=0);
		
	}
}

/*

1. Cria novo objecto com a data actual
2. Cria novo objecto com uma qualquer data
3. Indica se a data é válida
4. Escreve data
5. Escreve data por extenso
6. Dia anterior
7. Dia seguinte
0. Termina
 * */

