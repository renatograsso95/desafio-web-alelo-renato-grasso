package br.com.alelo.stepDefinition;

import br.com.alelo.actions.EnderecoAction;
import br.com.alelo.actions.HomeAction;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class PesquisaStep {

    private HomeAction home = new HomeAction();
    private EnderecoAction buscaEndereco = new EnderecoAction();




    @Dado("que eu estou no site do Correios")
    public void que_eu_estou_no_site_do_correios() {
        home.confirmarTelaHomeCarregada();
    }

    @Quando("realizar a pesquisa por {string}")
    public void realizar_a_pesquisa_por(String texto) {
        home.pesquisar(texto);

    }

    @Entao("ira retorna o output das informacoes solicitadas")
    public void ira_retorna_o_output_das_informacoes_solicitadas() {
        buscaEndereco.confirmarTelaBuscaEnderecoCarregada();
        buscaEndereco.validarRetorno();    }
}