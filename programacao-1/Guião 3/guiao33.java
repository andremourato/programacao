import java.util.Scanner;
public class guiao33 {
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int p;
		System.out.printf("NUMERO REAL: ");
		p = sc.nextInt();
		int max=p, min=p, med, s=0, n, c=0;
		do{
			System.out.printf("NUMERO REAL: ");
			n = sc.nextInt();
			s+=n;
			c++;
			if(n>max){
				max=n;
			}
			if(n<min){
				min=n;
			}
			med=s/c;
		}while(n!=p);
		System.out.println("VALOR MAXIMO: "+max);
		System.out.println("VALOR MINIMO: "+min);
		System.out.println("VALOR MEDIO: "+med);
		System.out.println("NUMERO DE ELEMENTOS: "+c);
	}
}
