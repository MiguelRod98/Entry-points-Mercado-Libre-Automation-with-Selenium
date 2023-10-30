package com.globant.page;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor javascriptExecutor;
    private Actions actions;

    /**
     * I initialize the elements of each page and create instances of the classes and interfaces to be used.
     * @param webDriver
     */
    public BasePage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        wait = new WebDriverWait(webDriver, 20, 5000);
        javascriptExecutor = (JavascriptExecutor) webDriver;
        actions = new Actions(webDriver);
        driver = webDriver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public JavascriptExecutor getJavascriptExecutor() {
        return javascriptExecutor;
    }

    public Actions getActions() {
        return actions;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void click(WebElement element) {
        element.click();
    }

    public void type(String inputText, WebElement element) {
        element.sendKeys(inputText);
    }
}
