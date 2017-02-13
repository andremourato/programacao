import java.util.Scanner;
public class totalliquidofatura {
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		double p, dp, d, ivap, iva, tlf; //preço, desconto, iva, totalliquidofatura
		System.out.print("Preco do produto: ");
		p = sc.nextDouble();
		System.out.print("Desconto: ");
		dp = sc.nextDouble();
		d = dp/100;
		System.out.print("Taxa de IVA: ");
		ivap = sc.nextDouble();
		iva = ivap/100;
		tlf = p-p*Math.abs(d)+p*iva;
		System.out.println("Valor liquido: " + tlf);
	}
}

