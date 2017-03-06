public class Tarefa {
	
	Tarefa(Data inicio, Data fim, String texto){
		
		assert inicio.maisAntigo(fim);
		assert !texto.equals("");
		this.inicio = inicio;
		this.fim = fim;
		this.texto = texto;
		
	}
	
	void escreve(){ //imprime a informação no ecrã
		inicio.printDateToString();
		System.out.printf(" <-> ", inicio.dateToString(), fim.dateToString(), texto);
		fim.printDateToString();
		System.out.println(": "+texto);
	}
	
	public Data inicio(){
		return inicio;
	}
	
	public Data fim(){
		return fim;
	}
	
	public String texto(){
		return texto;
	}
	
	public boolean isIn(Data inicio, Data fim){
		if(this.inicio.maisRecente(fim)&&this.fim.maisRecente(fim)) return false;
		else if(this.inicio.maisAntigo(inicio)&&this.fim.maisAntigo(inicio)) return false;
		else return true;
	}
	
	public static void sort(Tarefa[] tarefas, int numTarefas){
		for(int i = 0; i < tarefas.length; i++){
			for(int j = i+1; j < tarefas.length; j++){
				if (tarefas[j].inicio.maisAntigo(tarefas[i].inicio))
				{
				  Tarefa tmp = tarefas[j];
				  tarefas[j] = tarefas[i];
				  tarefas[i] = tmp;
				}
			}
		}
	}
	
	private Data inicio;
	private Data fim;
	private String texto;
}

