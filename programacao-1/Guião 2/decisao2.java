import java.util.Scanner;
public class decisao2 {
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		double n1, n2;
		System.out.print("Numero A: ");
		n1 = sc.nextDouble();
		System.out.print("Numero B: ");
		n2 = sc.nextDouble();
		
		if (n1 > n2){
			System.out.print("A > B");
		} else if (n1 == n2){
			System.out.print("A = B");
		} else {
			System.out.print("A < B");
		}
	}
}
