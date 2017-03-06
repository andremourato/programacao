import static java.lang.System.*;

public class GuessGame {

  private int secretNumber; // to hold the secret
  private int min;
  private int max;
  private int numAttempts = 0;
  private boolean finished = false;
  private int guess;

  public GuessGame(int min, int max) {
	assert min < max;
	this.min = min;
	this.max = max;
	secretNumber = (int)(min+Math.random()*(max-min));
	assert secretNumber >= min && secretNumber <= max;
    
  }

  public int min() {
    return min;
  }

  public int max() {
	return max;
  }
  
  public int secretNumber(){
		return secretNumber;
	}

  public boolean validAttempt(int n) {
    if (n >= min && n <= max) return true;
    else return false;
  }

  public boolean finished() {
	return finished;
  }

  public boolean attemptIsHigher() {
    if(guess > secretNumber) return true;
    else return false;
  }

  public boolean attemptIsLower() {
    if(guess < secretNumber) return true;
    else return false;
  }

	public void play(int n) {
		numAttempts++;
		guess = n;
		if(validAttempt(n) && !finished()){
			if(!attemptIsHigher()&&!attemptIsLower()) finished = true;
		}
	}

  public int numAttempts() {
    return numAttempts;
  }

  /**
   * Simple tests of the GuessGame class.
   * This method tests the functionality of the GuessGame class.
   * It should be used by the programmer to test and debug the class.
   * It is not meant to be called in client programs.
   *
   * To run from the command line, use:
   *   java -ea GuessGame
   */
  public static void main(String[] args) {
    out.println("Starting tests.");
    GuessGame game = new GuessGame(1,10);
    // initial tests:
    assert !game.finished() : "game should not be finished yet";
    assert game.min() == 1;
    assert game.max() == 10;
    assert game.numAttempts() == 0 : "there should be no attempts yet";
    for(int i = -10; i <= 20; i++) {
      assert game.validAttempt(i) == (i >= 1 && i <= 10);
    }
    // trying all wrong answers:
    int nplay = 0; // how may times play was called
    for(int n = 1; n <= 10; n++) {
      if (n != game.secretNumber()) {
        game.play(n); // make a wrong guess
        nplay++;
        assert game.numAttempts() == nplay;
        assert !game.finished() : "game should not be finished yet";
        assert (n < game.secretNumber()) == game.attemptIsLower();
        assert (n > game.secretNumber()) == game.attemptIsHigher();
      }
    }
    // make the right guess:
    game.play(game.secretNumber());
    nplay++;
    assert game.finished() : "game should be finished now";
    assert game.numAttempts() == nplay;
    out.println("No error detected!");
  }
}

