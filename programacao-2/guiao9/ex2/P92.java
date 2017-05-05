import static java.lang.System.*;
import java.util.Scanner;

public class P92 {

  public static void main(String[] args) {
    NumberArray na = new NumberArray();
    insertionSort(na.array(), 0, na.length());
    na.print();
  }

  static void insertionSort(int[] a, int start, int end) {
	for(int i = start+1; i < end; i++){
		int j;
		int v = a[i];
		for(j = i-1;j >= start && a[j] > v; j--)
			a[j+1] = a[j];
		a[j+1] = v;
	}

  }

}

