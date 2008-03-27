package sg.edu.ntu.Flibble;

public class GameBean {
	private String userA = null;
	private String userB = null;
	private String gameName = null;

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

	public void setUserB(String u) {
		userB = u;
	}

	public void setGameName(String g) {
		gameName = g;
	}

}
