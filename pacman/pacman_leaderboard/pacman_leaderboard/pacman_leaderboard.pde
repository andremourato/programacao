import javax.swing.JOptionPane;
PrintWriter leaderboard;
BufferedReader reader;
String player="jogador";

void setup() {
  leaderboard = createWriter("leaderboard.txt");
}

void draw() {
  
  keyPressed();
  writeName();
  //readScore();
}

void writeName() {
  leaderboard = createWriter("leaderboard.txt");
  leaderboard.println("Jogador  |  Score ");
  leaderboard.printf("%s  |  score \n", player);
  leaderboard.flush();
  leaderboard.close();
}

void readScore() {
  reader = createReader("leaderboard.txt");
  
  
}

void keyPressed() {
  fill(0,0,255);
  player += key;
  if(keyCode==ENTER) exit();
}