package aula4_e3;
import java.util.*;

public abstract class Utilizador extends Pessoa{
	
	static int NUM_SOCIOS = 1;
	
	private final int numSocio;
	private List<Video> watchedVideos;
	private List<Video> videoHistory;
	
	public Utilizador(String nome, int cc, Data dataNascimento){
		super(nome, cc, dataNascimento);
		this.numSocio = NUM_SOCIOS++;
		watchedVideos = new ArrayList<>();
		videoHistory = new ArrayList<>();
	}
	
	public void lendVideoToUser(Video video) {
		watchedVideos.add(video);
		videoHistory.add(video);
	}
	public void returnVideoFromUser(Video video) { watchedVideos.remove(video); }
	public String nome() { return nome;	}
	public int cc() { return cc; }
	public int numberOfVideosOwned() { return watchedVideos.size(); }
	public int numSocio() { return numSocio; }
	
	@Override
	public String toString() { return toString(" | "); }
	public String toString(String mid) { return nome + mid + cc + mid + super.dataNascimento(); }
	
	public Video[] watchedVideosToArray() { return watchedVideos.toArray(new Video[0]); }
	public Video[] historyVideosToArray() { return videoHistory.toArray(new Video[0]); }
}
