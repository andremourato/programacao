import java.util.Scanner;
public class guiao44 {
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		double n,n1,s=0,f;
		System.out.print("Valor de N: ");
		n=sc.nextInt();
		for(n1=0;n1<=n;n1++){
			f=Math.pow(-1,(int)n1)/(2*(int)n1+1);
			s+=f;
		}
		System.out.printf("Soma = %.15f\n",s);
		System.out.printf("π/4 = %.15f",Math.PI/4);
	}
}

