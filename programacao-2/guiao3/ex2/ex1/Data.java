package ex1;

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
		return true;
	}
	
	public boolean maiorDoQue( Data date ){
		if(this.ano < date.ano()) return false;
		else if(this.mes < date.mes()) return false;
		else if(this.dia < date.dia()) return false;
		return true;
	}
	
	public boolean menorDoQue( Data date ){
		if(this.ano < date.ano()) return true;
		else if(this.mes < date.mes()) return true;
		else if(this.dia < date.dia()) return true;
		return false;
	}
	
	public void escreve(){
		System.out.printf("%d-%d-%d",dia,mes,ano);
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

