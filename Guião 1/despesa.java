import java.util.Scanner;
public class despesa {
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		double d1, d2, d3, d4, dt, dmd;//despesa(dia 1), despesa(dia 2), despesa(dia 3) despesa total, despesa media diaria
		System.out.print("Despesa do dia 1: ");
		d1 = sc.nextDouble();
		d2 = d1*1.2;
		d3 = d2*1.2;
		d4 = d3*1.2;
		dt = d1+d2+d3+d4;
		dmd = dt/3;
		System.out.println("Despesa total: " + dt );
		System.out.println("Despesa media diaria: " + dmd);
		
	}
}

