package aula12.ex1;

import java.io.Serializable;

public class ClasseTeste extends Figura implements AlimentoVegetariano,Serializable {
	
	public double publicField1;
	public int publicField2;
	public Ponto publicField3;
	public short publicField4;
	private Ponto privateField1;
	private short privateField2;
	private long privateField3;
	
	
	public ClasseTeste(Ponto c) {
		super(c);
		// TODO Auto-generated constructor stub
	}
	public ClasseTeste(int x, int y) {
		this(new Ponto(x,y));
	}
	
	@Override
	public double area() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double perimetro() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void method(int a, int y, double t) {
		
	}
	public double getPublicField1() {
		return publicField1;
	}
	public void setPublicField1(double publicField1) {
		this.publicField1 = publicField1;
	}
	public int getPublicField2() {
		return publicField2;
	}
	public void setPublicField2(int publicField2) {
		this.publicField2 = publicField2;
	}
	public Ponto getPublicField3() {
		return publicField3;
	}
	public void setPublicField3(Ponto publicField3) {
		this.publicField3 = publicField3;
	}
	public Ponto getPrivateField1() {
		return privateField1;
	}
	public void setPrivateField1(Ponto privateField1) {
		this.privateField1 = privateField1;
	}
	public short getPrivateField2() {
		return privateField2;
	}
	public void setPrivateField2(short privateField2) {
		this.privateField2 = privateField2;
	}
	public long getPrivateField3() {
		return privateField3;
	}
	public void setPrivateField3(long privateField3) {
		this.privateField3 = privateField3;
	}

	@Override
	public String toString() {
		return "ClasseTeste";
	}
	
	

}
