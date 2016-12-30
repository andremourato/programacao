/* 
 * Andre Ribeiro Martins Marques Mourato
 * Nº Mec: 84745
 * 
 */
import java.io.*;
import java.util.*;
public class guiao11e3 {
	
	public static void main (String args[]) throws IOException {
		
		Scanner read = new Scanner(System.in);
		File fileIn;
		Scanner scf;
		PrintWriter write = new PrintWriter("newList.txt");
		int numEl=0; //numero de elementos do array
		int numNewEl=0; //número de novos elementos (numeros contidos no ficheiro)
		int option;
		int num;
		int[] arrayInt = new int[50];
		int[] arrayFile = new int[50];
		
		//MENU
		System.out.printf("-->> Analise de uma sequencia de numeros inteiros <<--\n");
		System.out.printf("\n");
		System.out.printf("1 - Ler sequencia\n");
		System.out.printf("2 - Imprimir sequencia\n");
		System.out.printf("3 - Calcular o maximo da sequencia\n");
		System.out.printf("4 - Calcular o minimo da sequencia\n");
		System.out.printf("5 - Calcular media da sequencia\n");
		System.out.printf("6 - Detetar se e uma sequencia so constituida por numeros pares\n");
		System.out.printf("7 - Ler uma sequencia de numeros de um ficheiro\n");
		System.out.printf("8 - Adicionar numeros a sequencia\n");
		System.out.printf("9 - Gravar a sequencia atual de numeros no ficheiro\n");
		System.out.printf("10 - Ordenar a sequencia por ordem crescente utilizando ordenacao sequencial\n");
		System.out.printf("11 - Ordenar a sequencia por ordem decrescente utilizando ordenacao por flutuacao\n");
		System.out.printf("12 - Pesquisa de valor na sequencia\n");
		System.out.printf("13 - Terminar o programa\n");
		System.out.printf("\n");
		do{
			System.out.printf("Opcao -> ");
			option=read.nextInt();
			switch(option){
				case 1:
					numEl=0;
					boolean valid = true;
					for(int i=0;valid==true;i++){
						System.out.printf("Valor: ");
						arrayInt[i]=read.nextInt();
						if(arrayInt[i]==0) valid = false;
						else numEl++;
					}
					break;
				case 2:
					for(int i=0;arrayInt[i]!=0;i++){
						System.out.printf("arrayInt[%d] = %d\n",i,arrayInt[i]);
					}
					break;
				case 3:
					int max = arrayInt[0];
					for(int i=0;i<numEl;i++){
						if(arrayInt[i]>max){max=arrayInt[i];}
					}
					System.out.printf("O valor maximo da sequencia e: %d\n",max);
					break;
				case 4:
					int min = arrayInt[0];
					for(int i=0;i<numEl;i++){
						if(arrayInt[i]<min){min=arrayInt[i];}
					}
					System.out.printf("O valor minimo da sequencia e: %d\n",min);
					break;
				case 5:
					double soma=0, media;
					for(int i=0;i<numEl;i++){
						soma+=arrayInt[i];
					}
					System.out.printf("Soma: %.0f\n",soma);
					System.out.printf("No. ELEMENTOS: %d\n",numEl);
					media=soma/(numEl);
					System.out.printf("O valor medio da sequencia e: %.2f\n",media);
					break;
				case 6:
					int numPar=0;
					for(int i=0;i<numEl;i++){
						if(arrayInt[i]%2==0) numPar++;
					}
					if(numPar==numEl){ System.out.print("A sequencia e constituida por numeros pares\n");
					
					}else{
						System.out.print("A sequencia nao e constituida por numeros pares\n");
					}
					break;
				case 7:
					System.out.printf("Nome do ficheiro que contem os numeros: ");
					String nameFile = read.next();
					fileIn = new File(nameFile);
					checkFile(fileIn, nameFile);
					scf = new Scanner(fileIn);
					for(int i=0;scf.hasNextLine();i++){
						arrayFile[i] = scf.nextInt();
						numNewEl++;
					}
					System.out.printf("Numeros lidos com sucesso!\n");
					break;
				case 8:
					for(int i=0;i<(numEl+numNewEl);i++){
						arrayInt[numEl+i] = arrayFile[i];
					}
					numEl += numNewEl;
					System.out.printf("Numeros adicionados com sucesso!\n");
					break;
				case 9:
					for(int i=0;i<numEl;i++){
						write.println(arrayInt[i]);
					}
					write.close();
					System.out.printf("Sequencia imprimida para o ficheiro!\n");
					break;
				case 10:
					int tmp;
					for(int i = 0 ; i < numEl - 1 ; i++){ // fixamos uma posicao
						for(int j = i + 1 ; j < numEl ; j++){ // percorremos as outras
							if(arrayInt[i] > arrayInt[j]){ // se fora de sitio, trocamos
								tmp = arrayInt[i];
								arrayInt[i] = arrayInt[j]; // trocam-se os elementos
								arrayInt[j] = tmp;
							}
						}
					}
					System.out.printf("Sequencia ordenada por ordem crescente!\n");
					break;
				case 11:
					boolean changes;
					int tmp2;
					do{
						changes=false;
						for(int i=0;i<numEl-1;i++){
							if(arrayInt[i]<arrayInt[i+1]){
								tmp2=arrayInt[i];
								arrayInt[i]=arrayInt[i+1];
								arrayInt[i+1]=tmp2;
								changes=true;
							}
						}
					}while(changes);
					System.out.printf("Sequencia ordenada por ordem decrescente!\n");
					break;
				case 12:
					System.out.print("Valor que quer procurar: ");
					int value = read.nextInt();
					int n = 0;
					int pos = -1;
					do{
						if(arrayInt[n++] == value){
							pos = n-1;
						}
					}while(pos == -1 && n < numEl);
					System.out.printf("O valor %d esta na posicao %d do array\n", value, pos);
					break;
				case 13:
					//é necessário que este case exista para o que o programa funcione corretamente
					break;
				default:
					System.out.printf("OPCAO INVALIDA!\n");
					break;
			}
		}while(option!=13);//TERMINA QUANDO E INTRODUZIDO 13
	}
	public static void checkFile(File fileIn, String nameFile){
		if(!fileIn.exists()){
			System.out.printf("ERROR: The file %s doesn't exist.\n",nameFile);
			System.exit(1);
		}
		if(!fileIn.canRead()){
			System.out.printf("ERROR: The file %s cannot be read.\n",nameFile);
			System.exit(2);
		}
	}
}

