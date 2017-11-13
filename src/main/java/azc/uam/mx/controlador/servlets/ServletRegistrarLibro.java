package azc.uam.mx.controlador.servlets;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import azc.uam.mx.modelo.BeanLibro;
import azc.uam.mx.modelo.DAO.DAO_Libro;
import azc.uam.mx.validaciones.Validando;


public class ServletRegistrarLibro extends HttpServlet
{



	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletRegistrarLibro()
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

		HttpSession session = request.getSession();
		Long ok = (Long)session.getAttribute("NumEco");
		if(ok==null)
		{
			try
			{
				response.getWriter().append("Served at: ServletRegistrarLibro GET 111").append(request.getContextPath());
				doPost(request, response);
				throw new Exception();
			}
			catch (Exception ex)
			{
				System.out.println("ServletRegistrarLibro GET 222" );
				response.sendRedirect("../index.html");
			}
			finally
			{
				System.out.println("ServletRegistrarLibro GET 333");
			}
		}
		else
		{
			System.out.println("ServletRegistrarLibro GET 444");
			request.getRequestDispatcher("/Codigo/ServletLibrosDadosDeAlta.html").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		HttpSession session = request.getSession();
		Long ok = (Long)	session.getAttribute("NumEco");

		//		RequestDispatcher rd = request.getRequestDispatcher("NewFile.html");
		//	rd.forward(request, response);

		if(ok!=null)
		{

			try {

				String pageRegistroDeUsaurio = "/Codigo/RegistroDeLibrosNuevos.jsp";
				String pageSuccefull   =       "/Codigo/NewFile.html";

				BeanLibro libro = new BeanLibro();

				// --->>> Aqui ahy un error con el goole con el null pointexception hay que capturarlo con un tray cach     

				libro.setTitulo(Validando.converMayus(request.getParameter("titulo"))); //<------------
				libro.setAutor(Validando.converMayus(request.getParameter("autor"))); //<------------   
				libro.setEdicion(Validando.converMayus(request.getParameter("edicion")));  //<------------
				libro.setEditorial(Validando.converMayus(request.getParameter("editorial"))); //<------------
				libro.setISDN(Validando.isLong(request.getParameter("ISDN")));
				libro.setCopias_De_Este_Libro(Validando.isInteger(request.getParameter("copias")));

				Map<String, String> errors = Validando.validatelibro(libro);

				if ( !errors.isEmpty())
				{

					Set<String> setCodes = errors.keySet();
					Iterator<String> iterator = setCodes.iterator();

					while (iterator.hasNext())
					{
						String codeo = iterator.next();
						String message = errors.get(codeo);
						request.setAttribute(codeo, message);
					}

					request.getRequestDispatcher(pageRegistroDeUsaurio).forward(request, response);
				}
				else
				{
					int sw=0;
					sw=DAO_Libro.agregarLibro(libro);

					if(sw==1)
					{
						List<BeanLibro> listaaaaa= DAO_Libro.getLibros();
						request.setAttribute("Wow", listaaaaa);
						request.getRequestDispatcher(pageSuccefull).forward(request, response);

					}
					else
					{
						if(sw==2)
						{
							request.setAttribute("message2", "Matricula duplicada");
						}
						if(sw==0)
						{
							System.out.println("Problemas con la conexión a la base de datos");
							request.setAttribute("message2", "Matricula duplicada");
						}
						request.getRequestDispatcher(pageRegistroDeUsaurio).forward(request, response);
					}
				}
			}
			finally
			{
				System.out.println("ServletRegistrarLibro POST 111");
			}
		}
		else
		{
			System.out.println("ServletRegistrarLibro POST 222 ");
			request.getRequestDispatcher("/Codigo/ServletLibrosDadosDeAlta.html").forward(request, response);
		}
	}

}

