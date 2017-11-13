package azc.uam.mx.controlador.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LogoutServlet extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session != null)
		{
			session.removeAttribute("NumEco");
			session.invalidate();
			//session.setAttribute("NumEco", null);
			//System.out.println("ddd"+session.getAttribute("NumEco"));
			//request.getSession(true);
		}
		//session = request.getSession(true);
		//session.setAttribute("NumEco", null);
		request.getRequestDispatcher("/Codigo/InicioDeSistema.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		//	response.setContentType("text/html");

		HttpSession session = request.getSession();

		if(session != null)
		{
			session.removeAttribute("NumEco");
			session.invalidate();

			//	Long ok = (Long)	session.getAttribute("NumEco");
			//	    		HttpSession session = request.getSession();
			//session.setAttribute("NumEco", null);
			//System.out.println("ddd"+session.getAttribute("NumEco"));
			//	System.out.println("ddd"+session.getAttribute("NumEco"));
			//request.getSession(true);
		}
		//session = request.getSession(true);
		//session.setAttribute("NumEco", null);

		request.getRequestDispatcher("/Codigo/InicioDeSistema.jsp").forward(request, response);
	}

}
