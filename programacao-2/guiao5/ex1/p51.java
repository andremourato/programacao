import static java.lang.System.*;
import java.util.Scanner;

public class p51 {
  private static final Scanner scin = new Scanner(System.in);

  public static void help(GuessGame game) {
    assert game != null;
    out.printf("Find the secret number in range [%d,%d]!\n", game.min(), game.max());
    out.printf("Available commands:\n");
    out.printf("  <number>   (new attempt to guess secret)\n");
    out.printf("  count      (show current number of attempts)\n");
    //out.printf("  show       (show all attempts done)\n");
    out.printf("  help       (information on command usage)\n");
    out.printf("  quit       (exits the program)\n");
  }

  public static void main(String[] args) {
    if (args.length != 0 && args.length != 2) {
      out.println("Usage: p42	 [ <min> <max> ]");
      out.println("(by default range [0,20] is used)");
      exit(1);
    }
    int min = 0;
    int max = 20;
    if (args.length == 2) {
		try{ //in case the user introduces invalid arguments (Strings, etc.)
			min = Integer.parseInt(args[0]);
			max = Integer.parseInt(args[1]);
		}catch(NumberFormatException e){ 
			out.println("\nInvalid arguments. Assuming default.");
		}
		if(min > max){ //guarantees that the program keeps running even if min > max
			out.println("\n'Min' cannot be greater than 'Max'. Assuming default.");
			min = 0;
			max = 20;
		}
    }
    GuessGame game = new GuessGame(min, max);

    out.println();
    help(game);
    out.println();
    while (!game.finished()) {
      out.print("Command? ");
      String command = scin.next();
      out.println();
      switch (command) {
		  case "quit":
			exit(1);
			break;
		  case "help":
			help(game);
			break;
		  case "count":
			out.printf("Number of attempts: %d\n", game.numAttempts());
			break;
		  default:
			playGame(Integer.parseInt(command), game);
			break;
      }
      out.println();
    }
    out.printf("Game finished in %d attempts\n", game.numAttempts());
  }
  
  static void playGame(int n, GuessGame game){
		game.play(n);
		if(game.attemptIsHigher()) out.printf("%d is too high!", n);
		else if(game.attemptIsLower()) out.printf("%d is too low!", n);
	
	}
}

