import java.util.*;
public class guiao10e5 {
	
	public static void main (String[] args) {
		Scanner read = new Scanner(System.in);
		System.out.print("Numero: ");
		int number = read.nextInt();
		System.out.print("Base: ");
		int base = read.nextInt();
		System.out.printf("Numero %d na base %d: %s", number, base, numToBase(number, base));
		
	}
	public static String numToBase(int number, int base){
		String newNumber=""; //inicia-se uma string vazia à qual se vão acrescentando os algarismos necessarios para representar o numero na nova base
		int division; //valor inteiro do quociente entre o numero e a base
		int remainder; //resto da divisao inteira
		do{
			division = number/base;
			remainder = number%base;
			newNumber = remainder+newNumber; //concatena-se o resto da divisao inteira, à esquerda da string que contem o numero
			number=division;
		}while(division!=0); //se a divisao for 0 o programa termina o ciclo porque já obtivemos o nosso número
		return newNumber; //devolve-se a string com o numero na nova base
	}
}

