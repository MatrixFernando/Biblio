package azc.uam.mx.modelo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class BeanLibro {
	
	
	@Min(value = 100000000l, message="Matricula no valida debe tener minimo 9 DIGITOS")
    @NotNull(message="No puede estar vacío")
    @Max(value = 1000000000000000000l, message="Matricula no valida")
	private Long ISDN=null;
	
	@Size(min = 2, max = 50, message = "El ó los nombre(s) son minimo de 2 caracteres y  maximo de 50")
	@NotEmpty(message = "No puede estar vacío")
	private String Titulo="";
	
	
	@Size(min = 2, max = 50, message = "El ó los nombre(s) son minimo de 2 caracteres y  maximo de 50")
	@NotEmpty(message = "No puede estar vacío")	
	private String Autor="";
	
	@Size(min = 2, max = 50, message = "El ó los nombre(s) son minimo de 2 caracteres y  maximo de 50")
	@NotEmpty(message = "No puede estar vacío")
	private String Edicion = ""; 
	
	@Size(min = 2, max = 50, message = "El ó los nombre(s) son minimo de 2 caracteres y  maximo de 50")
	@NotEmpty(message = "No puede estar vacío")
	private String Editorial = ""; 
	
	@Min(value = 1, message="Matricula no valida debe tener minimo 9 DIGITOS")
    @NotNull(message="No puede estar vacío")
    @Max(value = 1000, message="Matricula no valida")
	private Integer Copias_De_Este_Libro=null;
	
	public BeanLibro(){}
	
	public BeanLibro(Long ISDN, String Titulo,  String Autor, String Edicion, String Editorial, Integer Copias_De_Este_Libro)
	{
		this.ISDN=ISDN;
		this.Titulo=Titulo;
		this.Autor=Autor;
		this.Edicion=Edicion;
		this.Editorial=Editorial;
		this.Copias_De_Este_Libro=Copias_De_Este_Libro;
}
	
	public String toString (){
		String mensaje="Los argumentos son "+ISDN+" " +Titulo +"  "+Autor+" "+"Edicion"+"Editorial"+"Copias_De_Este_Libro";
		return mensaje;
	}

	public Long getISDN() {
		return ISDN;
	}
	public void setISDN(Long ISDN) {
		this.ISDN = ISDN;
	}

	public String getTitulo() {
		return Titulo;
	}
	public void setTitulo(String titulo) {
		this.Titulo = titulo;
	}

	public String getAutor() {
		return Autor;
	}
	public void setAutor(String autor) {
		this.Autor = autor;
	}

	public String getEdicion() {
		return Edicion;
	}
	public void setEdicion(String edicion) {
		this.Edicion = edicion;
	}

	public String getEditorial() {
		return Editorial;
	}

	public void setEditorial(String editorial) {
		this.Editorial = editorial;
	}

	public Integer getCopias_De_Este_Libro() {
		return Copias_De_Este_Libro;
	}

	public void setCopias_De_Este_Libro(Integer copias_De_Este_Libro) {
		this.Copias_De_Este_Libro = copias_De_Este_Libro;
	}

	
	
}