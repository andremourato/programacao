int pacSize = 10;
int directionX= 1; //direção nos XX inicial do pacman
int directionY = 1; //direção nos YY inicial do pacman
float x = 10;
float  y = 10;
float speed = 3;
boolean halt = true;

void setup() {
  size(500, 500);
  smooth();
  noStroke();
  ellipseMode(RADIUS);
}

void draw() {
  //ellipse(100,100,50,50);
  simulate();
  render();
}

//trajetória do pacman
void simulate() {
  if ( !halt) {
    x += speed * directionX;
    y += speed * directionY;
    x = (x + width) % width;
    y = (y + height) % height;
  }
}

void render() { 
  background(0);
  fill(255, 255, 0);
  
  for ( int i=-1; i < 2; i++) {
    for ( int j=-1; j < 2; j++) {
      pushMatrix();
      translate(x + (i * width), y + (j*height));
      if ( directionX == -1) { 
        rotate(PI);
      }
      if ( directionY == 1) { 
        rotate(HALF_PI);
      }
      if ( directionY == -1) { 
        rotate( PI + HALF_PI );
      }
      arc(0, 0, pacSize, pacSize, map((millis() % 500), 0, 500, 0, 0.52), map((millis() % 500), 0, 500, TWO_PI, 5.76) );
      popMatrix();
    }
  }
}


void keyPressed() {
  
  if (key == CODED) {
    if (keyCode == RIGHT) {
      directionX= 1;
      directionY = 0;
      halt = false;
    }
    if (keyCode == LEFT) {      
      directionX= -1;
      directionY = 0;
      halt = false;
    }
    if (keyCode == DOWN) {
      directionX= 0;
      directionY = 1;
      halt = false;
    } 
    if (keyCode == UP) {
      directionX= 0;
      directionY = -1;
      halt = false;
    }
  }
}