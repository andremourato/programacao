package data;

public class Data {
	public Data(int dia, int mes, int ano){
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}
	
	public boolean igualA( Data date ){
		if(this.ano != date.ano()) return false;
		else if(this.mes != date.mes()) return false;
		else if(this.dia != date.dia()) return false;
		else return true;
	}
	
	public boolean maiorDoQue( Data date ){
		
		if(this.ano < date.ano()) return false;
		else if(this.ano > date.ano()) return true;
		else { //se o ano for igual
			if(this.mes < date.mes()) return false;
			else if(this.mes > date.mes()) return true;
			else{ //se o mes for igual
				if(this.dia < date.dia()) return false;
				else if(this.dia > date.dia()) return true;
				else return false; //se a data for igual
			}
		}
	}
	
	public boolean menorDoQue( Data date ){
		
		if(this.ano < date.ano()) return true;
		else if(this.ano > date.ano()) return false;
		else{ //se o ano for igual
			if(this.mes < date.mes()) return true;
			else if(this.mes > date.mes()) return false;
			else{ //se o mes for igual
				if(this.dia < date.dia()) return true;
				else if(this.dia > date.dia()) return false;
				else return false; //se as datas forem iguais
			}
		}
	}
	
	public int dia(){
		return dia;
	}
	
	public int mes(){
		return mes;
	}
	
	public int ano(){
		return ano;
	}
	
	private int dia;
	private int mes;
	private int ano;
	
}

