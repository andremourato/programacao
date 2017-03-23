import static java.lang.System.*;

public class p64 {
	
	public static void main (String[] args) {
		
		for(String s : args){
			out.printf("\"%s\" -> \"%s\"",s, invertString(s, s.length()-1));
		}
	}
	
	static String invertString(String s, int i){
		if(i < 0) return "";
		return s.charAt(i) + invertString(s, i-1);
	}
}

