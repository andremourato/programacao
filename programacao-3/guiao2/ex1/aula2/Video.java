package aula2;

public class Video {
	
	static int currentID = 0;
	private final int id;
	private final String age;
	private final String title;
	private final String category;
	private boolean available;
	private int ratingTotal;
	private int ratingAverage; //Rating (1-10)
	private int numClients;
	
	public Video(String title, String age, String category) {
		if(!validCategory(category)||!validAge(age)) throw new IllegalArgumentException();
		this.id = currentID++;
		this.age = age;
		this.title = title;
		this.category = category;
		this.available = true;
		this.numClients = 0;
		this.ratingTotal = 0;
		this.ratingAverage = 0;
	}

	public int id() { return id; }
	public int rating() { return ratingAverage; }
	public String age() { return age; }
	public String title() { return title; }
	public String category() { return category; }
	
	public String toString() { return toString(" | "); }
	public String toString(String mid) { return title + mid + ratingAverage + mid + id + mid + String.format("%1$"+8+"s", category) + mid + age; }
	
	public void lendVideo() { 
		available = false;
		numClients++;
	}
	public void returnVideo(int r) { 
		available = true;
		addRating(r);
	}
	public boolean isAvailable() { return available; }
	
	private void addRating(int r) {
		ratingTotal += r;
		ratingAverage = Math.min(Math.max((int)Math.round((double)ratingTotal/(double)numClients), 0), 10);
	}
	
	private static boolean validCategory(String cat) {
		return cat.equals("Action") || cat.equals("Comedy") || cat.equals("Children") || cat.equals("Drama");
	}
	private static boolean validAge(String ageRating) {
		return ageRating.equals("ALL") || ageRating.equals("M6") || ageRating.equals("M12") || ageRating.equals("M16") || ageRating.equals("M18");
	}
	
}
