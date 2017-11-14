package aula8.ex3;

public class Question {
	
	private String imageName; //the name of the image file
	private String question; //The question itself
	private String[] options;
	private int difficulty;
	
	public Question(String imageName, String question, String[] options, int difficulty) {
		this.imageName = imageName;
		this.question = question;
		this.options = options;
		this.difficulty = difficulty;
	}
	
	public String getImageName() {
		return imageName;
	}

	public String getQuestion() {
		return question;
	}

	public String[] getOptions() {
		return options;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public String solution() {
		return options[0];
	}
	
	public String getDifficultyString() {
		return String.valueOf(difficulty);
	}
	
	@Override
	public String toString() {
		return question+": "+options[0]+" /Image: "+imageName+" /Dif: "+difficulty;
	}
	
	
	
}
