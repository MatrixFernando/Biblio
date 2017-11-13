package azc.uam.mx.modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import azc.uam.mx.modelo.BeanUsuario;
import azc.uam.mx.modelo.ConexionNueva;

public class DAO_Usuario 
{

	// Metodo que inserta al Usuario a la BD
	public static int agregarUsuario(BeanUsuario usuario)
	{

		ConexionNueva metodospool = new ConexionNueva();
		Connection cn = null;
		@SuppressWarnings("unused")
		int agregado=0;
		String sql = "INSERT INTO Usuario VALUES (?, ?, ?,?,?,?,?)";

		try
		{

			cn=metodospool.dataSource.getConnection();

			if(cn!=null)
			{

				PreparedStatement ps = cn.prepareStatement(sql);

				ps.setLong(1, usuario.getMatricula());
				ps.setString(2, usuario.getNombres());
				ps.setString(3, usuario.getApellido_paterno());
				ps.setString(4, usuario.getApellido_materno());
				ps.setInt(5, usuario.getEdad());
				ps.setString(6, usuario.getCorreo());
				ps.setString(7, usuario.getContrasenia());
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



	// Metodo que Obtiene todos los atributos del usuario
	public static LinkedList<BeanUsuario> getUsuarios()
	{

		LinkedList<BeanUsuario> listaDeUsuario=new LinkedList<BeanUsuario>();

		ConexionNueva c=new ConexionNueva();
		Connection con= null;

		@SuppressWarnings("unused")
		int agregado=0;


		try 
		{

			con=c.dataSource.getConnection();

			if(con!=null)
			{




				Statement st = con.createStatement();
				/*--> Query*/ 	ResultSet rs = st.executeQuery("select * from Usuario" );

				while (rs.next())
				{
					BeanUsuario contacto = new BeanUsuario();
					// contacto.setId(rs.getInt("id"));
					contacto.setMatricula(Long.parseLong(rs.getString("matricula")));
					contacto.setNombres(rs.getString("nombres"));
					contacto.setApellido_paterno(rs.getString("apellido_paterno"));
					contacto.setApellido_materno(rs.getString("apellido_materno"));
					contacto.setEdad(Integer.parseInt(rs.getString("edad")));		
					contacto.setCorreo(rs.getString("Email"));
					contacto.setContrasenia(rs.getString("contrasenia"));
					listaDeUsuario.add(contacto);
				}

				/*-->*/	 return listaDeUsuario;
			}
		}
		catch (MySQLIntegrityConstraintViolationException e)
		{
			/*-->*/	 return listaDeUsuario;
		}	

		catch (SQLException e) 
		{

			System.out.println(e);


		}
		finally
		{

			try {

				con.close();

			} 
			catch (SQLException ex) 
			{

				System.out.println(ex);
				/*-->*/ return listaDeUsuario;
			}

		}
		/*-->*/ return listaDeUsuario;
	}

}
