import data.*;

public class Tarefa {
	
	Tarefa(Data inicio, Data fim, String texto){
		this.inicio = inicio;
		this.fim = fim;
		this.texto = texto;
		
	}
	
	void escreve(){
		System.out.printf("%s <-> %s: %s\n", dateToString(inicio),dateToString(fim), texto);
	}
	
	String dateToString(Data data){
		return ""+data.dia()+"-"+data.mes()+"-"+data.ano();
	}
	
	private Data inicio;
	private Data fim;
	private String texto;
}

