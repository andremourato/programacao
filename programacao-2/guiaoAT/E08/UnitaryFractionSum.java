import static java.lang.System.*;

public class UnitaryFractionSum {
	
	public static void main (String[] args) {
		
		if(args.length != 2){
			out.println("Usage: java UnitaryFractionSum <rational>");
			exit(1);
		}
		try{
			int num = Integer.parseInt(args[0]);
			int den = Integer.parseInt(args[1]);
			out.printf("%s = %s\n", args[0]+"/"+args[1], fractions(num, den));
		}catch(Exception e){
			out.println("Usage: java UnitaryFractionSum <rational>");
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

