package com.globant.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MercadoLibreHomePage extends BasePage {

    @FindBy(id = "cb1-edit")
    private WebElement searchInput;

    @FindBy(className = "nav-search-btn")
    private WebElement searchButton;

    @FindBy(linkText = "Categorías")
    private WebElement categoriesMenuOption;

    @FindBy(linkText = "Tecnología")
    private WebElement technologyMenuOption;

    @FindBy(linkText = "Portátiles")
    private WebElement computationSubMenuOption;

    @FindBy(css = "a.category")
    private List<WebElement> computationCategoriesSelect;

    /**
     * I set the page path in the constructor and maximize the window
     *
     * @param webDriver
     */
    public MercadoLibreHomePage(WebDriver webDriver) {
        super(webDriver);
        webDriver.get("https://www.mercadolibre.com.co/");
        webDriver.manage().window().maximize();
    }

    /**
     *
     * @param searchFor
     * @return PcGamerListPage
     */
    public PcGamerListPage searchProductInput(String searchFor) {
        type(searchFor, searchInput);
        getWait().until(ExpectedConditions.elementToBeClickable(searchButton));
        click(searchButton);
        return new PcGamerListPage(getDriver());
    }

    /**
     *
     * @return PcSelectCategoriesNavPage
     */
    public PcSelectCategoriesNavPage searchProductNavCategories() {
        getActions().moveToElement(categoriesMenuOption).perform();
        getWait().until(ExpectedConditions.visibilityOf(technologyMenuOption));
        getActions().moveToElement(technologyMenuOption).perform();
        getWait().until(ExpectedConditions.elementToBeClickable(computationSubMenuOption));
        click(computationSubMenuOption);
        return new PcSelectCategoriesNavPage(getDriver());
    }

    /**
     *
     * @return PcSelectCategoriesFooterPage
     */
    public PcSelectCategoriesFooterPage searchProductPopularCategories() {
        getJavascriptExecutor().executeScript("arguments[0].scrollIntoView(true);", computationCategoriesSelect.get(2));
        getWait().until(ExpectedConditions.elementToBeClickable(computationCategoriesSelect.get(2)));
        click(computationCategoriesSelect.get(2));
        return new PcSelectCategoriesFooterPage(getDriver());
    }
}
