import java.util.Scanner;
public class guiao37 {
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int x,y,q,p=0;//p=produto
		System.out.printf("X: ");
		x=sc.nextInt();
		System.out.printf("Y: ");
		y=sc.nextInt();
		if(x>y){
			q=x%2;
			do{
				q=x%2;
				if(q!=0){ //x é impar
					p=p+y;
					x=x/2;
					y=y*2;
				}else if(q==0){ //x é par
					x=x/2;
					y=y*2;
				}	
			}while(x!=1);
			p=p+y;
			System.out.printf("PRODUTO: "+p);
		}else{
			q=y%2;
			do{
				q=y%2;
				if(q!=0){ //x é impar
					p=p+x;
					y=y/2;
					x=x*2;
				}else if(q==0){ //x é par
					y=y/2;
					x=x*2;
				}	
			}while(y!=1);
			p=p+x;
			System.out.printf("PRODUTO: "+p);
		}
	}	
}
