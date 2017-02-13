import java.util.Scanner;
public class CelsiustoF {
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		double c, f;
		System.out.printf("Temperatura em Celsius: ");
		c = sc.nextDouble();
		f = 1.8*c+32;
		System.out.printf("Temperatura em Fahrenheit: "+f);		
	}
}

