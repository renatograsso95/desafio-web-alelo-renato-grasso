package br.com.alelo.Hook;

import static br.com.alelo.core.DriverFactory.getDriver;
import static br.com.alelo.core.DriverFactory.killDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.com.alelo.core.DriverFactory;
import br.com.alelo.core.PropertyReader;
import br.com.alelo.core.Property;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    @Rule
    public TestName name = new TestName();

    @Before
    public void beforeScenario(Scenario scenario) {
        System.out.println("Iniciando a execução do teste: " + scenario.getName());
        Thread.currentThread().setName(scenario.getName());
        getDriver().get(PropertyReader.getProperty("web.url"));
    }

    @After
    public void afterScenario(Scenario scenario) throws IOException {
        TakesScreenshot ss = (TakesScreenshot) DriverFactory.getDriver();
        File arquivo = ss.getScreenshotAs(OutputType.FILE);
        String status = scenario.getStatus().toString();
        FileUtils.copyFile(arquivo, new File("evidencias" + File.separator + "screenshot_status_" + status
                + File.separator + scenario.getName() + ".jpg"));
        if (Property.FECHAR_BROWSER) {
            killDriver();
        }

    }
}