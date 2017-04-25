import static java.lang.System.*;

public class P2 {
	
	public static void main (String[] args) {
		
		for(String s : args){
			out.printf("\"%s\" -> \"%s\"\n",s, invertString(s, "", 0));
		}
	}
	
	static String invertString(String s, String numbers, int i){
		if(i > s.length() - 1) return "";
		char c = s.charAt(i);
		if(Character.isDigit(c)){
			numbers = c + numbers;
			if(i == s.length()-1 || !Character.isDigit(s.charAt(i+1))){
				return numbers + invertString(s, "", i + 1);
			}
			return invertString(s, numbers, i+1); 
		}
		else return c + invertString(s, "", i + 1);
	}
}
