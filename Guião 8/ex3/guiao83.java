
/* 
 * André Ribeiro Martins Marques Mourato
 * Nº Mec: 84745
 * 
 */
 
import java.io.*;
import java.util.*;
public class guiao83 {
	static int count=0;
	static double[] numArray = new double[50];
	static Scanner read = new Scanner(System.in);
	public static void main (String args[]) throws IOException {
		
		int option;
		int[] arrayInt = new int[50];
		//MENU
		System.out.printf("-->> Análise de uma sequência de números inteiros <<--\n");
		System.out.printf("\n");
		System.out.printf("1 - Ler sequência\n");
		System.out.printf("2 - Imprimir sequência\n");
		System.out.printf("3 - Calcular o máximo da sequência\n");
		System.out.printf("4 - Calcular o mínimo da sequência\n");
		System.out.printf("5 - Calcular média da sequência\n");
		System.out.printf("6 - Detetar se é uma sequência só constituída por números pares\n");
		System.out.printf("7 - Ler uma sequência de números de um ficheiro\n");
		System.out.printf("8 - Adicionar números à sequência\n");
		System.out.printf("10 - Terminar o programa\n");
		System.out.printf("\n");
		do{
			System.out.printf("Opção -> ");
			option=read.nextInt();
			switch(option){
				case 1:
					lerSeq(arrayInt);
					break;
				case 2:
					impSeq(arrayInt);
					break;
				case 3:
					System.out.printf("O valor máximo da sequência é: %d\n",max(arrayInt));
					break;
				case 4:
					System.out.printf("O valor mínimo da sequência é: %d\n",min(arrayInt));
					break;
				case 5:
					System.out.printf("O valor médio da sequência é: %d\n",med(arrayInt));
					break;
				case 6:
					par(arrayInt);
					break;
				case 7:
					lerFicheiro();
					break;
				case 8:
					addNumbers();
					break;
				case 9:
					
					break;
				case 10:
					break;
				default:
					System.out.printf("OPÇÃO INVALIDA!\n");
					break;
			}
		}while(option!=10);//TERMINA QUANDO É INTRODUZIDO 10
	}
	//Ler sequência
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
	//Imprimir sequência
	public static void impSeq(int array[]){
		for(int i=0;array[i]!=0;i++){
			System.out.printf("array[%d] = %d\n",i,array[i]);
		}
	}
	//Calcular máximo da sequência
	public static int max(int[] array){
		int max = array[0];
		for(int i=0;i<count;i++){
			if(array[i]>max){max=array[i];}
		}
		return max;
	}
	//Calcular mínimo da sequência
	public static int min(int[] array){
		int min = array[0];
		for(int i=0;i<count;i++){
			if(array[i]<min){min=array[i];}
		}
		return min;
	}
	//Calcular a média da sequência
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
	//Detetar se é uma sequência par
	public static void par(int[] array){
		int numPar=0;
		for(int i=0;i<count;i++){
			if(array[i]%2==0) numPar++;
		}
		if(numPar==count){ System.out.print("A sequência é constituida por números pares\n");
		
		}else{
			System.out.print("A sequência não é constituida por números pares\n");
		}
	}
	//Ler sequência de números
	public static void lerFicheiro() throws IOException{
		
		double line;
		File file = new File("numbers.txt");
		Scanner readFile = new Scanner(file);
		while(readFile.hasNextDouble()){
			line = readFile.nextDouble();
			for(int i=0;readFile.hasNextDouble();i++){
				numArray[i]=line;
			}
			System.out.printf("%f\n",line);
		}
	}
	//Adicionar numeros à sequencia existente
	public static void addNumbers(){
		int count=0;
		System.out.printf("Introduza 3 números\n");
		for(int i=5;i<8;i++){
			System.out.print("Número a adicionar: ");
			numArray[i] = read.nextDouble();
			count++;
		}
	}
}

