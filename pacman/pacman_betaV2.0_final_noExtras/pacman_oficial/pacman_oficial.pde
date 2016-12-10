/*
*
 *  André Ribeiro Martins Marques Mourato/ NºMec: 84745
 *  José Diogo Xavier Monteiro/ NºMec: 84736
 *
 */

import ddf.minim.*;
Minim minim;
AudioPlayer intro, chump, death;
String stage="menu";
int nCol, nLin;          // nº de linas e de colunas
int tamanho = 50;        // tamanho (largura e altura) das células do labirinto  
String direction;          // direção do pacman
int espacamento = 2;     // espaço livre entre células
int vel = 1;             // módulo da velocidade do pacman
float margemV, margemH;  // margem livre na vertical e na horizontal para assegurar que as células são quadrangulares
color corObstaculos = color(50, 0, 200);      // cor de fundo dos obstáculos
color corFronteira = color(80, 60, 200);
color corBolas = color(255);
color red = color(255, 0, 0);
int red_vx, red_vy;                //Velocidades do fantasma vermelho
color blue = color(51, 204, 255);
int blue_vx, blue_vy;              //Velocidades do fantasma azul
color pink = color(255, 162, 122);
int pink_vx, pink_vy;              //Velocidades do fantasma rosa
int pink_pathCount;
color orange = color(255, 204, 0);
int orange_vx, orange_vy;          //Velocidades do fantasma laranja
int orange_pathCount;
int path[][];
boolean wasHere[][];

int numBalls; //numero de bolas
int numEaten; //número de bolas comidas

PImage img1, img2;
boolean soundOn=true;
boolean pause=false;

// Posicao e tamanho do Pacman
float px, py, pRaio;

//velocidade na horizontal e vertical do Pacman
int vx, vy;

/*Posição dos fantasmas*/

//Fantasma vermelho
float red_px, red_py;

//Fantasma azul
float blue_px, blue_py;

//Fantasma rosa
float pink_px, pink_py;

//Fantasma laranja
float orange_px, orange_py;

//Corre uma vez
void setup() {

  frameRate(200);
  //Música
  minim = new Minim(this);
  intro = minim.loadFile("pacman_beginning.wav");
  intro.setGain(-10);
  chump = minim.loadFile("pacman_chomp.wav");
  chump.setGain(-15);
  death = minim.loadFile("pacman_death.wav");
  death.setGain(-10);

  // Definir o tamanho da janela; notar que size() não aceita variáveis.
  size(720, 520);
  background(1);
  nCol = (int)(width/tamanho);
  nLin = (int)(height/tamanho);
  path = new int[nLin+2][nCol+2];//respetivamente altura e comprimento
  wasHere = new boolean[nLin+2][nCol+2]; //verifica se o pacman já passou pela casa

  // Assegurar que nº de linhas e nº de colunas é maior ou igual a 3
  assert nCol >= 5 && nLin >= 5;

  // Determinar margens para limitar a área útil do game 
  margemV = (width - nCol * tamanho) / 2.0;
  margemH = (height - nLin * tamanho) / 2.0;

  // Inicializar o Pacman
  px = centroX(1);
  py = centroY(1);
  pRaio = (tamanho - espacamento) / 2;

  //Posição dos fantasmas

  //Fantasma vermelho
  red_px=centroX(9);
  red_py=centroY(1);

  //Fantasma azul
  blue_px=centroX(7);
  blue_py=centroY(5);

  //Fantasma rosa
  pink_px=centroX(3);
  pink_py=centroY(4);
  pink_pathCount=0;

  //Fantasma laranja
  orange_px=centroX(nCol);
  orange_py=centroY(7);
  orange_pathCount=0;

  //Velocidade inicial do pacman
  vx = 0;
  vy = 0;
}

//Corre várias vezes
void draw() {

  if (stage=="menu") {
    img1 = loadImage("menu_inicial_1.jpg");
    image(img1, 0, 0);
    img2 = loadImage("pacman_letras.png");
    image(img2, 40, 80);
    buttonHighlight();
  }
  if (stage=="ready") {
    background(0);
    fill(255, 255, 0);
    textSize(60);
    text("READY!", (width/2)-100, height/2);
    if (!intro.isPlaying()) stage="game";
  }
  if (stage=="game") {

    background(0);
    desenharLabirinto();
    desenharPontos();
    desenharPacman();
    definePath();
    desenhaFantasmas();
    ghostPath();

    /*//pacman aparece do outro lado do ecrã quando sai dos limites
     px = (px + width) % width;
     py = (py + height) % height;*/

    //Mudar de direção
    keyPressed();

    //Deteção de colisão
    detectWall();

    //Deteta colisão com fantasma
    detectGhost();
    
    //Bolas
    numBalls=ballCount();
    eatBall();
    numEaten=95-numBalls;

    //Som
    if (!intro.isPlaying()) {
      sound();
    }
    
    //Verifica se ganhou o jogo
    victoryCheck();

    //IMPRIMIR DADOS PARA TESTE
    //System.out.printf("px = %f\n", px);
    //System.out.printf("py = %f\n", py);
    //if (red_px==centroX(10)) System.out.print("Contact!");
    //if ((int)red_py==(int)centroY(3)) System.out.print("Contact!");
    /*println("centroY(3)= "+centroY(3));
     println("centroY(4)= "+centroY(4));
     println("centroY(7)= "+centroY(7));*/
  }
  if (stage=="death") {
    background(0);
    fill(255, 0, 0);
    textSize(80);
    text("GAME OVER", (width/2)-230, height/2);
    fill(255, 255, 0);
    textSize(40);
    text("Score: "+numEaten, (width/2)-250, (height/2)+100);
  }
  if (stage=="victory") {
    background(0);
    fill(0, 255, 0);
    textSize(60);
    text("VICTORY!", (width/2)-150, height/2);
    
  }
  if (stage=="pause") {
    noLoop();
    fill(255, 255, 0);
    textSize(40);
    text("Paused", centroX(6)+8, centroY(4)+14);
  }
}

/**************************
 *           MENU         *
 **************************/

//Escolhe a opção
public void mousePressed() {
  //JOGAR
  if (mouseX>90&&mouseX<190&&mouseY>335&&mouseY<380) {
    stage="ready";
    intro.play();
  }
  //SAIR DO game
  if (mouseX>90&&mouseX<190&&mouseY>385&&mouseY<430) {
    //SAI DO game
    exit();
  }
}

public void buttonHighlight() {

  //Titulo
  /*fill(0);
   textSize(80);
   text("Pacman", 100, 150);*/

  //Botão PLAY
  if (mouseX>90&&mouseX<190&&mouseY>335&&mouseY<380) {
    fill(0);
    textSize(40);
    text("Play", 100, 370);
  } else {
    fill(255, 255, 0);
    textSize(40);
    text("Play", 100, 370);
  }

  //Botão EXIT
  if (mouseX>90&&mouseX<190&&mouseY>385&&mouseY<430) {
    fill(0);
    textSize(40);
    text("Exit", 100, 420);
  } else {
    fill(255, 255, 0);
    textSize(40);
    text("Exit", 100, 420);
  }
}

/***************************
 *           Jogo          *
 **************************/


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
    if (vx!=0||vy!=0) arc(0, 0, pRaio, pRaio, map((millis() % 350), 50, 300, 0, 0.52), map((millis() % 350), 50, 300, TWO_PI, 5.76) ); //se estiver em movimento faz a animação
    else arc(0, 0, pRaio, pRaio, QUARTER_PI, (7*PI/4)); //se estiver parado para a animação
    popMatrix();
}

//funçao que desenha o mapa em cada frama
void desenharLabirinto () {

  // desenha a fronteira da área de game
  fill(0);
  stroke(corFronteira);
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
      if (path[j][i]==2&&c != corObstaculos) {
        fill(corBolas);
        ellipse(cx, cy, pRaio/2, pRaio/2);
      }
    }
  }
}

/********************************
 *           Fantasmas          *
 *******************************/

//Desenha fantasmas
public void desenhaFantasmas() {

  //Fantasma vermelho
  criarFantasma((int)red_px, (int)red_py, red);
  //Fantasma azul
  criarFantasma((int)blue_px, (int)blue_py, blue);
  //Fantasma rosa
  criarFantasma((int)pink_px, (int)pink_py, pink);
  //Fantasma laranja
  criarFantasma((int)orange_px, (int)orange_py, orange);
}

//Cria fantasmas
public void criarFantasma(int x, int y, color c) {

  //Corpo dos fantasmas
  int d=36;//diametro da circunferencia
  int h=12;//altura do fantasma
  fill(c);
  arc(x, y, d, d, -PI, 0);
  rect(x-(d/2), y, d, h);

  //Da esquerda para a direita
  //1º
  triangle(x-(d/2), y+h, x-(d/2), y+h+10, x-(d/2)+(d/6), y+h);
  //2º
  triangle(x-(d/2)+(d/6), y+h, x-(d/2)+(d/3), y+h+10, x, y+h);
  //3º
  triangle(x, y+h, x-(d/2)+4*(d/6), y+h+10, x-(d/2)+5*(d/6), y+h);
  //4º
  triangle(x-(d/2)+5*(d/6), y+h, x-(d/2)+d, y+h+10, x-(d/2)+d, y+h);

  //Olhos
  fill(255);
  ellipse(x-8, y-2, 13, 13);
  ellipse(x+8, y-2, 13, 13);

  //Dentro do olho
  fill(51, 102, 255);
  ellipse(x-8, y-2, 6, 9);
  ellipse(x+8, y-2, 6, 9);
  noStroke();
}

/*******************************
 *           Movimento         *
 ******************************/

//Trajetória dos fantasmas
public void ghostPath() {

  //Fantasma vermelho
  translate(red_px+= red_vx, red_py-= red_vy);

  if (red_py==centroY(1)&&red_px==centroX(9)) {
    red_vx=0;
    red_vy=-vel;
  }
  if (red_py==centroY(3)) {
    red_vx=vel;
    red_vy=0;
  }
  if (red_px==centroX(10)) {
    red_vx=0;
    red_vy=-vel;
  }
  if (red_py==centroY(5)) {
    red_vy=0;
    red_vx=vel;
  }
  if (red_px==centroX(11)) {
    red_vx=0;
    red_vy=-vel;
  }
  if (red_py==centroY(6)) {
    red_vx=vel;
    red_vy=0;
  }
  if (red_px==centroX(nCol)) {
    red_vx=0;
    red_vy=vel;
  }
  if (red_py==centroY(1)&&red_px!=centroX(9)) {
    red_vx=-vel;
    red_vy=0;
  }

  //Fantasma azul
  translate(blue_px+= blue_vx, blue_py-= blue_vy);

  if (blue_px==centroX(7)&&blue_py==centroY(5)) {
    blue_vx=-vel;
    blue_vy=0;
  }
  if (blue_px==centroX(4)) {
    blue_vx=0;
    blue_vy=-vel;
  }
  if (blue_py==centroY(6)&&blue_px==centroX(4)) {
    blue_vx=-vel;
    blue_vy=0;
  }
  if (blue_px==centroX(1)) {
    blue_vy=-vel;
    blue_vx=0;
  }
  if (blue_py==centroY(nLin)) {
    blue_vx=vel;
    blue_vy=0;
  }
  if (blue_px==centroX(6)&&blue_py==centroY(nLin)) {
    blue_vx=0;
    blue_vy=vel;
  }
  if (blue_py==centroY(7)&&blue_px==centroX(6)) {
    blue_vx=vel;
    blue_vy=0;
  }
  if (blue_py==centroY(7)&&blue_px==centroX(7)) {
    blue_vx=0;
    blue_vy=vel;
  }

  //Fantasma rosa
  translate(pink_px+= pink_vx, pink_py-= pink_vy);

  if (pink_px==centroX(3)&&pink_py==centroY(4)) {
    pink_vx=-vel;
    pink_vy=0;
  }
  if (pink_px==centroX(1)&&pink_py==centroY(4)) {
    pink_vx=0;
    pink_vy=vel;
  }
  if (pink_py==centroY(1)&&pink_px==centroX(1)) {
    pink_vx=vel;
    pink_vy=0;
  }
  if (pink_px==centroX(7)) {
    pink_pathCount=1;
    pink_vx=0;
    pink_vy=-vel;
  }
  if (pink_py==centroY(3)&&pink_px==centroX(7)) {
    pink_vx=-vel;
    pink_vy=0;
  }
  if (pink_px==centroX(5)&&pink_py==centroY(3)) {
    pink_vx=0;
    pink_vy=vel;
  }
  if (pink_py==centroY(1)&&pink_px==centroX(5)&&pink_pathCount==1) {
    pink_vx=-vel;
    pink_vy=0;
  }
  if (pink_py==centroY(1)&&pink_px==centroX(3)&&pink_pathCount==1) {
    pink_vx=0;
    pink_vy=-vel;
  }

  //Fantasma laranja
  translate(orange_px+= orange_vx, orange_py-= orange_vy);

  if (orange_px==centroX(nCol)&&orange_py==centroY(7)) {
    orange_pathCount=0;
    orange_vx=0;
    orange_vy=-vel;
  }
  if (orange_py==centroY(nLin)&&orange_px==centroX(nCol)&&orange_pathCount==0) {
    orange_vx=-vel;
    orange_vy=0;
  }
  if (orange_px==centroX(9)&&orange_py==centroY(nLin)) {
    orange_vx=0;
    orange_vy=vel;
  }
  if (orange_px==centroX(9)&&orange_py==centroY(7)) {
    orange_vx=vel;
    orange_vy=0;
  }
  if (orange_px==centroX(11)&&orange_py==centroY(7)) {
    orange_vx=0;
    orange_vy=-vel;
  }
  if (orange_px==centroX(11)&&orange_py==centroY(8)) {
    orange_vx=vel;
    orange_vy=0;
  }
  if (orange_px==centroX(11)&&orange_py==centroY(8)) {
    orange_vx=vel;
    orange_vy=0;
  }
  if (orange_px==centroX(12)&&orange_py==centroY(8)) {
    orange_pathCount=1;
    orange_vx=0;
    orange_vy=-vel;
  }
  if (orange_px==centroX(12)&&orange_py==centroY(nLin)&&orange_pathCount==1) {
    orange_vx=vel;
    orange_vy=0;
  }
  if (orange_px==centroX(nCol)&&orange_py==centroY(nLin)&&orange_pathCount==1) {
    orange_vx=0;
    orange_vy=vel;
    orange_pathCount=0;
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

/*Posição pacman*/
//No eixo dos XX
public int positionX(float px) {
  return (int)(((px-margemH)/tamanho)+0.5);
}

//No eixo dos YY
public int positionY(float py) {
  return (int)(((py-margemV)/tamanho)+0.5);
}

//Controlo do Pacman
public void keyPressed() {

  if (key==CODED) {
    switch(keyCode) {

      //Direita
    case RIGHT:
      for (int i=1; i<nLin+1; i++) {
        if (py==centroY(i)&&turnRight()) {
          vx = vel;
          vy = 0;
          direction = "right";
        }
      }
      break;

      //Esquerda  
    case LEFT:
      for (int i=1; i<nLin+1; i++) {
        if (py==centroY(i)&&turnLeft()) {
          vx = -vel;
          vy = 0;
          direction = "left";
        }
      }
      break;

      //Baixo  
    case DOWN:
      for (int i=1; i<nCol+1; i++) {
        if (px==centroX(i)&&turnDown()) {
          vx = 0;
          vy = -vel;
          direction = "down";
        }
      }
      break;

      //Cima  
    case UP:
      for (int i=1; i<nCol+1; i++) {
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

/*****************************
 *           Colisão         *
 ****************************/

//Define o array do mapa
public void definePath() {

  for (int j=0; j<=nLin+1; j++) {
    for (int i=0; i<=nCol+1; i++) {
      if (get((int)centroX(i), (int)centroY(j))!=corObstaculos&&wasHere[j][i]==false) path[j][i] = 2;
      if (i==0||j==0||i==nCol+1||j==nLin+1) path[j][i] = 0;
      System.out.printf("%d ", path[j][i]);
    }
    System.out.println();
  }
  System.out.println();
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

//detetacolisão com fantasmas
public void detectGhost() {

  //colisão com o fantasma vermelho
  if (dist(px, py, red_px, red_py)<18) {
    stage="death";
    intro.mute();
    chump.mute();
    death.play();
  }
  //colisão com o fantasma azul
  if (dist(px, py, blue_px, blue_py)<18) {
    stage="death";
    intro.mute();
    chump.mute();
    death.play();
  }
  //colisão com o fantasma rosa
  if (dist(px, py, pink_px, pink_py)<18) {
    stage="death";
    intro.mute();
    chump.mute();
    death.play();
  }
  //colisão com o fantasma laranja
  if (dist(px, py, orange_px, orange_py)<18) {
    stage="death";
    intro.mute();
    chump.mute();
    death.play();
  }
}

/************************
 *         Ovos         *
 ***********************/

//Conta os ovos
public int ballCount() {
  int balls=0;
  for (int j=0; j<=nLin+1; j++) {
    for (int i=0; i<=nCol+1; i++) {
      if (path[j][i]==2) balls++;
    }
  }
  return balls;
}

//Pacman come ovos
public void eatBall() {
  for (int j=0; j<=nLin+1; j++) {
    for (int i=0; i<=nCol+1; i++) {
      if (j==positionY(py)&&i==positionY(px)&&path[j][i]==2) {
        wasHere[j][i]=true;
        path[j][i]=1;
      }
    }
  }
}

public void victoryCheck(){
  if(numBalls==0) stage="victory";
}

/************************************
 *           Teclas premidas        *
 ***********************************/

public void keyTyped() {
  if (key=='m'||key=='M') soundToggle();
  if (key==' ') {
    if (stage=="game"||stage=="pause") pauseToggle();
  }
}

/************************************
 *           MENU DE PAUSA          *
 ***********************************/

//Pausa ou jogar
public void pauseToggle() {
  pause=!pause;
  pauseControl();
  if (pause) System.out.println("Pausa");
  else System.out.println("Continuar");
}

//Controlo de pause
public void pauseControl() {

  if (pause) {
    stage="pause";
    intro.mute();
    chump.mute();
    death.mute();
  }
  if (!pause) {
    loop();
    stage="game";
    intro.unmute();
    chump.unmute();
    death.unmute();
  }
}

/**************************
 *           Som          *
 **************************/

public void sound() {
  if (!chump.isPlaying()&&(vx!=0||vy!=0)) chump.loop();
  if (vx==0&&vy==0) chump.pause();
}

//Com som ou sem som
public void soundToggle() {
  soundOn=!soundOn;
  soundControl();
  if (soundOn)System.out.println("Som ligado!");
  else System.out.println("Som desligado!");
}

//associada à soundtoggle
public void soundControl() {

  //Desliga o som
  if (!soundOn) {
    intro.mute();
    chump.mute();
    death.mute();
  }

  //Liga o som
  if (soundOn) {
    intro.unmute();
    chump.unmute();
    death.unmute();
  }
}