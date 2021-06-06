package br.com.alelo.core;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;

public class BaseAction {

    protected DSL dsl;

    public BaseAction() {
        dsl = new DSL();
    }

    public void verificarElementosCarregadoNaPage(By... elements) {
        try {
            for (By element : elements) {
                if(!dsl.isVisible(element)) {
                    throw new NotFoundException("Elemento esperado em tela não encontrado " + element);
                }
            }
        } catch (NotFoundException e) {
            throw new NotFoundException("Tela parcialmente carregada ou não carregada totalmente. ", e);
        }
    }

    public void assertiva(By locator, String keyProperty) {
        String texto = dsl.text(locator).replaceAll("\\s+", " ");
        Assert.assertEquals(PropertyReader.getProperty(keyProperty), texto);
    }

    public void validationTitle(String keyProperty) {
        String texto = dsl.getTitle();
        Assert.assertEquals(PropertyReader.getProperty(keyProperty), texto);
    }
}