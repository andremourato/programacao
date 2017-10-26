package aula6.ex2;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ListsProcess {
	
	public static <E> List<E> filter(List<E> list, Predicate<E> condition) {
		List<E> newList = new ArrayList<>();
		for(E element : list) {
			if(condition.test(element))
				newList.add(element);
		}		
		return newList;
	}
	
}