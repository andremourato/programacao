public class Factors{
	
	public static void main (String args[]) {
		if(args.length == 0){
			System.out.println("Invalid number of arguments");
			System.exit(1);
		}
		//Verificação desnecessária, porque o programa percorre 2 vezes o array. Mas torna o programa mais robusto
		//Garante que todos os argumentos são válidos antes de correr
		try{ 
			for(String a : args){
				int n = Integer.parseInt(a);
			}
		}catch(Exception e){
			System.out.println("Usage: java Factors <number>");
			System.exit(1);
		}
		for(String a : args){
				int n = Integer.parseInt(a);
				System.out.printf("%d = %s\n", n, factors(n));
		}
	}
	
	static String factors(int n){
		
		assert n >= 0;
		if(n == 0) return "0";
		if(n == 1) return "1";
		for(int i = 2; i < n/2; i++){ // Para tornar o algoritmo mais eficaz, não é necessário verificar os valores a partir de n/2
			if(n % i == 0) return String.valueOf(i) + " * " + factors(n/i);
		}
		return String.valueOf(n);
	}
}

