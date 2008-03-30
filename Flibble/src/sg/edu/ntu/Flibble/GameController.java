package sg.edu.ntu.Flibble;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class for Servlet: GameController
 *
 */
 public class GameController extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public GameController() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = null;
		String action = request.getParameter("action");
		if("login".equals(action)){
			dispatcher = request.getRequestDispatcher("/Login");
		}
		else if("logout".equals(action)){
			dispatcher = request.getRequestDispatcher("/Logout");
		}
		else if("CGame".equals(action)){
			dispatcher = request.getRequestDispatcher("/CGame");
		}
		else if("DGame".equals(action)){
			dispatcher = request.getRequestDispatcher("/CGame");
		}
		else if("JoinIn".equals(action)){
			dispatcher = request.getRequestDispatcher("/CGame");
		}
		else if("query".equals(action)){
			dispatcher = request.getRequestDispatcher("/CGame");
		}
		else if("LoadInit".equals(action)){
			dispatcher = request.getRequestDispatcher("/LoadInit");
		}
		else if("MDefence".equals(action)){
			dispatcher = request.getRequestDispatcher("/TGame");
		}
		else if("QDefence".equals(action)){
			dispatcher = request.getRequestDispatcher("/TGame");
		}
		else if("MAttack".equals(action)){
			dispatcher = request.getRequestDispatcher("/TGame");
		}
		else if("QAttack".equals(action)){
			dispatcher = request.getRequestDispatcher("/TGame");
		}
		if (dispatcher != null) {
		    dispatcher.forward(request, response);
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