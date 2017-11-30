package aula10.ex1;
import java.util.Iterator;
import java.util.List;

public abstract class TestGeneric {
	
	public static void main(String[] args) {
		
		VectorGeneric<Pessoa> vp = new VectorGeneric<Pessoa>();
		for (int i=0; i<10; i++)
			vp.addElem(new Pessoa("Bebé no Vector "+i,
			1000+i, Data.today()));
		
		Iterator<Pessoa> vec = vp.iterator();
		
		printSet(vp.iterator());
		
		ListaGeneric<Pessoa> lp = new ListaGeneric<Pessoa>();
		while ( vec.hasNext() )
			lp.addElem( vec.next() );
		
		Iterator<Pessoa> lista = lp.iterator();
		while ( lista.hasNext() )
			System.out.println( lista.next() );
		
		ListaGeneric<Figura> figList = new ListaGeneric<Figura>();
		figList.addElem(new Circulo (1,3, 1));
		figList.addElem(new Quadrado(3,4, 2));

		figList.addElem(new Rectangulo(1,2, 2,5));
		
		printSet(figList.iterator());
		
		System.out.println("Soma da Area de Lista de Figuras: " + sumArea(figList));
		
		// Partindo do principio que Quadrado extends Rectangulo:
		ListaGeneric<Rectangulo> quadList = new ListaGeneric<Rectangulo>();
		quadList.addElem(new Quadrado(3,4, 2));
		quadList.addElem(new Rectangulo(1,2, 2,5));
		System.out.println("Soma da Area de Lista de Quadrados: " + sumArea(quadList));
		
		
		//My tests
		//Test with iterator
		System.out.println("-------------- Teste VectorPessoas --------------");
		vp = new VectorGeneric<>();

		Pessoa p1 = new Pessoa("Joaquim",new Data(1,6,1998));
		Pessoa p2 = new Pessoa("Andre",new Data(5,2,1997));
		Pessoa p3 = new Pessoa("Maria", new Data(8,6,1999));
		Pessoa p4 = new Pessoa("Isabel", new Data(3,10,1998));
		Pessoa p5 = new Pessoa("Jose", new Data(3,10,1998));
		Pessoa dummy = new Pessoa("Dummy", new Data(6,6,1944));
		
		vp = new VectorGeneric<Pessoa>();
		vp.addElem(p1);
		vp.addElem(p2);
		vp.addElem(p3);
		vp.addElem(p4);
		vp.addElem(p5);
		System.out.println(vp.addElem(dummy) ? "Added dummy!" : "CANNOT ADD ELEMENT!");
		System.out.println(vp.removeElem(dummy) ? "Removed dummy!" : "CANNOT REMOVE ELEMENT!");
		
		System.out.println("\nPrinting Vector...\n");
		//This for each is possible because VectorGeneric implements Iterable
		for(Pessoa p : vp) {
			System.out.println(p);
		}
		System.out.println("\nRemoving elements from the vector...\n");
		if(vp.removeElem(p1)) System.out.println("Removed "+p1);
		if(vp.removeElem(p2)) System.out.println("Removed "+p2);
		if(vp.removeElem(p3)) System.out.println("Removed "+p3);
		if(vp.removeElem(p4)) System.out.println("Removed "+p4);
		if(vp.removeElem(p5)) System.out.println("Removed "+p5);
		
		System.out.println("\nCurrent vector size: "+vp.totalElem());
		
		System.out.println("\n-------------- Teste ListaPessoas --------------");
		lp = new ListaGeneric<>();
		
		lp = new ListaGeneric<>();
		lp.addElem(p1);
		lp.addElem(p2);
		lp.addElem(p3);
		lp.addElem(p4);
		lp.addElem(p5);
		
		Iterator it = lp.iterator();
		
		System.out.println("\nPrinting List...\n");
		//This for each is possible because ListaGeneric implements Iterable
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println("\nRemoving elements from the list...\n");
		if(lp.removeElem(p1)) System.out.println("Removed "+p1);
		if(lp.removeElem(p2)) System.out.println("Removed "+p2);
		if(lp.removeElem(p3)) System.out.println("Removed "+p3);
		if(lp.removeElem(p4)) System.out.println("Removed "+p4);
		if(lp.removeElem(p5)) System.out.println("Removed "+p5);

		System.out.println("\nCurrent list size: "+lp.totalElem());
		
		System.out.println("\n-------------- Fim dos testes --------------");
	}
	
	static double sumArea(ListaGeneric<? extends Figura> list) {
		
		double total = 0;
		Iterator it = list.iterator();
		while(it.hasNext())
			total += ((Figura)it.next()).area();
		return total;
	}
	
	static void printSet(Iterator iterator) {
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
	}
}