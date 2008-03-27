package sg.edu.ntu.Flibble;

import java.util.Hashtable;

public class RoomBean {
	private Hashtable<String, GameBean> games;

	public RoomBean() {
		games = new Hashtable<String, GameBean>();
	}

	public boolean addGame(String gName) {
		if (games.containsKey(gName)) {
			return false;
		} else {
			GameBean gb = new GameBean(gName);
			games.put(gName, gb);
			return true;
		}
	}

	public boolean addGame(String gName, String userA, String userB) {
		if (games.containsKey(gName)) {
			return false;
		} else {
			GameBean gb = new GameBean(gName, userA, userB);
			games.put(gName, gb);
			return true;
		}
	}

	public void delGame(String gName) {
		GameBean gb = games.get(gName);
		if (gb != null) {
			games.remove(gName);
			gb = null;
		}
	}

} // end of class

