import java.util.Scanner;
public class guiao43 {
	
	static Scanner sc = new Scanner(System.in);
	public static void main (String args[]) {
		int i,m,p=1;
		Scanner sc = new Scanner(System.in);
		System.out.print("Fatorial: ");
		m=sc.nextInt();
		if(m<=10&&m>0){	
			for(i=1;i<=m;i++){
			System.out.printf("%d! = %d\n",i,fact(i));
			}
		}else{System.out.print("Número inválido!");}
			
	}
	public static int fact(int m){
		int i,p=1;
		if(m<=10&&m>0){
			
			for(i=1;i<=m;i++){
				p*=i;
			}
		}else{System.out.print("Número inválido!");}
		return p;
	}
}

