package user;
import aula2.*;
import java.util.*;

public class Utilizador {

	protected final String nome;
	protected final int cc;
	protected final Data dataNascimento;
	protected List<Video> watchedVideos;
	protected List<Video> videoHistory;
	
	public Utilizador(String nome, int cc, Data dataNascimento){
		this.nome = nome;
		this.cc = cc;
		this.dataNascimento = dataNascimento;
		watchedVideos = new ArrayList<>();
		videoHistory = new ArrayList<>();
	}
	
	public void lendVideoToUser(Video video) {
		watchedVideos.add(video);
		videoHistory.add(video);
	}
	public void returnVideoFromUser(Video video) { watchedVideos.remove(video); }
	public Data dataNascimento() { return dataNascimento; }
	public String nome() { return nome;	}
	public int cc() { return cc; }
	public int numberOfVideosOwned() { return watchedVideos.size(); }
	
	public String toString() { return toString(" | "); }
	public String toString(String mid) { return nome + mid + cc + mid + dataNascimento; }
	
	public Video[] watchedVideosToArray() { return watchedVideos.toArray(new Video[0]); }
	public Video[] historyVideosToArray() { return videoHistory.toArray(new Video[0]); }
}
