import java.util.*;

public class Data {
	
	private int day;
	private int month;
	private int year;
	
	Data(){ //sets the date to the current day in case no arguments are given
		Calendar today = Calendar.getInstance();
		this.year = today.get(Calendar.YEAR);
		this.month = today.get(Calendar.MONTH)+1;
		this.day = today.get(Calendar.DAY_OF_MONTH);
		
	}
	
	Data(int year, int month, int day){ //sets the date to a given date
		this.year = year;
		this.month = month;
		this.day = day;
		
	}
	
	public int year(){
		return year;
	}
	
	public int month(){
		return month;
	}
	
	public String nameOfMonth(){ //takes an index and returns the nameo of the corresponding month
		if(month==1) return "Janeiro";
		else if(month==2) return "Fevereiro";
		else if(month==3) return "Março";
		else if(month==4) return "Abril";
		else if(month==5) return "Maio";
		else if(month==6) return "Junho";
		else if(month==7) return "Julho";
		else if(month==8) return "Agosto";
		else if(month==9) return "Setembro";
		else if(month==10) return "Outubro";
		else if(month==11) return "Novembro";
		else if(month==12) return "Dezembro";
		else return "Mês inválido";
	}
	
	public void printDate(){ //prints the date on the screen
		System.out.printf("Data: "+fullDate()+"\n");
	}
	
	public String fullDate(){ //returns the full date
		return day+" de "+nameOfMonth()+" de "+year;
	}
	
	public void vaiParaAmanha(){ //moves to the the following day
		day++;
		if(day > numDays(year,month)){
			month++;
			day = 1;
			if(month > 12){
				month = 1;
				year++;
			}
		}
	}
	
	public void vaiParaOntem(){ //moves to the previous day
		day--;
		if(day < 1){
			month--;
			day = numDays(year, month);
			if(month < 1){
				year--;
				month = 12;
			}
		}
	}
	
	public int day(){
		return day;
	}
	
	public String formatDate(){ //return the date in numbers
		return day+"-"+month+"-"+year;
	}
	
	public static boolean isLeap(int year){ //verifies if it's a leap year or not
		if(year%4==0){
			if(year%100==0){
				if(year%400==0){
					return true;
				}else return false;
			}else return true;
		}else return false;
	}
	
	public static int numDays(int year, int month){ //returns the numbers of days that the current month has
		if(month==2){
			if(isLeap(year)) return 29;
			else return 28;  
		}else if(month%2!=0)return 31;// if the month is odd
		else return 30;
	}
	
	public static boolean isValid(int year, int month, int day){ //checks if the current date is vaalid or not
		if(year >= 0){ //if it's a valid year
			if(month > 0 && month < 13){ //if it's a valid month
				if(day <= numDays(year, month) && day > 0) return true; //and it's a valid number of days, then return true
				else return false;
			}else return false;
		}else return false;
	}
}
