package br.com.alelo.core;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DSL {


    /*Utilização de DSL
    * por conta de cenário mais curto e melhor utilização neste caso
    */
    public void write(By by, String texto) {
        DriverFactory.getDriver().findElement(by).clear();
        DriverFactory.getDriver().findElement(by).sendKeys(texto);
    }

    public void pressEnter(By by, String texto) {
        write(by, texto);
        DriverFactory.getDriver().findElement(by).sendKeys(Keys.ENTER);
    }


    public String text(By by) {
        return DriverFactory.getDriver().findElement(by).getText();
    }


    public String getTitle() {
        return DriverFactory.getDriver().getTitle();
    }


    public String listTable(By lista) {
        WebElement table = DriverFactory.getDriver().findElement(lista);
        String body = table.findElement(By.xpath("./tbody")).getText();
        return body;
    }

//Explicit
    public void locatorVisible(By locator) {
        DriverFactory.getWaitDriver().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public boolean isVisible(By locator) {
        try {
            locatorVisible(locator);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    //Metodo para abrir novo navegador apos execução da feature
    public void changeBrowser() {
        String winHandleBefore = DriverFactory.getDriver().getWindowHandle();
        DriverFactory.getDriver().switchTo().window(winHandleBefore);
        DriverFactory.getDriver().close();
        for (String winHandle : DriverFactory.getDriver().getWindowHandles()) {
            DriverFactory.getDriver().switchTo().window(winHandle);
        }
    }

}