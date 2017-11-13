package azc.uam.mx.modelo;

import javax.validation.constraints.*;

import org.hibernate.validator.constraints.NotEmpty;


public class BeanAdministrador
{

	// Atributos del usurio que son 
	// id, nombres, apellidos, edad, correo, matricula, contraseña
	// Todos los atributos se validan
	@Min(value = 100000000l, message="Número Ecónomico no valida debe tener minimo 9 DIGITOS")
    @NotNull(message="No puede estar vacío")
    @Max(value = 1000000000000000000l, message="Número Ecónomico no valida")
/*--->*/private Long numero_economico=0L; 
	
	@Size(min = 2, max = 50, message = "El ó los nombre(s) son minimo de 2 caracteres y  maximo de 50")
	@Pattern(regexp="[^0-9]*", message = "No es un nombre valido")
	@NotEmpty(message = "No puede estar vacío")
/*--->*/private String nombres="";  

	@Pattern(regexp="[^0-9]*", message = "No es un apellido valido")
	@Size(min = 2, max = 50, message = "El ó los apellido(s) deben tener minimo de 2 a maximo 50 Caracteres")
    @NotEmpty(message = "No puede estar vacío")
/*--->*/private String apellido_paterno=""; 
	
	@Pattern(regexp="[^0-9]*", message = "No es un apellido valido")
	@Size(min = 2, max = 50, message = "El ó los apellido(s) deben tener minimo de 2 a maximo 50 Caracteres")
    @NotEmpty(message = "No puede estar vacío")
/*--->*/private String apellido_materno=""; 

	@NotNull(message="No puede estar vacio")
	@Min(value = 18, message="Solo mayores de edad")
	@Max(value = 140, message="Edad no valida")
/*--->*/private Integer edad=null; 

    @Pattern(regexp="^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,5}",  message="Este no es un email valido") 
    @NotEmpty(message = "No puede estar vacío")
	@Size( max = 320, message = "Este no es un email valido")
/*--->*/private String correo="";  

	@AssertTrue(message="La contraseña no coincide")
	private boolean isPasswordValido2()
	{
		 if ((contrasenia!=null) && (!contrasenia.equals(confirmarcontrasenia))) {
	        return false;
	}
		 else 
		 {
	        return true;
	     }
	}
	@Size( min = 8, message = "Esta no es una contrseña valida minimo 8 caracteres")
/*--->*/private String contrasenia="";  //<------------
	@Size( max = 16, message = "Este no es una contrseña valida maximo 16 caracteres")
	@NotEmpty(message="No puede estar vacío")
/*--->*/private String confirmarcontrasenia="";   
	
	
	//Constructor sin parametros
	public BeanAdministrador() {}
	
	
	//Constructor con todos los atributos menos el ID
	public BeanAdministrador(Long numero_economico, String nombres, String apellido_paterno, String apellido_materno, Integer edad, String correo, String contrasenia)
	{
		this.numero_economico=numero_economico;
		this.nombres=nombres;
		this.apellido_paterno=apellido_paterno;
		this.apellido_materno=apellido_materno;
		this.edad=edad;
		this.correo=correo;
		this.contrasenia=contrasenia;
	//	this.confirmarcontrasenia=confirmarcontrasenia;
	}
	
	public String toString ()
	{
		String mensaje="Los argumentos son::::::: "+numero_economico+" "+nombres+" "+apellido_paterno+" "+apellido_materno+" "+edad+" "+correo+" "+contrasenia+" kkk";
		return mensaje;
	}
	
	
// metodos GET
	
	
	public Long getNumero_economico() {
		return numero_economico;
	}

	
	public String getNombres() {
		return nombres;
	}
	 
public String getApellido_paterno() {
	return apellido_paterno;
}
public String getApellido_materno() {
	return apellido_materno;
}
	public Integer getEdad() {
		return edad;
	}
	public String getCorreo() {
		return correo;
	}

	
	public String getContrasenia() {
		return contrasenia;
	}
	public String getConfirmarcontrasenia() {
		return confirmarcontrasenia;
	}
	

// metodos SET

	public void setNumero_economico(Long numero_economico) {
		this.numero_economico = numero_economico;
	}
	
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public void setApellido_paterno(String apellido_paterno) {
		this.apellido_paterno = apellido_paterno;
	}

	public void setApellido_materno(String apellido_materno) {
		this.apellido_materno = apellido_materno;
	}
	
	
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public void setConfirmarcontrasenia(String confirmarcontrasenia) {
		this.confirmarcontrasenia = confirmarcontrasenia;
	}
	
}
