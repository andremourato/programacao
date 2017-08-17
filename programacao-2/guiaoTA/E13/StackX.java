import java.util.ArrayList;
import java.util.List;
/**
 * Uma estrutura de dados de tipo pilha, mas com os métodos alternativos:
 * - popN(n): retira os n elementos de topo da pilha
 * - topMatches(seqChars): verifica se os últimos caracteres na pilha
 *                         coincidem com seqChars
 * - toString(): devolve uma String com todos os caracteres contidos
 *               na pilha (desde o mais antigo até ao mais recente)
 */

public class StackX{
	//Como não se pode usar as classes do p2utils recorri à 
	//ArrayList original do Java :P
	//Para mais informações sobre a LinkedList do Java consultem o site da Oracle

	List<Character> list = new ArrayList<>(); //List of characters
	public void push(char e){
		list.add(e);
	}

	public void popN(int n){
		while(n-- > 0){
			list.remove(size()-1);
		}
	}
	
	public boolean topMatches(String seq){
		if(seq.length()>size()) //To prevent StringIndexOutOfBounds
			return false;
		int j = size()-1;
		for(int i = seq.length()-1; i >= 0; i--){
			if(seq.charAt(i) != list.get(j--))
				return false;
		}
		return true;
	}
	
	public int size(){
		return list.size();
	}
	
	public String toString(){
		String str = "";
		for(int i = 0; i < size(); i++){
			str += list.get(i);
		}
		return str;
	}
	
	public char top(){
		return list.get(size()-1);
	}
}

