package sg.edu.ntu.Flibble;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.http.HttpServlet;

public class Constant {
	public static enum FL_STATUS { SUCCESS, FAILURE};
	public static enum FL_GSTATUS { PLAYING, WAITING, COMPLETED };

	public static final String fJsonStatus = "Status";
	public static final String fJsonUserId = "UserId";
	public static final String fJsonGameTD = "GameTD";
	public static final String fJsonGameSG = "Games";
	public static final String fJsonGameUrl = "GameUrl";
	public static final String fJsonGameFlg = "Correct";
	public static final String fJsonGameName = "gname";
	public static Properties properties = null;
	public static int pageNumber = 0;
	public static final int pageNumberMax = 100;

	public static void getAppProp(HttpServlet r){
		try {
			
			InputStream in = r.getServletContext().getResourceAsStream(Constant.Application.bridgePropertyFile);
			properties = new Properties();
			properties.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public class Application {
		public static final String bridgePropertyFile = "/WEB-INF/bridge.property";
		public static final String userPropertyFile = "/WEB-INF/user.property";
		public static final String flickrConnString = "http://api.flickr.com/services/rest/?method=flickr.photos.getRecent";
		public static final String flickrConnStringIntest = "http://api.flickr.com/services/rest/?method=flickr.interestingness.getList";
		public static final String flickrApiKey = "api_key";
		public static final String flickrExtras = "extras";
		public static final String flickrPerPage = "per_page";
//		public static final String flickrPage = "page=1";
		public static final String flickrPage = "page";
		
		public static final String appName = "Flibble";
		
		
	}
}
