package aula4_e3;
import java.util.*;

public class VideoList {
	
	private List<Video> videos = new ArrayList<>();
	
	public void addVideo(Video video) {
		videos.add(video);
	}
	
	public void removeVideo(Video video) {
		videos.remove(video);
	}
	
	public Video getVideo(int id) {
		for(Video video : videosToArray()) {
			if(video.id() == id)
				return video;
		}
		throw new IllegalArgumentException();
	}
	
	public int size() { return videos.size(); }
	public Video[] videosToArray() { return videos.toArray(new Video[0]); }
}
