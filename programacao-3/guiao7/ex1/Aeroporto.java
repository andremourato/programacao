package aula7.ex1;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;


public class Aeroporto {
	
	private List<Voo> voos = new ArrayList<>();
	private HashMap<String,Companhia> dict = new HashMap<>(); //(Sigla, Companhia)
	
	public Aeroporto(String companhiasFile, String infoFile) throws IOException {
		List<String> infoCompanhias = Files.readAllLines(Paths.get(companhiasFile));
		List<String> info = Files.readAllLines(Paths.get(infoFile));
		
		//Adiciona todas as companhias aereas
		for(int i = 0; i < infoCompanhias.size(); i++) {
			if(i == 0) continue;
			String[] lineSplit = infoCompanhias.get(i).split("\t");
			dict.put(lineSplit[0], new Companhia(lineSplit[0],lineSplit[1]));
		}
		
		//Adiciona todos os voos
		for(int i = 0; i < info.size(); i++) {
			if(i == 0) continue;
			String[] lineSplit = info.get(i).split("\t");
			Companhia company = dict.get(lineSplit[1].substring(0,2));
			//Ignores invalid inputs
			if(company == null) continue;
			Hora delay = lineSplit.length < 4 ? new Hora() : new Hora(lineSplit[3]);
			addVoo(new Voo(new Hora(lineSplit[0]),delay,lineSplit[1],lineSplit[2],company));
		}
		
	}
	
	public void printAverageDelay() {
		HashMap<Companhia,Integer> tabelaAtrasos = new HashMap<>(); //(Companhia,NumMinutosDeAtraso)
		System.out.println("Companhia\t\tAtraso");
		for(Companhia companhia : dict.values().toArray(new Companhia[0])) {
			int sum = 0;
			int count = 0;
			for(Voo voo : voos.toArray(new Voo[0])) {
				if(voo.getCompanhia() == companhia) {
					sum += voo.delayToMinutes();
					count++;
				}
			}
			tabelaAtrasos.put(companhia,new Integer((int)((float)sum/(float)count)));
		}
		
		Companhia[] sortedCompanhias = tabelaAtrasos.keySet().toArray(new Companhia[0]);
		Arrays.sort(sortedCompanhias, new Comparator<Companhia>() {

			@Override
			public int compare(Companhia o1, Companhia o2) {
				return tabelaAtrasos.get(o1)-tabelaAtrasos.get(o2);
			}
			
		});
		for(Companhia companhia : sortedCompanhias) {
			System.out.printf(String.format("%-18s\t%s\n", companhia, new Hora(tabelaAtrasos.get(companhia))));
		}
		
	}
	
	public void printToScreen() {
		System.out.println("Hora\tVoo\t\tCompanhia\t\tOrigem\t\t\tAtraso\tObs");
		for(Voo voo : voos.toArray(new Voo[0])) {
			System.out.println(voo);
		}
	}
	
	public String fligthsToString() {
		String str = "";
		for(Voo voo : voos.toArray(new Voo[0])) {
			str += voo + "\n";
		}
		return str;
	}
	
	public boolean writeToFile(String filename) throws IOException {
		Files.write(Paths.get(filename), fligthsToString().getBytes());
		return true;
	}
	
	public boolean addVoo(Voo voo) {
		return voos.add(voo);
	}

	public boolean writoToBinaryFile(String path) throws IOException {
		RandomAccessFile file = new RandomAccessFile(path, "rw");
		file.write(fligthsToString().getBytes());
		file.close();
		return true;
	}
	
	public boolean readFromBinaryPrint(String path) throws IOException {
		RandomAccessFile file = new RandomAccessFile(path, "rw");
		byte[] info = new byte[(int)file.length()];
		file.readFully(info);
		file.close();
		System.out.println(new String(info));
		return true;
	}
	
}
