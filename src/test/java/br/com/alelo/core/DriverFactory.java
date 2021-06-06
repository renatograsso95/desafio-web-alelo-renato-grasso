package br.com.alelo.core;

import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static br.com.alelo.core.Property.browser;


public class DriverFactory {

    private static WebDriver driver;
    private static WebDriverWait waitDriver;

    private static String webdriver = "";

    private DriverFactory() {
    }

    //Metodo para ambos drivers
    public static WebDriver getDriver() {
        if (driver == null) {
            switch (browser) {
                case FIREFOX:
                    webdriver = Paths.get("").toAbsolutePath().toString() + "/drivers/geckodriver.exe";
                    System.setProperty("webdriver.gecko.driver", webdriver);
                    driver = new FirefoxDriver();
                    break;
                case CHROME:
                    webdriver = Paths.get("").toAbsolutePath().toString() + "/drivers/chromedriver.exe";
                    System.setProperty("webdriver.chrome.driver", webdriver);
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-dev-shm-usage");
                    options.addArguments("--headless");
                    driver = new ChromeDriver();
                    break;
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static WebDriverWait getWaitDriver() {
        waitDriver = new WebDriverWait(driver, 10);
        return waitDriver;
    }

    public static void killDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}