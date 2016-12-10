import java.util.Scanner;
import java.io.*;

public class OrdenacaoExemplo1{
	public static void main(String[] args) throws IOException{
		Scanner kb = new Scanner(System.in);

    String name = new String();
    System.out.print("File name: ");
    name = kb.nextLine();
    int n = fileSize(name);
    System.out.println("The file has " + n + " numbers");
    int a[] = new int[n];
    readArrayFromFile(a, name);
    bubbleSort(a);
    System.out.println("Ascending order: ");
    printArray(a);
    sequentialSort(a);
    System.out.println("Descending order: ");
    printArray(a);
    System.out.print("Value to search for: ");
    int valor = kb.nextInt();
    int p = sequentialSearch(a, valor);
    if(p != -1){
      System.out.println("Exist in position " + p);
    }
    else{
      System.out.println("Do not exist!");
    }

  }

  public static int sequentialSearch(int a[], int n){
    int pos = -1;

    for(int i = 0 ; i < a.length ; i++){
      if(a[i] == n){
        pos = i;

      }
    }
    return pos;
  }

  public static void sequentialSort(int a[]){
    for(int i = 0 ; i < a.length -1 ; i++){
      for(int j = i+1 ; j < a.length ; j++){
        if(a[i] < a[j]){
          swap(a, i, j);
        }
      }
    }
  }

  public static void bubbleSort(int a[]){
    int t = 0;
    do{
      t = 0;
      for(int i = 0 ; i <= a.length - 2; i++){
        if(a[i] > a[i+1]){
          swap(a, i, i+1);
          t++;
        }
      }
    }while(t != 0);
  }

  public static void swap(int a[], int i, int j){
    int tmp;
    tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
  }

  public static void printArray(int a[]){
    for(int i = 0 ; i < a.length ; i++){
      System.out.printf("%d\n", a[i]);
    }
  }

  public static void readArrayFromFile(int a[], String name)throws IOException{
    File f = new File(name);
    Scanner sc = new Scanner(f);
    for(int i = 0 ; i < a.length ; i++){
      a[i] = sc.nextInt();
    }
  }

  public static int fileSize(String name)throws IOException{

    File f = new File(name);
    Scanner sc = new Scanner(f);
    int n = 0;
    while(sc.hasNextInt()){
      n++;
      sc.nextInt();
    }
    sc.close();

    return n;
  }
}
