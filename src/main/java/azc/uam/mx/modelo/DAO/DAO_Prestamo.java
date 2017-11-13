package azc.uam.mx.modelo.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import azc.uam.mx.modelo.BeanLibro;
import azc.uam.mx.modelo.BeanPrestamo;
import azc.uam.mx.modelo.BeanUsuario;
import azc.uam.mx.modelo.ConexionNueva;

public class DAO_Prestamo
{

	//private static final LinkedList<BeanAnimal> BeanAnimal = null;



	public static int agregarLibro(BeanLibro libro)
	{

		ConexionNueva metodospool = new ConexionNueva();
		Connection cn = null;
		@SuppressWarnings("unused")
		int agregado=0;
		String sql = "INSERT INTO Libro VALUES (?, ?, ?,?,?,?)";

		try 
		{


			cn=metodospool.dataSource.getConnection();

			if(cn!=null)
			{

				PreparedStatement ps = cn.prepareStatement(sql);

				ps.setLong(1, libro.getISDN());
				ps.setString(2, libro.getTitulo());
				ps.setString(3, libro.getAutor());
				ps.setString(4, libro.getEdicion());
				ps.setString(5, libro.getEditorial());
				ps.setInt(6, libro.getCopias_De_Este_Libro());

				ps.executeUpdate();
				ps.close();


				/*-->*/ return agregado=1;
			}

			/*-->*/	 return agregado=2;
		}
		catch (MySQLIntegrityConstraintViolationException e)
		{
			/*-->*/	 return agregado=3;
		}	

		catch (SQLException e) 
		{

			System.out.println(e);

		}
		finally
		{


			try {

				cn.close();

			} 
			catch (SQLException ex) 
			{

				System.out.println(ex);
				/*-->*/ return agregado=4;
			}

		}
		/*-->*/ return agregado=5;
	}


	/*

public    List<?>   getPrestamos()
{


	List<Date> listadePrestamosDatos=new LinkedList<Date>();
	List<Long> listadePrestamosLong=new LinkedList<Long>();
	ArrayList<?> nombreArray = new ArrayList<>();

	ConexionNueva c=new ConexionNueva();
		Connection con= null;

		@SuppressWarnings("unused")
		int agregado=0;


		try {

			con=c.dataSource.getConnection();

			if(con!=null){

		Date FDP, FDD;
		Long Matri, isdn;


		Statement st = con.createStatement();    
/*--> Query*/ 	// ResultSet rs = st.executeQuery("select * from Prestamo;" );


	//Lista de tipo beamPrestamo
	//List<eanPrestamo> myLista = new 

	//-	while (rs.next())
	//--	{

	//BeanLibro libros = new BeanLibro();
	// contacto.setId(rs.getInt("id"));
	//-			listadePrestamosDatos.add( FDP = rs.getDate("Fecha_De_Prestamo"));
	//-			listadePrestamosDatos.add( FDD = rs.getDate("Fecha_De_Devolucion"));
	//-			listadePrestamosLong.add( Matri = rs.getLong("Matricula"));
	//-			listadePrestamosLong.add( isdn = rs.getLong("ISDN"));

	//crear obj de tipo BeanPrestamo

	//myLista.add(date1,long1);
	//myLista.add(date2,long2)

	//-			nombreArray.add(  listadePrestamosDatos);
	//-			nombreArray.add( listadePrestamosLong);
	//-			System.out.println(FDP +" "+ FDD +" "+Matri+" "+isdn);

	//--		}

	/*-->*/	//-- return nombreArray;
	//-	}}catch (MySQLIntegrityConstraintViolationException e)
	//-  {
	/*-->*/	 //-return nombreArray;
	//return myLista;
	//-		 }	

	/*		 catch (SQLException e) {

			System.out.println(e);

		}finally{


			try {

				con.close();

			} catch (SQLException ex) {

				System.out.println(ex);
				/*-->*/ //-- return listadePrestamos;
	//-}

	//-}
	/*-->*///-- return listadePrestamos;
	//-	}  


	public  static   LinkedList<BeanPrestamo>    getPrestamos()
	{
		LinkedList<BeanPrestamo> listadePrestamosDatos=new LinkedList<BeanPrestamo>();

		//	List<BeanUsuario> listadePrestamosDatos=new LinkedList<BeanUsuario>();
		//	List<BeanLibro> listadePrestamosLong=new LinkedList<BeanLibro>();
		//	ArrayList<?> nombreArray = new ArrayList<>();

		ConexionNueva c=new ConexionNueva();
		Connection con= null;

		@SuppressWarnings("unused")
		int agregado=0;


		try 
		{
			con=c.dataSource.getConnection();

			if(con!=null)
			{

				//	Date FDP, FDD;
				//	Long Matri, isdn;


				Statement st = con.createStatement();    
				/*--> Query*/ 	 ResultSet rs = st.executeQuery("Select  Prestamo.Fecha_De_Prestamo, Prestamo.Fecha_De_Devolucion, "
						+ "Usuario.Nombres, Usuario.Apellido_Paterno, Usuario.Apellido_Materno, "
						+ "Libro.Titulo, Libro.Autor, Libro.Edicion "
						+ "from Prestamo, Usuario, Libro "
						+ "where Prestamo.Matricula = Usuario.Matricula and Prestamo.ISDN = Libro.ISDN" );

				//	Select  Prestamo.Fecha_De_Prestamo, Prestamo.Fecha_De_Devolucion, "
				//			+ "Usuario.Nombres, Usuario.Apellido_Paterno, Usuario.Apellido_Materno, "
				//			+ "Libro.Titulo, Libro.Autor, Libro.Edicion "
				//			+ "from Prestamo, Usuario, Libro "
				//			+ "where Prestamo.Matricula = Usuario.Matricula and Prestamo.ISDN = Libro.ISDN

				//Lista de tipo beamPrestamo
				//List<eanPrestamo> myLista = new 

				while (rs.next())
				{

					BeanPrestamo Prestamo_ok = new BeanPrestamo();
					BeanUsuario Usuario_Prestamo = new BeanUsuario();
					BeanLibro libros_Prestamos = new BeanLibro();

					Prestamo_ok.setFecha_de_prestamo(rs.getDate("Fecha_De_Prestamo"));
					Prestamo_ok.setFecha_de_devolucion(rs.getDate("Fecha_De_Devolucion"));
					Usuario_Prestamo.setNombres(rs.getString("Nombres"));
					Usuario_Prestamo.setApellido_paterno(rs.getString("Apellido_Paterno"));
					Usuario_Prestamo.setApellido_materno(rs.getString("Apellido_Materno"));
					libros_Prestamos.setTitulo(rs.getString("Titulo"));
					libros_Prestamos.setAutor(rs.getString("Autor"));
					libros_Prestamos.setEdicion(rs.getString("Edicion"));
					Prestamo_ok.setHeredausuario(Usuario_Prestamo);
					Prestamo_ok.setHeredalibro(libros_Prestamos);

					listadePrestamosDatos.add(Prestamo_ok);
				}

				/*-->*/	 return listadePrestamosDatos;
			}
		}
		catch (MySQLIntegrityConstraintViolationException e)
		{
			/*-->*/	return listadePrestamosDatos;

		}	

		catch (SQLException e) 
		{

			System.out.println(e);

		}
		finally
		{


			try 
			{

				con.close();

			} catch (SQLException ex) {

				System.out.println(ex);
				/*-->*/ return listadePrestamosDatos;
			}

		}
		/*-->*/  return listadePrestamosDatos;
	}  



	public static void impimirDatos ()
	{

		LinkedList<BeanPrestamo>  ok = getPrestamos();

		for (int i=0;i<ok.size();i++)
		{
			// out.println("<tr>");
			System.out.println(" "+ ok.size());
			System.out.println("<tdkkk>"+ok.get(i).getFecha_de_prestamo()+"</td>");
			System.out.println("<tdggg>"+ok.get(i).getFecha_de_devolucion()+"</td>");
			System.out.println("<tdggg>"+ok.get(i).getHeredausuario().getApellido_paterno()+"</td>");
			System.out.println("<tdggg>"+ok.get(i).getHeredalibro().getTitulo()+"</td>");

			// System.out.println("<td>"+lista.get(i).getNombre()+"</td>");
			// System.out.println("<tdmmmmm>"+lista.get(i).getDueño()+"</td>");

			System.out.println("</tr>");

		}

	}

}



