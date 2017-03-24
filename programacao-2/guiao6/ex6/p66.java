import static java.lang.System.*;

public class p66 {
	
	static int P;
	static float juro;
		
	public static void main (String[] args) {
		
		if(args.length != 4){
			out.println("USO: java -ea p66 <n> <M> <T> <P>");
			exit(1);
		}
		
		try{ //Verifica se todos os argumentos são válidos
			for(String a : args)
				Integer.parseInt(a);
		}catch(Exception e){
			out.println("USO: java -ea p66 <n> <M> <T> <P>");
			exit(1);
		}
		
		int N = Integer.parseInt(args[0]);
		int M = Integer.parseInt(args[1]);
		int T = Integer.parseInt(args[2]);
		P = Integer.parseInt(args[3]);
		
		float div = (float)M;
		juro = 1+(float)T/100;
		
		/* Método iterativo*/
		for(int n = 1; n <= N;n++)
			div = div * juro - P;
		if(div < 0){
			out.print("\nImpossivel pagar a divida\n");
			exit(1);
		}
		out.printf("(iterativo) d(%d) = %.10f \n", N, div);
		
		/*Método recursivo*/
		div = getDiv(M, N);
		if(div < 0){
			out.print("\nImpossivel pagar a divida\n");
			exit(1);
		}
		out.printf("(recursivo) d(%d) = %.10f\n", N, div);
	}
	
	static float getDiv(int M, int n){
		
		if(n == 0) return M;
		else return getDiv(M, n-1) * juro - P;
	}
}

