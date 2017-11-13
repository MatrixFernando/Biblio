package azc.uam.mx.controlador.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Suervletpruebasokok
 */
public class Suervletpruebasokok extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Suervletpruebasokok()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		response.getWriter().append("Servedxxx at: ").append(request.getContextPath());

		System.out.println("jijidjfijdfijdfijdif");
		HttpSession session = request.getSession();

		Long ok = (Long)	session.getAttribute("NumEco");

		System.out.println("fffff " + ok);
		if(ok==null)
		{




			System.out.println("iiiiiiiiiiiiiiiii");
			request.getRequestDispatcher("/Codigo/RegistroDeUsuario.jsp").forward(request, response);





		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		//	doGet(request, response);

		try 
		{

			System.out.println("jdjd");
			response.getWriter().append("Servelllld at: ").append(request.getContextPath());
			doPost(request, response);
			throw new Exception();
		} catch (Exception ex) 
		{
			System.out.println("Error 22" );
			response.sendRedirect("../index.html");
			//     System.out.println("Error 22"+ex);
		}
		finally
		{
			System.out.println("Finally num1");
		}
	}

}
