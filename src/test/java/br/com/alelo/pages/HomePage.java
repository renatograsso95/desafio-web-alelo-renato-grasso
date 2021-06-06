package br.com.alelo.pages;

import org.openqa.selenium.By;

public class HomePage {

    public final By inputPesquisa = By.name("relaxation");
    public final By barraMenu = By.className("banner-principal-g");
    public final By cardBuscaEndereco = By.xpath("(//div[contains(@class,'card card-mais-acessados')])[2]");

}