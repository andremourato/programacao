import java.util.Scanner;
public class decisao11 {
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		double x1, x2, a, b, c, i, r;//incognita,2ºgrau,1ºgrau,independente
		System.out.print("Valor de A: ");
		a = sc.nextDouble();
		System.out.print("Valor de B: ");
		b = sc.nextDouble();
		System.out.print("Valor de C: ");
		c = sc.nextDouble();
		if(Math.sqrt(Math.pow(b,2)-(4*a*c))>0){
			
			x1=((-b)+Math.sqrt(Math.pow(b,2)-(4*a*c)))/(2*a);
			x2=((-b)-Math.sqrt(Math.pow(b,2)-(4*a*c)))/(2*a);
			System.out.println("X1 = "+x1);
			System.out.printf("X2 = "+x2);
			
		}else{
			
			r=(-b)/(2*a);
			i=Math.sqrt(Math.abs(Math.pow(b,2)-(4*a*c)))/(2*a);
			System.out.println("X1 = "+r+"+"+i+"i");
			System.out.printf("X2 = "+r+"-"+i+"i");
		}
	}
}
