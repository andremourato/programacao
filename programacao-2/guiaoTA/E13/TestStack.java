/*
 *Programa criado para testar a StackX, visto que o material de apoio fornecido
 * no eLearning relativo a este exercício é pouco
 * 
 */
public class TestStack {
	
	static StackX s = new StackX();
	public static void main (String[] args) {
		s.push('a');
		printInfo();
		s.push('b');
		printInfo();
		s.push('c');
		printInfo();
		s.push('d');
		printInfo();
		s.push('e');
		printInfo();
		s.popN(3);
		printInfo();
	}
	
	private static void printInfo(){
		System.out.println("-----------------------------");
		System.out.println("size() = "+s.size());
		System.out.println("top() = "+s.top());
		System.out.println("topMatches(\"a\") = "+s.topMatches("a"));
		System.out.println("topMatches(\"ab\") = "+s.topMatches("ab"));
		System.out.println("topMatches(\"abc\") = "+s.topMatches("abc"));
		System.out.println("topMatches(\"abcd\") = "+s.topMatches("abcd"));
		System.out.println("topMatches(\"cd\") = "+s.topMatches("cd"));
		System.out.println("toString() = "+s.toString());
		
	}
}

