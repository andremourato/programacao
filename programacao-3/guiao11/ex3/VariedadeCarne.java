package aula11.ex3;

public enum VariedadeCarne {
	vaca(0),
	porco(1),
	peru(2),
	frango(3),
	outra(4);
	
	private int index;
	
	private VariedadeCarne(int i) {
		index = i;
	}
	
	public int getIndex() {
		return index;
	}
	
	public static VariedadeCarne getVar(int n) {
		VariedadeCarne var = null;
		for(VariedadeCarne v : VariedadeCarne.values()) {
			if(v.getIndex() == n) return v;
		}
		return var;
	}
}
