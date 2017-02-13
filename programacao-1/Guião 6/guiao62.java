import java.util.*;
public class guiao62 {
	
	static Scanner read = new Scanner(System.in);
	public static void main (String args[]) {
		
		int i,num,numCount=0,count=0,intPos;//numCount=nº de vezes que o número aparece; num=contagem do número de valores introduzidos
		System.out.printf("Número a verificar: ");
		num=read.nextInt();
		do{
			System.out.printf("Inteiro positivo: ");
			intPos=read.nextInt();
			if(intPos==num){
				numCount++;
			}
			count++;
		}while(count<100&&intPos>=0);
		System.out.printf("O número %d apareceu %d vezes",num,numCount);
	}
}
