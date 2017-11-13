package azc.uam.mx.validadores;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
 
import javax.validation.Constraint;
import javax.validation.Payload;




import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
 


 
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DniValidator.class)
public @interface Dni {
   String message() default "{errors.dni.invalid}";
   Class<?>[] groups() default {};
   Class<? extends Payload>[] payload() default {};
}





 class DniValidator implements ConstraintValidator<Dni, String> {
  
   private static Pattern dniPattern;
   private static String cadenaLetras;
  
   public void initialize(Dni dni) {
      dniPattern = Pattern.compile("\\d{8}[a-zA-Z]");
      cadenaLetras = "TRWAGMYFPDXBNJZSQVHLCKE";
   }
 
   public boolean isValid(String value, ConstraintValidatorContext context) {
      if(dniPattern.matcher(value).matches()){
         int num = Integer.parseInt(value.substring(0, value.length()-1));
         String letra = value.substring(value.length()-1);
         int pos = num % 23;
   
         if(cadenaLetras.substring(pos, pos+1).equalsIgnoreCase(letra)){
            return true;
         }
      }
      return false;
   }
}