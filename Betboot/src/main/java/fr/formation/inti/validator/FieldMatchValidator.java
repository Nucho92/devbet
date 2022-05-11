package fr.formation.inti.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Component;

import fr.formation.inti.ann.FieldMatch;



@Component
public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {

	private String password;
    private String confirmPassword;
    private String message;

    @Override
    public void initialize(FieldMatch constraintAnnotation) {
        this.password = constraintAnnotation.password();
        this.confirmPassword = constraintAnnotation.confirmPassword();
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
    	boolean valid = true;
        Object passwordValue = new BeanWrapperImpl(value).getPropertyValue(password);
        Object confirmPasswordValue = new BeanWrapperImpl(value).getPropertyValue(confirmPassword);
        
        valid =  passwordValue == null && confirmPasswordValue == null || passwordValue != null && passwordValue.equals(confirmPasswordValue);
        
        if (!valid){
            constraintValidatorContext.buildConstraintViolationWithTemplate(message)
                    .addPropertyNode(password)
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
        }
 
        return valid;
    }

}
