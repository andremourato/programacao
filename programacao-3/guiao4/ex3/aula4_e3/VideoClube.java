package aula4_e3;
import java.util.*;

public class VideoClube {
		
	private UserList users = new UserList();
	private VideoList videos = new VideoList();	
	private int movieLimit;
	
	public VideoClube(int N) {
		movieLimit = N;
	}
	
	public void addUser(Utilizador student) {
		users.addUser(student);
	}
	
	public void removeUser(int cc) {
		users.removeUser(users.getUser(cc));
	}
	
	public void printUserVideos(int cc) {
		Utilizador user = users.getUser(cc);
		System.out.println("---------------------------------------------");
		System.out.println("|  Videos de: "+user+" |");
		System.out.println("---------------------------------------------");
		for(Video video : user.watchedVideosToArray())
			System.out.println("| "+ video +" |");
	}
	
	public void addVideo(String title, String age, String category) {
		videos.addVideo(new Video(title,age,category));
	}
	
	public void removeVideo(int id) {
		videos.removeVideo(videos.getVideo(id));
	}
	
	public void checkAvailability(int id) {
		String status = "available";
		if(!videos.getVideo(id).isAvailable())
			status = "unavailable";
		System.out.println("Status of video "+id+": "+status);
	}
	
	public void lendVideo(int id, int cc) {
		Video video = videos.getVideo(id);
		Utilizador user = users.getUser(cc);
		if(user.numberOfVideosOwned()>=movieLimit) {
			System.out.println("O utilizador "+user.nome()+" atingiu a sua quota de videos.");
			return;
		}
		if(!video.isAvailable()) { 
			System.out.println("Video "+id+" está indisponivel de momento e não pode requisitado!");
			return;
		}
		video.lendVideo();
		user.lendVideoToUser(video);
		System.out.println("Video requisitado com sucesso");
	}
	
	public void returnVideo(int id, int cc, int r) {
		Video video = videos.getVideo(id);
		Utilizador user = users.getUser(cc);
		if(video.isAvailable()) { 
			System.out.println("Video "+id+" is available at the moment. Cannot have 2 similar videos!");
			return;
		}
		video.returnVideo(r);
		user.returnVideoFromUser(video);
		System.out.println("Video devolvido com sucesso");
	}
	
	public void printUserVideoHistory(int cc) {
		Utilizador user = users.getUser(cc);
		System.out.println("---------------------------------------------");
		System.out.println("|      Historico de videos de "+user.nome()+"      |");
		System.out.println("---------------------------------------------");
		for(Video video : user.historyVideosToArray()) {
			System.out.println("| " + video + " |");
		}
	}
	
	public void printCatalog() {
		System.out.println("---------------------------------------------");
		System.out.println("|             Catálogo de videos            |");
		System.out.println("---------------------------------------------");
		for(Video video : videos.videosToArray()) {
			System.out.println("| " + video + " |");
		}
	}
	
	public void printCatalogByRating() {
		Video[] sortedArray = videos.videosToArray().clone();
		/*Sorts the videos by rating*/
		Arrays.sort(sortedArray, new Comparator<Video>() {
	        @Override
	        public int compare(Video v1, Video v2) {
	        	int i = -2;
	        	if(v1.rating() > v2.rating())
	        		i = -1;
	        	else if(v1.rating() < v2.rating())
	        		i = 1;
	        	else
	        		i = 0;
	            return i;
	        }
	    });
		
		System.out.println("---------------------------------------------");
		System.out.println("|        Catálogo de videos por Rating       |");
		System.out.println("---------------------------------------------");
		for(Video video : sortedArray) {
			System.out.println("| " + video + " |");
		}
	}
}
