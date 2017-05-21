import p2utils.*;
import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class P111 {
	
	public static void main (String[] args) throws IOException {
		if(args.length != 1){
			out.println("Usage: java -ea P111 <password file>");
			exit(1);
		}
		Scanner sc = new Scanner(new File(args[0]));
		KeyValueList<String> loginInfo = new KeyValueList<String>();
		while(sc.hasNext()){
			loginInfo.set(sc.next(), sc.next());
		}
		Scanner read = new Scanner(in);
		do{
			out.print("Login:	");
			String login = read.nextLine();
			out.print("Password:  ");
			String password = read.nextLine();
			if(loginInfo.contains(login) && loginInfo.get(login).equals(password))
				out.println("Authentication successful");
			else out.println("Authentication failed");
			out.println();
		}while(true); //This loop is only broken with EOF
	}
}

