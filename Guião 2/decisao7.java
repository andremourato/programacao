import java.util.Scanner;
public class decisao7 {
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int n1, n2, n3;
		boolean c12,c13,c23;
		System.out.printf("NUMERO A: ");
		n1 = sc.nextInt();
		System.out.printf("NUMERO B: ");
		n2 = sc.nextInt();
		System.out.printf("NUMERO C: ");
		n3 = sc.nextInt();
		c12 = n1>n2;
		c13 = n1>n3;
		c23 = n2>n3;
		if(c12&&c13){
			System.out.printf("O MAIOR NUMERO E O NUMERO "+n1);
		}else if(!c12&&c23){
			System.out.printf("O MAIOR NUMERO E O NUMERO "+n2);
		}else if(!c13&&!c23){
			System.out.printf("O MAIOR NUMERO E O NUMERO "+n3);	
		}
	}
}
