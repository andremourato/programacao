package aula11.ex2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TestMethods {
	
	public static void main(String[] args) throws ClassNotFoundException {
		List<Figura> list = new ArrayList<>();
		/*list.add(new Quadrado(2));
		list.add(new Quadrado(3));
		list.add(new Quadrado(9));	//Maior figura
		list.add(new Rectangulo(1,81));
		list.add(new Rectangulo(5,1));*/
		list.add(new Quadrado(1));
		list.add(new Quadrado(2));
		list.add(new Quadrado(2));	//Maior figura
		list.add(new Rectangulo(1,1));
		list.add(new Rectangulo(1,1));
		System.out.println("Maior figura: "+maiorFiguraJ7(list));
		System.out.println("Maior perimetro: "+maiorPerimetroJ7(list));
		System.out.println("Soma total das areas: "+areaTotalJ8(list));
		System.out.println("Soma total das areas dos quadrados: "+areaTotalJ8(list,"Quadrado"));
	}
	
	private static Figura maiorFiguraJ7(List<Figura> figs) {
		return (Figura)figs.stream().max(new Comparator<Figura>() {
			@Override
			public int compare(Figura arg0, Figura arg1) {
				return arg0.compareTo(arg1);
			}
		}).get();
	}
	
	private static Figura maiorPerimetroJ7(List<Figura> figs) {
		return (Figura)figs.stream().max(new Comparator<Figura>() {
			@Override
			public int compare(Figura arg0, Figura arg1) {
				double dif = arg0.perimetro()-arg1.perimetro();
				if(dif > 0) return 1;
				else if(dif < 0) return -1;
				else return 0;
			}
		}).get();
	}
	
	private static double areaTotalJ8(List<Figura> figs) {
		return figs.stream().mapToDouble(x -> x.area()).sum();
	}
	
	private static double areaTotalJ8(List<Figura> figs, String subtipoNome) throws ClassNotFoundException {
		return figs.stream()
				.filter(x -> x.getClass().getSimpleName().equals(subtipoNome))
				.mapToDouble(x -> x.area())
				.sum();
	}
	
}
