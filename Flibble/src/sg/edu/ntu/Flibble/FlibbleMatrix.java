package sg.edu.ntu.Flibble;

import org.json.JSONException;
import org.json.JSONObject;

public class FlibbleMatrix {
	private int cellNo = 0;
	private String flibbleUrl = "";
	private String tagString = "";
	
	public FlibbleMatrix(int cn, String url, String tag){
		cellNo = cn;
		flibbleUrl = url;
		tagString = tag;
	}
	
	public int getCellNo(){
		return cellNo;
	}
	
	public String getFlibbleUrl(){
		return flibbleUrl;
	}
	
	public String getTagString(){
		return tagString;
	}

	public JSONObject toJSONImg() throws JSONException {
		JSONObject jo = new JSONObject();
		jo.put("cellNo", cellNo);
		jo.put("tagString", tagString);
		return jo;
	}
	
	public JSONObject toJSONTag() throws JSONException {
		JSONObject jo = new JSONObject();
		jo.put("cellNo", cellNo);
		jo.put("flibbleUrl", flibbleUrl);
		jo.put("tagString", tagString);
		return jo;
	}
}
