import java.util.*;
public class guiao55 {
	
	static Scanner read = new Scanner(System.in);
	public static void main (String args[]) {
		int larg, alt;
		System.out.print("Largura: ");
		larg=read.nextInt();
		System.out.print("Altura: ");
		alt=read.nextInt();
		if(alt<=1||larg<=1){System.out.print("DIMENSÃO INVÁLIDA");
		}else printNtimes(alt,larg);
		
	}
	public static void printNtimes(int alt,int larg){
		int i1,i2,i3;
		String bigSpace="",space = " ";
		for(i1=0;i1<larg;i1++){
			System.out.print("* ");
		}
		System.out.printf("\n");
		//inicio do algoritmo dos espaços vazios
		for(i2=0;i2<=(alt-3);i2++){
			System.out.printf("*");
			for(i3=0;i3<=2*larg-4;i3++)bigSpace+=space;
			System.out.printf(bigSpace);
			System.out.printf("*\n");
			bigSpace="";
		}
		//fim do algoritmo
		for(i1=0;i1<larg;i1++){
			System.out.print("* ");
		}
	}
}
