/***********************************
 *           TEMPORIZADOR          *
 ***********************************/
void draw(){
  timer(10000);
  println(timer(10000));
}

boolean time;

int timer(int timerLength) {
  int remainingTime = timerLength-millis();

  if (remainingTime/1000>0) {
    int actualTime = (remainingTime/1000);
    return actualTime;
  } else {
    time = false;
    return 0;
  }
}