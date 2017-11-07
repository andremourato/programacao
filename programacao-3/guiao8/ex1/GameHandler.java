package aula8.ex1;
import static java.lang.System.*;
public class GameHandler {
	
	char jogador1 = 'X';
	char jogador2 = 'O';
	GameEngine jogo = new GameEngine(jogador1,jogador2);
	
	public void efetuarJogada(int col, int lin) {
		if(jogo.jogadaValida(lin, col)){
			jogo.jogada(lin, col);
		}else out.println("ERRO: Jogada invalida");
	}
	
	public String ultimoJogador() {
		return String.valueOf(jogo.ultimoJogador());
	}
	
	public boolean terminado() {
		return jogo.terminado();
	}
	
	public boolean ultimoJogadorGanhou() {
		return jogo.ultimoJogadorGanhou();
	}
	
}
