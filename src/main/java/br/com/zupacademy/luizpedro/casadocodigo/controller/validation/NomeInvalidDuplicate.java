package br.com.zupacademy.luizpedro.casadocodigo.controller.validation;

import br.com.zupacademy.luizpedro.casadocodigo.dto.CategoriaRequest;
import br.com.zupacademy.luizpedro.casadocodigo.model.Categoria;
import br.com.zupacademy.luizpedro.casadocodigo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class NomeInvalidDuplicate implements Validator {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return CategoriaRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if(errors.hasErrors()){
            return;
        }

        CategoriaRequest categoriaRequest = (CategoriaRequest) o;
        Optional<Categoria> categoria = categoriaRepository.findByNome(categoriaRequest.getNome());

        if(categoria.isPresent()){
            errors.rejectValue("nome", null, "Nome "+categoriaRequest.getNome()+" existente");
        }



    }
}
