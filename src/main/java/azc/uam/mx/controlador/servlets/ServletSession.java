package azc.uam.mx.controlador.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import azc.uam.mx.modelo.DAO.DAO_Administrador;
/**
 * Servlet implementation class ServletSession
 */
@WebServlet("/WOW.html")
public class ServletSession extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletSession()
	{
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		Long ok = (Long)session.getAttribute("NumEco");
		//	System.out.println("Auto compeltoado "+ok);

		if(ok==null)
		{
			System.out.println("NO hay session");
			//    request.getRequestDispatcher("/Codigo/InicioDeSistema.jsp").forward(request, response);
			response.sendRedirect("InicioDeSistema.jsp");
		}
		else
		{
			System.out.println("Si hay session");
			response.sendRedirect("RegistroDeUsuario.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String GetrequestpagePASOaRegistroDeUsaurio = "/Codigo/RegistroDeUsuario.jsp";
		String GetrequestpageAQUIInicioDeSistema  =   "/Codigo/InicioDeSistema.jsp";
		//  String SendredirectpagePASOaRegistroDeUsaurio = "RegistroDeUsuario.jsp";
		//	String SendredirectAQUIInicioDeSistema =  "InicioDeSistema.jsp";
		//  String NumEcon, pass;
		String  NumEcon = request.getParameter("NumeroEconmico");
		String  pass = request.getParameter("contrasenia");
		//   System.out.println("dkdkd"+NumEcon);
		Long NUM_ECO= DAO_Administrador.getValidarSessionDeUsuario(NumEcon, pass ) ;

		if(NUM_ECO.toString().equals(NumEcon.toString()))
		{
			HttpSession session = request.getSession();
			session.setAttribute("NumEco", NUM_ECO);
			request.getRequestDispatcher(GetrequestpagePASOaRegistroDeUsaurio).forward(request, response);	    
			//  response.sendRedirect(SendredirectpagePASOaRegistroDeUsaurio);
			//  return;
		}
		else
		{
			//lógica para login inválido
			System.out.println("NO Entro a la session en post ooohh mii good");
			String error1="Algún dato esta incorrecto";
			request.setAttribute("error",error1);
			request.getRequestDispatcher(GetrequestpageAQUIInicioDeSistema).forward(request, response);
		}
	}

}
