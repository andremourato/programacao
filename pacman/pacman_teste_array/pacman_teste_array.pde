/*
*
 *  André Ribeiro Martins Marques Mourato/ NºMec: 84745
 *  José Diogo Xavier Monteiro/ NºMec: 84736
 *
 */
// Parâmetros do labirinto
int nCol, nLin;          // nº de linas e de colunas
int tamanho = 50;        // tamanho (largura e altura) das células do labirinto  
String direction;          // direção do pacman
int espacamento = 2;     // espaço livre entre células
int vel = 2;             // módulo da velocidade
float margemV, margemH;  // margem livre na vertical e na horizontal para assegurar que as células são quadrangulares
color corObstaculos = color(50, 0, 200);      // cor de fundo dos obstáculos
int path[][]; //array se necessário

// Posicao e tamanho do Pacman
float px, py, pRaio;

//velocidade na horizontal e vertical do Pacman
int vx, vy;

//Corre uma vez
void setup() {

  // Definir o tamanho da janela; notar que size() não aceita variáveis.
  size(720, 520);
  background(1);

  nCol = (int)(width/tamanho);
  nLin = (int)(height/tamanho);
  path = new int[nLin][nCol];

  // Assegurar que nº de linhas e nº de colunas é maior ou igual a 3
  assert nCol >= 5 && nLin >= 5;

  // Determinar margens para limitar a área útil do jogo 
  margemV = (width - nCol * tamanho) / 2.0;
  margemH = (height - nLin * tamanho) / 2.0;

  // Posição inicial do Pacman
  px = centroX(1);
  py = centroY(1);
  pRaio = (tamanho - espacamento) / 2;

  //Velocidade inicial
  vx = 0;
  vy = 0;
}

//Corre várias vezes
void draw() {
  background(0);
  
  //Verificar array
  System.out.println(path[2][2]);
  
  desenharLabirinto();
  desenharPontos();
  desenharPacman();

  //EQUAÇÕES DO MOVIMENTO
  px+= vx;
  py-= vy;

  /*//pacman aparece do outro lado do ecrã quando sai dos limites. USADO PARA TELETRANSPORTAR
   px = (px + width) % width;
   py = (py + height) % height;*/

  //Mudar de direção
  keyPressed();

  //Deteta colisão
  definePath();
  detectCollision();
}

//FUNÇAO DESENHA PACMAN EM CADA FRAME
void desenharPacman() {

  fill(255, 255, 0);
  pushMatrix();
  translate(px+= vx, py-= vy);
  if (direction=="left") { 
    rotate(PI);
  }
  if (direction=="down") { 
    rotate(HALF_PI);
  }
  if (direction=="up") { 
    rotate( PI + HALF_PI );
  }
  arc(0, 0, pRaio, pRaio, map((millis() % 500), 0, 500, 0, 0.52), map((millis() % 500), 0, 500, TWO_PI, 5.76) );
  popMatrix();
}

//funçao que desenha o mapa em cada frama
void desenharLabirinto () {

  // desenha a fronteira da área de jogo
  fill(0);
  stroke(80, 60, 200);
  strokeWeight(espacamento);
  rect(margemH, margemV, width - 2*margemH, height - 2*margemV);

  // Desenha obstáculos do tipo: (coluna, linha, largura XX, comprimento YY)
  desenharObstaculo(2, 2, 1, 2);
  desenharObstaculo(2, 5, 2, 1);
  desenharObstaculo(2, 7, 1, 3);
  desenharObstaculo(3, 7, 1, 1);
  desenharObstaculo(4, 2, 1, 3);
  desenharObstaculo(4, 9, 2, 1);
  desenharObstaculo(5, 6, 2, 1);
  desenharObstaculo(5, 7, 1, 1);
  desenharObstaculo(4, 2, 1, 3);
  desenharObstaculo(7, 8, 2, 2);
  desenharObstaculo(6, 4, 4, 1);
  desenharObstaculo(6, 2, 1, 1);
  desenharObstaculo(8, 2, 1, 2);
  desenharObstaculo(13, 2, 1, 2);
  desenharObstaculo(11, 2, 1, 3);
  desenharObstaculo(10, 2, 1, 1);
  desenharObstaculo(12, 5, 2, 1);
  desenharObstaculo(13, 7, 1, 3);
  desenharObstaculo(12, 7, 1, 1);
  desenharObstaculo(8, 6, 3, 1);
  desenharObstaculo(10, 8, 1, 2);
  desenharObstaculo(11, 9, 1, 1);
}

/* Desenha um obstáculo interno de um labirinto:
 x: índice da célula inicial segundo eixo dos X - gama (1..nCol) 
 y: índice da célula inicial segundo eixo dos Y - gama (1..nLin)
 numC: nº de colunas (células) segundo eixo dos X (largura do obstáculo)
 numL: nº de linhas (células) segundo eixo dos Y (altura do obstáculo) 
 */

//função que desenha o obstaculo: (coluna, linha, largura XX, comprimento YY)
void desenharObstaculo(int x, int y, int numC, int numL) {

  float x0, y0, larg, comp;
  x0 = margemH + (x-1) * tamanho;
  y0 = margemV + (y-1) * tamanho;
  larg = numC * tamanho;
  comp = numL * tamanho;
  fill(corObstaculos);
  noStroke();
  strokeWeight(espacamento/2);
  rect(x0, y0, larg, comp);
}

/*
Desenhar pontos nas células vazias (que não fazem parte de um obstáculo). 
 Esta função usa a cor de fundo no ecrã para determinar se uma célula está vazia ou se faz parte de um obstáculo.
 */
void desenharPontos() {

  float cx, cy;
  ellipseMode(CENTER);
  fill(255);
  noStroke();

  // Insere um ponto nas células vazias
  for (int i=1; i<=nCol; i++) {
    for (int j=1; j<=nLin; j++) {
      cx = centroX(i);
      cy = centroY(j);
      color c = get((int)cx, (int)cy);
      if (c != corObstaculos) {
        fill(255);
        ellipse(cx, cy, pRaio/2, pRaio/2);
      }
    }
  }
}

// transformar o índice de uma célula em coordenada no ecrã
float centroX(int col) {
  return margemH + (col - 0.5) * tamanho;
}

// transformar o índice de uma célula em coordenada no ecrã
float centroY(int lin) {
  return margemV + (lin - 0.5) * tamanho;
}

//Controlo do Pacman. GARANTE QUE O PACMAN APENAS ANDA NAS LINHAS E COLUNAS
public void keyPressed() {

  if (key==CODED) {
    switch(keyCode) {

      //Direita
    case RIGHT:
      for (int i=0; i<nLin; i++) {
        if (path[(int)px][(int)py]==1) {
          vx = vel;
          vy = 0;
          direction = "right";
        }
      }
      break;

      //Esquerda  
    case LEFT:
      for (int i=0; i<nLin; i++) {
        if (path[(int)px][(int)py]==1) {
          vx = -vel;
          vy = 0;
          direction = "left";
        }
      }
      break;

      //Baixo  
    case DOWN:
      for (int i=0; i<nCol; i++) {
        if (path[(int)px][(int)py]==1) {
          vx = 0;
          vy = -vel;
          direction = "down";
        }
      }
      break;

      //Cima  
    case UP:
      for (int i=0; i<nCol; i++) {
        if (path[(int)px][(int)py]==1) {
          vx = 0;
          vy = vel;
          direction = "up";
        }
      }
      break;
    }
  }
}

//Deteta colisão com paredes por cor
public void detectObject() {

  //RIGHT
  if (get((int)(px+pRaio+espacamento), (int)py)==corObstaculos) {
    vx = -vx;
  }

  //LEFT
  if (get((int)(px-pRaio-espacamento), (int)py)==corObstaculos) {
    vx = -vx;
  }

  //DOWN
  if (get((int)px, (int)(py+pRaio+espacamento))==corObstaculos) {
    vy = -vy;
  }

  //UP
  if (get((int)px, (int)(py-pRaio-espacamento))==corObstaculos) {
    vy = -vy;
  }
}

//Função que reconhece os limites do mapa
public void outBounds() {
  if (px > centroX(nCol))
    vx = -vx;
  if (px < centroX(1))
    vx = -vx;
  if (py > centroY(nLin))
    vy = -vy;
  if (py < centroY(1))
    vy = -vy;
}

//Função que define array bidimensional
public void definePath() {
    
  for (int i=0; i<nLin; i++) {
    for (int j=0; j<nCol; j++) {
      if (get((int)centroY(i), (int)centroX(j))!=corObstaculos) path[i][j] = 1;
    }
  }
}


public void detectCollision() {
  detectObject();
  outBounds();
}