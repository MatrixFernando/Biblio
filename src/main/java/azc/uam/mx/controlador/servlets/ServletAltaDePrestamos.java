package azc.uam.mx.controlador.servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import azc.uam.mx.modelo.BeanPrestamo;
import azc.uam.mx.modelo.DAO.DAO_Prestamo;

/**
 * Servlet implementation class ServletAdminDadosDeAlta
 */

public class ServletAltaDePrestamos extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletAltaDePrestamos()
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
				System.out.println("asdfas");	
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
				System.out.println("Finally num1");
			}
		}
		else
		{
			LinkedList<BeanPrestamo> listadePrestamos = DAO_Prestamo.getPrestamos();
			request.setAttribute("WowPrestamos", listadePrestamos); 
			//		DAO_Prestamo.impimirDatos ();
			request.getRequestDispatcher("/Codigo/AltaDePrestamos.jsp").forward(request, response);
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
				// --->>> Se hace un try catch para el metodo get para evitar que se caiga el servidor con un enter en la URLRox12356
				response.getWriter().append("Served at: ").append(request.getContextPath());
				System.out.println("asdfas");
				//	DAO_Prestamo.getPrestamos();
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
				System.out.println("Finally num1");
			}
		}
		else
		{
			LinkedList<BeanPrestamo> listadePrestamos = DAO_Prestamo.getPrestamos();
			request.setAttribute("WowPrestamos", listadePrestamos); 
			//	DAO_Prestamo.impimirDatos ();
			request.getRequestDispatcher("/Codigo/AltaDePrestamos.jsp").forward(request, response);
		}
	}

}
