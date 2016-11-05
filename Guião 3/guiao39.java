import java.util.Scanner;
public class guiao39 {
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		double r;//real,negativo,positivo,intervalo_positivo,intervalo_negativo
		int n=0,p=0,ip=0,in=0;
		System.out.printf("NUMERO REAL: ");
		r=sc.nextDouble();
		if(r!=0){
			if(r<0){
				n=1;
			}else if(r>0){
				p=1;
			}
			if(r>=100&&r<=1000){
				ip=1;
			}else if(r>=-1000&&r<=-100){
				in=1;
			}
			do{
				System.out.printf("NUMERO REAL: ");
				r=sc.nextDouble();
				if(r<0){
					n++;
				}else if(r>0){
					p++;
				}
				if(r>=100&&r<=1000){
					ip++;
				}else if(r>=-1000&&r<=-100){
					in++;
				}
			}while(r!=0);
			System.out.println("NUMEROS POSITIVOS: "+p);
			System.out.println("NUMERO NEGATIVOS: "+n);
			System.out.println("NUMEROS EM [100,1000]: "+ip);
			System.out.printf("NUMEROS EM [-1000,-100]: "+in);
		}else{
			System.out.printf("PRIMEIRO NUMERO NAO PODE SER 0");
		}
	}
}
