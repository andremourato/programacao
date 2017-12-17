package aula13.ex3;

import java.util.LinkedList;
import java.util.List;

public class TicketManager {
	
	private int INDEX = 0;
	private String[] workers;
	
	public TicketManager(String[] workers) {
		this.workers = workers;
	}
	
	/* Gives out N tickets in rotating order */
	public List<String> giveTickets(int N) {
		List<String> awardedWorkers = new LinkedList<>();
		for(int i = 1; i <= N; i++) awardedWorkers.add(giveTicket());
		return awardedWorkers;
	}

	private String giveTicket() {
		INDEX = (INDEX + 1) % workers.length;
		return workers[INDEX];
	}
}
