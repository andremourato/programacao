import java.util.Scanner;
public class guiao35 {
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int n,c=2,r;// nº natural
		System.out.printf("INTRODUZA UM NUMERO INTEIRO POSITIVO: ");
		n=sc.nextInt();
		if(n==2){
			System.out.println("NUMERO PRIMO");
		}else if(n>0){
			do{
				r=n%c;
				c++;
			}while(r!=0&&c<n);
				if(c==n){
					System.out.println("NUMERO PRIMO");
				}else{
					System.out.println("NUMERO NAO PRIMO");
				}
		}else{
			System.out.printf("NUMERO INVALIDO");
		}
	}
}

//~ Como o algoritmo não abrangia todos os números primos (neste caso não abrangia o número 2)
//~ Criei uma exceção para esse número com o código: if(n==2){System.out.println("NUMERO PRIMO")};
