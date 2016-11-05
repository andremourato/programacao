import java.util.*;
public class hhmmss {
	
	public static void main (String args[]) {
		
		Scanner sc = new Scanner(System.in);
		int h, hr, m, mr, so, si;//horas, horas(resto), minutos, minutos(resto), segundosoutput, segundosinput
		System.out.print("Tempo em segundos: ");
		si = sc.nextInt();
		h = si/3600;// Valor das horas
		hr = si%3600;
		m = hr/60;// Valor do minutos
		mr = hr%60;
		so = mr%60;
		System.out.println("Tempo em hh:mm:ss: " + String.format("%02d", h) + ":" + String.format("%02d", m) + ":" + String.format("%02d", so));
		
	}
}

