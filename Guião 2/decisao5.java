import java.util.Scanner;
public class decisao5 {
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		boolean c1;
		double x1, y1, x2, y2, x3, y3, x4, y4, l1, l2, l3, l4;//coordenadas (x,y), comprimento dos lados (l)
		System.out.print("Coordenada X do ponto 1: ");
		x1 = sc.nextDouble();
		System.out.print("Coordenada Y do ponto 1: ");
		y1 = sc.nextDouble();
		System.out.print("Coordenada X do ponto 2: ");
		x2 = sc.nextDouble();
		System.out.print("Coordenada Y do ponto 2: ");
		y2 = sc.nextDouble();
		System.out.print("Coordenada X do ponto 3: ");
		x3 = sc.nextDouble();
		System.out.print("Coordenada Y do ponto 3: ");
		y3 = sc.nextDouble();
		System.out.print("Coordenada X do ponto 4: ");
		x4 = sc.nextDouble();
		System.out.print("Coordenada Y do ponto 4: ");
		y4 = sc.nextDouble();
		l1 = Math.abs(x2-x1);
		l2 = Math.abs(y2-y3);
		l3 = Math.abs(x3-x4);
		l4 = Math.abs(y1-y4);
		c1 = (l1+l2+l3+l4)/4==l1;
		
		if(c1==true){
			System.out.printf("A figura forma um quadrado!");
			
		} else{
			System.out.printf("A figura nao forma um quadrado!");
		}		
	}
}
