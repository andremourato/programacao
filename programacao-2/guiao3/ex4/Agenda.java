import static java.lang.System.*;
import data.*;

public class Agenda {
	
	int numTarefas = 0; //contagem do numero de tarefas
	Tarefa[] tarefas = new Tarefa[1]; //array de tarefas
	
	public void novaTarefa(Tarefa tarefa){ //adiciona uma nova tarefa
		
		Tarefa[] newTarefas = new Tarefa[numTarefas+1];
		arraycopy(tarefas, 0, newTarefas, 0, numTarefas);
		tarefas = newTarefas;
		tarefas[numTarefas] = tarefa;
		numTarefas++;
		
	}
	
	public Tarefa[] compromissos(Data inicio, Data fim){ //devolve um array com os compromissos existentes
		int index = 0;
		Tarefa[] compromissos = new Tarefa[countTarefas(inicio, fim)];
		for(int i=0; i<tarefas.length;i++){
			if(tarefas[i].isIn(inicio, fim)){
				compromissos[index] = tarefas[i];
				index++;
			}
		}
		
		return compromissos;
	}
	
	private int countTarefas(Data inicio, Data fim){
		int count = 0;
		for(int i=0;i<numTarefas;i++){
			if(tarefas[i].isIn(inicio, fim)) count++; //se estiver naquele intervalo
		}
		return count;
	}
	
	public void escreve(){
		out.println("Agenda:");
		Tarefa.sort(tarefas, numTarefas);
		for(int i=0; i<numTarefas;i++){
			tarefas[i].escreve();
		}
		
	}
	
}

