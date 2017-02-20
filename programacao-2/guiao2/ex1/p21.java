/*************************************************************************
 * Compilation: javac j21.java 
 * Execution: java j21
 *************************************************************************/
import static java.lang.System.*;
import java.util.*;

public class p21
{
  // Exemplo simples de utilização da class Complex
  public static void main(String[] args)
  {
	Complexo a;
	try{ //the program checks if there are arguments
		a = new Complexo(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
		
	}catch(Exception e){ //if not it will ask the values to the user
		Scanner read = new Scanner(System.in);
		out.print("Re: ");
		int real = read.nextInt();
		out.print("Im: ");
		int imag = read.nextInt();
		a = new Complexo(real, imag);
	}

    // Vamos usar métodos de 'a'
    out.println("(" + a.real() + " + " + a.imag() + "i)");
    out.println("  parte real = " + a.real());
    out.println("  parte imaginaria = " + a.imag());
    out.println("  modulo = " + a.abs());
    out.printf("  fase   =  %2.2f\n", a.phase());
  }	
}
