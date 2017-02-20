package pt.ua.prog2;

public class Contacto{

    public Contacto(String nome, String telefone, String eMail){ //caso contenha email
        this.nome = nome;
        this.telefone = telefone;
        this.eMail = eMail;

    }

    public Contacto(String nome, String telefone){ //caso nao contenha email
        this.nome = nome;
        this.telefone = telefone;

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

    private String eMail;
    private String telefone;
    private String nome;

}

