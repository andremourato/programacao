package user;
import aula2.*;

public class Funcionario extends Utilizador {

	protected final int numFiscal;
	protected final int numFuncionario;
	
	public Funcionario(String nome, int numFiscal, int cc, int numFuncionario, Data dataNascimento) {
		super(nome,cc,dataNascimento);
		this.numFiscal = numFiscal;
		this.numFuncionario = numFuncionario;
		
	}
	
	public int numFiscal() { return numFiscal;	}
	public int numFuncionario() { return numFuncionario; }
	
}
