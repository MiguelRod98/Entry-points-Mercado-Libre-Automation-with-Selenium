package com.globant.page;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class PcGamerListPage extends BasePage {

    @FindBy(className = "ui-search-item__title")
    private List<WebElement> listProduct;

    public PcGamerListPage(WebDriver webDriver) {
        super(webDriver);
    }

    /**
     *
     * @return PcGamerSelectPage
     */
    public PcGamerSelectPage selectProductListByInput() {
        getWait().until(ExpectedConditions.elementToBeClickable(listProduct.get(0)));
        click(listProduct.get(0));
        return new PcGamerSelectPage(getDriver());
    }

    /**
     *
     * @return PcGamerSelectPage
     */
    public PcGamerSelectPage selectProductListByNavCategory() {
        getJavascriptExecutor().executeScript("arguments[0].scrollIntoView(true);", listProduct.get(1));
        getWait().until(ExpectedConditions.elementToBeClickable(listProduct.get(1)));
        click(listProduct.get(1));
        return new PcGamerSelectPage(getDriver());
    }

    /**
     *
     * @return PcGamerSelectPage
     */
    public PcGamerSelectPage selectProductListByFooterCategory() {
        getJavascriptExecutor().executeScript("arguments[0].scrollIntoView(true);", listProduct.get(5));
        try {
            getWait().until(ExpectedConditions.elementToBeClickable(listProduct.get(5)));
            click(listProduct.get(5));
        } catch (StaleElementReferenceException e) {
            getWait().until(ExpectedConditions.elementToBeClickable(listProduct.get(5)));
            click(listProduct.get(5));
        }
        return new PcGamerSelectPage(getDriver());
    }
}
