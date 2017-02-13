import java.util.Scanner;
public class distancia {
	
	public static void main (String args[]) {
		
		Scanner sc = new Scanner(System.in);
		double x1, y1, x2, y2, dpc, dpk; //A(x1,y1), B(x2,y2), Distância(cm), Distância(km)
		System.out.print("Coordenada x do ponto A: ");
		x1 = sc.nextDouble();
		System.out.print("Coordenada y do ponto A: ");
		y1 = sc.nextDouble();
		System.out.print("Coordenada x do ponto B: ");
		x2 = sc.nextDouble();
		System.out.print("Coordenada y do ponto B: ");
		y2 = sc.nextDouble();
		dpc = Math.sqrt(Math.pow((x2-x1),2)+Math.pow((y2-y1),2));
		dpk = dpc*100;
		System.out.println("A distância em cm e: " + dpc);
		System.out.println("A distancia em km e: " + dpk);
	}
}
