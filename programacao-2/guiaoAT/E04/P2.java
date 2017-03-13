import static java.lang.System.*;

public class P2{
	
	public static void main(String[] args){
		int number = 1;
		assert args.length != 0 : "No arguments detected";
		for(int i = 0; i < args.length; i++){
			out.printf("%s -> %s\n", args[i], invertDigits(args[i], "", "", 0));
		}
	}
	
	static String invertDigits(String origin, String digits, String newStr, int index){ //inverts the given string
		
		assert origin != "";
		assert 0 <= index && index < origin.length();
		char c = origin.charAt(index);
		if(!Character.isDigit(c)){
			if(index > 0 && Character.isDigit(origin.charAt(index-1))) newStr += digits;
			else if(Character.isDigit(origin.length()-1)) newStr += digits;
			 newStr += c;
			 digits = "";
		}else if(index == origin.length()-1){
			digits = c + digits;
			newStr += digits;
		}else digits = c + digits;
		if(index == origin.length()-1) return newStr;
		else return invertDigits(origin, digits, newStr, ++index);
	}
}

