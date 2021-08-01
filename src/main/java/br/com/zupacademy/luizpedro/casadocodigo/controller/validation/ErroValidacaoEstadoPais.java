package br.com.zupacademy.luizpedro.casadocodigo.controller.validation;

public class ErroValidacaoEstadoPais {

    public ErroValidacaoEstadoPais(String nomeEstado, Long idPais){
        this.erro = nomeEstado + " já existente no país "+idPais;
    }

    private String erro;

    public String getErro() {
        return erro;
    }
}
