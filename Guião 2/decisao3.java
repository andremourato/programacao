import java.util.Scanner;
public class decisao3 {
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int i; //idade
		boolean c1, c2, c3, c4;
		System.out.print("Idade do visitante: ");
		i = sc.nextInt();
		c1 = i >= 6;
		c2 = i <= 12;
		c3 = i >= 13;
		c4 = i <= 65;
		if (i < 6){
		System.out.print("Isento de pagamento");
		} else if (c1&&c2){
		System.out.print("Bilhete de criança");
		} else if (c3&&c4){
		System.out.print("Bilhete normal");	
		} else if (i > 65){
		System.out.print("Bilhete terceira idade");
		}
		
	}
}

