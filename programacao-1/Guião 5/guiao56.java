import java.util.*;
public class guiao56 {
	
	static Scanner read = new Scanner(System.in);
	public static void main (String args[]) {
		int tab,i;
		tab = verifyValue();
		//Estrutura da tabela
		//Primeira linha:
		System.out.printf("---------------------\n");
		//Segunda linha
		System.out.printf("|  Tabuada dos %02d   |\n",tab);
		//Terceira linha
		System.out.printf("---------------------\n");
		//Linhas intermédias
		for(i=1;i<=10;i++){
			System.out.printf("|  %02d x %02d  |  %03d  |\n",tab,i,tabValue(tab,i));
		}
		//Última linha
		System.out.printf("---------------------\n");
	}
	//Verificação do valor da tabuada
	public static int verifyValue(){ 
		int a=0,b=100,value=0;
		do{
			System.out.print("Tabuada dos: ");
			value = read.nextInt();
			if(value>=b||value<=a) System.out.println("Introduzir valor pertencente a ]0,100[");
		}while(value>=b||value<=a);
		return value;
	}
	//Função da tabuada
	public static int tabValue(int tab, int number){
		int product;
		product=tab*number;
		return product;
	}
}

