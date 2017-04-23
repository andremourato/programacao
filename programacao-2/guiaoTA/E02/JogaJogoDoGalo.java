import static java.lang.System.*;
import java.util.Scanner;
import jogos.*;

public class JogaJogoDoGalo {
  public static void main(String[] args) {
	Scanner sin = new Scanner(in);
	char jogador1 = 'X';
	char jogador2 = 'O';
	JogoDoGalo jogo;
	int lin, col;
	do{
		jogo = new JogoDoGalo(jogador1, jogador2);
		out.printf("Jogo #%d\n", jogo.numJogos);
		jogo.mostraTabuleiro();
		while (!jogo.terminado()) {
			out.print("(lin col): ");
			lin = sin.nextInt();
			col = sin.nextInt();
			if(jogo.jogadaValida(lin, col)){
				jogo.jogada(lin, col);
				jogo.mostraTabuleiro();
			}else out.println("ERRO: Jogada invalida");
		}
		out.println();
		if (jogo.ultimoJogadorGanhou()){ //caso de vitória
			jogo.numJogos++; //incrementa o número de jogos
			if(jogo.ultimoJogador()==jogador1) jogo.vitoriasX++; //Concede a vitória ao jogador 'X'
			else jogo.vitoriasY++; //Concede a vitória ao jogador 'Y'
			out.println("Jogador '"+jogo.ultimoJogador()+"' ganhou!\n");
			jogo.printPontuacao();
		}else{ //caso de empate
			jogo.numJogos++; //incrementa o número de jogos
			jogo.empates++;
			out.println("Jogo empatado!\n");
			jogo.printPontuacao();
		}
	}while(jogo.numJogos<=10 || jogo.vitoriasX <3 || jogo.vitoriasY <3);
  }
}
