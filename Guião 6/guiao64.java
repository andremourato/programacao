import java.util.*;
public class guiao64 {
	
	static int num,arrayGlobal[];//variáveis e array global cujo alcance são todas as funções
	static Scanner read = new Scanner(System.in);
	public static void main (String args[]) {
		
		int num,arrayGlobal[];//num = número de notas a processar
		do{
			System.out.printf("Número de notas: ");
			num=read.nextInt();
		}while(num<=0||num>50);
		arrayGlobal=new int[num]; //Número de elementos do array definido pelo user
		//Cria o array
		for(int i=0;i<num;i++){
			arrayGlobal[i]=verifyNota();
		}
		System.out.printf("Histograma de notas\n");
		System.out.printf("-----------------------------\n");
		for(int i=0;i<=20;i++){
			System.out.printf("%2d | ",i);
			for(int j=0;j<arrayGlobal.length;j++){	
				if(arrayGlobal[j]==i)System.out.print("*");
			}
			System.out.println();
		}
	}
	//Função para validar valor
	public static int verifyNota(){
		int nota;
		do{
			System.out.print("Nota: ");
			nota=read.nextInt();
			
		}while(nota<0||nota>20);
		return nota;
	}
}
