import java.util.Scanner;

public class G1E3 {
	
	public static void main (String args[]) {
		
		Scanner read = new Scanner(System.in);
		System.out.println("--------------------------");
		System.out.println("|  Figuras geométricas   |");
		System.out.println("--------------------------");
		System.out.println("| 1 - Criar um círculo   |");
		System.out.println("| 2 - Criar um quadrado  |");
		System.out.println("| 3 - Criar um retangulo |");
		System.out.println("--------------------------");
		System.out.print("\nFigura: ");
		int type = Integer.parseInt(read.nextLine());
		
		Circle circle = null;
		Square square = null;
		Rectangle rectangle = null;
		
		if(type == 1){
			
			System.out.print("Raio: ");
			int radius = Integer.parseInt(read.nextLine());
			
			System.out.print("Coordenada X do centro: ");
			int x = Integer.parseInt(read.nextLine());
			
			System.out.print("Coordenada Y do centro: ");
			int y = Integer.parseInt(read.nextLine());
			
			circle = new Circle(x,y,radius);
			System.out.println("\nInformação sobre a figura introduzida: \n"+circle);
			
		}else if(type == 2){
			
			System.out.print("Comprimento: ");
			int width = Integer.parseInt(read.nextLine());
			
			System.out.print("Coordenada X do centro: ");
			int x = Integer.parseInt(read.nextLine());
			
			System.out.print("Coordenada Y do centro: ");
			int y = Integer.parseInt(read.nextLine());
			
			square = new Square(x,y,width);
			System.out.println("\nInformação sobre a figura introduzida: \n"+square);
			
		}else if(type == 3){
			
			System.out.print("Comprimento: ");
			int width = Integer.parseInt(read.nextLine());
			
			System.out.print("Largura: ");
			int height = Integer.parseInt(read.nextLine());
			
			System.out.print("Coordenada X do centro: ");
			int x = Integer.parseInt(read.nextLine());
			
			System.out.print("Coordenada Y do centro: ");
			int y = Integer.parseInt(read.nextLine());
			
			rectangle = new Rectangle(x,y,width,height);
			System.out.println("\nInformação sobre a figura introduzida: \n"+rectangle);
		}
		System.out.println();
		//Test figures
		Circle circle2 = new Circle(7,0,3);
		Circle circle3 = new Circle(4,3,5);
		Square square2 = new Square(1,2,3);
		Square square3 = new Square(6,4,5);
		Rectangle rectangle2 = new Rectangle(1,2,3,4);
		Rectangle rectangle3 = new Rectangle(2,5,5,7);
		
		//The interseption checking is only available if the user has chosen a circle
		if(circle != null){
			System.out.println("A figura é um círculo de raio 3: "+circle.equals(circle2));
			System.out.println("Interseta o círculo com centro no ponto "+circle2.center()+" e de raio "+circle2.radius()+": "+circle.intersepts(circle2));
			System.out.println("Interseta o círculo com centro no ponto "+circle3.center()+" e de raio "+circle3.radius()+": "+circle.intersepts(circle3));
		}
		if(square != null) System.out.println("A figura é um quadrado de comprimento 3: "+square.equals(square2));
		if(rectangle != null) System.out.println("A figura é um retangulo de dimensões 3x4: "+rectangle.equals(rectangle2));
		
	}
	
}

