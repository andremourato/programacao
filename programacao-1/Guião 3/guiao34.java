import java.util.Scanner;
public class guiao34 {
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int c=1, ran=(int)(100.0*Math.random()) + 1, input;
		do{
			System.out.printf("TENTATIVA "+c+": ");
			input=sc.nextInt();
			if(input>ran){
				System.out.println("NUMERO DEMASIADO ALTO");
			}else if(input<ran){
				System.out.println("NUMERO DEMASIADO BAIXO");
			}
			
			c++;
		}while(input!=ran);
		System.out.printf("ACERTOU NO NUMERO EM "+(c-1)+" TENTATIVAS");
	}
}
