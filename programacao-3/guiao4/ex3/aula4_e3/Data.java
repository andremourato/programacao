package aula4_e3;
import java.util.Date;
import java.text.*;

public class Data {
	private final int dia;
	private final int mes;
	private final int ano;
	
	public Data(int d, int m, int a){
		if(!isValidDate(a,m,d)) throw new IllegalArgumentException();
		dia = d;
		mes = m;
		ano = a;
	}
	
	public int dia(){ return dia; }
	public int mes(){ return mes; }
	public int ano(){ return ano; }
	public String toString(){
		return String.format("%02d-%02d-%04d", dia, mes, ano);
	}
	
	//Checks if a given date is valid
	private static boolean isValidDate(int ano, int mes, int dia){
		Date date = null;
		String inputDate = dia+"-"+mes+"-"+ano;
		try {
			DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			formatter.setLenient(false);
			date = formatter.parse(inputDate);
		} catch (ParseException e) {
			return false;
		}
		return true;
	}
	
}

