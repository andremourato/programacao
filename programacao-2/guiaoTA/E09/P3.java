import static java.lang.System.*;

public class P3 {

   public static void main(String[] args) {
	   if(args.length % 2 != 0){
		  out.println("ERROR: even number of arguments required!");
	   }
	   assert args.length % 2 == 0;
	   for(int i = 0; i < args.length/2; i++){
		  out.printf("\"%s\" is prefixed by \"%s\" -> ", args[i*2], args[i*2+1]);
		  if(isPrefix(args[i*2], args[i*2+1], 0)) out.println("true");
		  else out.println("false");
	   }
   }
   
   static boolean isPrefix(String str, String prefix, int i){
	   if(prefix.equals("")) return true;
	   if(str.equals("")) return false;
	   if(str.length() < prefix.length()) return false;
	   if(i == prefix.length() - 1) return true;
	   if(str.charAt(i) != prefix.charAt(i)) return false;
	   return isPrefix(str, prefix, i+1);
	  
   }
}

