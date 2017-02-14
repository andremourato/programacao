import static java.lang.System.*;
import java.util.Scanner;

// Complete o programa para calcular a nota final NF de
// um aluno de Programação 2 (2016--2017) na época normal.
public class p12{
  public static final Scanner in = new Scanner(System.in);

  public static void main(String[] args){
    double tpi1 = readInRange("TPI1: ", 0.0, 20.0);
    double tpi2 = readInRange("TPI2: ", 0.0, 20.0);
    double pg1 = readInRange("PG1: ", 0.0, 20.0);
    double pg2 = readInRange("PG2: ", 0.0, 20.0);
    double pg3 = readInRange("PG3: ", 0.0, 20.0);
    double ef = readInRange("EF: ", 0.0, 20.0);
    double pg = (pg1+pg2+pg3)/3;
    double tp = (tpi1+tpi2)/2;
    double p = calculateP(pg, ef);
    double nf = 0.2*tp+0.8*p;

    out.printf("PG = %.1f\n", pg);
    out.printf("TP = %.1f\n", tp);
    out.printf("P  = %.1f\n", p);
    out.printf("NF = %.1f\n", nf);
    if (nf < 9.5)
      out.println("REPROVADO!");
    else
      out.println("APROVADO!");
  }

  // Reads a double that must be in the range [min, max].
  // Shows the prompt, reads a double value.
  // If the value is not in the range, prints a warning and repeats.
	public static double readInRange(String prompt, double min, double max){
	assert min <= max : "max must be at least as large as min!";
	System.out.print(prompt);
	double value = in.nextDouble();
	return value;
	}
  
  static double calculateP(double pg, double ef){
		if(ef-4<=pg||ef+4>=pg) return 0.5*ef+0.5*pg;
		else if(pg<ef-4) return 0.75*ef+0.25*pg-1;
		else return 0.75*ef+0.25*pg+1;
			
	}
}
