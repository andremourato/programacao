import java.util.Scanner;
public class decisao8 {
	
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
			if(c23){
				System.out.printf("NUMEROS POR ORDEM CRESCENTE: "+n3+", "+n2+", "+n1);
			}else{
				System.out.printf("NUMEROS POR ORDEM CRESCENTE: "+n2+", "+n3+", "+n1);
			}
		}else if(!c12&&c23){
			if(c13){
				System.out.printf("NUMEROS POR ORDEM CRESCENTE: "+n1+", "+n1+", "+n2);
			}else{
				System.out.printf("NUMEROS POR ORDEM CRESCENTE: "+n1+", "+n3+", "+n2);
			}
		}else if(!c13&&!c23){
			if(c12){
				System.out.printf("NUMEROS POR ORDEM CRESCENTE: "+n2+", "+n1+", "+n3);
			}else{
				System.out.printf("NUMEROS POR ORDEM CRESCENTE: "+n1+", "+n2+", "+n3);
			}	
		}
	}
}
