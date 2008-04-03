package sg.edu.ntu.Flibble;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

import org.json.JSONException;
import org.json.JSONObject;

public class RoomBean {
	private Hashtable<String, GameBean> games;
	private Vector<String> players;
	private int gCounter = 0;
	
	public RoomBean() {
		games = new Hashtable<String, GameBean>();
		players = new Vector<String>();
	}
	
	public boolean AddGame(String gName) {
		if (games.containsKey(gName)) {
			return false;
		} else {
			GameBean gb = new GameBean(gName);
			games.put(gName, gb);
			return true;
		}
	}
	public boolean AddGame(String gName, String userA) {
		if (games.containsKey(gName)) {
			return false;
		} else {
			GameBean gb = new GameBean(gName, userA);
			games.put(gName, gb);
			return true;
		}
	}
	public boolean AddGame(String gName, String userA, String userB) {
		if (games.containsKey(gName)) {
			return false;
		} else {
			GameBean gb = new GameBean(gName, userA, userB);
			games.put(gName, gb);
			return true;
		}
	}
	
	public boolean JoinGame(String gName, String userB){
		if (games.containsKey(gName)) {
			MyDebug.WriteDebug("Found game");
			GameBean game = games.get(gName);
			if (game.getUserB().equals("")==true){
				MyDebug.WriteDebug("about to set user");
				return game.setUserB(userB);
			}
			else {
				return false;
			}
		} else {
			return false;
		}
	}

	public GameBean getGame(String gName){
		return  games.get(gName);
	}

	
	public void DelGame(String gName) {
		GameBean gb = games.get(gName);
		if (gb != null) {
			games.remove(gName);
			gb = null;
		}
	}
	public boolean AddPlayer(String p){
		if(players.indexOf(p) == -1) {
			players.add(p);
			return true;
		}
		else {
			return false;
		}
	}
	public void DelPlayer(String p){
		players.remove(p);
	}
	public JSONObject GetGameDetailsJSON() throws JSONException {
		Enumeration<String> e = games.keys();
		JSONObject js = new JSONObject();
		while (e.hasMoreElements()){
			js.append("Games", GetGameDetailJSON(e.nextElement()));
		}
		return js;	
	}

	public JSONObject GetGameDetailsJSON(JSONObject js) throws JSONException {
		Enumeration<String> e = games.keys();
		while (e.hasMoreElements()){
			js.append("Games", GetGameDetailJSON(e.nextElement()));
		}
		return js;
	}

	public JSONObject GetGameDetailJSON(String key) throws JSONException {
		GameBean game = games.get(key);
		JSONObject jo = null;
		if (game.getGameStatus() != Constant.FL_GSTATUS.COMPLETED){
			jo = game.toJSON();
		}
		return jo;
		//====================
		//return games.get(key).toJSON();
	}
	
	public int GenCounter(){
		gCounter++;
		return gCounter;
	}
} // end of class

