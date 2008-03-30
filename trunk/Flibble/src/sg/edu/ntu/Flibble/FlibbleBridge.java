package sg.edu.ntu.Flibble;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class for Servlet: FlibbleBridge
 */
public class FlibbleBridge extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	static final long serialVersionUID = 1L;
	//private static final int bridgeMultiFactor = 3;
	private Properties properties;

	public FlibbleBridge() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = Constant.Application.flickrConnString + "&" + Constant.Application.flickrApiKey + "=" + properties.getProperty("FlibbleDefaultApiKey")
				+ "&" + Constant.Application.flickrExtras + "=" + properties.getProperty("FlibbleDefaultExtras") + "&" + Constant.Application.flickrPerPage
				+ "=" + (Math.pow(Integer.parseInt(properties.getProperty("FlibbleDefaultMatrixSize")), 2) * 2) + "&" + Constant.Application.flickrPage;

		// i copy yuku's proxy lab here :D
		HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
		InputStreamReader in = new InputStreamReader(con.getInputStream(), "utf-8");
		response.setContentType(con.getContentType());
		while (true) {
			int c = in.read();
			if (c < 0)
				break;
			response.getWriter().print((char) c);
		}
		
		
		//--------for testing
		Constant.getAppProp(this);
	}

	public void init() throws ServletException {
		InputStream in = null;
		try {
			System.out.println("about to get file:" + Constant.Application.bridgePropertyFile);
			in = getServletContext().getResourceAsStream(Constant.Application.bridgePropertyFile);
			properties = new Properties();
			properties.load(in);
			super.init();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}