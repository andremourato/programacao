package aula13.ex1_parte2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TestProgram {
	
	public static void main(String[] args) {
		Cidade cid1 = new Cidade("Szohod", 31212);
		Cidade cid2 = new Cidade("Wadesdah", 23423);
		Vila cid3 = new Vila("BedRock", 23423);
		Estado est1 = new Estado("North Borduria", 223133, cid1);
		Estado est2 = new Estado("South Borduria", 84321, cid2);
		//Estado est3 = new Estado("California",1000000,cid3); //Erro de compilação
		//Pais p1 = new Pais("Borduria", est1.getCapital()); //Erro de compilação
		/* Estes 2 erros de compilação são propositados para responder à alinea d) do ex1 */
		Pais p1 = new Pais("Borduria", (Cidade)est1.getCapital());
		Pais p2 = new Pais("Khemed", cid2);
		Pais p3 = new Pais("Aurelia");
		Pais p4 = new Pais("Atlantis");
		p1.addRegiao(est1);
		p1.addRegiao(est2);
		p2.addRegiao(new Provincia("Afrinia", 232475, "Aluko Pono"));
		p2.addRegiao(new Provincia("Eriador", 100000, "Dumpgase Liru"));
		p2.addRegiao(new Provincia("Laurania", 30000, "Mukabamba Dabba"));
		List<Pais> org = new ArrayList<Pais>();
		org.add(p1);
		org.add(p2);
		org.add(p3);
		org.add(p4);
		System.out.println("----Iterar sobre o conjunto");
		Iterator<Pais> itr = org.iterator();
		while (itr.hasNext())
			System.out.println(itr.next());
		System.out.println("-------Iterar sobre o conjunto - For each (java 8)");
		for (Pais pais: org)
			System.out.println(pais);
		System.out.println("-------Iterar sobre o conjunto - STREAM API ;)");
		org.stream().forEach(System.out::println);
		
		//All elements must be different
		System.out.println("------- Comparing paises -------");
		Set<Pais> paises = new TreeSet<>();
		paises.add(p1);
		paises.add(p2);
		paises.add(p1);
		paises.add(p1);
		paises.add(p1);
		paises.add(p3);
		paises.add(p4);
		paises.forEach(System.out::println);
		
		System.out.println("------- Testing hashcode -------");
		paises = new HashSet<>();
		paises.add(p1);
		paises.add(p2);
		paises.add(p1);
		paises.add(p1);
		paises.add(p1);
		paises.add(p3);
		paises.add(p4);
		paises.forEach(System.out::println);
	}
}
