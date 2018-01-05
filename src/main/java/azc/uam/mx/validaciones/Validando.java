package azc.uam.mx.validaciones;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import azc.uam.mx.modelo.BeanAdministrador;
import azc.uam.mx.modelo.BeanLibro;
import azc.uam.mx.modelo.BeanUsuario;

public class Validando
{

	//Metodo que regresa un MAP con los errores de la validacion y recibe los atributos del usuario y los valida
	public static Map<String, String>  validateUsuarios(BeanUsuario user)
	{

		Map<String, String> maperror = new HashMap<>();

		// Aqui se usa el framework de hibernate
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		// Aqui se procesa las validaciones del usuario
		Set<ConstraintViolation<BeanUsuario>> cvs = validator.validate(user);     
		if (!cvs.isEmpty())
		{
			for (ConstraintViolation<BeanUsuario> cv : cvs)
			{
				//	System.out.println("** "+cv.getPropertyPath().toString()+"*** "+cv.getMessage());
				maperror.put( cv.getPropertyPath().toString() , cv.getMessage());
			}
		}
		/*--->*/return maperror;
	}


	//Metodo que regresa un MAP con los errores de la validacion y recibe los atributos del usuario y los valida
	public static Map<String, String>  validateAdministrador(BeanAdministrador admin) 
	{

		Map<String, String> maperror = new HashMap<>();

		// Aqui se usa el framework de hibernate
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		// Aqui se procesa las validaciones del usuario
		Set<ConstraintViolation<BeanAdministrador>> cvs = validator.validate(admin);     
		if (!cvs.isEmpty())
		{
			for (ConstraintViolation<BeanAdministrador> cv : cvs)
			{
				//	System.out.println("** "+cv.getPropertyPath().toString()+"*** "+cv.getMessage());
				maperror.put( cv.getPropertyPath().toString() , cv.getMessage());
			}
		}
		/*--->*/return maperror;
	}



	//Metodo que regresa un MAP con los errores de la validacion y recibe los atributos del usuario y los valida
	public static Map<String, String>  validatelibro(BeanLibro libro) 
	{

		Map<String, String> maperror = new HashMap<>();

		// Aqui se usa el framework de hibernate
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		// Aqui se procesa las validaciones del usuario
		Set<ConstraintViolation<BeanLibro>> cvs = validator.validate(libro);     
		if (!cvs.isEmpty())
		{
			for (ConstraintViolation<BeanLibro> cv : cvs) 
			{
				//	System.out.println("** "+cv.getPropertyPath().toString()+"*** "+cv.getMessage());
				maperror.put( cv.getPropertyPath().toString() , cv.getMessage());
			}
		}
		/*--->*/return maperror;
	}


	//Metodo que valida un dato tipo Byte
	public static boolean isByte(String str) {

		int num=0;
		try
		{
			num=Byte.parseByte(str);

			if(0>=num)
			{
		    /*--->*/    return false;
			}
			/*--->*/	return true;

		}catch(Exception e){
			/*--->*/    return false; 
		}
	}



	//Metodo que valida un dato tipo ENTERO
	public static Integer isInteger(String str) {

		Integer num=null;
		try
		{
			num=Integer.parseInt(str);

			if(0>=num)
			{
			/*--->*/    return -1;
			}
			/*--->*/	return num;

		}catch(Exception e){
			/*--->*/    return null; 
		}
	}

	//Metodo que valida un dato tipo LONG
	public static Long isLong(String str) {

		Long num=null;
		try
		{
			num=Long.parseLong(str);

			if(0>=num)
			{
			/*----->*/  return 18l;
			}
			/*----->*/  return num;
		}
		catch(Exception e)
		{
			/*----->*/	return null; 
		}
	}

	// Metodo que pone en mayuscula las primeras letras de las palabras
	public static String converMayus(String cadena) {

		try{	
			String nuevacadena = "";

			if(cadena.equals(""))      
			{
				/*----->*/  return cadena;
			}
			for (String palabra : cadena.split(" "))
			{
				nuevacadena += palabra.substring(0, 1).toUpperCase() + palabra.substring(1, palabra.length()).toLowerCase() + " ";
			}
			/*----->*/  return nuevacadena = nuevacadena.trim();
		}
		catch (Exception e)
		{
			System.out.println("Instrucciones a ejecutar cuando se produce este error"); 
		}
		/*----->*/  return cadena;
	}


}




