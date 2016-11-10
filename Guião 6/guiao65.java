import java.util.*;
public class guiao65 {
	
	static Scanner read = new Scanner(System.in);
	public static void main (String args[]) {
		int size=readPos(),desv;
		double[] arrayNum = new double[size];
		arrayNum=createArray(arrayNum,size);
		desv=calculateDesv(arrayNum, size);
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
	//Função de calculo do desvio-padrão
	public static double calculateDesv (double[] array,int size){
		int soma=0;
		double media,desv;
		for(int i=0;i<size;i++){	
			soma+=array[i];
		}
		media=soma/size;
		desv=sqrt(/size-1);
		return desv;
		
	}
}

