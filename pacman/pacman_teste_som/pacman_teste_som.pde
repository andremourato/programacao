/*
*
 *  André Ribeiro Martins Marques Mourato/ NºMec: 84745
 *  José Diogo Xavier Monteiro/ NºMec: 84736
 *
 */

import ddf.minim.*;
Minim minim;
AudioPlayer intro, chump, death;

boolean soundOn=true;

//Corre uma vez
void setup() {
  //Música
  minim = new Minim(this);
  intro = minim.loadFile("pacman_beginning.wav");
  chump = minim.loadFile("pacman_chomp.wav");
  death = minim.loadFile("pacman_death.wav");

  // Definir o tamanho da janela; notar que size() não aceita variáveis.
  size(720, 520);
  background(1);
}

//Corre várias vezes
void draw() {
  if(!chump.isPlaying()) chump.loop();
}

public void keyTyped() {
  if (key=='m'||key=='M') soundToggle();
  
}

/**************************
 *           Som          *
 **************************/

public void sound() {
  chump.play();
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