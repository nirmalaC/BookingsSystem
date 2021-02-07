package helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import stepDefinitions.Hooks;

import java.time.Duration;
import java.util.logging.Logger;

public class UiHelper {

   static  WebDriverWait wait = new WebDriverWait(Hooks.driver, 5);

    /**
     * This Explicit Wait method is to handle the wait for elements to be visible on the page
     * @param element This is the Webelement that has to be visible on the web page.
     */
    public static void waitForVisibleElement(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * This method is to check the element is clickable
     * @param element This is the Webelement that has to be visible on the web page.
     */
    public static void waitForClickableElement(WebElement element){
        waitForVisibleElement(element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * This JavascriptExecutor method is to handle the ajax call
     */
    public static void waitForJQueryLoad() {
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