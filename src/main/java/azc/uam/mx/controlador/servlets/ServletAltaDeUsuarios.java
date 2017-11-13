package azc.uam.mx.controlador.servlets;

import java.io.IOException;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import azc.uam.mx.modelo.BeanUsuario;
import azc.uam.mx.modelo.DAO.DAO_Usuario;

/**
 * Servlet implementation class ServletAdminDadosDeAlta
 */

public class ServletAltaDeUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletAltaDeUsuarios()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		HttpSession session = request.getSession();

		Long okNumeroEco = (Long)	session.getAttribute("NumEco");


		if(okNumeroEco==null)
		{
			try
			{
				// --->>> Se hace un try catch para el metodo get para evitar que se caiga el servidor con un enter en la URL
				response.getWriter().append("No hay session: ").append(request.getContextPath());
				throw new Exception();
			} 
			catch (Exception ex)
			{
				// Al cacharlo Se dirije a la pagina principal 
				System.out.println("Error 22 en el metodo GET" );
				response.sendRedirect("../index.html");
			}
			finally
			{
				System.out.println("Finally 11 SErvletAltaDeUsuario");
			}
		}
		else
		{

			LinkedList<BeanUsuario> listaDeUsuario = DAO_Usuario.getUsuarios();
			request.setAttribute("WowUsuario", listaDeUsuario);
			request.getRequestDispatcher("/Codigo/AltaDeUsuarios.jsp").forward(request, response);
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		Long okNumeroEco = (Long)	session.getAttribute("NumEco");
		if(okNumeroEco==null)
		{
			try
			{
				// --->>> Se hace un try catch para el metodo get para evitar que se caiga el servidor con un enter en la URL
				response.getWriter().append("Served at: ").append(request.getContextPath());
				// doPost(request, response);
				throw new Exception();
			} catch (Exception ex) {
				// Al cacharlo Se dirije a la pagina principal 
				System.out.println("Error 22 en el metodo GET" );
				response.sendRedirect("../index.html");
			}
			finally 
			{
				System.out.println("Finally num 22 SErvletAltaDeUsuario");
			}
		}
		else
		{
			LinkedList<BeanUsuario> listaDeUsuario = DAO_Usuario.getUsuarios();
			request.setAttribute("WowUsuario", listaDeUsuario); 
			request.getRequestDispatcher("/Codigo/AltaDeUsuarios.jsp").forward(request, response);
		}
	}

}
