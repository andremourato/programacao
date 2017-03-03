import java.util.*;

public class Data {
	
	private int days = 0;
	private static int numDatas = 0;
	
	public Data(){ //sets the date to the current day in case no arguments are given
		Calendar today = Calendar.getInstance();
		days = convertToDays(today.get(Calendar.YEAR),today.get(Calendar.MONTH)+1,today.get(Calendar.DAY_OF_MONTH));
		numDatas++;
	}
	
	public Data(int year, int month, int day){ //sets the date to a given date
		days = convertToDays(year, month, day);
		numDatas++;
	}
	
	public String nameOfMonth(int month){ //takes an index and returns the name of the corresponding month
		
		if     (month==1)  return "Janeiro";
		else if(month==2)  return "Fevereiro";
		else if(month==3)  return "Março";
		else if(month==4)  return "Abril";
		else if(month==5)  return "Maio";
		else if(month==6)  return "Junho";
		else if(month==7)  return "Julho";
		else if(month==8)  return "Agosto";
		else if(month==9)  return "Setembro";
		else if(month==10) return "Outubro";
		else if(month==11) return "Novembro";
		else if(month==12) return "Dezembro";
		else               return "Mês inválido";
	}
	
	public void printData(){
		int[] date = convertFromDays();
		System.out.printf("\nData: %02d-%02d-%04d\n",date[0],date[1],date[2]);
	}
	
	public void printDateOnly(){
		int[] date = convertFromDays();
		System.out.printf("%02d-%02d-%04d",date[0],date[1],date[2]);
	}
	
	public void printFullData(){ //prints the date on the screen
		int[] date = convertFromDays();
		System.out.printf("Data: %d de %s de %d\n", date[0], nameOfMonth(date[1]), date[2]);
	}
	
	public void vaiParaOntem(){ //moves to the previous day
		days--;
	}
	
	public void vaiParaAmanha(){ //moves to the the following day
		days++;
	}
	
	public boolean isLeap(int year){ //verifies if it's a leap year or not
		if(year%4==0){
			if(year%100==0){
				if(year%400==0) return true;
				else return false;
			}else return true;
		}else return false;
	}
	
	public int days(){
		return days;
	}
	
	public int numDays(int year, int month){ //returns the numbers of days that the current month has
		
		if(month == 1)       return 31; //janeiro
		else if(month == 2){ //fevereiro
			if(isLeap(year)) return 29;
			else             return 28;
		}
		else if(month == 3)  return 31;//março
		else if(month == 4)  return 30;//abril
		else if(month == 5)  return 31;//maio
		else if(month == 6)  return 30;//junho
		else if(month == 7)  return 31;//julho
		else if(month == 8)  return 31;//agosto
		else if(month == 9)  return 30;//setembro
		else if(month == 10) return 31;//outubro
		else if(month == 11) return 30;//novembro
		else if(month == 12) return 31;//dezembro
		else return -1; //mes invalido
	}
	
	public void printIsValid(){
		if(isValid()) System.out.println("Data válida!\n");
		else System.out.println("A data não é válida!\n");
	}
	
	public int daysBetween(Data date){
		return date.days()-days;
	}
	
	public boolean igualA( Data date ){
		
		int[] dataAtual = convertFromDays();
		int[] dataAnterior = convertFromDays(date.days());
		
		if(dataAtual[2] != dataAnterior[2]) return false;
		else if(dataAtual[1] != dataAnterior[1]) return false;
		else if(dataAtual[0] != dataAnterior[0]) return false;
		else return true;
	}
	
	public boolean maiorDoQue( Data date ){
		
		int[] dataAtual = convertFromDays();
		int[] dataAnterior = convertFromDays(date.days());
		
		if(dataAtual[2] < dataAnterior[2]) return false;
		else if(dataAtual[2] > dataAnterior[2]) return true;
		else { //se o ano for igual
			if(dataAtual[1] < dataAnterior[1]) return false;
			else if(dataAtual[1] > dataAnterior[1]) return true;
			else{ //se o mes for igual
				if(dataAtual[0] < dataAnterior[0]) return false;
				else if(dataAtual[0] > dataAnterior[0]) return true;
				else return false; //se a data for igual
			}
		}
	}
	
	public boolean menorDoQue( Data date ){
		
		int[] dataAtual = convertFromDays();
		int[] dataAnterior = convertFromDays(date.days());
		
		if(dataAtual[2] < dataAnterior[2]) return true;
		else if(dataAtual[2] > dataAnterior[2]) return false;
		else{ //se o ano for igual
			if(dataAtual[1] < dataAnterior[1]) return true;
			else if(dataAtual[1] > dataAnterior[1]) return false;
			else{ //se o mes for igual
				if(dataAtual[0] < dataAnterior[0]) return true;
				else if(dataAtual[0] > dataAnterior[0]) return false;
				else return false; //se as datas forem iguais
			}
		}
	}
	
	private boolean isValid(){ //checks if the current date is vaalid or not
	
		int[] date = convertFromDays();
		int day = date[0];
		int month = date[1];
		int year = date[2];
		if(year >= 2000){ //if it's a valid year
			if(month > 0 && month < 13){ //if it's a valid month
				if(day <= numDays(year, month) && day > 0) return true; //and it's a valid number of days, then return true
				else return false;
			}else return false;
		}else return false;
	}
	
	private int convertToDays(int year, int month, int day){ //número de dias a partir de 1-1-2000 até à data especificada
		
		int numDays = 0;
		for(int i = 2000; i < year; i++){
			if(isLeap(i))numDays += 366;
			else numDays += 365;
		}
		for(int i = 1; i < month; i++){
			numDays += numDays(year, i);
		}
		numDays += day-1;
		return numDays;
	}
	
	private int[] convertFromDays(){
		int currentDays = this.days;
		int[] date = new int[3];
		date[0] = 1;
		date[1] = 1;
		date[2] = 2000; //iniciamos a data a 1 de janeiro de 2000
		
		do{
			currentDays--;
			date = moveToTomorrow(date[0], date[1], date[2]);
			
		}while(currentDays > 0);
		return date;
		
	}
	
	private int[] convertFromDays(int numDays){
		
		int[] date = new int[3];
		date[0] = 1;
		date[1] = 1;
		date[2] = 2000; //iniciamos a data a 1 de janeiro de 2000
		
		do{
			numDays--;
			date = moveToTomorrow(date[0], date[1], date[2]);
			
		}while(numDays > 0);
		return date;
		
	}
	
	private int[] moveToTomorrow(int day, int month, int year){ //exclusivamente usado para determinar a data atual
		
		day++;
		if(day > numDays(year,month)){ //se mudar de mes
			month++;
			day = 1;
			if(month > 12){ //se mudar de ano
				month = 1;
				year++;
			}
		}
		int[] date = new int[3];
		date[0] = day;
		date[1] = month;
		date[2] = year;
		return date;
	}
	
}
