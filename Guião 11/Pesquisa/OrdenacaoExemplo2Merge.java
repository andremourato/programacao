import java.util.*;
import java.io.*;

public class OrdenacaoExemplo2Merge {
    public static void main(String[] args) throws IOException{
        Scanner kb = new Scanner(System.in);
// testa o merge sort
int[] um   ={2,3,9,13,33};
int[] dois ={5,10,11,22,25};
int[] r = new int[10];
merge(um,dois,r);
System.out.println(Arrays.toString(r));
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
        if(p != -1) {
            System.out.println("Exist in position " + p);
        } else{
            System.out.println("Do not exist!");
        }


    }

    public static int sequentialSearch(int a[], int n) {
        int pos = -1;

        for(int i = 0 ; i < a.length ; i++) {
            if(a[i] == n) {
                pos = i;
                break;
            }
        }
        return pos;
    }

    public static void sequentialSort(int a[]) {
        for(int i = 0 ; i < a.length -1 ; i++) {
            for(int j = i+1 ; j < a.length ; j++) {
                if(a[i] < a[j]) {
                    swap(a, i, j);
                }
            }
        }
    }

    public static void bubbleSort(int a[]) {
        int tmp, t = 0;
        do {
            t = 0;
            for(int i = 0 ; i <= a.length - 2; i++) {
                if(a[i] > a[i+1]) {
                    swap(a, i, i+1);
                    t++;
                }
            }
        } while(t != 0);
    }

    public static void swap(int a[], int i, int j) {
        int tmp;
        tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void printArray(int a[]) {
        for(int i = 0 ; i < a.length ; i++) {
            System.out.printf("%d\n", a[i]);
        }
    }

    public static void readArrayFromFile(int a[], String name)throws IOException{
        File f = new File(name);
        Scanner sc = new Scanner(f);
        for(int i = 0 ; i < a.length ; i++) {
            a[i] = sc.nextInt();
        }
    }
    public  static void merge(int[] primeiro, int[] segundo, int [] resultado) {
        // Merge 2 arrays no array resultado
        // Próximo elemento a considerar no primeiro array
        int iprimeiro = 0;
        // Próximo elemento a considerar no segundo array
        int isegundo = 0;

        // Próximo elemento livre no array resultado
        int j = 0;
        // Enquanto o iprimeiro ou o isegundo não chegar ao fim, copia
        // o elemento mais pequeno para o resultado.
        while (iprimeiro < primeiro.length && isegundo < segundo.length) {
            if (primeiro[iprimeiro] < segundo[isegundo]) {
                resultado[j] = primeiro[iprimeiro];
                iprimeiro++;
            } else {
                resultado[j] = segundo[isegundo];
                isegundo++;
            }
            j++;
        }
        // copia para resultado o que restou de primeiro ou segundo
        System.arraycopy(primeiro, iprimeiro, resultado, j, primeiro.length - iprimeiro);
        System.arraycopy(segundo, isegundo, resultado, j, segundo.length - isegundo);
    }
    public static int fileSize(String name)throws IOException{

        File f = new File(name);
        Scanner sc = new Scanner(f);
        int n = 0;
        while(sc.hasNextInt()) {
            n++;
            sc.nextInt();
        }
        sc.close();

        return n;
    }
}
