/*
*
*
*		PROGRAMA INCOMPLETO
*
*/

import java.util.*;
import java.io.*;
public class guiao11e3{
	
	static Scanner read = new Scanner(System.in);
	static File fileIn;
	public static void main (String[] args) throws IOException{
		
		Scanner scf;
		double numberArray[] = new double[1]; //inicia-se o array com uma dimensao qualquer
		double numberArrayOrdered[] = new double[1]; //array que contem os valores do array 'numberArray' ordenados
		int opcao;
		double avg=-1;
		System.out.printf("Analisador de pH\n");
		System.out.printf("1 - Ler valores de pH de um ficheiro\n");
		System.out.printf("2 - Escrever valores de pH no terminal\n");
		System.out.printf("3 - Calcular o pH medio das amostras\n");
		System.out.printf("4 - Calcular o numero de amostras acidas e basicas\n");
		System.out.printf("5 - Calcular o numero de amostras de pH superior a media\n");
		System.out.printf("6 - Escrever valores de pH no terminal ordenados de modo crescente\n");
		System.out.printf("7 - Terminar programa\n");
		do{
			double number;
			System.out.printf("Opcao -> ");
			opcao = read.nextInt();
			switch(opcao) {
					
				case 1: //le os valores de pH do ficheiro
					System.out.print("Nome do ficheiro que contem os valores de pH: ");
					String fileName = read.next();
					fileIn = new File(fileName);
					checkFile(fileIn, fileName);
					scf = new Scanner(fileIn);
					numberArray = new double[countValidNumbers(fileIn)];
					for(int i=0; i<numberArray.length;i++){
						number = Double.parseDouble(scf.next());
						if(number>=0&&number<=14) numberArray[i]=number;
					}
					System.out.printf("Valores lidos com sucesso!\n");
					System.out.println();
					break;
				case 2: //escreve os valores de pH no terminal
					for(int i=0;i<numberArray.length;i++){
						System.out.printf("array[%d] = %.2f\n",i,numberArray[i]);
					}
					System.out.println();
					break;
				case 3: //calcula o valor medio do pH
					double sum=0; //soma dos valores de pH
					for(int i=0;i<numberArray.length;i++){
						sum += numberArray[i];
					}
					avg = (sum/numberArray.length);
					System.out.printf("Valor medio do pH: %.2f\n", avg);
					System.out.println();
					break;
				case 4:
					int baseCount=0;
					int acidCount=0;
					for(int i=0;i<numberArray.length;i++){
						number = numberArray[i];
						if(number<7) acidCount++;//se o pH for inferior a 7 a amostra e acida
						if(number>7) baseCount++; //se o pH for superior a 7 a amostra e basica
					}
					System.out.printf("Existem %d amostras acidas.\n",acidCount);
					System.out.printf("Existem %d amostras basicas.\n",baseCount);
					System.out.println();
					break;
				case 5:
					int aboveAvgCount=0; //numero de valores acima da media
					for(int i=0;i<numberArray.length;i++){ //percorre o array
						number = numberArray[i];
						if(number>avg) aboveAvgCount++;  //incrementa sempre que for superior à media
					}
					System.out.printf("Existem %d valores acima da media.\n", aboveAvgCount);
					System.out.println();
					break;
				case 6:
					double tmp;
					boolean changes=false;
					numberArrayOrdered = new double[numberArray.length];
					for(int i=0;i<numberArray.length;i++){
						numberArrayOrdered[i] = numberArray[i];
					}
					do{
						changes = false;
						for(int i=0;i<numberArrayOrdered.length-1;i++){
							if(numberArrayOrdered[i]>numberArrayOrdered[i+1]){
								tmp = numberArrayOrdered[i];
								numberArrayOrdered[i]=numberArrayOrdered[i+1];
								numberArrayOrdered[i+1]=tmp;
								changes = true;
							}
						}
					}while(changes);
					System.out.printf("Valores de pH ordenados:\n");
					for(int i=0;i<numberArrayOrdered.length;i++){
						System.out.printf("arrayOrdenado[%d] = %.2f\n",i,numberArrayOrdered[i]);
					}
					System.out.println();
					break;
				case 7:
					//termina o programa
					break;
				default:
					System.out.println("Opcao invalida!");
					break;
			}
		}while(opcao!=7);
	}
	public static int countValidNumbers(File fileIn) throws IOException{
		Scanner scf = new Scanner(fileIn);
		int numElem=0;
		double number; 
		while(scf.hasNext()){
			number = Double.parseDouble(scf.next());
			if(number>=0&&number<=14) numElem++;
		}
		scf.close();
		return numElem;
	}
	public static void checkFile(File file, String fileName){
		if(!file.exists()){
			System.out.printf("ERROR: File %s does not exist.\n", fileName);
			System.exit(1);
		}
		if(!file.canRead()){
			System.out.printf("ERROR: File %s cannot be read.\n", fileName);
			System.exit(2);
		}
	}
	
}

