import java.util.Scanner;
public class angulohip {
	
	public static void main (String args[]) {
		
		Scanner sc = new Scanner(System.in);
		double a, b, h, f, angr, ang; //cateto a, cateto b, hipotenusa, fração, angulo(radianos), angulo(graus)
		System.out.print("Comprimento do cateto A: ");
		a = sc.nextDouble();
		System.out.print("Comprimento do cateto B: ");
		b = sc.nextDouble();
		h = Math.sqrt(Math.pow(a, 2)+Math.pow(b,2));
		angr = Math.acos(a/h);
		ang = (angr*180)/Math.PI;
		System.out.println("Hipotenusa: " + h);
		System.out.println("Angulo: " + ang);
	}
}

