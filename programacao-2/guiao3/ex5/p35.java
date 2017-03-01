import static java.lang.System.*;
import java.util.*;

public class p35 {
	
	static Caixa caixa = new Caixa();
	
	public static void main (String args[]) {
		
		Scanner read = new Scanner(in);
		int option;
		
		printInfo();
		do{
			out.print("Opcao: ");
			option = read.nextInt();
			
			switch(option){
				
				case 1:
					//Adiciona moedas
					caixa.adicionarMoedas();
					printInfo();
				break;
					
				case 2:
					//Retira moedas
					out.print("Valor minimo a retirar: ");
					caixa.retirarMoedas(read.nextLong());
					printInfo();
				break;
					
				case 3:
					//Mostra as moedas na caixa
					mostrarMoedas(caixa.moedas());
					printInfo();
				break;
					
				case 4:
					//Mostra o dinheiro na caixa
					out.println("Dinheiro na caixa: "+caixa.total());
					printInfo();
				break;
				
				default:
				
				break;
			}
		
		}while(option!=0);
	}
	
	static void printInfo(){
		Scanner sc = new Scanner(in);
		out.print("(PRIMA ENTER)");
		sc.nextLine();
		out.println("\n1. Adicionar moedas");
		out.println("2. Retirar dinheiro");
		out.println("3. Ver moedas na caixa");
		out.println("4. Ver total da caixa");
		out.println("0. Termina\n");
	}
	
	static void mostrarMoedas(long[] moedas){ //utilizado neste ficheiro, apenas para cumprir as especificações do guião
		
		for(int i=0;i<moedas.length;i++){
			if(i < moedas.length-1){
				System.out.print(moedas[i]+", ");
			}else System.out.print(moedas[i]);
		}
		out.println();
	}
}
