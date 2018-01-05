package azc.uam.mx.modelo;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class ConexionNueva {

/*
 * bibliotecaok
 * 127.7.173.130
 * adminEfxRTlC
 * ms8Wu9_pNJHy
 * 
 * Biblioteca
 * localhost
 * root
 * R123
 * 
 */
	
	
    public DataSource dataSource;
/*
    public String db = "bibliotecaok";
    public String url = "jdbc:mysql://127.7.173.130/"+db+"?autoReconnect=true&useSSL=false";
    public String user = "adminEfxRTlC";
    public String pass = "ms8Wu9_pNJHy";
    */
    public String db = System.getenv("db");
    public String url = "jdbc:mysql://localhost/"+db+"?autoReconnect=true&useSSL=false";
    public String user = "root";
    public String pass = "rox123";

    public ConexionNueva()
    {

        inicializaDataSource();

    }

    public void inicializaDataSource()
    {
        BasicDataSource basicDataSource = new BasicDataSource();

        basicDataSource.setDriverClassName("org.gjt.mm.mysql.Driver");
        basicDataSource.setUsername(user);
        basicDataSource.setPassword(pass);
        basicDataSource.setUrl(url);
        basicDataSource.setMaxIdle(50);

        dataSource = basicDataSource;
    }

}
