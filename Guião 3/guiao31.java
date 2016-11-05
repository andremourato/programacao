import java.util.*;
public class guiao31 {
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int a,cont=0;
		do{
		System.out.printf("Introduzir valores positivos: ");
		a = sc.nextInt();
		cont++;
		}while(a>=0);
		System.out.printf("Foram introduzidos "+cont+" numeros");
	}
}

