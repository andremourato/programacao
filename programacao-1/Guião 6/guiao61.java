import java.util.*;
public class guiao61 {
	
	static Scanner read = new Scanner(System.in);
	public static void main (String args[]) {
		int a[];
		System.out.print("Quantos números?: ");
		int n = read.nextInt(),i;
		a = new int[n];
		for(i=0;i<n;i++){
			System.out.print("Número: ");
			a[i]=read.nextInt();
		}
		for(i=--n;i>=0;i--){
			System.out.printf("%d ",a[i]);
		}		
	}
}
