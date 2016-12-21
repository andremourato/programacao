/* 
 * Andre Ribeiro Martins Marques Mourato
 * Nº Mec: 84745
 * 
 */
import java.io.*;
import java.util.*;
public class guiao83 {
	static int count=0;
	static Scanner read = new Scanner(System.in);
	public static void main (String args[]) throws IOException {
		
		File fileIn = new File("numbers.txt");
		Scanner scf = new Scanner(fileIn);
		PrintWriter pwf = new PrintWriter("numbers.txt");
		int option;
		int num;
		int[] arrayInt = new int[50];
		int[] arrayFile = new int[50];
		
		//MENU
		System.out.printf("-->> Analise de uma sequencia de numeros inteiros <<--\n");
		System.out.printf("\n");
		System.out.printf("1 - Ler sequencia\n");
		System.out.printf("2 - Imprimir sequencia\n");
		System.out.printf("3 - Calcular o maximo da sequencia\n");
		System.out.printf("4 - Calcular o minimo da sequencia\n");
		System.out.printf("5 - Calcular media da sequencia\n");
		System.out.printf("6 - Detetar se e uma sequencia so constituida por numeros pares\n");
		System.out.printf("7 - Ler uma sequencia de numeros de um ficheiro\n");
		System.out.printf("8 - Adicionar numeros a sequencia\n");
		System.out.printf("9 - Gravar a sequencia atual de numeros no ficheiro\n");
		System.out.printf("10 - Terminar o programa\n");
		System.out.printf("\n");
		do{
			System.out.printf("Opcao -> ");
			option=read.nextInt();
			switch(option){
				case 1:
					lerSeq(arrayInt);
					break;
				case 2:
					impSeq(arrayInt);
					break;
				case 3:
					System.out.printf("O valor maximo da sequencia e: %d\n",max(arrayInt));
					break;
				case 4:
					System.out.printf("O valor minimo da sequencia e: %d\n",min(arrayInt));
					break;
				case 5:
					System.out.printf("O valor medio da sequencia e: %d\n",med(arrayInt));
					break;
				case 6:
					par(arrayInt);
					break;
				case 7:
					for(int i=0;scf.hasNextLine();i++){
						String line = scf.nextLine();
						arrayFile[i] = Integer.parseInt(line);
						System.out.println(arrayFile[i]);
					}
					break;
				case 8:
					do{
						System.out.println("Numero: ");
						num = Integer.parseInt(read.nextLine());
						
					}while(num!=0);
					
					break;
				case 9:
				
					break;
				
				case 10:
				
					break;
				default:
					System.out.printf("OPÇAO INVALIDA!\n");
					break;
			}
		}while(option!=10);//TERMINA QUANDO E INTRODUZIDO 10
	}
	//Ler sequencia
	public static void lerSeq(int[] array){
		int i=0;
		do{
			System.out.printf("Valor: ");
			array[i]=read.nextInt();
			i++;
			count++;
		}while(array[i-1]!=0);
		count--;
	}
	//Imprimir sequencia
	public static void impSeq(int array[]){
		for(int i=0;array[i]!=0;i++){
			System.out.printf("array[%d] = %d\n",i,array[i]);
		}
	}
	//Calcular maximo da sequencia
	public static int max(int[] array){
		int max = array[0];
		for(int i=0;i<count;i++){
			if(array[i]>max){max=array[i];}
		}
		return max;
	}
	//Calcular minimo da sequencia
	public static int min(int[] array){
		int min = array[0];
		for(int i=0;i<count;i++){
			if(array[i]<min){min=array[i];}
		}
		return min;
	}
	//Calcular a media da sequencia
	public static int med(int[] array){
		int soma=0, media;
		
		for(int i=0;i<count;i++){
			soma+=array[i];
		}
		System.out.printf("Soma: %d\n",soma);
		System.out.printf("Nº ELEMENTOS: %d\n",count);
		media=soma/(count);
		return media;
	}
	//Detetar se e uma sequencia par
	public static void par(int[] array){
		int numPar=0;
		for(int i=0;i<count;i++){
			if(array[i]%2==0) numPar++;
		}
		if(numPar==count){ System.out.print("A sequencia e constituida por numeros pares\n");
		
		}else{
			System.out.print("A sequencia nao e constituida por numeros pares\n");
		}
	}
}

