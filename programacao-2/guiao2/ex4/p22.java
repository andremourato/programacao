import pt.ua.prog2.*;
import java.util.*;

public class p22
{
	
	public static void main(String[] args){
	
	Scanner read = new Scanner(System.in);
    Contacto[] cl = new Contacto[4];

    for(int i=0;i<4;i++){
		
		System.out.print("Nome: ");
		String nome = read.nextLine();
		System.out.print("Telemovel: ");
		String telemovel = read.nextLine();
		System.out.print("Email: ");
		String email = read.nextLine();
		cl[i] = new Contacto(nome, telemovel, email);
		
	}
    System.out.println("Listagem:");
    for (int i = 0; i < cl.length; i++)
    {
      System.out.println(cl[i].nome() + 
          ": " + cl[i].telefone() + 
          "; " + cl[i].eMail());
    }
    System.out.println("Contactos: "+Contacto.quantidade());
  }
  
}
