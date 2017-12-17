package aula13.ex3;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class WorkerGifts {
	
	// (Worker, List of Gifts)
	// Workers can have multiple gifts
	private final Map<String, List<String>> workerGifts = new TreeMap<>();

	public void giveGift(String gift, String worker) {
		
		if(workerGifts.containsKey(worker)) {
			workerGifts.get(worker).add(gift);
		}else {
			List<String> newListOfGifts = new LinkedList<>();
			newListOfGifts.add(gift);
			workerGifts.put(worker, newListOfGifts);
		}
		
	}
	
	/*Removes the last gift given to 'worker'
	 * returns true if gift is removed from worker
	 * returns false if worker has 0 gifts
	 */
	public boolean takeBackGift(String worker) {
		if(workerGifts.containsKey(worker)) {
			List<String> listOfGifts = workerGifts.get(worker);
			listOfGifts.remove(listOfGifts.size()-1); //Removes the most recent gift
			if(listOfGifts.size() == 0) workerGifts.remove(worker); //Of the list is empty, removes it
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return workerGifts.keySet().stream()
								   .map(x -> x.concat(" -> ").concat(workerGifts.get(x).toString()))
								   .collect(Collectors.joining("\n"));
	}	
	
}
