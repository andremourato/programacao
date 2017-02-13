import java.util.Scanner;
public class guiao36 {
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int n1,n2,r,mdc;
		System.out.printf("N1: ");
		n1 = sc.nextInt();
		System.out.printf("N2: ");
		n2 = sc.nextInt();
		if(n1>n2){
			r=n1%n2;
			while(r!=0){
				n1=n2;
				n2=r;
				r=n1%n2;
			}
			mdc=n2;
			System.out.printf("MDC: "+mdc);
		}else if(n1==n2){
			System.out.printf("OS VALORES NAO PODEM SER IGUAIS");
		}else{
			r=n2%n1;
			while(r!=0){
				n2=n1;
				n1=r;
				r=n2%n1;
			}
			mdc=n1;
			System.out.printf("MDC: "+mdc);
		}
	}
}
