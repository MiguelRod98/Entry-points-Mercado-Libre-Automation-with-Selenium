package com.globant.page;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PcSelectCategoriesFooterPage extends BasePage {

    @FindBy(id = "special")
    private WebElement optionCategorySelect;

    public PcSelectCategoriesFooterPage(WebDriver webDriver) {
        super(webDriver);
    }

    /**
     *
     * @return PcGamerListPage
     */
    public PcGamerListPage categoryFooterSelect() {
        try {
            getJavascriptExecutor().executeScript("arguments[0].scrollIntoView(true);", optionCategorySelect);
            getWait().until(ExpectedConditions.visibilityOf(optionCategorySelect));
            getWait().until(ExpectedConditions.elementToBeClickable(optionCategorySelect));
            click(optionCategorySelect);
        } catch (StaleElementReferenceException e) {
            getJavascriptExecutor().executeScript("arguments[0].scrollIntoView(true);", optionCategorySelect);
            getWait().until(ExpectedConditions.visibilityOf(optionCategorySelect));
            getWait().until(ExpectedConditions.elementToBeClickable(optionCategorySelect));
            click(optionCategorySelect);
        }
        return new PcGamerListPage(getDriver());
    }
}
