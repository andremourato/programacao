import java.util.Scanner;
public class guiao42 {
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int i,n,c=1,p=1;//numero, contagem, produto
		System.out.printf("TABUADA DOS: ");
		n=sc.nextInt();
		if(n>0&&n<100){
			System.out.printf("TABUADA DOS %d \n",n);
			for(i=1;i<=10;i++){
				p=n*c;
				System.out.printf("%d * %d = %d\n",n,c,p);
				c++;
			}
		}else{System.out.print("Número inválido!");}
	}
}

