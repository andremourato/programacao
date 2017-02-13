import java.util.Scanner;
public class guiao310 {
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int p1,p2,min,max;
		System.out.printf("NÚMERO: ");
		p1=sc.nextInt();
		min=p1;
		max=p1;
		if(p1>0){
			do{
				System.out.printf("NÚMERO: ");
				p2=p1;
				if(p1>0){
					if(p1>max){
						max=p1;
					}
					if(p1<min){
						min=p1;
					}
				}else{
				System.out.println("O NÚMERO DEVE SER INTEIRO POSITIVO");
				}
				p1=sc.nextInt();
				System.out.println("P2: "+p2+"		P1: "+p1+"		MAX: "+max+"		MIN: "+min);
			}while(p1!=p2*2&&p1>0);
				System.out.println("MÁXIMO: "+max);
				System.out.printf("MINIMO: "+min);
		}else{System.out.println("O NÚMERO DEVE SER INTEIRO POSITIVO");}
	}
}
