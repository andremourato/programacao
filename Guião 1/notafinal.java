import java.util.Scanner;
public class notafinal {
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		double tp1, tp2, api, ep, nf;//nf=nota final
		System.out.print("Nota de TP1: ");
		tp1 = sc.nextDouble();
		System.out.print("Nota de TP2: ");
		tp2 = sc.nextDouble();
		System.out.print("Nota de API: ");
		api = sc.nextDouble();
		System.out.print("Nota de EP: ");
		ep = sc.nextDouble();
		nf = 0.15*tp1+0.15*tp2+0.30*api+0.4*ep;
		System.out.println("A nota final e: " + nf);
	}
}

