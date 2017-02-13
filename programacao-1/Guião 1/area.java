import java.util.Scanner;
public class area
{
	public static void main (String args[]) 
	{
		Scanner sc = new Scanner(System.in);
		double l, c, a, p; //largura, comprimento, area, perimetro
		System.out.print("Largura da figura: ");
		l = sc.nextDouble();
		System.out.print("Comprimento da figura: ");
		c = sc.nextDouble();
		a = l*c;
		p = 2*l + 2*c;
		System.out.println("A area e: " + a);
		System.out.println("O perimetro e: " + p);
	}
}
