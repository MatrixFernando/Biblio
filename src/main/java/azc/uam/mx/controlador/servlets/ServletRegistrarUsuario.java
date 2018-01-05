package azc.uam.mx.controlador.servlets;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import azc.uam.mx.modelo.BeanUsuario;
import azc.uam.mx.modelo.DAO.DAO_Usuario;
import azc.uam.mx.validaciones.Validando;


public class ServletRegistrarUsuario extends HttpServlet {

	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletRegistrarUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();

		Long ok = (Long) session.getAttribute("NumEco");

		if(ok==null)
		{
			try {
				System.out.println("you you ");
				//	response.getWriter().append("Served at: ").append(request.getContextPath());
				//	doPost(request, response);
				throw new Exception();
			} catch (Exception ex)
			{
				System.out.println("Error 22" );
				response.sendRedirect("../index.html");
				//     System.out.println("Error 22"+ex);
			}
			finally
			{
				System.out.println("Finally num 11 SErvletRefistroDeUsaurio");
			}
		}
		else
		{
			System.out.println("iiiiiiiiooiiiiiiiii");
			request.getRequestDispatcher("/Codigo/ServletUsuariosDadosDeAlta.html").forward(request, response);
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
				String pageRegistroDeUsaurio = "/Codigo/RegistroDeUsuario.jsp";
				String pageSuccefull   =       "/Codigo/ServletUsuariosDadosDeAlta.html";

				BeanUsuario user = new BeanUsuario();

				// --->>> Aqui ahy un error con el goole con el null pointexception hay que capturarlo con un tray cach     
				user.setNombres(Validando.converMayus(request.getParameter("nombres"))); //<------------
				user.setApellido_paterno(Validando.converMayus(request.getParameter("apellido_paterno"))); //<------------
				user.setApellido_materno(Validando.converMayus(request.getParameter("apellido_materno"))); //<------------   
				user.setEdad(Validando.isInteger(request.getParameter("edad")));
				user.setCorreo(request.getParameter("correo"));  //<------------
				user.setContrasenia(request.getParameter("contrasenia")); //<------------
				user.setConfirmarcontrasenia(request.getParameter("confirmarcontrasenia")); //<------------
				/*
	        String edad = request.getParameter("edad"); 
	        if(edad.equals(""))
	        {
	        	user.setEdad(null);
	        }  else {
	        	if(Validando.isNumericInteger(edad))
	        	{
	        		user.setEdad( Integer.parseInt(edad));              //<------------
	        	}else {
	        		user.setEdad(150); 
	        	}
	        }
				 */

				//   String matricula =request.getParameter("matricula"); 
				//user.setMatricula(Validando.isNumericLong(request.getParameter("matricula")));
				System.out.println("MMMAtriculaaa");

				/*   if(matricula.equals(""))
	        {
	        	user.setMatricula(null);
	        }  else {
	        	if(Validando.isNumericLong(matricula))
	        	{
	        		user.setMatricula(Long.parseLong(matricula));     //<------------
	        	}else{
	        		user.setMatricula(1l);
	        	}
	        }*/

				Map<String, String> errors = Validando.validateUsuarios(user);
				String codeo="";
				String message="";
				if ( !errors.isEmpty())
				{

					Set<String> setCodes = errors.keySet();
					Iterator<String> iterator = setCodes.iterator();

					while (iterator.hasNext())
					{
						codeo = iterator.next();
						message = errors.get(codeo);
						request.setAttribute(codeo, message);
						//	request.setAttribute("ok",codeo);
						//	System.out.println(codeo);
					}
					//	request.setAttribute("ok",codeo);
					//	System.out.println("jjjj"+errors.get(codeo));
					//	System.out.println("****"+codeo);
					//	System.out.println("mmmm"+message);
					//	<%= request.getAttribute("codeo") %>
					//	response.sendRedirect("RegistroDeUsuario.jsp");
					request.getRequestDispatcher(pageRegistroDeUsaurio).forward(request, response);
				}
				else
				{

					int sw=0;
					sw=DAO_Usuario.agregarUsuario(user);
					//  sw=Usuario.agregarUsuario(user);

					if(sw==1)
					{
						// Linkedlist
						//	 Usuario ok = new Usuario();
						LinkedList<BeanUsuario> listaaaaa= DAO_Usuario.getUsuarios();

						//		 Map<String, String> errors = Validando.validate(user);
						System.out.println("Aquiiii000****"+listaaaaa);
						request.setAttribute("Wow", listaaaaa);

						//	 <c:forEach items="${listContactos}" var="item"> 

						System.out.println("---> aquiiii 111 " + sw );
						System.out.println("si llega?");


						request.getRequestDispatcher(pageSuccefull).include(request, response);

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
							// request.setAttribute("message2", "Matricula duplicada");
						}
						request.getRequestDispatcher(pageRegistroDeUsaurio).forward(request, response);
					}
				}








			}
			finally {
				System.out.println("Finally num333 SErvletRefistroDeUsaurio");
			}
		}else {
			System.out.println("iiiiiiiiiiiiiiiii");
			request.getRequestDispatcher("/Codigo/ServletUsuariosDadosDeAlta.html").forward(request, response);
		}

	}
}
