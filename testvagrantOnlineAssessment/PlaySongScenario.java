package testvagrantOnlineAssessment;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PlaySongScenario {
	
	private final int limit;
	private Map<String, LinkedList<String>> songStore;

	public PlaySongScenario(int limit) {
		this.limit = limit;
		this.songStore = new HashMap<>();
	}

	public void addSong(String user, String song) {
		songStore.putIfAbsent(user, new LinkedList<String>());
		LinkedList<String> playlist = songStore.get(user);

		// Remove the song if it already exists
		playlist.remove(song);

		if (playlist.size() >= limit) {
			
			playlist.removeFirst();
		}
		// Add the new song to the playlist
		playlist.add(song);
	}

	public List<String> getRecentlyPlayed(String user) {
		return songStore.getOrDefault(user, new LinkedList<String>());
	}


}
