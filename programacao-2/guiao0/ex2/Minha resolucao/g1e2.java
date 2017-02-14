import java.util.*;

public class g1e2 {
	
	public static void main (String[] args) {
		Nota nota = lerNota();
		int nf = calcularNota(nota);
		System.out.printf("A nota final e: %d\n",nf);
		if(nf>=9.5) System.out.println("Aprovado");
		else System.out.println("Reprovado");
	}
	
	static Nota lerNota(){
		Nota nota = new Nota(); //armazena os valores numa variavel do tipo Nota
		Scanner read = new Scanner(System.in);
		System.out.print("TP1: ");
		nota.tp1 = read.nextInt(); //le o tp1
		System.out.print("TP2: ");
		nota.tp2 = read.nextInt(); //le o tp2
		System.out.print("PG1: ");
		nota.pg1 = read.nextInt(); //le o pg1
		System.out.print("PG2: ");
		nota.pg2 = read.nextInt(); //le o pg2
		System.out.print("PG3: ");
		nota.pg3 = read.nextInt(); //le o pg3
		System.out.print("EF: ");
		nota.ef = read.nextInt(); //le o exame final
		return nota;
	}
	
	static int calcularNota(Nota nota){
		int tp = (nota.tp1+nota.tp2)/2;
		int pg = (nota.pg1+nota.pg2+nota.pg3)/3;
		int p = calcularPratica(pg, nota.ef);
		return (int)(0.2*tp+0.8*p);
	}
	
	static int calcularPratica(int pg, int ef){
		if(ef-4<=pg||ef+4>=pg) return (int)(0.5*ef+0.5*pg);
		else if(pg<ef-4) return (int)(0.75*ef+0.25*pg-1);
		else if(pg>ef+4) return (int)(0.75*ef+0.25*pg+1);
		return -1; //nunca vai acontecer mas é necessário
			
	}
}

class Nota{
	int tp1;
	int tp2;
	int pg1;
	int pg2;
	int pg3;
	int ef;

}

