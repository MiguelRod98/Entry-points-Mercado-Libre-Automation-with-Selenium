package com.globant.test;

import com.globant.page.MercadoLibreHomePage;
import com.globant.page.PcGamerListPage;
import com.globant.page.PcGamerSelectPage;
import com.globant.page.PcSelectCategoriesNavPage;
import com.globant.page.PcSelectCategoriesFooterPage;
import com.globant.page.PcPaymentsOptionPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class EntryPointSearchProductTest extends BaseTest {

    @Parameters({"inputSearch"})
    @Test(groups = "1", priority = 1, invocationCount = 2)
    public void searchProductTestByInput(String inputSearch) {
        MercadoLibreHomePage mercadoLibreHomePage = getMercadoLibreHomePage();
        PcGamerListPage pcGamerListPage = mercadoLibreHomePage.searchProductInput(inputSearch);
        PcGamerSelectPage pcGamerSelectPage = pcGamerListPage.selectProductListByInput();
        assertTrue(pcGamerSelectPage.getTitlePcGamer().isDisplayed());
        assertTrue(pcGamerSelectPage.getPricePcGamer().isDisplayed());
    }

    @Test(groups = "2", priority = 2, invocationCount = 2)
    public void searchProductTestByCategoriesNav() {
        MercadoLibreHomePage mercadoLibreHomePage = getMercadoLibreHomePage();
        PcSelectCategoriesNavPage pcSelectCategoriesNavPage = mercadoLibreHomePage.searchProductNavCategories();
        PcGamerListPage pcGamerListPage = pcSelectCategoriesNavPage.selectCategories();
        PcGamerSelectPage pcGamerSelectPage = pcGamerListPage.selectProductListByNavCategory();
        assertTrue(pcGamerSelectPage.getTitlePcGamer().isDisplayed());
        assertTrue(pcGamerSelectPage.getPricePcGamer().isDisplayed());
    }

    @Test(groups = "3", priority = 3, invocationCount = 2)
    public void searchProductTestByCategoriesFooter() {
        MercadoLibreHomePage mercadoLibreHomePage = getMercadoLibreHomePage();
        PcSelectCategoriesFooterPage pcSelectCategoriesFooterPage = mercadoLibreHomePage.searchProductPopularCategories();
        PcGamerListPage pcGamerListPage = pcSelectCategoriesFooterPage.categoryFooterSelect();
        PcGamerSelectPage pcGamerSelectPage = pcGamerListPage.selectProductListByFooterCategory();
        assertTrue(pcGamerSelectPage.getPaymentsComputer().isDisplayed());
        PcPaymentsOptionPage pcPaymentsOptionPage = pcGamerSelectPage.paymentsProductSelect();
        pcPaymentsOptionPage.paymentsClose();
        assertTrue(pcGamerSelectPage.getTitlePcGamer().isDisplayed());
        assertTrue(pcGamerSelectPage.getPricePcGamer().isDisplayed());
    }
}
