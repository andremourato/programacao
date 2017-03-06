import static java.lang.System.*;

// Este programa é igual ao p33 da aula anterior.
public class p43
{
  public static void main(String[] args)
  {
    Tarefa[] tarefas = new Tarefa[args.length / 7]; // argumentos em grupos de sete (data-inicio data-fim texto)
    for(int i = 0; i < tarefas.length; i++)
    {
      int dia, mes, ano;
      dia = Integer.parseInt(args[i*7]);
      mes = Integer.parseInt(args[i*7+1]);
      ano = Integer.parseInt(args[i*7+2]);
      Data inicio = new Data(dia, mes, ano);
      dia = Integer.parseInt(args[i*7+3]);
      mes = Integer.parseInt(args[i*7+4]);
      ano = Integer.parseInt(args[i*7+5]);
      Data fim = new Data(dia, mes, ano);
      String texto = args[i*7+6];
      tarefas[i] = new Tarefa(inicio, fim, texto);
    }
    for(int i = 0; i < tarefas.length; i++)
      tarefas[i].escreve();
  }
}

