import java.util.*;
public class guiao46 {
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int i1, i2,larg, alt;
		System.out.print("Largura: ");
		larg=sc.nextInt();
		System.out.print("Altura: ");
		alt=sc.nextInt();
		for(i1=1;i1<=alt;i1++){
				System.out.printf("\n");
				for(i2=1;i2<=larg;i2++){System.out.print("* ");}
		}
	}
}
