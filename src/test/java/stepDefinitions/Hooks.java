package stepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import helpers.Utils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Hooks {

    public static WebDriver driver;

    public static Logger log = Logger.getLogger(String.valueOf(Hooks.class));

    public static Properties configProperties;

    public static String browser;

    public Hooks() throws IOException {
        configProperties = Utils.readPropertiesFile();
        browser = configProperties.getProperty("browser");
    }

    /**
     * This method will initialize the driver instance.
     */
    @Before("~@ApiTests")
    public void openBrowser() {

        log.info("Test Started");

            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
            }
            initiateWebdriver();
    }

    /**
     * This will quit the driver instance
     */
    @After("~@ApiTests")
    public void quitDriver() {
        driver.quit();
        log.info("Test Finished");

    }


    /**
     * This method will navigate to the given URL
     */
    public static void initiateWebdriver() {
        log.info("Opening Browser...." + browser);
        driver.manage().window().maximize();
        driver.get(configProperties.getProperty("url"));
    }

}