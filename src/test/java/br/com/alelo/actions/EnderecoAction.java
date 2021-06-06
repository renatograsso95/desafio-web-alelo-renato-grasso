package br.com.alelo.actions;

import org.junit.Assert;

import br.com.alelo.core.BaseAction;
import br.com.alelo.core.PropertyReader;
import br.com.alelo.pages.EnderecoPage;

public class EnderecoAction extends BaseAction {

    private EnderecoPage buscaEnderecoPage = new EnderecoPage();

    public void confirmarTelaBuscaEnderecoCarregada() {
        dsl.changeBrowser();
        verificarElementosCarregadoNaPage(buscaEnderecoPage.menu, buscaEnderecoPage.trilha,
                buscaEnderecoPage.btnVoltar);
    }

    public void validarRetorno() {
        try {
            String retornoMensagem = dsl.text(buscaEnderecoPage.mensagemResultado);
            if (!retornoMensagem.contains(PropertyReader.getProperty("web.busca.not.expected"))) {
                String lista = dsl.listTable(buscaEnderecoPage.table);
                System.out.println("[PASSED] Retorno da Lista: \n" + lista);
            } else {
                Assert.fail("Lista retornou vazia: \n" + retornoMensagem);
            }
        } catch (Exception e) {
            Assert.fail("Não foi possível validar lista.\nErro: \n" + e.getMessage());
        }

    }
}