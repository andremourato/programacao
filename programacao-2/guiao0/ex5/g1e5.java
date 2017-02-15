import java.util.*;

public class g1e5 {
	
	public static void main (String[] args) {
		Scanner read = new Scanner(System.in);
		int value, numbers=0;
		int sum=0;
		double avg;
		do{
			System.out.print("Numero: ");
			value = read.nextInt();
			if(value==0&&numbers==0){ //exception in case the first number given is '0'. Which isn't valid
				System.out.print("Valor invalido");
				System.exit(1);
			}
			sum += value; 
			if(value!=0)numbers++; //it increments the amount of numbers everytime it's not a '0'
		}while(value!=0);
		avg = (double)sum/numbers;
		System.out.printf("Soma: %d\n",sum);
		System.out.printf("Media: %.1f\n",avg);
	}
}

