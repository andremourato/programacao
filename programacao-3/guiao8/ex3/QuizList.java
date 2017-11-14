package aula8.ex3;

import java.util.ArrayList;
import java.util.HashMap;

public class QuizList {
	
	private HashMap<String,ArrayList<Question>> list = new HashMap<>(); //(KEY=LevelOfDifficulty,VALUE=ArrayOfQuizes)
	private int numQuestions = 0;
	
	public ArrayList<Question>[] lists(){
		return list.values().toArray(new ArrayList[0]);
	}
	
	public String[] keys() {
		return list.keySet().toArray(new String[0]);
	}
	
	public boolean contains(Question question) {
		for(ArrayList<Question> arraylist : lists())
			for(Question q : arraylist)
				if(question == q)
					return true;
		return false;
	}
	
	public ArrayList<Question> get(String key){
		return list.get(key);
	}
	
	public ArrayList<Question> get(int key){
		return list.get(String.valueOf(key));
	}
	
	public void insert(Question question) {
		String level = question.getDifficultyString();
		if(list.containsKey(level)) {
			list.get(level).add(question);
		}else {
			ArrayList<Question> tmp = new ArrayList<>();
			tmp.add(question);
			list.put(level, tmp);
		}
		numQuestions++;
	}
	
	public boolean remove(Question question) {
		for(String key : keys()) {
			ArrayList<Question> arraylist = list.get(key);
			if(arraylist.remove(question)) {
				if(arraylist.size() == 0) list.remove(key);
				numQuestions--;
				return true;
			}
		}
		return false;
	}
	
	public int getCurrentLevel() {
		int min = Integer.MAX_VALUE;
		for(String key : keys()) {
			min = Math.min(Integer.parseInt(key), min);
		}
		return min;
	}
	
	public int numQuestions() {
		return numQuestions;
	}
	
	public int numLevels() {
		return list.size();
	}
}
