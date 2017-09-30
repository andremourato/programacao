/*
 * André Mourato
 * GitHub - https://github.com/andremourato
*/
package teste;
import aula3.*;

public class Test {
	
	public static void main(String[] args) throws Exception{
		
		/*DUMMY OBJECTS*/
		System.out.println("----------INICIALIZACAO DOS OBJETOS DE TESTE-----------");
		//Cartas de condução
		Carta cartaMotas = new Carta("A");
		Carta cartaLigeiros = new Carta("B");
		Carta cartaMercadorias = new Carta("C");
		Carta cartaPassageiros = new Carta("D");
		try{ 
			Carta cartaInvalida = new Carta("X"); //Levanta exceção
		}catch(Exception e) {
			System.out.println("Carta invalida!");
			System.out.println(e);
		}
		
		//Datas de nascimento
		Data data1 = new Data(1,2,1998);
		Data data2 = new Data(19,4,1997);
		Data data3 = new Data(25,9,1970);
		Data data4 = new Data(19,4,1990);
		Data data5 = new Data(9,8,1998);
		try {
			Data dataInvalida = new Data(32,3,1998); //Levanta exceção
		}catch(IllegalArgumentException e) {
			System.out.println("Data invalida!");
			System.out.println(e);
		}
		
		//Condutores
		Condutor condutorMota = new Condutor("Manuel",14785467,data1,cartaMotas);
		Condutor condutorLigeiro = new Condutor("Miguel",14345487,data2,cartaLigeiros);
		Condutor condutorMercadoria = new Condutor("Ana",14725347,data3,cartaMercadorias);
		Condutor condutorPassageiro = new Condutor("Maria",16786354,data4,cartaPassageiros);
		
		//Pessoas
		Pessoa passageiro1 = new Pessoa("Andre Mourato",19765334,data5); //Criador deste programa
		Pessoa passageiro2 = new Pessoa("Joao",19895334,data2);
		Pessoa passageiro3 = new Pessoa("Mariana",19795334,data1);
		Pessoa passageiro4 = new Pessoa("Margarida",19700334,data3);
		Pessoa passageiro5 = new Pessoa("Jose",197795334,data2);
		Pessoa passageiro6 = new Pessoa("Joana",19795334,data1);
		
		//Veiculos
		Veiculo veiculo = new Veiculo(condutorMota,1,125.0,11.0,3000.0,cartaMotas);
		Motociclo motaSemAtrelado = new Motociclo(condutorMota);
		Motociclo motaComAtrelado = new Motociclo(condutorMota,true);
		Ligeiro carroAzul = new Ligeiro(condutorLigeiro,"AZUL");
		Ligeiro carroComCondutorIlegal = new Ligeiro(condutorMota,"VERMELHO");
		PesadoMercadoria camiaoMercadoria = new PesadoMercadoria(condutorMercadoria);
		PesadoPassageiros autocarro = new PesadoPassageiros(condutorPassageiro);
		
		/*Teste do programa*/
		System.out.println("----------INICIO DO PROGRAMA DE TESTE-----------");
		//Teste do veiculo
		try {
			veiculo.addPassageiro(passageiro1); //Veiculo cheio. Levanta exceção
		}catch(Exception e){
			System.out.println(e);
		}
		System.out.println("O " + veiculo + " é conduzido por "+veiculo.condutor().nome());
		System.out.println(veiculo.info());
						
		System.out.println("--------------------------");
		//Teste do motociclo
		//Sem atrelado
		try {
			motaSemAtrelado.addPassageiro(passageiro1); //Veiculo cheio. Levanta exceção
		}catch(Exception e){
			System.out.println(e);
		}
		
		System.out.println("O " + motaSemAtrelado + " é conduzido por "+motaSemAtrelado.condutor().nome());
		System.out.println(motaSemAtrelado.info());
		
		System.out.println("--------------------------");
		//Com atrelado

		motaComAtrelado.addPassageiro(passageiro1); //Tem atrelado, por isso tem lugar para mais 1 passageiro. Não levanta exceção
		
		System.out.println(motaComAtrelado + " é conduzido por "+motaComAtrelado.condutor().nome());
		System.out.println(motaComAtrelado.info());
		
		System.out.println("--------------------------");
		//Teste do Ligeiro
		carroAzul.addPassageiro(passageiro1); //Tem mais 4 lugares
		carroAzul.addPassageiro(passageiro2);
		carroAzul.addPassageiro(passageiro3);
		carroAzul.addPassageiro(passageiro4);
		try {
			carroAzul.addPassageiro(passageiro5); //Não há mais lugares no carro. Levanta exceção
		}catch(Exception e) {
			System.out.println(e);
		}
		
		System.out.println("O "+carroAzul+" de cor "+ carroAzul.cor() + " é conduzido por "+carroAzul.condutor().nome());
		System.out.println(carroAzul.info());
		
		System.out.println("--------------------------");
		//Teste do Condutor Ilegal
		System.out.println("O "+carroComCondutorIlegal+" de cor "+ carroComCondutorIlegal.cor() + " é conduzido por "+carroComCondutorIlegal.condutor().nome());
		System.out.println("O condutor tem a carta apropriada: "+(carroComCondutorIlegal.cartaValidaCondutor()?"Sim":"Não")); //NÃO
		carroComCondutorIlegal.mudarCondutor(condutorLigeiro);
		System.out.println("O condutor tem a carta apropriada: "+(carroComCondutorIlegal.cartaValidaCondutor()?"Sim":"Não")); //SIM
		
		System.out.println("--------------------------");
		//Teste do pesado de mercadoria
		System.out.println(camiaoMercadoria + " é conduzido por "+camiaoMercadoria.condutor().nome());
		camiaoMercadoria.addPassageiro(passageiro2);
		camiaoMercadoria.addMercadoria("banana");
		camiaoMercadoria.addMercadoria("banana");
		camiaoMercadoria.addMercadoria("banana");
		camiaoMercadoria.addMercadoria("pera");
		camiaoMercadoria.addMercadoria("pera");
		System.out.println("Quantidade de bananas: "+camiaoMercadoria.quantidadeDe("banana")); // == 3
		System.out.println("Quantidade de pera: "+camiaoMercadoria.quantidadeDe("pera")); // == 2
		System.out.println(camiaoMercadoria.info());
		
		System.out.println("--------------------------");
		//Teste do Pesado de Passageiros
		System.out.println("O autocarro tem "+autocarro.numPassageiros()+" passageiros a bordo"); //== 0
		autocarro.addPassageiro(passageiro1);
		autocarro.addPassageiro(passageiro2);
		autocarro.addPassageiro(passageiro3);
		autocarro.addPassageiro(passageiro4);
		autocarro.addPassageiro(passageiro5);
		autocarro.addPassageiro(passageiro6);
		autocarro.addPassageiro(condutorMota);
		autocarro.addPassageiro(condutorMercadoria);
		autocarro.addPassageiro(condutorLigeiro);
		autocarro.addPassageiro(condutorPassageiro);
		System.out.println("O autocarro tem "+autocarro.numPassageiros()+" passageiros a bordo");// == 10
		autocarro.removePassageiro(19765334); //remove passageiro 1 pelo cc
		autocarro.removePassageiro(passageiro5); //remove passageiro 5
		System.out.println("O autocarro tem "+autocarro.numPassageiros()+" passageiros a bordo");// == 8
		autocarro.saidaPassageiros(new Pessoa[]{passageiro2, passageiro3, condutorLigeiro});
		System.out.println("O autocarro tem "+autocarro.numPassageiros()+" passageiros a bordo");// == 5
		System.out.println(autocarro.info());
		autocarro.anunciarParagem("Viseu");
		try {
			autocarro.anunciarParagem("invalida");
		}catch(Exception e) {
			System.out.println(e);
		}
		System.out.println("----------FIM DO PROGRAMA DE TESTE-----------");
	}
	
}
