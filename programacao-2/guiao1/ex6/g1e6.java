import java.util.*;

public class g1e6 {
	
	public static void main (String[] args) {
		Scanner read = new Scanner(System.in);
		int random = (int) (Math.random()*(101));
		int guess;
		int score=0;
		System.out.println("---------------------");
		System.out.println("| ADIVINHA O NUMERO |");
		System.out.println("---------------------");
		System.out.println();
		do{
			System.out.print("Tentativa: ");
			guess = read.nextInt();
			if(guess>random) System.out.println("A tentativa e maior do que o numero");
			else if(guess<random) System.out.println("A tentativa e menor do que o numero");
			System.out.println();
			score++;
		}while(guess!=random);
		if(score==1)System.out.println("Conseguiste acertar no numero numa tentativa!\n");
		else System.out.printf("Conseguiste acertar no numero em %d tentativas\n",score);
		
	}
}
