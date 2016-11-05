import java.util.Scanner;
public class guiao45 {
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		double a=3,b=4,c,cont=0;
		System.out.printf("A	B	C\n");
		c=pitagoras(a,b);
		do{
			do{
				c=pitagoras(a,b);
					if((c==(int)c)&&c!=0){ //verifica se c é inteiro. em caso positivo escreve os valores de a,b e c
					System.out.printf("%d	%d	%d\n",(int)a,(int)b,(int)c);
					b++;
					cont++;
					}else{b++;}
			}while(b<100);
			b=1;
			a++;

		}while(a<100);
		System.out.printf("\nFORAM REPRESENTADOS %d COMBINAÇÕES",(int)cont);
	}
	public static double pitagoras(double x, double y){
		double hip=0;
		if(x<y){hip=Math.sqrt(Math.pow(x,2)+Math.pow(y,2));}
		return hip;
	}
}
