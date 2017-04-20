package p2utils;

public class Pessoa implements Comparable<Pessoa>{
	
	private Data birth;
	private String name;
	
	public Pessoa(Data birth, String name){
		assert birth.dia() >= 1 && birth.dia() <= 31;
		assert birth.mes() >= 1 && birth.mes() <= 12;
		this.birth = birth;
		this.name = name;
	}
	
	public String name(){
		return name;
	}
	
	public Data birth(){
		return birth;
	}
	
	public String toString(){
		return "("+birth.dia()+","+birth.mes()+","+birth.ano()+","+name+")";
	
	}
	
	public int compareTo(Pessoa p){
		if(birth.mes() > p.birth.mes()) return 1;
		else if (birth.mes() < p.birth.mes()) return -1;
		else{
			if(birth.dia() > p.birth.dia()) return 1;
			else if(birth.dia() < p.birth.dia()) return -1;
			else return 0;
		}
		
	}
	
}

