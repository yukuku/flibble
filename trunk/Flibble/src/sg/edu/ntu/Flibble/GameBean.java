package sg.edu.ntu.Flibble;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

public class GameBean {
	private String userA = "";
	private String userB = "";
	private String gameName = null;
	private String curTurn = null;
	private int scoreA = 0;
	private int scoreB = 0;
	private int curCel = -1;
	private Constant.FL_GSTATUS gstatus = Constant.FL_GSTATUS.WAITING;
	private FlibbleMatrix[] fmA;
	private FlibbleMatrix[] fmB;
	
	public GameBean() {
	}

	public GameBean(String gameName) {
		this.gameName = gameName;
	}

	public GameBean(String gameName, String userA) {
		this.gameName = gameName;
		this.userA = userA;
	}

	public GameBean(String gameName, String userA, String userB) {
		this.gameName = gameName;
		this.userA = userA;
		this.userB = userB;
	}

	public String getUserA() {
		return userA;
	}

	public String getUserB() {
		return userB;
	}

	public String getUsers() {
		return userA + " and " + userB;
	}

	public String getGameName() {
		return gameName;
	}

	public void setUserA(String u) {
		userA = u;
	}

	public boolean setUserB(String u) {
		if(userA.equals("")!=true){
			userB = u;
			curTurn = userA;
			scoreA = scoreB = 0;
			gstatus = Constant.FL_GSTATUS.PLAYING;
			return startGame();
		}
		else {
			return false;
		}
	}

	public void setGameName(String g) {
		gameName = g;
	}
	
	public void setScoreA() {
		scoreA++;
	}
	public void setScoreB() {
		scoreB++;
	}

	public JSONObject toJSON() throws JSONException {
		JSONObject jo = new JSONObject();
		jo.put("GameName", gameName);
		jo.put("UserA", userA);
		jo.put("UserB", userB);
		jo.put("CurTurn", curTurn);
		jo.put("Score", "" + scoreA + ":" + scoreB);
		jo.put("GStatus", gstatus);
		return jo;
	}
	
	private boolean startGame() {
		try {
			fmA = FlibbleBridge2.getFlibbleMatrix();
			fmB = FlibbleBridge2.getFlibbleMatrix();
			MyDebug.WriteDebug("Initialized fm");
			return true;
		}
		catch (IOException ex){
			MyDebug.WriteDebug("Initialized fm failure with" + ex);
			return false;
		}
		
	}

	public JSONObject toJSONInit(String user) throws JSONException {
		JSONObject jo = this.toJSON();
		if (user.equals(userA)){
			for(int i=0; i<fmA.length; i++){
				jo.append("MyImgs", fmA[i].toJSONImg());
				jo.append("MyTags", fmB[i].toJSONTag());
			}
		}
		else if (user.equals(userB)){
			for(int i=0; i<fmA.length; i++){
				jo.append("MyImgs", fmB[i].toJSONImg());
				jo.append("MyTags", fmA[i].toJSONTag());
			}
		}
		return jo;
	}
	
	public boolean MDefence(String user,int cellId){
		boolean retVal = false;
		if(curTurn.equals(user) && cellId < fmA.length){
			curCel = cellId;
			curTurn = user.equals(userA)? userB : userA;
			retVal = true;
		}
		return retVal;
	}

	public String QAttack(String user){
		String retVal = "";
		if(curTurn.equals(user) && curCel != -1){
			retVal = user.equals(userA)? fmB[curCel].getFlibbleUrl() : fmA[curCel].getFlibbleUrl();
		}
		return retVal;
	}

	public boolean MAttack(String user, int cellId){
		boolean retVal = false;
		if(curTurn.equals(user)){
			if(cellId == curCel){
				if(user.equals(userA)){
					scoreA++;
				}
				else {
					scoreB++;
				}
				retVal=true;
			}
		}
		return retVal;
	}

	public boolean QDefence(String user){
		boolean retVal = false;
		if(curTurn.equals(user)){
			retVal = true;
		}
		return retVal;
	}
}
