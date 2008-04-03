package sg.edu.ntu.Flibble;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;

public class FlibbleBridge2 {
	public static FlibbleMatrix [] getFlibbleMatrix() throws IOException{
		MyDebug.WriteDebug("size = " + Constant.properties.getProperty("FlibbleDefaultMatrixSize"));
		int imgCount = (int) Math.pow(Integer.parseInt(Constant.properties.getProperty("FlibbleDefaultMatrixSize")), 2);
		FlibbleMatrix [] fm = new FlibbleMatrix[imgCount];
		
		try {
			int i =0, j=0, k=0;
			NodeList nodes = null;
			while (i<imgCount){
				boolean isDuplicate = false;
				if(j==0){
					nodes = getNodes();
					j = imgCount*2;
				}
				NamedNodeMap nodMap = nodes.item(j-1).getAttributes();
				String tag = nodMap.getNamedItem("tags").getNodeValue().trim();
				
				// to remove duplicate tags
				for (k=0; k<i; k++){
					if(fm[k].getTagString().equals(tag) == true){
						isDuplicate = true;
					}
				}
				if(tag !=null && tag.trim().equals("") != true && isDuplicate != true) {
					String furl = "http://farm" + nodMap.getNamedItem("farm").getNodeValue() +
							".static.flickr.com/" + nodMap.getNamedItem("server").getNodeValue() +
							"/" + nodMap.getNamedItem("id").getNodeValue() +
							"_" + nodMap.getNamedItem("secret").getNodeValue() +
							"_t.jpg";
					MyDebug.WriteDebug("current url is " + furl);
					MyDebug.WriteDebug("current tag is " + tag);
					MyDebug.WriteDebug("current id is " + i);
					fm[i] = new FlibbleMatrix(i, furl, tag);
					i++;
				}
				j--;
			}
		}
		catch (SAXException ex){
			System.out.println(ex);
			ex.printStackTrace();
		}
		
		return fm;
	}
	
	public static NodeList getNodes() throws IOException, SAXException{
		NodeList nodes;
		MyDebug.WriteDebug("About to get img from flickr");
		DOMParser parser = new DOMParser();
//		InputStream in = getFlickImgs();
//		parser.parse(new InputSource(in));
		String in = getFlickImgs2();
		parser.parse(new InputSource(new StringReader(in)));
		Document doc = parser.getDocument();
		nodes = doc.getElementsByTagName("photo");
		return nodes;
	}
	
	public static InputStream getFlickImgs() throws IOException {
		String url = Constant.Application.flickrConnString + "&" + Constant.Application.flickrApiKey + "=" + Constant.properties.getProperty("FlibbleDefaultApiKey")
		+ "&" + Constant.Application.flickrExtras + "=" + Constant.properties.getProperty("FlibbleDefaultExtras") + "&" + Constant.Application.flickrPerPage
		+ "=" + (Math.pow(Integer.parseInt(Constant.properties.getProperty("FlibbleDefaultMatrixSize")), 2) * 2) + "&" + Constant.Application.flickrPage;

		HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
		InputStream in = con.getInputStream();

		con.disconnect();
		return in;
	}

	public static String getFlickImgs2() throws IOException {
		String url = Constant.Application.flickrConnString + "&" + Constant.Application.flickrApiKey + "=" + Constant.properties.getProperty("FlibbleDefaultApiKey")
		+ "&" + Constant.Application.flickrExtras + "=" + Constant.properties.getProperty("FlibbleDefaultExtras") + "&" + Constant.Application.flickrPerPage
		+ "=" + (Math.pow(Integer.parseInt(Constant.properties.getProperty("FlibbleDefaultMatrixSize")), 2) * 2) + "&" 
		+ Constant.Application.flickrPage + "=" + Constant.pageNumber;
		if (Constant.pageNumber < Constant.pageNumberMax) {
			Constant.pageNumber++;
		}
		else {
			Constant.pageNumber = 1;
		}

		HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
		String ret = "";
		//---Test
		InputStreamReader in2 = new InputStreamReader(con.getInputStream(), "utf-8");
		while (true) {
			int c = in2.read();
			if (c < 0)
				break;
			MyDebug.WriteDebugChar((char) c);
			ret = ret + String.valueOf((char) c);
		}
		ret = ret + "\n";

		con.disconnect();
		return ret;
	}
}
