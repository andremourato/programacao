import java.util.*;
public class guiao92 {
	
	static Scanner read = new Scanner(System.in);
	public static void main (String[] args) {
		ponto2D ponto = new ponto2D();
		ponto2D origem = new ponto2D();
		ponto2D pontoMaiorDist = new ponto2D();
		origem.x = 0;
		origem.y = 0;
		int numPontos=0; // numero de pontos
		double maxDist=0; //distancia do ponto mais afastado da origem
		double dist=0; //distancia entre o ponto e a origem
		double somaDist=0; //soma das distancias dos pontos à origem
		do{
			System.out.println();
			System.out.printf("Introduza um ponto: \n");
			ponto = lerPonto(); //le as cooredenadas do ponto
			numPontos++; //incrementa o numero de pontos em 1
			dist = calcularDist(ponto, origem);
			somaDist+=dist;
			if(dist > maxDist){
				maxDist = dist;
				pontoMaiorDist.x = ponto.x;
				pontoMaiorDist.y = ponto.y;
			}
		}while(ponto.x!=0&&ponto.y!=0); //O programa vai continuar a pedir input ao utilizador até este introduzir as coordenadas da Origem
		numPontos--; //nao conta o numero 0
		System.out.printf("A soma da distancia dos %d pontos a origem e: %.1f\n", numPontos, somaDist);
		escreverPonto(pontoMaiorDist);
	}
	public static ponto2D lerPonto(){
		ponto2D ponto = new ponto2D();
		System.out.println("Coordenada X: ");
		ponto.x = read.nextDouble();
		System.out.println("Coordenada Y: ");
		ponto.y = read.nextDouble();
		return ponto;
	}
	public static void escreverPonto(ponto2D ponto){
		System.out.printf("O ponto mais afastado da origem foi: (%.1f;%.1f)\n",ponto.x,ponto.y);
	}
	public static double calcularDist(ponto2D ponto1, ponto2D ponto2){
		return Math.sqrt(Math.pow(Math.abs(ponto1.x-ponto2.x),2)+Math.pow(Math.abs(ponto1.y-ponto2.y),2));
	}
}

class ponto2D{
	double x;
	double y;
}

