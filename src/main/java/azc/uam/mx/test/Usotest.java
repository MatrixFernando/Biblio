package azc.uam.mx.test;

public class Usotest {

    public static void main(String[] args) {
        String str1="dd12";
	String str2="0";
        String respuesta;
        
	int numerador, denominador, cociente;
        try{
            numerador=Integer.parseInt(str1);
            denominador=Integer.parseInt(str2);
            cociente=numerador/denominador;
            respuesta=String.valueOf(cociente);
        }catch(NumberFormatException ex){
            respuesta="Se han introducido caracteres no numéricos";
            ex.printStackTrace();
        }catch(ArithmeticException ex){
            respuesta="División entre cero";
        }
        System.out.println(respuesta);
    }

}