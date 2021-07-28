package br.com.zupacademy.luizpedro.casadocodigo.controller.validation;

import br.com.zupacademy.luizpedro.casadocodigo.dto.AutorRequest;
import br.com.zupacademy.luizpedro.casadocodigo.dto.CategoriaRequest;
import br.com.zupacademy.luizpedro.casadocodigo.model.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

public class GenericInvalidDuplicate implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }

    @Override
    public void validate(Object o, Errors errors) {
    }
}
