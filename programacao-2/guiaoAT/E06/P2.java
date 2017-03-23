import static java.lang.System.*;

public class P2 {
	
	public static void main (String args[]) {
		
		assert args.length > 0 : "Usage: java P2 <arg1> ... <argN>";
		for(String a : args) //No for each não existe indice. A String 'a' toma o valor de todos os argumentos
			out.printf("\"%s\" contains %d pairs of consecutive equal characters\n", a, countPairs(a, 0));
	}
	
	static int countPairs(String str, int i){
	
		if(i >= str.length()-1) return 0;
		if(str.charAt(i) == str.charAt(i+1)) return 1 + countPairs(str, i+1);
		else return 0 + countPairs(str, i+1);
	}
}

