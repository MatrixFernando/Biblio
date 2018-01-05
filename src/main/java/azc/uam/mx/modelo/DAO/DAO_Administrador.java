package azc.uam.mx.modelo.DAO;


import java.sql.*;
import java.util.LinkedList;


import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import azc.uam.mx.modelo.BeanAdministrador;

import azc.uam.mx.modelo.ConexionNueva;

public class DAO_Administrador
{
	public static int AgregarAdministrador(BeanAdministrador Admin)
	{                                                  

		ConexionNueva metodospool = new ConexionNueva();
		Connection cn = null;
		@SuppressWarnings("unused")
		int agregado=0;
		String sql = "INSERT INTO Administrador " +
				"(Numero_Economico, Nombres, Apellido_Paterno, Apellido_Materno, Edad, Email, Contrasenia) VALUES (?, ?, ?,?,?,?,?)";
		try
		{
			cn=metodospool.dataSource.getConnection();

			if(cn!=null)
			{


				PreparedStatement ps = cn.prepareStatement(sql);
				ps.setLong(1, Admin.getNumero_economico());
				ps.setString(2, Admin.getNombres());
				ps.setString(3, Admin.getApellido_paterno());
				ps.setString(4, Admin.getApellido_materno());
				ps.setInt(5, Admin.getEdad());
				ps.setString(6, Admin.getCorreo());
				ps.setString(7, Admin.getContrasenia());
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




	public static LinkedList<BeanAdministrador> getContactosAdmin()
	{
		LinkedList<BeanAdministrador> listaDeAdministradores=new LinkedList<BeanAdministrador>();

		ConexionNueva c=new ConexionNueva();
		Connection con= null;

		try 
		{

			con=c.dataSource.getConnection();

			if(con!=null)
			{

				Statement st = con.createStatement();
				/*--> Query*/ 	ResultSet rs = st.executeQuery("select * from Administrador" );

				while (rs.next())
				{
					BeanAdministrador contacto = new BeanAdministrador();
					// contacto.setId(rs.getInt("id"));
					contacto.setNumero_economico(Long.parseLong(rs.getString("numero_economico")));
					contacto.setNombres(rs.getString("nombres"));
					contacto.setApellido_paterno(rs.getString("apellido_paterno"));
					contacto.setApellido_materno(rs.getString("apellido_materno"));
					contacto.setEdad(Integer.parseInt(rs.getString("edad")));		
					contacto.setCorreo(rs.getString("Email"));
					contacto.setContrasenia(rs.getString("contrasenia"));
					listaDeAdministradores.add(contacto);
				}

				/*-->*/	 return listaDeAdministradores;
			}
		}
		catch (MySQLIntegrityConstraintViolationException e)
		{
			/*-->*/	 return listaDeAdministradores;
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
				/*-->*/ return listaDeAdministradores;
			}

		}
		/*-->*/ return listaDeAdministradores;
	}  




	public static long getValidarSessionDeUsuario(String numero_economico, String contrasenia)
	{
		//	LinkedList<BeanAdministrador> listaDeAdministradores=new LinkedList<BeanAdministrador>();



		String num_eco=numero_economico;
		String contra=contrasenia;

		long NE=0l;
		ConexionNueva c=new ConexionNueva();
		Connection con= null;

		try 
		{

			con=c.dataSource.getConnection();

			if(con!=null)
			{

				Statement st = con.createStatement();
				/*--> Query*/ 	ResultSet rs = st.executeQuery("select Numero_Economico  from Administrador where Numero_Economico =" +num_eco+" and Contrasenia = "+ contra );

				while (rs.next())
				{

					NE=rs.getLong("Numero_Economico");

				}
				System.out.println("---> BIEN 1 <---");
				/*-->*/	 return NE;
			}
		}
		catch (MySQLIntegrityConstraintViolationException e)
		{
			System.out.println("Fallo 111 -->"+e);
			/*-->*/	 return NE;
		}	

		catch (SQLException e) 
		{

			//System.out.println(e);
			System.out.println("Fallo 222 -->"+e);
			return NE;
		}
		finally
		{

			try 
			{

				con.close();

			} 
			catch (SQLException ex)
			{

				System.out.println("Fallo 333-->"+ex);
				return NE;
			}

		}
		System.out.println("-->BIEN 2<--");
		/*-->*/ return NE;
	}  

}