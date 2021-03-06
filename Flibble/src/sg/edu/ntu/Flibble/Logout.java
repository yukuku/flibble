package sg.edu.ntu.Flibble;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Servlet implementation class for Servlet: Logout
 *
 */
 public class Logout extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Logout() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		String userId = request.getParameter("user");
		ServletContext appContext = getServletContext();
		RoomBean room = S.roomBean;

		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		
		MyDebug.WriteDebug("Before if condition");
		if(action.equals("logout") ){
			room.DelPlayer(userId);
			JSONObject js = new JSONObject();
			MyDebug.WriteDebug("Logout Successful");
			try {
				js.put(Constant.fJsonStatus, Constant.FL_STATUS.SUCCESS);
				js.put(Constant.fJsonUserId, userId);
				out.println(js.toString());
			}
			catch (JSONException je){
				out.println("error JSON");
			}
		}
		else {
			JSONObject js = new JSONObject();
			try {
				js.put(Constant.fJsonStatus, Constant.FL_STATUS.FAILURE);
				js.put(Constant.fJsonUserId, userId);
				out.println(js.toString());
			}
			catch (JSONException je){
				out.println("error JSON");
			}
		}
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}   	  	    
}