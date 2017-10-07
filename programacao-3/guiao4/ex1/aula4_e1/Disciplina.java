package aula4_e1;
import java.util.ArrayList;
import java.util.List;

public class Disciplina {
	
	private final String nome;
	private final String areaCientifica;
	private final int ects;
	private Professor responsavel;
	private List<Estudante> alunos;
	
	public Disciplina(String nome, String areaCientifica, int ects, Professor responsavel) {
		super();
		this.nome = nome;
		this.areaCientifica = areaCientifica;
		this.ects = ects;
		this.responsavel = responsavel;
		this.alunos = new ArrayList<>();
	}
	
	public boolean addAluno(Estudante est) {
		if(alunos.contains(est))
			return false;
		return alunos.add(est);
	}
	
	public boolean delAluno(int nMec) {
		for(Estudante estudante : getAlunos()) {
			if(estudante.nMec() == nMec)
				return alunos.remove(estudante);
		}
		return false;
	}
	
	public boolean alunoInscrito(int nMec) {
		for(Estudante estudante : getAlunos()) {
			if(estudante.nMec() == nMec)
				return true;
		}
		return false;
	}
	
	public int numAlunos() {
		return alunos.size();
	}
	
	@Override
	public String toString() {
		return String.format("Disciplina: %s (%d ECTS) da Area de %s\n"
							+"Responsavel: %s\n"
							+ "Existem %d alunos inscritos",nome,ects,areaCientifica,responsavel,numAlunos());
	}
	
	public Estudante[] getAlunos() {
		return alunos.toArray(new Estudante[0]);
	}
	
	public Estudante[] getAlunos(String tipo) {
		List<Estudante> tmpAlunos = new ArrayList<>();
		for(Estudante estudante : getAlunos()) {
			if(estudante.getClass().toString().contains(tipo)) {
				tmpAlunos.add(estudante);
			}
		}
		return tmpAlunos.toArray(new Estudante[0]);
	}
	
}
