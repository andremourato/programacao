import java.util.Scanner;
public class decisao10 {
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		boolean cr4, cr400;
		int d, m, y, db, da, mb, ma, yb, ya, ab4, ab400;//day, month, year, db=day_before, ma=month_after, yb=year_before
		System.out.printf("Dia: ");
		d = sc.nextInt();
		System.out.print("Mes: ");
		m = sc.nextInt();
		System.out.print("Ano: ");
		y = sc.nextInt();
		ab4 = y%4;
		ab400 = y%400;
		cr4 = ab4==0;
		cr400 = ab400==0;
		if (cr4 || cr400){//É ano bissexto
			switch(m){
				
			case 1:
				if(d==1){
					db = 31;
					da = d+1;
					mb = 12;
					ma = m;
					yb = y-1;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);
				}else if(d==31){
					db = d-1;
					da = 1;
					mb = m;
					ma = m+1;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);	
				}else if(d>31||d<0){
					System.out.print("DATA INVALIDA");
				}else{
					db = d-1;
					da = d+1;
					mb = m;
					ma = m;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);	
				}
				break;
			case 2:
				if(d==1){
					db = 31;
					da = d+1;
					mb = 1;
					ma = m;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);
				}else if(d==29){
					db = d-1;
					da = 1;
					mb = m;
					ma = m+1;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);	
				}else if(d>29||d<0){
					System.out.print("DATA INVALIDA");
				}else{
					db = d-1;
					da = d+1;
					mb = m;
					ma = m;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);	
				}
				break;
			case 3:
				if(d==1){
					db = 29;
					da = d+1;
					mb = 2;
					ma = m;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);
				}else if(d==31){
					db = d-1;
					da = 1;
					mb = m;
					ma = m+1;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);	
				}else if(d>31||d<0){
					System.out.print("DATA INVALIDA");
				}else{
					db = d-1;
					da = d+1;
					mb = m;
					ma = m;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);	
				}
				break;
			case 4:
				if(d==1){
					db = 31;
					da = d+1;
					mb = 3;
					ma = m;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);
				}else if(d==30){
					db = d-1;
					da = 1;
					mb = m;
					ma = m+1;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);	
				}else if(d>30||d<0){
					System.out.print("DATA INVALIDA");
				}else{
					db = d-1;
					da = d+1;
					mb = m;
					ma = m;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);	
				}
				break;
			case 5:
				if(d==1){
					db = 30;
					da = d+1;
					mb = 4;
					ma = m;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);
				}else if(d==31){
					db = d-1;
					da = 1;
					mb = m;
					ma = m+1;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);	
				}else if(d>31||d<0){
					System.out.print("DATA INVALIDA");
				}else{
					db = d-1;
					da = d+1;
					mb = m;
					ma = m;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);	
				}
				break;
			case 6:
				if(d==1){
					db = 31;
					da = d+1;
					mb = 5;
					ma = m;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);
				}else if(d==30){
					db = d-1;
					da = 1;
					mb = m;
					ma = m+1;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);	
				}else if(d>30||d<0){
					System.out.print("DATA INVALIDA");
				}else{
					db = d-1;
					da = d+1;
					mb = m;
					ma = m;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);	
				}
				break;
			case 7:
				if(d==1){
					db = 30;
					da = d+1;
					mb = 6;
					ma = m;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);
				}else if(d==31){
					db = d-1;
					da = 1;
					mb = m;
					ma = m+1;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);	
				}else if(d>31||d<0){
					System.out.print("DATA INVALIDA");
				}else{
					db = d-1;
					da = d+1;
					mb = m;
					ma = m;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);	
				}
				break;
			case 8:
				if(d==1){
					db = 31;
					da = d+1;
					mb = 7;
					ma = m;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);
				}else if(d==31){
					db = d-1;
					da = 1;
					mb = m;
					ma = m+1;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);	
				}else if(d>31||d<0){
					System.out.print("DATA INVALIDA");
				}else{
					db = d-1;
					da = d+1;
					mb = m;
					ma = m;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);	
				}
				break;
			case 9:
				if(d==1){
					db = 31;
					da = d+1;
					mb = 8;
					ma = m;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);
				}else if(d==30){
					db = d-1;
					da = 1;
					mb = m;
					ma = m+1;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);	
				}else if(d>30||d<0){
					System.out.print("DATA INVALIDA");
				}else{
					db = d-1;
					da = d+1;
					mb = m;
					ma = m;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);	
				}
				break;
			case 10:
				if(d==1){
					db = 30;
					da = d+1;
					mb = 9;
					ma = m;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);
				}else if(d==31){
					db = d-1;
					da = 1;
					mb = m;
					ma = m+1;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);	
				}else if(d>31||d<0){
					System.out.print("DATA INVALIDA");
				}else{
					db = d-1;
					da = d+1;
					mb = m;
					ma = m;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);	
				}
				break;
			case 11:
				if(d==1){
					db = 31;
					da = d+1;
					mb = 10;
					ma = m;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);
				}else if(d==30){
					db = d-1;
					da = 1;
					mb = m;
					ma = m+1;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);	
				}else if(d>30||d<0){
					System.out.print("DATA INVALIDA");
				}else{
					db = d-1;
					da = d+1;
					mb = m;
					ma = m;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);	
				}
				break;
			case 12:
				if(d==1){
					db = 30;
					da = d+1;
					mb = 11;
					ma = m;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);
				}else if(d==31){
					db = d-1;
					da = 1;
					mb = m;
					ma = 1;
					yb = y;
					ya = y+1;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);	
				}else if(d>31||d<0){
					System.out.print("DATA INVALIDA");
				}else{
					db = d-1;
					da = d+1;
					mb = m;
					ma = m;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);	
				}
				break;
			}								
		}else{ //Não é bissexto
			switch(m){
				
			case 1:
				if(d==1){
					db = 31;
					da = d+1;
					mb = 12;
					ma = m;
					yb = y-1;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);
				}else if(d==31){
					db = d-1;
					da = 1;
					mb = m;
					ma = m+1;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);	
				}else if(d>31||d<0){
					System.out.print("DATA INVALIDA");
				}else{
					db = d-1;
					da = d+1;
					mb = m;
					ma = m;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);	
				}
				break;
			case 2:
				if(d==1){
					db = 31;
					da = d+1;
					mb = 1;
					ma = m;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);
				}else if(d==28){
					db = d-1;
					da = 1;
					mb = m;
					ma = m+1;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);	
				}else if(d>28||d<0){
					System.out.print("DATA INVALIDA");
				}else{
					db = d-1;
					da = d+1;
					mb = m;
					ma = m;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);	
				}
				break;
			case 3:
				if(d==1){
					db = 30;
					da = d+1;
					mb = 2;
					ma = m;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);
				}else if(d==31){
					db = d-1;
					da = 1;
					mb = m;
					ma = m+1;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);	
				}else if(d>31||d<0){
					System.out.print("DATA INVALIDA");
				}else{
					db = d-1;
					da = d+1;
					mb = m;
					ma = m;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);	
				}
				break;
			case 4:
				if(d==1){
					db = 31;
					da = d+1;
					mb = 3;
					ma = m;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);
				}else if(d==30){
					db = d-1;
					da = 1;
					mb = m;
					ma = m+1;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);	
				}else if(d>30||d<0){
					System.out.print("DATA INVALIDA");
				}else{
					db = d-1;
					da = d+1;
					mb = m;
					ma = m;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);	
				}
				break;
			case 5:
				if(d==1){
					db = 30;
					da = d+1;
					mb = 4;
					ma = m;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);
				}else if(d==31){
					db = d-1;
					da = 1;
					mb = m;
					ma = m+1;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);	
				}else if(d>31||d<0){
					System.out.print("DATA INVALIDA");
				}else{
					db = d-1;
					da = d+1;
					mb = m;
					ma = m;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);	
				}
				break;
			case 6:
				if(d==1){
					db = 31;
					da = d+1;
					mb = 5;
					ma = m;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);
				}else if(d==30){
					db = d-1;
					da = 1;
					mb = m;
					ma = m+1;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);	
				}else if(d>30||d<0){
					System.out.print("DATA INVALIDA");
				}else{
					db = d-1;
					da = d+1;
					mb = m;
					ma = m;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);	
				}
				break;
			case 7:
				if(d==1){
					db = 30;
					da = d+1;
					mb = 6;
					ma = m;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);
				}else if(d==31){
					db = d-1;
					da = 1;
					mb = m;
					ma = m+1;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);	
				}else if(d>31||d<0){
					System.out.print("DATA INVALIDA");
				}else{
					db = d-1;
					da = d+1;
					mb = m;
					ma = m;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);	
				}
				break;
			case 8:
				if(d==1){
					db = 31;
					da = d+1;
					mb = 7;
					ma = m;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);
				}else if(d==31){
					db = d-1;
					da = 1;
					mb = m;
					ma = m+1;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);	
				}else if(d>31||d<0){
					System.out.print("DATA INVALIDA");
				}else{
					db = d-1;
					da = d+1;
					mb = m;
					ma = m;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);	
				}
				break;
			case 9:
				if(d==1){
					db = 31;
					da = d+1;
					mb = 8;
					ma = m;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);
				}else if(d==30){
					db = d-1;
					da = 1;
					mb = m;
					ma = m+1;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);	
				}else if(d>30||d<0){
					System.out.print("DATA INVALIDA");
				}else{
					db = d-1;
					da = d+1;
					mb = m;
					ma = m;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);	
				}
				break;
			case 10:
				if(d==1){
					db = 30;
					da = d+1;
					mb = 9;
					ma = m;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);
				}else if(d==31){
					db = d-1;
					da = 1;
					mb = m;
					ma = m+1;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);	
				}else if(d>31||d<0){
					System.out.print("DATA INVALIDA");
				}else{
					db = d-1;
					da = d+1;
					mb = m;
					ma = m;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);	
				}
				break;
			case 11:
				if(d==1){
					db = 31;
					da = d+1;
					mb = 10;
					ma = m;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);
				}else if(d==30){
					db = d-1;
					da = 1;
					mb = m;
					ma = m+1;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);	
				}else if(d>30||d<0){
					System.out.print("DATA INVALIDA");
				}else{
					db = d-1;
					da = d+1;
					mb = m;
					ma = m;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);	
				}
				break;
			case 12:
				if(d==1){
					db = 30;
					da = d+1;
					mb = 11;
					ma = m;
					yb = y;
					ya = y;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);
				}else if(d==31){
					db = d-1;
					da = 1;
					mb = m;
					ma = 1;
					yb = y;
					ya = y+1;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);	
				}else if(d>31||d<0){
					System.out.print("DATA INVALIDA");
				}else{
					db = d-1;
					da = d+1;
					mb = m;
					ma = m;
					yb = y;
					ya = y+1;
					System.out.println("O dia seguinte e "+da+"-"+ma+"-"+ya);
					System.out.printf("O anterior e "+db+"-"+mb+"-"+yb);	
				}
				break;
			}
		}
	}
}
