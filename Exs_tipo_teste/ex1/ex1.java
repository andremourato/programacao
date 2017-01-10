import java.io.*;
import java.util.*;
public class ex1 {
	
	static Scanner read = new Scanner(System.in);
	public static void main (String[] args) throws IOException {
		
		
		Scanner scf;
		File fileIn;
		Dados[] arrayValores = new Dados[30]; //array de um novo tipo de dados que contem a temperatura e a humidade
		int numElem=0;
		int opcao;
			System.out.printf("Estacao metereologica\n\n");
			System.out.printf("1 - Ler Ficheiros de dados\n");
			System.out.printf("2 - Acrescentar medida\n");
			System.out.printf("3 - Listar valores de temperatura e humidade\n");
			System.out.printf("4 - Listar medidas ordenadas por valor de temperatura\n");
			System.out.printf("5 - Listar medidas ordenadas por valor de humidade\n");
			System.out.printf("6 - Calcular valores medios de temperatura e humidade\n");
			System.out.printf("7 - Calcular valores maximos e minimos de temperatura e humidade\n");
			System.out.printf("8 - Calcular histograma das temperaturas e humidade\n");
			System.out.printf("9 - Terminar o programa\n");
			System.out.println();
			System.out.println("-------------------------------------------");
			System.out.println();
		do{	
			System.out.printf("Opcao -> ");
			opcao = read.nextInt(); //le a opcao escolhida
			switch(opcao){
				case 1:
					System.out.print("Nome do ficheiro que contem os valores: ");
					String fileName = read.next();
					fileIn = new File(fileName);
					scf = new Scanner(fileIn);
					for(int i=0; scf.hasNextLine();i++){
						arrayValores[i] = new Dados();
						arrayValores[i].temp = Integer.parseInt(scf.nextLine());
						arrayValores[i].hum = Integer.parseInt(scf.nextLine());
						numElem++;
					}
					System.out.println("Ficheiro lido!");
					/*for(int i=0;i<=numElem;i++){
						System.out.println(arrayValores[i].temp);
						System.out.println(arrayValores[i].hum);
					}*/ // Imprime o array
					System.out.println();
					System.out.println("-------------------------------------------");
					System.out.println();
					break;
				case 2:
					if(numElem<31){
						Dados valores = new Dados();
						boolean isValid;
						do{
							isValid = false;
							System.out.println("Valor da temperatura: ");
							valores.temp = read.nextInt();
							System.out.println("Valor da humidade: ");
							valores.hum = read.nextInt();
							isValid = isValid(valores);
							if(isValid){
								arrayValores[numElem] = new Dados();
								arrayValores[numElem].temp = valores.temp;
								arrayValores[numElem].hum = valores.hum;
							}else System.out.println("Valores invalidos!\n");
						}while(!isValid);
					}else System.out.println("Ja nao e possivel adicionar mais medidas");
					numElem++;
					System.out.println();
					System.out.println("-------------------------------------------");
					System.out.println();
					break;
				case 3:
					for(int i=0;i<numElem;i++){
						System.out.printf("Medida %d\n",i+1);
						System.out.printf("Temperatura: %d\n",arrayValores[i].temp);
						System.out.printf("Humidade: %d\n",arrayValores[i].hum);
						System.out.println();
					}
					System.out.println();
					System.out.println("-------------------------------------------");
					System.out.println();
					break;
				case 4:
					int tmpTemp1;
					int tmpHum1;
					boolean trocas1=false;
					do{
						trocas1 = false;
						for(int i=0;i<=numElem-1;i++){
							if(arrayValores[i].temp>arrayValores[i+1].temp){
								tmpTemp1 = arrayValores[i].temp;
								tmpHum1 = arrayValores[i].hum;
								arrayValores[i].temp = arrayValores[i+1].temp;
								arrayValores[i].hum = arrayValores[i+1].hum;
								arrayValores[i+1].temp = tmpTemp1;
								arrayValores[i+1].hum = tmpHum1;
								trocas1 = true;
							}
						}
					}while(trocas1);
					for(int i=0;i<=numElem;i++){
						System.out.printf("Medida %d\n",i+1);
						System.out.printf("Temperatura: %d\n",arrayValores[i].temp);
						System.out.printf("Humidade: %d\n",arrayValores[i].hum);
						System.out.println();
					}
					System.out.println();
					System.out.println("-------------------------------------------");
					System.out.println();
					break;
				case 5:
					int tmpTemp2;
					int tmpHum2;
					boolean trocas2 = false;
					do{
						trocas2 = false;
						for(int i=0;i<=numElem-1;i++){
							if(arrayValores[i].hum<arrayValores[i+1].hum){
								tmpTemp2 = arrayValores[i].temp;
								tmpHum2 = arrayValores[i].hum;
								arrayValores[i].temp = arrayValores[i+1].temp;
								arrayValores[i].hum = arrayValores[i+1].hum;
								arrayValores[i+1].temp = tmpTemp2;
								arrayValores[i+1].hum = tmpHum2;
								trocas2 = true;
							}
						}
					}while(trocas2);
					for(int i=0;i<=numElem;i++){
						System.out.printf("Medida %d\n",i+1);
						System.out.printf("Temperatura: %d\n",arrayValores[i].temp);
						System.out.printf("Humidade: %d\n",arrayValores[i].hum);
						System.out.println();
					}
					System.out.println();
					System.out.println("-------------------------------------------");
					System.out.println();
					break;
				case 6:
					Media media = new Media();
					Media soma = new Media();
					soma.temp = 0;
					soma.hum = 0;
					for(int i=0;i<=numElem;i++){
						soma.temp += arrayValores[i].temp;
						soma.hum += arrayValores[i].hum;
					}
					media.temp=soma.temp/numElem;
					media.hum=soma.hum/numElem;
					System.out.printf("Valor medio da temperatura: %.2f\n",media.temp);
					System.out.printf("Valor medio da humidade: %.2f\n",media.hum);
					System.out.println();
					System.out.println("-------------------------------------------");
					System.out.println();
					break;
				case 7:
					Dados max = new Dados();
					Dados min = new Dados();
					max.temp = arrayValores[0].temp;
					max.hum = arrayValores[0].hum;
					min.temp = arrayValores[0].temp;
					min.hum = arrayValores[0].hum;
					for(int i=0;i<=numElem;i++){
						if(arrayValores[i].temp>max.temp) max.temp = arrayValores[i].temp;
						if(arrayValores[i].temp<min.temp) min.temp = arrayValores[i].temp;
						if(arrayValores[i].hum>max.hum) max.hum = arrayValores[i].hum;
						if(arrayValores[i].hum<min.hum) min.hum = arrayValores[i].hum;
					}
					System.out.printf("Valor maximo da temperatura: %d\n",max.temp);
					System.out.printf("Valor minimo da temperatura: %d\n",min.temp);
					System.out.printf("Valor maximo da humidade: %d\n",max.hum);
					System.out.printf("Valor minimo da humidade: %d\n",min.hum);
					System.out.println();
					System.out.println("-------------------------------------------");
					System.out.println();
					break;
				case 8:
					System.out.println("Histogramada da temperatura");
					System.out.println("----------------------------");
					for(int i=-10;i<=40;i++){
						System.out.printf("%02d |",i);
						for(int j=0;j<=numElem;j++){
							if(arrayValores[j].temp==i) System.out.print("*");
						}
						System.out.println();
					}
					System.out.println();
					System.out.println("Histogramada da humidade");
					System.out.println("----------------------------");
					for(int i=-10;i<=40;i++){
						System.out.printf("%02d |",i);
						for(int j=0;j<=numElem;j++){
							if(arrayValores[j].hum==i) System.out.print("*");
						}
						System.out.println();
					}
					System.out.println();
					System.out.println("-------------------------------------------");
					System.out.println();
					break;
				case 9:
				
					break;
				
			}
		}while(opcao!=9);
	}
	public static boolean isValid(Dados valor){
		if((valor.temp>=-10&&valor.temp<=40)&&(valor.hum>=0&&valor.hum<=100)) return true;
		return false;
	}
}
class Dados {
	int temp;
	int hum;
	
}

class Media{
	double temp;
	double hum;
}

