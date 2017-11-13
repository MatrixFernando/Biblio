package azc.uam.mx.controlador.servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import azc.uam.mx.modelo.BeanAdministrador;
import azc.uam.mx.modelo.DAO.DAO_Administrador;

/**
 * Servlet implementation class ServletAdminDadosDeAlta
 */

public class ServletAdminDadosDeAlta extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletAdminDadosDeAlta()
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
				System.out.println("Finally num1 SERvletAdminDadoDeAlta");
			}
		}
		else
		{

			LinkedList<BeanAdministrador> listaaa=(LinkedList<BeanAdministrador>) DAO_Administrador.getContactosAdmin();

			request.setAttribute("Wow", listaaa);

			request.getRequestDispatcher("/Codigo/AdminDadosDeAlta.jsp").forward(request, response);

		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

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
			}
			catch (Exception ex)
			{
				// Al cacharlo Se dirije a la pagina principal 
				System.out.println("Error 22 en el metodo GET" );
				response.sendRedirect("../index.html");
			}

			finally
			{
				System.out.println("Finally num 22 ServletAdminDadoDeAlta");
			}
		}
		else
		{
			LinkedList<BeanAdministrador> listaDeAdministradores = DAO_Administrador.getContactosAdmin();
			request.setAttribute("Wow", listaDeAdministradores); 
			request.getRequestDispatcher("/Codigo/AdminDadosDeAlta.jsp").forward(request, response);
		}
	}

}
