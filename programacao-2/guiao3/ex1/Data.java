public class Data {
	Data(int dia, int mes, int ano){
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}
	
	boolean igualA( Data date ){
		if(this.ano != date.ano()) return false;
		else if(this.mes != date.mes()) return false;
		else if(this.dia != date.dia()) return false;
		return true;
	}
	
	boolean maiorDoQue( Data date ){
		if(this.ano < date.ano()) return false;
		else if(this.mes < date.mes()) return false;
		else if(this.dia < date.dia()) return false;
		return true;
	}
	
	boolean menorDoQue( Data date ){
		if(this.ano < date.ano()) return true;
		else if(this.mes < date.mes()) return true;
		else if(this.dia < date.dia()) return true;
		return false;
	}
	
	int dia(){
		return dia;
	}
	
	int mes(){
		return mes;
	}
	
	int ano(){
		return ano;
	}
	
	private int dia;
	private int mes;
	private int ano;
	
}

