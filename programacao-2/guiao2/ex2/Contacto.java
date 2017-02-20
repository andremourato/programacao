public class Contacto{
	
	Contacto(String nome, String telefone, String eMail){ //caso contenha email
		this.nome = nome;
		this.telefone = telefone;
		this.eMail = eMail;
		
	}
	
	Contacto(String nome, String telefone){ //caso nao contenha email
		this.nome = nome;
		this.telefone = telefone;
		
	}
	
	String eMail(){
		return eMail;
	}
	
	String telefone(){
		return telefone;
	}
	
	String nome(){
		return nome;
	}
	
	private String eMail;
	private String telefone;
	private String nome;
	
}

