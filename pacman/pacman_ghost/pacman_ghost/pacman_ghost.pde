color c = color(0, 0, 255);
int g1x, g1y; //posiçao do fantasma;
int vel=4;
int vx, vy; //velocidade nos XX e o nos YY


void setup() {
  size(720, 520);
  g1x=100;
  g1y=70;
}

void draw() {
  background(0);
  g1x+=vx;
  g1y+=vy;
  criarFantasma(g1x, g1y, c);
}

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

//Controlo do Pacman
public void keyPressed() {
  if (key==CODED) {
    switch(keyCode) {

      //Direita
    case RIGHT:
      vx = vel;
      vy = 0;
      break;

      //Esquerda  
    case LEFT:
      vx = -vel;
      vy = 0;
      break;

      //Baixo  
    case DOWN:
      vx = 0;
      vy = vel;
      break;

      //Cima  
    case UP:
      vx = 0;
      vy = -vel;
      break;
    }
  }
}