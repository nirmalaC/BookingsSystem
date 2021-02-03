package helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import stepDefinitions.Hooks;

import java.time.Duration;
import java.util.logging.Logger;

public class UiHelper {

    /**
     *
     * @param element This is the webelement that has to be visible on the web page.
     */
    public static void waitForVisibleElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(Hooks.driver, 30);
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    public static void waitUntilJSReady() {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, 10);

        try {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Hooks.driver;

            ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) Hooks.driver)
                    .executeScript("return document.readyState").toString().equals("complete");

            boolean jsReady = javascriptExecutor.executeScript("return document.readyState").toString().equals("complete");

            if (!jsReady) {
                wait.until(jsLoad);
            }
        } catch (WebDriverException ignored) {
        }
    }


    public static void waitForJQueryLoad() {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, 10);
        try {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Hooks.driver;
            ExpectedCondition<Boolean> jQueryLoad = driver -> ((Long) ((JavascriptExecutor) Hooks.driver)
                    .executeScript("return jQuery.active") == 0);

            boolean jqueryReady = (Boolean) javascriptExecutor.executeScript("return jQuery.active==0");

            if (!jqueryReady) {
                wait.until(jQueryLoad);
            }
        } catch (WebDriverException ignored) {
        }
    }


}