package com.globant.test;

import com.globant.driver.MyDriver;
import com.globant.page.MercadoLibreHomePage;
import org.testng.annotations.*;

public class BaseTest {
    private MyDriver myDriver;

    private MercadoLibreHomePage mercadoLibreHomePage;

    /**
     *
     * @param browser
     */
    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser"})
    public void beforeSuite(String browser) {
        myDriver = new MyDriver(browser);
        mercadoLibreHomePage = new MercadoLibreHomePage(getMyDriver().getDriver());
    }

    @AfterMethod(alwaysRun = true)
    public void afterSuite() {
        myDriver.getDriver().quit();
    }

    public MyDriver getMyDriver() {
        return myDriver;
    }

    public MercadoLibreHomePage getMercadoLibreHomePage() {
        return mercadoLibreHomePage;
    }
}
