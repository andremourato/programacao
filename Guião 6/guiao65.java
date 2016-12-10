/* 
 * André Ribeiro Martins Marques Mourato
 * NºMec: 84745
 * PROGRAMA IMCOMPLETO
 * 
 */
import java.util.*;
public class guiao65 {
	
	static Scanner read = new Scanner(System.in);
	public static void main (String args[]) {
		
		int size=readPos();
		double desv;
		double[] arrayNum = new double[size];
		//Criar array
		arrayNum=createArray(arrayNum,size);
		//Calcular desvio-padrão
		desv=calculateDesv(arrayNum, size);
		System.out.printf("DESVIO PADRAO: %f",calculateDesv(arrayNum,size));
	}
	//Função de validação do número de elementos
	public static int readPos(){
		
		int size;
		do{
			System.out.print("Número de valores a introduzir: ");
			size = read.nextInt();
			if(size<=0) System.out.print("O número deve ser positivo!\n");;
		}while(size<=0);
		return size;
	}
	//Função de criação do array
	public static double[] createArray(double[] array,int size){
		
		for(int i=0;i<size;i++){
			System.out.print("Valor: ");
			array[i]=read.nextDouble();
		}
		return array;
	}
	//Função de calculo da média
	public static double calculateMedia (double[] array,int size){
		
		int somaArray=0;
		double media;
		for(int i=0;i<size;i++){	
			somaArray+=array[i];
		}
		media=somaArray/size;
		return media;
		
	}
	//Função de calculo do desvio-padrão
	public static double calculateDesv (double[] array,int size){
		
		int soma=0;
		double media, desv;
		media=calculateMedia(array,size);
		for(int i=0;i<size;i++){	
			soma+=Math.pow(array[i]-media,2);
		}
		desv=Math.sqrt(soma/size-1);
		return desv;
		
	}
}
/* PROGRAMA IMCOMPLETO */

