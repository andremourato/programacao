package aula6.ex1;

public enum TipoPeixe {
	congelado(0),
	fresco(1);
	
	private int index;
	
	private TipoPeixe(int i) {
		index = i;
	}
	
	public int getIndex() {
		return index;
	}
	
	public static TipoPeixe getTipo(int n) {
		TipoPeixe var = null;
		for(TipoPeixe v : TipoPeixe.values()) {
			if(v.getIndex() == n) return v;
		}
		return var;
	}
}
