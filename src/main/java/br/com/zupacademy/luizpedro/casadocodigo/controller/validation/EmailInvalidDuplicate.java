package br.com.zupacademy.luizpedro.casadocodigo.controller.validation;

import br.com.zupacademy.luizpedro.casadocodigo.dto.AutorRequest;
import br.com.zupacademy.luizpedro.casadocodigo.model.Autor;
import br.com.zupacademy.luizpedro.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class EmailInvalidDuplicate implements Validator {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public boolean supports(Class<?> aClass) {

        return AutorRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if(errors.hasErrors()){
            return;
        }
        AutorRequest autorRequest = (AutorRequest) o;
        Optional<Autor> autor = autorRepository.findByEmail(autorRequest.getEmail());

        if(autor.isPresent()){
            errors.rejectValue("email", null, "Email "+autorRequest.getEmail()+" existente");
        }

    }
}
