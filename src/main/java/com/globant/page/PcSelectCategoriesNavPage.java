package com.globant.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class PcSelectCategoriesNavPage extends BasePage {

    @FindBy(className = "andes-carousel-snapped__control--next")
    private WebElement carouselButtonNext;

    @FindBy(className = "seo-ui-trends-entry-link")
    private List<WebElement> selectCarouselOption;

    public PcSelectCategoriesNavPage(WebDriver webDriver) {
        super(webDriver);
    }

    /**
     *
     * @return PcGamerListPage
     */
    public PcGamerListPage selectCategories() {
        getWait().until(ExpectedConditions.elementToBeClickable(carouselButtonNext));
        click(carouselButtonNext);
        getWait().until(ExpectedConditions.elementToBeClickable(selectCarouselOption.get(7)));
        click(selectCarouselOption.get(7));
        return new PcGamerListPage(getDriver());
    }
}
