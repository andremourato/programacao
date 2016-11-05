import java.util.Scanner;
public class guiao32 {
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		double n,p=1;
		do{
			System.out.printf("NUMERO REAL:");
			n =sc.nextDouble();
			if(n==0){
			}else{
				p*=n;
			}
		}while(n!=0);
		System.out.printf("PRODUTO: "+p);
	}
}
