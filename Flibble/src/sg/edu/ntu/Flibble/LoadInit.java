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
 * Servlet implementation class for Servlet: LoadInit
 *
 */
 public class LoadInit extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public LoadInit() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		String userId = request.getParameter("user");
		String gname = request.getParameter("gname");
		ServletContext appContext = getServletContext();
		RoomBean room = S.roomBean;
		boolean retFlag = false;

		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		JSONObject js = new JSONObject();
		
		MyDebug.WriteDebug("Before if condition");
		if(action.equals("LoadInit") && userId != null && userId.equals("")!=true){
			MyDebug.WriteDebug("is loadinit");
			if(gname!=null && gname.equals("")!=true){
				MyDebug.WriteDebug("game name not empty");
				GameBean game = room.getGame(gname);
				if (game.getGameStatus() == Constant.FL_GSTATUS.PLAYING){
					try {
						MyDebug.WriteDebug("Constructing json");
						js.put(Constant.fJsonGameTD, game.toJSONInit(userId));
						retFlag = true;
					}
					catch (JSONException je){
						out.println("error JSON");
					}
				}
			}
		}
		
		if (retFlag){
			try {
				js.put(Constant.fJsonStatus, Constant.FL_STATUS.SUCCESS);
				js.put(Constant.fJsonUserId, userId);
				js = room.GetGameDetailsJSON(js);
				out.println(js.toString());
			}
			catch (JSONException je){
				out.println("error JSON");
			}
		}
		else {
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