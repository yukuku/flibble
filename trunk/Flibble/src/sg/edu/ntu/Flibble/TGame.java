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
		RoomBean room = S.roomBean;
		boolean retFlag = false;
		boolean delGameFlag = false;

		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		JSONObject js = new JSONObject();
		
		MyDebug.WriteDebug("Before if condition["+ request.getQueryString() +"]");
		String cellId = request.getParameter("cellId");
		GameBean game = room.getGame(gname);
		if(action.equals("MDefence") && userId != null && userId.equals("")!=true && gname!=null && "".equals(gname) != true){
			if(cellId != null && !cellId.equals("")){
				retFlag = game.MDefence(userId, Integer.parseInt(cellId));
			}
		}
		if(action.equals("QDefence") && userId != null && userId.equals("")!=true && gname!=null && "".equals(gname) != true){
			retFlag = game.QDefence(userId);
			if(retFlag == true){
				try {
					js.put(Constant.fJsonGameFlg, game.getCorrect());
					retFlag = true;
					
					//======================
					//upon game complete, delete game here, also delete the 2 users from room
					if(game.getGameStatus() == Constant.FL_GSTATUS.COMPLETED ){
						delGameFlag = true;
					}
					//======================
				}
				catch (JSONException je){
					out.println("error JSON");
				}
			}
		}
		if(action.equals("MAttack") && userId != null && userId.equals("")!=true && gname!=null && "".equals(gname) != true){
			if(cellId != null && !cellId.equals("")){
				retFlag = game.MAttack(userId, Integer.parseInt(cellId));
				if(retFlag == true){
					try {
						js.put(Constant.fJsonGameFlg, game.getCorrect());
						retFlag = true;
					}
					catch (JSONException je){
						out.println("error JSON");
					}
				}
			}
		}
		if(action.equals("QAttack") && userId != null && userId.equals("")!=true && gname!=null && "".equals(gname) != true){
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
		if(action.equals("query2") && userId != null && userId.equals("")!=true && gname!=null && "".equals(gname) != true){
			retFlag = true;
		}

		if (retFlag){
			try {
				js.put(Constant.fJsonStatus, Constant.FL_STATUS.SUCCESS);
				js.put(Constant.fJsonUserId, userId);
				js.put(Constant.fJsonGameSG, game.toJSON());
				MyDebug.WriteDebug(js.toString());
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
		
		
		//============================
		if(delGameFlag == true){
			MyDebug.WriteDebug(game.getGameName() + "Game completed, delete the game and user");
			room.DelPlayer(game.getUserA());
			room.DelPlayer(game.getUserB());
			room.DelGame(game.getGameName());
		}
		//============================
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}   	  	    
}