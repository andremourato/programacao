package user;
import aula2.*;

public class Estudante extends Utilizador { 
	
	protected final String curso;
	protected final int nmec;
	
	public Estudante(String nome, String curso, int cc, int nmec, Data dataNascimento){
		super(nome,cc,dataNascimento);
		this.curso = curso;
		this.nmec = nmec;
		
	}
	
	public String curso() { return curso; }
	public int nmec() { return nmec; }
}
