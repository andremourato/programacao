import java.util.Scanner;
public class decisao6 {
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int n1, rd;
		System.out.printf("INTRODUZA O NUMERO: ");
		n1 = sc.nextInt();
		rd = n1%2;
		if(rd==0){
		System.out.printf("O NUMERO "+n1+" E PAR");
		} else{
		System.out.printf("O NUMERO "+n1+" NAO E PAR");
		}
	}
}

