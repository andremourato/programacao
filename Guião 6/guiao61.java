import java.util.*;
public class guiao61 {
	static Scanner read = new Scanner(System.in);
public static void main (String args[]) {
		System.out.print("Tamanho do array: ");
		int n=read.nextInt(), i;
		int a[];
		a=new int[n];
		for(i=0;i<n;i++) {
			a[i]=i;
			System.out.printf("%d ",a[i]);
		}
	}
}
