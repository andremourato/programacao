package aula5.ex2;

public class TestVeiculos {

	public static void main(String[] args) {
		
		/*DUMMY OBJECTS*/
		//CORES
		Color azul = Color.azul;
		Color roxo = Color.roxo;
		Color verde = Color.verde;
		Color amarelo = Color.amarelo;
		Color vermelho = Color.vermelho;
		
		//MATRICULAS
		String matricula1 = "FG-27-32";
		String matricula2 = "20-MT-13";
		String matricula3 = "BE-90-71";
		String matricula4 = "GE-90-36";
		String matricula5 = "66-IO-71";
		String matricula6 = "56-LJ-89";
		String matricula7 = "PP-90-01";
		
		//Veiculos
		Veiculo mota = new Moto(vermelho, 120, 1500, matricula6, 2000, true);
		Veiculo carro = new Automovel(azul, 280, 3000, matricula7, 2010, false);
		Veiculo bicicleta = new Bicicleta(verde, 0.58);
		
		Moto motaSemAtrelado = new Moto(vermelho, 120, 1500, matricula1, 2000, false);
		Moto motaComAtrelado = new Moto(roxo, 120, 1500, matricula2, 2005, true);
		Automovel carroAzulTrancado = new Automovel(azul, 280, 3000, matricula3, 2010, true);
		Automovel carroAmareloDestrancado = new Automovel(amarelo, 280, 3000, matricula4, 2010, false);
		Bicicleta bicicletaVerde = new Bicicleta(verde, 0.58);
		
		//Veiculos da policia
		CarroPolicia carroPolicia = new CarroPolicia(azul, 120, 1500, matricula5, 2000, true, true);
		MotoPolicia motaPolicia = new MotoPolicia(azul, 120, 2000, matricula6, 2000, false);
		BicicletaPolicia bicicletaPolicia = new BicicletaPolicia(azul, 0.58);
		
		/*INICIO DO TESTE DO PROGRAMA*/
		System.out.println("--------A TESTAR VEICULOS--------");
		Veiculo dummyVeiculo = mota;
		System.out.println("O objeto é uma "+dummyVeiculo); //MOTO
		dummyVeiculo = carro;
		System.out.println("O objeto é um "+dummyVeiculo);//AUTOMOVEL
		dummyVeiculo = bicicleta;
		System.out.println("O objeto é uma "+dummyVeiculo);//BICICLETA
		
		System.out.println();
		System.out.println("--------A TESTAR MOTAS--------");
		Moto dummyMoto = motaSemAtrelado;
		System.out.println("A "+dummyMoto+" de matricula "+dummyMoto.getMatricula()+ //FG-27-32
							   (dummyMoto.hasAtrelado()?"":" não")+					 //Sem atrelado
							   " tem atrelado e tem cor "+dummyMoto.getCor());		 //VERMELHO
		
		dummyMoto = motaComAtrelado;
		System.out.println("A "+dummyMoto+" de matricula "+dummyMoto.getMatricula()+ //20-MT-13
				   (dummyMoto.hasAtrelado()?"":" não")+" tem atrelado e tem cor "+   //Com atrelado
				   dummyMoto.getCor());												 //ROXO
		
		System.out.println();
		System.out.println("--------A TESTAR CARROS--------");
		Automovel dummyCarro = carroAzulTrancado;
		System.out.println("O "+dummyCarro+" de matricula "+dummyCarro.getMatricula()+ 	//BE-90-71			  
							(dummyCarro.isTrancado()?"":" não")+			  			//Trancado
							" está trancado e tem cor "+dummyCarro.getCor()); 			//AZUL
		
		dummyCarro = carroAmareloDestrancado;
		System.out.println("O "+dummyCarro+" de matricula "+dummyCarro.getMatricula()+  //GE-90-36
				(dummyCarro.isTrancado()?"":" não")+									//Destrancado
				" está trancado e tem cor "+dummyCarro.getCor()); 						//AMARELO
	
		System.out.println();
		System.out.println("--------A TESTAR BICICLETAS--------");
		System.out.println("A "+bicicletaVerde+" tem um selim de altura "+
							bicicletaVerde.getAlturaSelim()+"m e tem cor "+bicicletaVerde.getCor());
	
		System.out.println();
		System.out.println("--------A TESTAR VEICULOS DA POLICIA--------");
		System.out.println("O "+carroPolicia+" de matricula "+carroPolicia.getMatricula()+
							", de ID "+carroPolicia.getId()+
							" e de cor "+carroPolicia.getCor()+
							", tem as sirenes "+(carroPolicia.isSireneLigada()?"":"des")+"ligadas"); //Ligadas
		carroPolicia.toggleSirene(); //Desliga as sirenes
		System.out.println("O "+carroPolicia+" de matricula "+carroPolicia.getMatricula()+
				", pertence ao Serviço de Emergência "+carroPolicia.getTipo()+				//PJ
				", de ID "+carroPolicia.getId()+											//ID = 9
				" e de cor "+carroPolicia.getCor()+											//AZUL
				", tem as sirenes "+(carroPolicia.isSireneLigada()?"":"des")+"ligadas");   //Desligadas
		
		System.out.println("A "+motaPolicia+", tem uma cilindrada de "+motaPolicia.getCilindrada()+		//2000
							", atinge uma velocidade máxima de "+motaPolicia.getVelocidadeMax()+"KM/H"+ //120KM/H
							" e "+(motaPolicia.hasAtrelado()?"":"não")+" tem atrelado"); 				//Não tem atrelado
		
		System.out.println("A "+bicicletaPolicia+" pertence ao Serviço de Emergência "+bicicletaPolicia.getTipo()+
							", tem cor "+bicicletaPolicia.getCor()+
							" e tem selim de altura "+bicicletaPolicia.getAlturaSelim()+"m");
		System.out.println("\n--------FIM DO TESTE DO PROGRAMA--------");
		
	}

}
