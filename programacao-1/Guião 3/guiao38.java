import java.util.Scanner;
public class guiao38 {
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int n,c=1,sum=0;
		double med;
		System.out.printf("NOTA: ");
		n=sc.nextInt();
		if(n<=20&&n>=0){
			while(n>=0){
				sum+=n;
				System.out.printf("NOTA: ");
				n=sc.nextInt();
				c++;
			}
			med=(double)sum/(c-1);
			System.out.println("SOMA: "+sum);
			System.out.printf("MEDIA: "+med);
		}else{
			System.out.printf("NOTA INVALIDA");
		}
	}
}

