package br.com.warnit.validators.impl;

import br.com.warnit.model.domain.Usuario;
import br.com.warnit.service.UsuarioService;
import br.com.warnit.validators.annotations.EmailUniqueValid;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailUniqueValidator implements ConstraintValidator<EmailUniqueValid, Object> {

    @Autowired
    private UsuarioService usuarioService;
    private String email;
    private String message;
    private String id;

    @Override
    public void initialize(EmailUniqueValid constraintAnnotation) {
        this.email = constraintAnnotation.email();
        this.message = constraintAnnotation.message();
        this.id = constraintAnnotation.id();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        boolean result = true;
        try{
            final String email = BeanUtils.getProperty(o, this.email);
            final String id = BeanUtils.getProperty(o, this.id);
            Usuario usuario = usuarioService.findByEmail(email);
            if(id != null || !id.isEmpty()){
                if(!usuario.getId().equals(Long.parseLong(id))){
                    result = false;
                }
            }
        }catch (Exception e){
            result = false;
        }

        if(!result){
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(message)
                    .addPropertyNode("email").addConstraintViolation();
        }
        return result;
    }
}
