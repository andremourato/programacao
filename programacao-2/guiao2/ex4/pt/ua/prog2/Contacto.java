package pt.ua.prog2;

public class Contacto{

    public Contacto(String nome, String telefone, String eMail){
        this.nome = nome;
        this.telefone = telefone;
        this.eMail = eMail;
        verificarContacto(); //verifica se o nome é válido
        quantidade++; //incrementa a variavel que guarda a quantidade de contactos

    }
    
	private void verificarContacto(){
		if(nome.length()==0){ //se o nome estiver vazio
			System.err.println("Contacto invalido!"); //imprime uma mensagem de erro
			System.exit(1); //e termina
		}
	}

	public String eMail(){
        return eMail;
    }

    public String telefone(){
        return telefone;
    }

    public String nome(){
        return nome;
    }
	
	public static int quantidade(){
		return quantidade;
	}
	
	private static int quantidade;
    private String eMail;
    private String telefone;
    private String nome;

}

