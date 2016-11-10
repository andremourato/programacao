/**
 * Function - Define several functions, and test them.
 * 
 * Nesta classe deve definir novas funções e testá-las na função main.
 * 
 * 
 **/
import java.util.Scanner;
public class guiao5 {
	static Scanner read = new Scanner(System.in);
	public static void main (String args[]) {
		Scanner read = new Scanner(System.in);
		//~ // Testar função sqr:
		System.out.printf("sqr(%f) = %f\n", 10.1, sqr(10.1));
		System.out.printf("sqr(%f) = %f\n", -2.0, sqr(-2.0));
	
		//Invoque as funções pedidas no enunciado para as testar:
		//Por exemplo, para testar func f (problema 5.2):
		
		System.out.printf("f(%d) = %f\n", 5, f(5));
		//Testar as restantes funções desenvolvidas
		System.out.printf("max(%.03f,%.03f) = %.03f\n", 3.1, 5.2, max(3.1, 5.2));
		System.out.printf("max(%d,%d) = %d\n", 3, 2, max(3, 2));
		System.out.printf("poly3(%.01f,%.01f,%.01f,%.01f,%.01f) = %.02f\n", 1.0,2.0,1.0,3.0,1.0,poly3(1.0,2.0,1.0,1.0,1.0));
		System.out.printf("fact(%d) = %d\n", 5, fact(5));
		System.out.printf("Número introduzido: %d\n",getIntPos());
		System.out.printf("Número %d pertencente ao intervalo!\n",getIntRange());
		System.out.print("Mensagem a repetir: ");
		String msg = read.next();
		System.out.print("Quantas vezes?: ");
		int n = read.nextInt();
		printNtimes(msg,n);
		//int ano = getIntPos("Ano? ");
		//System.out.printf("ano = %d\n", ano);
	
	}
	/**
	 * sqr - calcula o quadrado de um número (real).
	 * (A classe Math tem uma função para a raiz quadrada, sqrt,
	 * mas falta-lhe uma para o quadrado: sqr colmata essa lacuna!)
	 **/

	public static double sqr(double x) {
		double y;	// variavel para resultado
		y = x*x;	// calculo do resultado a partir dos dados
		return y;	// devolver o resultado
	}
	
	// Defina as funções pedidas no enunciado:
	
	public static double f(int n){
		double f;
		f=1/(1+sqr(n));
		return f;
	}
	public static double max(double x, double y){
		return(x>y?x:y);
	}
	
	public static int max(int x, int y){
		return(x>y?x:y);
	}
	public static double poly3(double x, double a, double b, double c, double d){
		return ((a*x*sqr(x))+(b*sqr(x))+(c*x+d));
	}
	public static int fact(int x){
		int a=1,p=1;
		do{
			p*=a;
			a++;
		}while(a<=x);
		return p;
	}
	public static int getIntPos(){
		int inteiro=-1;
		Scanner read = new Scanner(System.in);
		while(inteiro<0){
			System.out.print("Inteiro positivo: ");
			inteiro = read.nextInt();
			if(inteiro<0)System.out.println("O valor deve ser inteiro postitivo!");
		}
		return inteiro;
	}
	public static int getIntRange(){
		int a,b,value=0;
		System.out.print("Limite a: ");
		a=read.nextInt();
		System.out.print("Limite b: ");
		b=read.nextInt();
		if(a<b){
			do{
				System.out.print("VALOR: ");
				value = read.nextInt();
			}while(value>b||value<a);
		}else if(a>b){
			do{
				System.out.print("VALOR: ");
				value = read.nextInt();
			}while(value>a||value<b);
		}else System.out.print("Limites inválidos!!");
		return value;
	}	
	public static void printNtimes(String msg, int n){
		int i;
		for(i=0;i<n;i++){
			System.out.print(msg);
		}
	}
}
