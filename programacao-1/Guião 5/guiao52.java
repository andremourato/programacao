import java.util.*;
public class guiao52 {
	static Scanner read = new Scanner(System.in);
	public static void main (String args[]) {
		int n,fat;
		System.out.print("Fatorial de: ");
		n=read.nextInt();
		if(n>0&&n<=10){
			for(;n>=1;n--){
				
				System.out.printf("%d! = %d\n",n,fact(n));
			}
		}else{System.out.print("O valor tem que pertencer ao intervalo [1,10]");}
	}
	public static int fact(int x){

		int a,p=1;
		for(a=1;a<=x;a++) p*=a;
		return p;
	}
}
