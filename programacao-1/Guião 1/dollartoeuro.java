import java.util.Scanner;
public class dollartoeuro {
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		double d, e; //dollar, euro
		System.out.print("Dolares: ");
		d = sc.nextDouble();
		e = 0.8913*d;
		System.out.println("Euros: " + e);
	}
}

