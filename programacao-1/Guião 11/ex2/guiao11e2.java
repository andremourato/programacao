import java.util.*;
public class guiao11e2 {
	
	static Scanner read = new Scanner(System.in);
	static int chave[] = new int[6]; //invoca-se um array global inteiro
	public static void main (String[] args) {
		lerChave();
		System.out.println(); //linha de espaço
		mostraChave();
	}
	public static void lerChave(){ //le a chave
		for(int i=0;i<chave.length;i++){
			System.out.printf("Elemento %d da chave = ",i+1);
			int number = read.nextInt();
			if(number>=1&&number<=49&&!pertenceChave(number)) chave[i] = number;
			else{
				System.out.println("Numero invalido!");
				i--;
			}
		}
	}
	public static boolean pertenceChave(int number){ //verifica se o numero especificado pertence ao array
		for(int i=0;i<chave.length;i++){
			if(chave[i] == number ) return true;
		}
		return false;
	}
	public static void mostraChave(){
		System.out.printf("	Aposta de totoloto\n");
		for(int i=1;i<50;i++){
			boolean endOfLine = false;
			if(i%7==0) endOfLine = true; //verifica se é o ultimo elemento da linha
			if(endOfLine) System.out.printf("%02d  \n",i); //se o elemento for o ultimo da sua linha, mudamos de linha
			else if(pertenceChave(i)) System.out.printf(" X   ",i); //se o elemento pertencer ao array imprime-se um 'X'
			else System.out.printf("%02d   ",i);
			//if(!pertenceChave(i)) System.out.printf("%d ",i);
		}
	}
}

