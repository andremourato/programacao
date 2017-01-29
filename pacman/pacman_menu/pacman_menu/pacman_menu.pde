PImage img;

void setup() {
  size(720, 520);
}

void draw() {

  //Fundo
  background(0);
  img = loadImage("menu_inicial_2.gif");
  image(img, 0, 0);
  //guideLines();
  
  //Botões
  buttonHighlight();
  
}

//Escolhe a opção
public void mousePressed(){
  //JOGAR
  if(mouseX>315&&mouseX<410&&mouseY>335&&mouseY<380){
    //JOGA
    System.out.print("Jogar");
  }
  //SAIR DO JOGO
  if (mouseX>315&&mouseX<410&&mouseY>385&&mouseY<430) {
    //SAI DO JOGO
    System.out.print("Sair do jogo");
    exit();
  }
}

public void buttonHighlight(){
 //Botão PLAY

  if (mouseX>315&&mouseX<410&&mouseY>335&&mouseY<380) {
    fill(255,0,0);
    textSize(40);
    text("Play", 325, 370);
    
  } else {
    fill(255);
    textSize(40);
    text("Play", 325, 370);
  }


  //Botão EXIT
  if (mouseX>315&&mouseX<410&&mouseY>385&&mouseY<430) {
    fill(255,0,0);
    textSize(40);
    text("Exit", 325, 420);
  } else {
    fill(250);
    textSize(40);
    text("Exit", 325, 420);
  }
}

public void guideLines() {

  //botao PLAY
  line(315, 380, 410, 380);
  stroke(255, 0, 0);
  line(315, 380, 315, 335);
  stroke(255, 0, 0);
  line(315, 335, 410, 335);
  stroke(255, 0, 0);
  line(410, 335, 410, 380);
  stroke(255, 0, 0);

  //botao EXIT
  line(315, 430, 315, 385);
  stroke(255, 0, 0);
  line(315, 385, 410, 385);
  stroke(255, 0, 0);
  line(410, 385, 410, 430);
  stroke(255, 0, 0);
  line(410, 430, 315, 430);
  stroke(255, 0, 0);
}