package com.globant.page;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PcPaymentsOptionPage extends BasePage {

    @FindBy(css = "button.andes-modal__close-button")
    private WebElement closePaymentsOption;

    @FindBy(id = "cb1-edit")
    private WebElement inputSearchVerification;

    public PcPaymentsOptionPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void paymentsClose() {
        if (inputSearchVerification.isDisplayed()) {
            getWait().until(ExpectedConditions.visibilityOf(inputSearchVerification));
            getJavascriptExecutor().executeScript("window.history.back();");
        } else {
            try {
                getWait().until(ExpectedConditions.visibilityOf(closePaymentsOption));
                getWait().until(ExpectedConditions.elementToBeClickable(closePaymentsOption));
                click(closePaymentsOption);
            } catch (ElementClickInterceptedException e) {
                getWait().until(ExpectedConditions.visibilityOf(closePaymentsOption));
                getWait().until(ExpectedConditions.elementToBeClickable(closePaymentsOption));
                click(closePaymentsOption);
            }
        }
        while (!inputSearchVerification.isDisplayed()) {
            getWait().until(ExpectedConditions.visibilityOf(inputSearchVerification));
            getJavascriptExecutor().executeScript("window.scrollTo({ top: 0, behavior: 'smooth' });");
        }
    }
}
