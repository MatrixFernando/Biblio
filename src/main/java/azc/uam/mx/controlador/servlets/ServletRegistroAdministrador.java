package azc.uam.mx.controlador.servlets;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import azc.uam.mx.modelo.BeanAdministrador;
import azc.uam.mx.modelo.DAO.DAO_Administrador;
import azc.uam.mx.validaciones.Validando;

@WebServlet("/AltaDeAdministrador.html")
public class ServletRegistroAdministrador extends HttpServlet
{


	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletRegistroAdministrador()
	{
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		HttpSession session = request.getSession();
		Long ok = (Long)	session.getAttribute("NumEco");

		if(ok==null)
		{

			try
			{
				// --->>> Se hace un try catch para el metodo get para evitar que se caiga el servidor con un enter en la URL
				response.getWriter().append("Served at jj: ").append(request.getContextPath());
				doPost(request, response);
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
				System.out.println("Finally num111 SErvletREGISTROAdminitrador");
			}
		}
		else
		{
			System.out.println("iiiiiiiiiiiiiiiii");
			response.sendRedirect("RegistroDeAdministrador.jsp");
			//	response.sendRedirect("InicioDeSistema.jsp");
			//   	response.sendRedirect("../index.html");
			//	  request.getRequestDispatcher("/Codigo/RegistroDeAdministrador.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		//	RequestDispatcher rd = request.getRequestDispatcher("RegistroDeAdministrador.jsp");
		// --->>> Aqui ahy un error con el google con el nullpointexception hay que capturarlo con un tray caTch  
		//	try {
		//paginas para dirigir el flujo del servlet
		//	String pageRegistroDeUsaurio = "/Codigo/RegistroDeAdministrador.jsp";
		//	String pageSuccefull   =       "/Codigo/NewFile.html";

		// Comienza el alta al Usuario
		BeanAdministrador Admin = new BeanAdministrador();

		Admin.setNombres(Validando.converMayus(request.getParameter("nombres"))); //<------------
		Admin.setApellido_paterno(Validando.converMayus(request.getParameter("apellido_paterno"))); //<------------
		Admin.setApellido_materno(Validando.converMayus(request.getParameter("apellido_materno"))); //<------------
		//Admin.setEdad(Validando.UnInteger(request.getParameter("edad")));
		Admin.setCorreo(request.getParameter("correo")); 
		Admin.setContrasenia(request.getParameter("contrasenia")); //<------------
		Admin.setConfirmarcontrasenia(request.getParameter("confirmarcontrasenia")); //<------------

		//		Integer okok = Validando.ValidandounInteger(request.getParameter("edad"));
		//   System.out.println("AQUI OJOJ OK OK" + okok);
		/*

			String edad = request.getParameter("edad"); 
			if(edad.equals(""))
			{
				Admin.setEdad(null);
			}  else {
				if(Validando.isNumericInteger(edad))
				{
					Admin.setEdad( Integer.parseInt(edad));              //<------------
				}else {
					Admin.setEdad(Integer.parseInt(edad)); 
				}
			}
		 */

		String numero_economico =request.getParameter("numero_economico"); 
		if(numero_economico.equals(""))
		{
			Admin.setNumero_economico(null);
		} 
		else
		{
			/*if(Validando.isNumericLong(numero_economico))
			{
				Admin.setNumero_economico(Long.parseLong(numero_economico));     //<------------
			}
			else
			{
				Admin.setNumero_economico(1l);
			}*/
		}
		
		// Aqui llegan los errores de las validaciones de los atributos del Usuario
		Map<String, String> errors = Validando.validateAdministrador(Admin);

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

			//	request.getAttribute("nombres");
			//	System.out.println(codeo);
			// se mandan los errores de los aributos al jsp faltan checar los de la BD Ejemplo matriculas duplicadas etc.

			//	response.sendRedirect("RegistroDeAdministrador.jsp");
			request.getRequestDispatcher("RegistroDeAdministrador.jsp").forward(request, response);

		}
		else
		{
			//	BeanUsuario woow= new BeanUsuario();
			//	woow.toString();
			System.out.println( Admin.toString());

			int sw=0;
			// Aqui abajo el metodo agrega al usaurio a la BD si no lo agrega manda su numero entero conrrespondiente al error
			sw=DAO_Administrador.AgregarAdministrador(Admin);

			if(sw==1)
			{
				// Aqui ya termino de validar los datos del Usuario 
				// Obtiene la lista de todos los Usuairos o contactos suscriptos y los manda a una nueva pagina JSP
				LinkedList<BeanAdministrador> lista= DAO_Administrador.getContactosAdmin();
				request.setAttribute("Wow", lista); 	 

				response.sendRedirect("ServletAdminDadosDeAlta.html");
				//	request.getRequestDispatcher(pageSuccefull).forward(request, response);

			}
			else
			{
				// Si cai en este bloque else es porque NO se logro ingresar el usuario a la BD
				// abajo estan los distintos tipos de motivos por los cuales no se logro ingresar al usuario
				if(sw==2)
				{
					request.setAttribute("message2", "Matricula duplicada");
				}
				if(sw==0)
				{
					System.out.println("Problemas con la conexión a la base de datos");
				}

				//request.getRequestDispatcher(pageRegistroDeUsaurio).forward(request, response);
				System.out.println("eeeeeeetetttteeeee");
				response.sendRedirect("RegistroDeAdministrador.jsp");
				//	response.sendRedirect("InicioDeSistema.jsp");
			}
		}

		/*		//throw new Exception();
		} catch (Exception ex) {
			// Al cacharlo Se dirije a la pagina principal 
			System.out.println("Error 33 EN EL metodo POST" );
			response.sendRedirect("../../index.html");
		} finally {
			System.out.println("Finally num1");
		}
		 */

	}

}

