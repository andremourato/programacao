package aula11.ex3;

public class UtilCompare {

	@SuppressWarnings("unchecked")
	public static Comparable findMax(Comparable[] objectArray) {
		int maxIndex = 0;
		for(int i = 1; i < objectArray.length; i++)
			if(objectArray[i] != null && objectArray[i].compareTo(objectArray[maxIndex]) > 0)
				maxIndex = i;

		return objectArray[maxIndex];
	}
	
	@SuppressWarnings("unchecked")
	public static void sortArray(Comparable[] objectArray){
		
		for(int i = objectArray.length-1; i >= 0; i--) {
			for(int j = 0; j < i; j++) {
				if(objectArray[j].compareTo(objectArray[j+1])>0) {
					Comparable tmp = objectArray[j];
					objectArray[j] = objectArray[j+1];
					objectArray[j+1] = tmp;
				}
			}
		}
	}
	
}
