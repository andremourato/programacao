int path[][];

void setup(){
  
  path = new int[nLin+2][nCol+2];//respetivamente altura e comprimento

}

void draw(){

}

//Atribui o valor de 0 ou 1 aos vários elementos do array e imprime o mesmo na consola
public void definePath() {

  for (int j=0; j<=nLin+1; j++) {
    for (int i=0; i<=nCol+1; i++) {
      if (get((int)centroY(i), (int)centroX(j))!=corObstaculos) path[j][i] = 1;
      if (i==0||j==0||i==nCol+1||j==nLin+1) path[j][i] = 0;
      System.out.printf("%d ", path[j][i]);
    }
    System.out.println();
  }
}