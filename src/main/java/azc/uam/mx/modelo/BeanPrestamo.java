package azc.uam.mx.modelo;

import java.util.Date;

public class BeanPrestamo {

	private Long idprestamo=0l;
	private Date fecha_de_prestamo=null;
	private Date fecha_de_devolucion=null;
	private BeanUsuario heredausuario=null;
	private BeanLibro heredalibro=null;
	
	public Long getIdprestamo() {
		return idprestamo;
	}
	public Date getFecha_de_prestamo() {
		return fecha_de_prestamo;
	}
	public Date getFecha_de_devolucion() {
		return fecha_de_devolucion;
	}

	public BeanUsuario getHeredausuario() {
		return heredausuario;
	}
	public BeanLibro getHeredalibro() {
		return heredalibro;
	}
	public void setIdprestamo(Long idprestamo) {
		this.idprestamo = idprestamo;
	}
	public void setFecha_de_prestamo(Date fecha_de_prestamo) {
		this.fecha_de_prestamo = fecha_de_prestamo;
	}
	public void setFecha_de_devolucion(Date fecha_de_devolucion) {
		this.fecha_de_devolucion = fecha_de_devolucion;
	}
	public void setHeredausuario(BeanUsuario heredausuario) {
		this.heredausuario = heredausuario;
	}
	public void setHeredalibro(BeanLibro heredalibro) {
		this.heredalibro = heredalibro;
	}
	
}



