import java.util.*;
import java.io.*;

public class ex4 {
	
	public static void main (String[] args) throws IOException {
		
		Scanner read = new Scanner(System.in);
		int opcao; //Escolhe a opçao
		Aluno alunos[] = new Aluno[100]; //array com informacao dos alunos
		int numAlunos=0;
		do{
			System.out.println("Servicos Academicos - Gestao de uma pauta:");
			System.out.println("1 - Ler ficheiro com numeros mec. e pedir informacao de notas");
			System.out.println("2 - Imprimir no terminal a informacao da disciplina");
			System.out.println("3 - Calcular estatisticas da notas finais");
			System.out.println("4 - Alterar as notas de um aluno");
			System.out.println("5 - Imprimir um histograma de notas");
			System.out.println("6 - Gravar num ficheiro a informacao da disciplina (ordenada)");
			System.out.println("7 - Terminar programa");
			System.out.println();
			System.out.println("-------------------------");
			System.out.println();
			System.out.print("Opcao -> ");
			opcao = Integer.parseInt(read.nextLine()); //le a opcao introduzida pelo utilizador
			System.out.println();
			
			switch(opcao){
				case 1:
					
					System.out.print("Nome do ficheiro: ");
					String fileName = read.nextLine(); //pede o nome do ficheiro
					File file = new File(fileName);
					Scanner scf = new Scanner(file);
					for(int i=0;scf.hasNextLine();i++){ //le o ficheiro
						alunos[i] = new Aluno();
						alunos[i].nmec = Integer.parseInt(scf.nextLine());
						numAlunos++;
						do{	
							System.out.print("Nota da epoca normal: ");
							alunos[i].norm = Integer.parseInt(read.nextLine());
							if(!isValid(alunos[i].norm)) System.out.println("Nota invalida!");
						}while(!isValid(alunos[i].norm));
						do{	
							System.out.print("Nota da epoca recurso: ");
							alunos[i].rec = Integer.parseInt(read.nextLine());
							if(!isValid(alunos[i].rec)) System.out.println("Nota invalida!");
						}while(!isValid(alunos[i].rec));
						if(alunos[i].norm>=alunos[i].rec) alunos[i].nfinal = alunos[i].norm;
						else alunos[i].nfinal = alunos[i].rec;
					}
					/*for(int i=0;scf.hasNextLine();i++){
						alunos[i] = new Aluno();
						alunos[i].nmec = Integer.parseInt(scf.nextLine());
						System.out.println(alunos[i].nmec);
					} percorre o array*/
					System.out.println("Notas lidas com sucesso!");
					System.out.println();
					System.out.println("-------------------------");
					System.out.println();
					break;
					
				case 2:
				
					System.out.println("Pauta de uma disciplina\n");
					System.out.println("------------------------");
					for(int i=0;i<numAlunos;i++){
						System.out.printf("| %05d | %02d | %02d | %02d |\n",alunos[i].nmec,alunos[i].norm,alunos[i].rec,alunos[i].nfinal);
					}
					System.out.println("------------------------");
					System.out.println();
					System.out.println("-------------------------");
					System.out.println();
					break;
					
				case 3:
					int best=0;
					double sum=0;
					double avg;
					int numAprovados=0;
					for(int i=0;i<numAlunos;i++){
						sum += alunos[i].nfinal;
						if(alunos[i].nfinal>alunos[best].nfinal) best = i;
						if(alunos[i].nfinal>=10) numAprovados++;
					}
					avg = (double)(sum/numAlunos);
					System.out.printf("Nota final media: %.2f\n",avg);
					System.out.printf("Numero mecanografico do melhor aluno: %d\n",alunos[best].nmec);
					System.out.printf("Numero de alunos aprovados: %d\n",numAprovados);
					System.out.printf("Numero de alunos reprovados: %d\n",numAlunos-numAprovados);
					
					System.out.println();
					System.out.println("-------------------------");
					System.out.println();
					break;
					
				case 4:
					int pos = -1;
					pos = posAluno(alunos, numAlunos);
					do{	
						System.out.print("Nota da epoca normal: ");
						alunos[pos].norm = Integer.parseInt(read.nextLine());
						if(!isValid(alunos[pos].norm)) System.out.println("Nota invalida!");
					}while(!isValid(alunos[pos].norm));
					do{	
						System.out.print("Nota da epoca recurso: ");
						alunos[pos].rec = Integer.parseInt(read.nextLine());
						if(!isValid(alunos[pos].rec)) System.out.println("Nota invalida!");
					}while(!isValid(alunos[pos].rec));
					if(alunos[pos].norm>=alunos[pos].rec) alunos[pos].nfinal = alunos[pos].norm;
					else alunos[pos].nfinal = alunos[pos].rec;
					System.out.println("Informacao alterada com sucesso!");
					System.out.println();
					System.out.println("-------------------------");
					System.out.println();
					break;
					
				case 5:
					drawHist(alunos, numAlunos);
					System.out.println();
					System.out.println("-------------------------");
					System.out.println();
					break;
					
				case 6:
					File outputFile = new File("sortedInfo.txt");
					PrintWriter pwf = new PrintWriter(outputFile);
					Aluno alunosf[] = new Aluno[numAlunos];
					alunosf = sortArray(alunos, numAlunos, alunosf);
					for(int i=0;i<numAlunos;i++){
						pwf.println("Numero mecanografico: "+alunosf[i].nmec);
						pwf.println("Nota da epoca normal: "+alunosf[i].norm);
						pwf.println("Nota da epoca de recurso: "+alunosf[i].rec);
						pwf.println("Nota final da disciplina: "+alunosf[i].nfinal);
						pwf.println();
					}
					pwf.close();
					System.out.println("Informacao gravada com sucesso!");
					System.out.println();
					System.out.println("-------------------------");
					System.out.println();
					break;
					
				case 7:
					//termina o programa
					break;
			}
		}while(opcao!=7); //se for introduzido o valor 7, o programa termina
	}
	public static boolean isValid(int nota){
		if((nota>=0&&nota<=20)||nota==77) return true; //valida a nota e cria a exceçao para o codigo 77 - faltou
		return false;
	}
	public static int posAluno(Aluno alunos[], int numAlunos){
		Scanner read = new Scanner(System.in);
		int nmec;
		int pos = -1;
		int n = 0;
		do{
			System.out.print("Numero mecanografico do aluno: ");
			nmec = Integer.parseInt(read.nextLine());
			do{
				if(alunos[n++].nmec==nmec) pos = n-1;
			}while(pos == -1 && n < numAlunos);
			if(pos==-1) System.out.println("Nao existe aluno com o numero mecanografico introduzido");
		}while(pos==-1);
		return pos;
	}
	public static Aluno[] sortArray(Aluno alunos[], int numAlunos, Aluno[] alunosf){
		Aluno tmp = new Aluno();
		alunosf = new Aluno[numAlunos];
		for(int i=0;i<numAlunos-1;i++){
			for(int j=i;j<numAlunos;j++){
				if(alunos[i].nfinal<alunos[j].nfinal){ //troca se esta condicao for concretizada
					tmp.nmec = alunos[i].nmec;
					tmp.norm = alunos[i].norm;
					tmp.rec = alunos[i].rec;
					tmp.nfinal = alunos[i].nfinal;
					alunos[i].nmec = alunos[j].nmec;
					alunos[i].norm = alunos[j].norm;
					alunos[i].rec = alunos[j].rec;
					alunos[i].nfinal = alunos[j].nfinal;
					alunos[j].nmec = tmp.nmec;
					alunos[j].norm = tmp.norm;
					alunos[j].rec = tmp.rec;
					alunos[j].nfinal = tmp.nfinal;
				}
			}
		}
		for(int i=0;i<numAlunos;i++){
			alunosf[i] = new Aluno();
			alunosf[i].nmec = alunos[i].nmec;
			alunosf[i].norm = alunos[i].norm;
			alunosf[i].rec = alunos[i].rec;
			alunosf[i].nfinal = alunos[i].nfinal;
		}
		return alunos;
	}
	public static void drawHist(Aluno[] alunos, int numAlunos){ //desenha o histograma
		int height = 0;
		int[] times = new int[21];
		for(int i=0; i<numAlunos;i++){
			for(int j=0;j<times.length;j++){
				if(alunos[i].nfinal==j) times[alunos[i].nfinal]++;
			}
		} //array times está definido
		for(int i : times) if(i > height) height = i; //determina a altura do histograma
		for(int n=height;n>0;n--){ //percorre o array na vertical
			for(int m=0;m<21;m++){ //percore o array na horizontal
				if(times[m]==n){
					System.out.print("  *");
					times[m]--;
				}else System.out.print("   ");
			}
			System.out.println();
		}
		System.out.println("----------------------------------------------------------------------");
		for(int i = 0 ; i < 21; i++) System.out.printf(" %02d",i); //imprime a linha com os valores de 0 a 20
	}
}

class Aluno{
	int nmec;
	int norm;
	int rec;
	int nfinal;

}
