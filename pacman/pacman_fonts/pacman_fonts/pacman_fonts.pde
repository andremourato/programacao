
//String[] fontList = PFont.list();
//printArray(fontList);

PFont font;

void setup() {
  size(200, 200);
  font = createFont("Sylfaen", 14);
}

void draw(){
  background(0);
  fill(255);
  textSize(100);
  textFont(font);
  text("hello", 100, 100);
}