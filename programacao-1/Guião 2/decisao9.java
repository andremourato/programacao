import java.util.Scanner;
public class decisao9 {
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int m; //mode (1/0)
		double t, c, f; //temperature, celsius, fahrenheit
		
		System.out.printf("Temperatura: ");
		t = sc.nextDouble();
		System.out.print("Modo: ");
		m = sc.nextInt();
		switch(m){
			case 0:
				f = 1.8*t+32;
				System.out.print("Temperatura em Fahrenheit: "+f);
				break;
				
			case 1:
				c = (t-32)/1.8;
				System.out.print("Temperatura em Celsius: "+c);
				break;
		}
	}
}
