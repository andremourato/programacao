public void keyPressed() {

  if (key==CODED) {
    switch(keyCode) {

      //Direita
    case RIGHT:
      vx = vel;
      vy = 0;
      direction = "right";
      break;

      //Esquerda  
    case LEFT:
      vx = -vel;
      vy = 0;
      direction = "left";
      break;

      //Baixo  
    case DOWN:
      vx = 0;
      vy = -vel;
      direction = "down";
      break;

      //Cima  
    case UP:
      vx = 0;
      vy = vel;
      direction = "up";
      break;
    }
  }
}