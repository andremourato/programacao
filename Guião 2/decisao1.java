import java.util.Scanner;
public class decisao1 {
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		double tp1, tp2, api, ep, nf;
		System.out.print("Nota de TP1: ");
		tp1 = sc.nextDouble();
		System.out.print("Nota de TP2: ");
		tp2 = sc.nextDouble();
		System.out.print("Nota de API: ");
		api = sc.nextDouble();
		System.out.print("Nota de EP: ");
		ep = sc.nextDouble();
		nf = 0.1*tp1+0.1*tp2+0.3*api+0.5*ep;
		
		if (nf >= 95) {
			
		System.out.println("APROVADO");
			
		}
		
		else {
			
		System.out.println("REPROVADO");
			
		}
		
	}
}

