package com.globant.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PcGamerSelectPage extends BasePage {

    @FindBy(tagName = "h1")
    private WebElement titlePcGamer;

    @FindBy(className = "andes-money-amount__fraction")
    private WebElement pricePcGamer;

    @FindBy(linkText = "Medios de pago")
    private WebElement paymentsComputer;

    public PcGamerSelectPage(WebDriver webDriver) {
        super(webDriver);
    }

    /**
     *
     * @return PcPaymentsOptionPage
     */
    public PcPaymentsOptionPage paymentsProductSelect() {
        getJavascriptExecutor().executeScript("arguments[0].scrollIntoView(true);", paymentsComputer);
        getWait().until(ExpectedConditions.visibilityOf(paymentsComputer));
        getWait().until(ExpectedConditions.elementToBeClickable(paymentsComputer));
        click(paymentsComputer);
        return new PcPaymentsOptionPage(getDriver());
    }

    public WebElement getPricePcGamer() {
        return pricePcGamer;
    }

    public WebElement getTitlePcGamer() {
        return titlePcGamer;
    }

    public WebElement getPaymentsComputer() {
        return paymentsComputer;
    }
}
