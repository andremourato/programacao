import java.util.*;
public class ex2 {
	
	static Scanner read = new Scanner(System.in);
	public static void main (String[] args) {
		
		Piloto[] pilotos = new Piloto[9];
		
		int opcao;
		int nPilotos=0;
		System.out.printf("Gestao de uma prova automovel:\n");
		System.out.printf("1 - Inserir informacao dos pilotos\n");
		System.out.printf("2 - Listar pilotos ordenados pelo numero da viatura\n");
		System.out.printf("3 - Alterar informacao de um piloto\n");
		System.out.printf("4 - Remover piloto com base no numero da viatura\n");
		System.out.printf("5 - Listar pilotos ordenados pelo nome\n");
		System.out.printf("6 - Remover piloto(s) com base no nome\n");
		System.out.printf("7 - Validar matriculas\n");
		System.out.printf("8 - Terminar programa\n");
		System.out.println();
		System.out.println("----------------------------------");
		System.out.println();
		do{
			System.out.print("Opcao -> ");
			opcao = Integer.parseInt(read.nextLine());
			switch(opcao){
				case 1: //inserir informação do pilotos
					Scanner readNew = new Scanner(System.in);
					pilotos = new Piloto[9];
					nPilotos = 0;
					for(int i=0;i<pilotos.length;i++){
						pilotos[i] = new Piloto();
						pilotos[i].numViat=i+1;
						System.out.print("Nome do piloto: ");
						pilotos[i].nome = readNew.nextLine();
						if(pilotos[i].nome.length()==0) break;
						System.out.print("Matricula do veiculo: ");
						pilotos[i].mat = readNew.nextLine();
						nPilotos++; //conta o numero de pilotos
						System.out.println();
					}
					/*for(int i=0;i<nPilotos;i++){
						System.out.println("Nome do piloto: "+pilotos[i].nome);
						System.out.println("Matricula: "+pilotos[i].mat);
						System.out.println("Numero da viatura: "+pilotos[i].numViat);
						System.out.println();
					} imprime o array*/
					System.out.println();
					System.out.println("----------------------------------");
					System.out.println();
					break;
				case 2:
					boolean trocas;
					Piloto tmp = new Piloto();
					for(int i=0;i<nPilotos-1;i++){
						for(int j=i+1;j<nPilotos;j++){
							if(pilotos[j].numViat>pilotos[i].numViat){
								tmp.numViat = pilotos[i].numViat; //troca toda a informaçao de um piloto por a de outro
								tmp.nome = pilotos[i].nome;
								tmp.mat = pilotos[i].mat;
								pilotos[i].numViat = pilotos[j].numViat;
								pilotos[i].nome = pilotos[j].nome;
								pilotos[i].mat = pilotos[j].mat;
								pilotos[j].numViat = tmp.numViat;
								pilotos[j].nome = tmp.nome;
								pilotos[j].mat = tmp.mat;
								trocas = true;
							}
						}
					}
					for(int i=0;i<nPilotos;i++){
						System.out.println("Nome do piloto: "+pilotos[i].nome);
						System.out.println("Matricula: "+pilotos[i].mat);
						System.out.println("Numero da viatura: "+pilotos[i].numViat);
						System.out.println();
					}
					System.out.println();
					System.out.println("----------------------------------");
					System.out.println();
					break;
				case 3:
					int posicao = -1;
					do{
						System.out.print("Numero de viatura: ");
						int numero = Integer.parseInt(read.nextLine());
						//vai procurar o piloto cujo numero da viatura foi introduzido
						posicao = procuraElemento(pilotos,numero, nPilotos);
						if(posicao==-1) System.out.println("Nao existe piloto com o numero de viatura introduzido!\n");
					}while(posicao==-1);
					System.out.print("Nome do piloto: "); //altera a informacao do piloto com o numero de viatura introduzido
					pilotos[posicao].nome = read.nextLine(); 
					if(pilotos[posicao].nome.length()==0) break;
					System.out.print("Matricula do veiculo: ");
					pilotos[posicao].mat = read.nextLine();
					System.out.println();
					System.out.println("----------------------------------");
					System.out.println();
					break;
				case 4:
					int posicaoRemover;
					do{
						System.out.print("Numero de viatura: ");
						int numero = Integer.parseInt(read.nextLine());
						//vai procurar o piloto cujo numero da viatura foi introduzido
						posicaoRemover = procuraElemento(pilotos,numero, nPilotos);
						if(posicaoRemover==-1) System.out.println("Nao existe piloto com o numero de viatura introduzido!\n");
					}while(posicaoRemover==-1);
					for(int i=posicaoRemover;i<nPilotos;i++){
						pilotos[i].nome = pilotos[i+1].nome;
						pilotos[i].mat = pilotos[i+1].mat;
						
					}
					nPilotos--;
					System.out.println();
					System.out.println("----------------------------------");
					System.out.println();
					break;
				case 5:
					String nomes[] = new String[nPilotos]; //cria-se um array String
					for(int i=0;i<nomes.length;i++){
						nomes[i] = pilotos[i].nome; //Atribui-se os nomes dos pilotos como elementos deste novo array
					}
					Arrays.sort(nomes); //coloca os nomes por ordem alfabetica
					for(int i=0;i<nomes.length;i++){
						pilotos[i].nome = nomes[i]; //devolve-se a lista de nomes por ordem alfabetica
					}
					for(int i=0;i<nPilotos;i++){
						System.out.println("Nome do piloto: "+pilotos[i].nome);
						System.out.println("Matricula: "+pilotos[i].mat);
						System.out.println("Numero da viatura: "+pilotos[i].numViat);
						System.out.println();
					}
					System.out.println();
					System.out.println("----------------------------------");
					System.out.println();
					break;
				case 6:
					int posicaoNomeRemover=-1;
					do{
						System.out.print("Nome do piloto: ");
						String nome = read.nextLine();
						//vai procurar o piloto cujo nome foi introduzido
						posicaoNomeRemover = procuraElemento(pilotos, nome, nPilotos);
						if(posicaoNomeRemover==-1) System.out.println("Nao existe piloto com o nome introduzido!\n");
					}while(posicaoNomeRemover==-1);
					for(int i=posicaoNomeRemover;i<nPilotos;i++){
						pilotos[i].nome = pilotos[i+1].nome;
						pilotos[i].mat = pilotos[i+1].mat;
					}
					nPilotos--;
					System.out.println("Piloto removido com sucesso!");
					System.out.println();
					System.out.println("----------------------------------");
					System.out.println();
					break;
				case 7:
					for(int i=0;i<nPilotos;i++){
						if(!validMatricula(pilotos[i].mat)){
							do{
								System.out.printf("Matricula do veiculo %d - INVALIDA \n",i+1);
								System.out.print("Nova matricula do veiculo: ");
								pilotos[i].mat = read.nextLine();
							}while(!validMatricula(pilotos[i].mat));
						}
					}
					System.out.println();
					System.out.println("----------------------------------");
					System.out.println();
					break;
				case 8:
					//termina o programa
					break;
				
			}
		}while(opcao!=8); //termina o programa quando for escolhida a opcao 8
	}
	public static int procuraElemento(Piloto pilotos[], int numero, int nPilotos){ //procura um elemento Integer
		int n=0;
		int pos=-1;
		
		do{
			if(pilotos[n++].numViat==numero) pos = n-1;
		}while(n<nPilotos);
		return pos;
	}
	public static int procuraElemento(Piloto pilotos[], String nome, int nPilotos){ //procura um elemento String
		int n=0;
		int pos=-1;
		
		do{
			if(pilotos[n++].nome.equals(nome)) pos = n-1;
		}while(n<nPilotos);
		return pos;
	}
	public static boolean validMatricula(String mat){
		if(mat.length()!=8) return false;
		if(mat.charAt(2)!='-'||mat.charAt(5)!='-') return false;
		if(Character.isLetter(mat.charAt(0))&&Character.isLetter(mat.charAt(1))&&Character.isDigit(mat.charAt(3))&&Character.isDigit(mat.charAt(4))&&Character.isDigit(mat.charAt(6))&&Character.isDigit(mat.charAt(7))) return true;
		if(Character.isDigit(mat.charAt(0))&&Character.isDigit(mat.charAt(1))&&Character.isLetter(mat.charAt(3))&&Character.isLetter(mat.charAt(4))&&Character.isDigit(mat.charAt(6))&&Character.isDigit(mat.charAt(7))) return true;
		if(Character.isDigit(mat.charAt(0))&&Character.isDigit(mat.charAt(1))&&Character.isDigit(mat.charAt(3))&&Character.isDigit(mat.charAt(4))&&Character.isLetter(mat.charAt(6))&&Character.isLetter(mat.charAt(7))) return true;
		return false;
	}
}

class Piloto{
	int numViat;
	String nome;
	String mat;
	
}
