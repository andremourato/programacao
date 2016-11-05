import java.util.Scanner;
public class decisao4switch {
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		boolean cr4, cr400;
		int m, a, d, ab4, ab400; //mes, ano, n de dias
		System.out.print("Mes: ");
		m = sc.nextInt();
		System.out.print("Ano: ");
		a = sc.nextInt();
		ab4 = a%4;
		ab400 = a%400;
		cr4 = ab4==0;
		cr400 = ab400==0;
		if (cr4 || cr400){//É ano bissexto
			switch(m){
				
			case 1:
				System.out.print("Janeiro de "+a+" tem 31 dias");
				break;
			case 2:
				System.out.print("Fevereiro de "+a+" tem 29 dias");
				break;
			case 3:
				System.out.print("Março de "+a+" tem 31 dias");
				break;
			case 4:
				System.out.print("Abril de "+a+" tem 30 dias");
				break;
			case 5:
				System.out.print("Maio de "+a+" tem 31 dias");
				break;
			case 6:
				System.out.print("Junho de "+a+" tem 30 dias");
				break;
			case 7:
				System.out.print("Julho de "+a+" tem 31 dias");
				break;
			case 8:
				System.out.print("Agosto de "+a+" tem 31 dias");
				break;
			case 9:
				System.out.print("Setembro de "+a+" tem 30 dias");
				break;
			case 10:
				System.out.print("Outubro de "+a+" tem 31 dias");
				break;
			case 11:
				System.out.print("Novembro de "+a+" tem 30 dias");
				break;
			case 12:
				System.out.print("Dezembro de "+a+" tem 31 dias");
				break;
			}									
		} else { //Não é bissexto
			switch(m){
				
			case 1:
				System.out.print("Janeiro de "+a+" tem 31 dias");
				break;
			case 2:
				System.out.print("Fevereiro de "+a+" tem 28 dias");
				break;
			case 3:
				System.out.print("Março de "+a+" tem 31 dias");
				break;
			case 4:
				System.out.print("Abril de "+a+" tem 30 dias");
				break;
			case 5:
				System.out.print("Maio de "+a+" tem 31 dias");
				break;
			case 6:
				System.out.print("Junho de "+a+" tem 30 dias");
				break;
			case 7:
				System.out.print("Julho de "+a+" tem 31 dias");
				break;
			case 8:
				System.out.print("Agosto de "+a+" tem 31 dias");
				break;
			case 9:
				System.out.print("Setembro de "+a+" tem 30 dias");
				break;
			case 10:
				System.out.print("Outubro de "+a+" tem 31 dias");
				break;
			case 11:
				System.out.print("Novembro de "+a+" tem 30 dias");
				break;
			case 12:
				System.out.print("Dezembro de "+a+" tem 31 dias");
				break;
			}
		}	
	}
}
