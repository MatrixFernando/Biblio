package azc.uam.mx.modelo.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import azc.uam.mx.modelo.BeanLibro;
import azc.uam.mx.modelo.ConexionNueva;

public class DAO_Libro 
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


			try
			{

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




	public static  List<BeanLibro>   getLibros()
	{

		List<BeanLibro> listaLibros=new LinkedList<BeanLibro>();

		ConexionNueva c=new ConexionNueva();
		Connection con= null;

		@SuppressWarnings("unused")
		int agregado=0;


		try {

			con=c.dataSource.getConnection();

			if(con!=null)
			{




				Statement st = con.createStatement();    
				/*--> Query*/ 	ResultSet rs = st.executeQuery("select * from Libro" );

				while (rs.next())
				{
					BeanLibro libros = new BeanLibro();
					// contacto.setId(rs.getInt("id"));
					libros.setISDN(Long.parseLong(rs.getString("ISDN")));
					libros.setTitulo(rs.getString("titulo"));
					libros.setAutor(rs.getString("autor"));
					libros.setEdicion(rs.getString("edicion"));
					libros.setEditorial(rs.getString("editorial"));		
					libros.setCopias_De_Este_Libro(Integer.parseInt(rs.getString("cantidad_de_Libros_Identicos_A_Este")));
					listaLibros.add(libros);
				}

				/*-->*/	 return listaLibros;
			}
		}
		catch (MySQLIntegrityConstraintViolationException e)
		{
			/*-->*/	 return listaLibros;
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

			}
			catch (SQLException ex)
			{

				System.out.println(ex);
				/*-->*/ return listaLibros;
			}

		}
		/*-->*/ return listaLibros;
	}  






	public static void impimirDatos ()
	{

		List<BeanLibro>  ok = getLibros();
		{
			for (int i=0;i<ok.size();i++)
			{
				// out.println("<tr>");
				System.out.println("<tdkkkkkkkkkkkkkkkk>"+ok.get(i).toString()+"</td>");
				System.out.println("<tdggg>"+ok.get(i).toString()+"</td>");
				// System.out.println("<td>"+lista.get(i).getNombre()+"</td>");
				// System.out.println("<tdmmmmm>"+lista.get(i).getDueño()+"</td>");

				System.out.println("</tr>");

			}
		}

	}
}
