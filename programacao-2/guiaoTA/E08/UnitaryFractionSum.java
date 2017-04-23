import static java.lang.System.*;

public class UnitaryFractionSum
{
	public static void main(String[] args){
		if(args.length != 2){
			out.println("Usage: java -ea UnitaryFractionSum <NUM> <DEN>");
			exit(1);
		}
		try{
			int num = Integer.parseInt(args[0]);
			int den = Integer.parseInt(args[1]);
			out.printf("%d/%d = %s\n", num, den, fractions(num, den));	
		}catch(NumberFormatException e){
			out.printf("ERROR: one of the arguments (%s, %s) is not an integer number!\n", args[0], args[1]);
			exit(1);
		}
		
	}
	
	static String fractions(int num, int den){
		int d = (int)Math.ceil((float)den/(float)num);
		num = num*d-den;
		den = den*d;
		if(num%den == 0) return "1/"+d;
		else return "1/"+d+" + "+fractions(num, den);
	}
}

