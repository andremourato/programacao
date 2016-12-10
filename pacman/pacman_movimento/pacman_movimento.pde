/***********************************\
 *           Versão teste          *
 \***********************************/

// Parâmetros do labirinto
int nCol, nLin;          // nº de linas e de colunas
int tamanho = 50;        // tamanho (largura e altura) das células do labirinto  
String direction;          // direção do pacman
int espacamento = 2;     // espaço livre entre células
int vel = 1;             // módulo da velocidade
float margemV, margemH;  // margem livre na vertical e na horizontal para assegurar que as células são quadrangulares
color corObstaculos = color(50, 0, 200);      // cor de fundo dos obstáculos
int path[][];

// Posicao e tamanho do Pacman
float px, py, pRaio;

//velocidade na horizontal e vertical do Pacman
int vx, vy; 

//Corre uma vez
void setup() {

  frameRate(200);
  // Definir o tamanho da janela; notar que size() não aceita variáveis.
  size(720, 520);
  background(1);

  nCol = (int)(width/tamanho);
  nLin = (int)(height/tamanho);
  path = new int[nLin+2][nCol+2];//respetivamente altura e comprimento

  // Assegurar que nº de linhas e nº de colunas é maior ou igual a 3
  assert nCol >= 5 && nLin >= 5;

  // Determinar margens para limitar a área útil do jogo 
  margemV = (width - nCol * tamanho) / 2.0;
  margemH = (height - nLin * tamanho) / 2.0;

  // Inicializar o Pacman
  px = centroX(5);
  py = centroY(5);
  pRaio = (tamanho - espacamento) / 2;

  //Velocidade inicial
  vx = 0;
  vy = 0;
}

//Corre várias vezes
void draw() {

  background(0);
  //desenharLabirinto();
  desenharPontos();
  desenharPacman();
  desenharObstaculo(6, 4, 4, 4);


  /*px = (px + width) % width;
   py = (py + height) % height;*/

  //Mudar de direção
  keyPressed();

  //Define array
  definePath();

  //Colisão
  detectWall();

  //TESTE
  System.out.printf("(%d, %d)\n", positionX(px), positionY(py));
  System.out.println(centroY(positionY(py)));
  System.out.println(py);
}

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
  if (vx!=0||vy!=0) arc(0, 0, pRaio, pRaio, map((millis() % 350), 50, 300, 0, 0.52), map((millis() % 350), 50, 300, TWO_PI, 5.76) ); //se estiver em movimento faz a animação
  else arc(0, 0, pRaio, pRaio, QUARTER_PI, (7*PI/4)); //se estiver parado para a animação
  popMatrix();
}

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
int centroX(int col) {
  return (int)(margemH + col*tamanho-tamanho*0.5);
}

// transformar o índice de uma célula em coordenada no ecrã
float centroY(int lin) {
  return margemV + (lin - 0.5) * tamanho;
}

//Controlo do Pacman
public void keyPressed() {

  if (key==CODED) {
    switch(keyCode) {

      //Direita
    case RIGHT:
      for (int i=0; i<=nLin+1; i++) {
        if (py==centroY(i)&&turnRight()) {
          vx = vel;
          vy = 0;
          direction = "right";
        }
      }
      break;

      //Esquerda  
    case LEFT:
      for (int i=0; i<=nLin+1; i++) {
        if (py==centroY(i)&&turnLeft()) {
          vx = -vel;
          vy = 0;
          direction = "left";
        }
      }
      break;

      //Baixo  
    case DOWN:
      for (int i=0; i<=nCol+1; i++) {
        if (px==centroX(i)&&turnDown()) {
          vx = 0;
          vy = -vel;
          direction = "down";
        }
      }
      break;

      //Cima  
    case UP:
      for (int i=0; i<=nCol+1; i++) {
        if (px==centroX(i)&&turnUp()) {
          vx = 0;
          vy = vel;
          direction = "up";
        }
      }
      break;
    }
  }
}

//Define o array do mapa
public void definePath() {

  for (int j=0; j<=nLin+1; j++) {
    for (int i=0; i<=nCol+1; i++) {
      if (get((int)centroX(i), (int)centroY(j))!=corObstaculos) path[j][i] = 2;
      if (i==0||j==0||i==nCol+1||j==nLin+1) path[j][i] = 0;
      System.out.printf("%d ", path[j][i]);
    }
    System.out.println();
  }
  System.out.println();
}

/*Posição pacman*/
//No eixo dos XX
public int positionX(float px) {
  return (int)(((px-margemH)/tamanho)+0.5);
}

//No eixo dos YY
public int positionY(float py) {
  return (int)(((py-margemV)/tamanho)+0.5);
}

//Verifica se pode virar à direita
public boolean turnRight() {
  if (path[positionY(py)][positionX(px)+1]!=0) return true;
  else return false;
}

//Verifica se pode virar à esquerda
public boolean turnLeft() {
  for (int j=1; j<=nLin; j++) {
    for (int i=1; i<=nCol; i++) {
      if (px==centroX(i)&&py==centroY(j)) {
        if (get((int)centroX(i-1), (int)centroY(j))==corObstaculos||px<=centroX(1))return false;
      }
    }
  }
  return true;
}

//Verifica se pode virar para baixo
public boolean turnDown() {
  if (path[positionY(py)+1][positionX(px)]!=0)return true;
  else return false;
}

//Verifica se pode virar para cima
public boolean turnUp() {
  for (int j=1; j<=nLin; j++) {
    for (int i=1; i<=nCol; i++) {
      if (px==centroX(i)&&py==centroY(j)) {
        if (get((int)centroX(i), (int)centroY(j-1))==corObstaculos||py<=centroY(1))return false;
      }
    }
  }
  return true;
}

//Deteta colisao
public void detectWall() {
  if (!turnRight()&&direction=="right") vx=0;
  if (!turnLeft()&&direction=="left") vx=0;
  if (!turnDown()&&direction=="down") vy=0;
  if (!turnUp()&&direction=="up") vy=0;
}