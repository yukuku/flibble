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
 * Servlet implementation class for Servlet: TGame
 *
 */
 public class TGame extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public TGame() {
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
		RoomBean room = (RoomBean) appContext.getAttribute("applicationBean");
		boolean retFlag = false;

		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		JSONObject js = new JSONObject();
		
		MyDebug.WriteDebug("Before if condition");
		String cellId = request.getParameter("cellId");
		GameBean game = room.getGame(gname);
		if(action.equals((String) "MDefence") && userId != null && userId.equals("")!=true && gname==null || gname.equals("")==true){
			if(cellId != null && !cellId.equals("")){
				retFlag = game.MDefence(userId, Integer.parseInt(cellId));
			}
		}
		if(action.equals((String) "QDefence") && userId != null && userId.equals("")!=true && gname==null || gname.equals("")==true){
			retFlag = game.QDefence(userId);
		}
		if(action.equals((String) "MAttack") && userId != null && userId.equals("")!=true && gname==null || gname.equals("")==true){
			if(cellId != null && !cellId.equals("")){
				retFlag = game.MAttack(userId, Integer.parseInt(cellId));
			}
		}
		if(action.equals((String) "QAttack") && userId != null && userId.equals("")!=true && gname==null || gname.equals("")==true){
			if(cellId != null){
				String url = game.QAttack(userId);
				if(!url.equals("")){
					try {
						js.put(Constant.fJsonGameUrl, url);
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
				js.put(Constant.fJsonGameSG, game.toJSON());
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