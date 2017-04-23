package jogos;
import static java.lang.System.*;

public class JogoDoGalo {
  public static final char VAZIO = '\0';
  public final char JOGADOR1;
  public final char JOGADOR2;
  
  /*
   * Inicia jogo.
   * O primeiro a jogar será j1
   */
   
  public JogoDoGalo(char j1, char j2) {
    assert j1!=j2;
    assert j1!=VAZIO && j2!=VAZIO;

    tabuleiro = new char[3][3]; //tamanho do tabuleiro 3x3
    for(int l = 0; l < 3; l++) 
      for(int c = 0; c < 3; c++)
        tabuleiro[l][c] = VAZIO;// atribui o elemento VAZIO a todas as posiçoes do tabuleiro inicialmente
    JOGADOR1 = j1;
    JOGADOR2 = j2;
    ultimoJogador = VAZIO; //inicializa o ultimoJogador como VAZIO porque ainda nenhum jogador efetuou uma jogada
    ultimaLin = ultimaCol = -1; //inicializa estas variaveis com valor inválido, neste caso -1
    numJogadas = 0;
  }
  
  public char ultimoJogador() { 
	  return ultimoJogador; //jogador que efetuou a ultima jogada
  }
  
  public static boolean coordValidas(int lin, int col) { //verifica se as coordenadas são válidas
    return 1<=lin && lin<=3 && 1<=col && col<=3;
  }
  
  public static boolean posicaoVazia(int lin, int col) {
    assert coordValidas(lin, col);
    return tabuleiro[lin-1][col-1] == VAZIO; //se o elemento do array especificado tiver valor = VAZIO, assume que essa posição está livre
  }
  
  public boolean terminado() {
    return ultimoJogador != VAZIO && ultimoJogadorGanhou() || numJogadas >= 9; //verifica se o jogo terminou ou não
  }

  public boolean jogadaValida(int lin, int col){
		return coordValidas(lin, col) && posicaoVazia(lin, col) && !terminado();
  }

  public boolean ultimoJogadorGanhou() {
    assert ultimoJogador() != VAZIO;
    boolean result;
       // vertical |
    result = contaIgual(ultimaLin, ultimaCol, -1, 0) + 1 + contaIgual(ultimaLin, ultimaCol, +1, 0) == 3; //se estiverem 3 alinhados na vertical ultimo jogador ganha
	   // horizontal -
    if (!result) result = contaIgual(ultimaLin, ultimaCol, 0, -1) + 1 + contaIgual(ultimaLin, ultimaCol, 0, +1) == 3;//se estiverem 3 alinhados na horizontal ultimo jogador ganha
       /* diagonal \ */
    if (!result) result = contaIgual(ultimaLin, ultimaCol, -1, -1) + 1 + contaIgual(ultimaLin, ultimaCol, +1, +1) == 3;//se estiverem 3 alinhados na diagonal ultimo jogador ganha
       // diagonal /
    if (!result) result = contaIgual(ultimaLin, ultimaCol, -1, +1) + 1 + contaIgual(ultimaLin, ultimaCol, +1, -1) == 3;//se estiverem 3 alinhados na diagonal ultimo jogador ganha
    return result;
  }
  
	public void jogada(int lin, int col) {
		assert jogadaValida(lin, col);

		ultimoJogador = (ultimoJogador != JOGADOR1) ? JOGADOR1 : JOGADOR2;
		ultimaLin = lin-1; //adapta o index das linhas para corresponder aos elementos corretos do array
		ultimaCol = col-1; //adapta o index das colunas para corresponder aos elementos corretos do array
		tabuleiro[ultimaLin][ultimaCol] = ultimoJogador;
		numJogadas++;
	}
  
   private int contaIgual(int lin, int col, int dlin, int dcol) {
    int result = 0;
    int l = lin + dlin;
    int c = col + dcol;
	if(l >= 0 && l < 3 && c >= 0 && c < 3 && tabuleiro[l][c] == ultimoJogador) result = 1 + contaIgual(l, c, dlin, dcol);//tem que verificar se naquele espaço existe 'X' ou 'O'
    return result;
  }
  
  public void mostraTabuleiro() {
    out.println();
    out.println("    1   2   3");
    for (int lin=1; lin<=3; lin++) { //imprime apenas da linha 1 até à linha 3
      out.printf("%2d ",lin);
      for (int col=1; col<=3; col++) { //imprime apenas da coluna 1 até à coluna 3
        char c = tabuleiro[lin-1][col-1];
        out.printf("%2c ", (c==VAZIO)? ' ' : c);
        out.printf("%c", (col<3)? '|' : '\n');
      }
      if (lin<3) out.printf("   ---+---+---\n");
    }
    out.println();
  }
  
  public int numJogadas(){
	return numJogadas;
  }

	public void printPontuacao(){
		out.print("Jogador | Vitorias | Derrotas | Empates\n");
		out.printf("   X    |     %d    |     %d    |    %d  \n", vitoriasX, vitoriasY, empates);
		out.printf("   O    |     %d    |     %d    |    %d  \n\n", vitoriasY, vitoriasX, empates);
	}

  private  static char[][] tabuleiro;
  public static int numJogos = 1;
  public static int vitoriasX = 0;
  public static int vitoriasY = 0;
  public static int empates = 0;
  private char ultimoJogador;
  private int ultimaLin, ultimaCol;
  private int numJogadas;
}
