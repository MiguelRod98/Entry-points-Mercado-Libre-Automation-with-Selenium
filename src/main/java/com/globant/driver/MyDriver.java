package com.globant.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyDriver {
    private WebDriver driver;

    /**
     * I create the constructor that receives as parameter the browser and by means
     * of a switch-case we set the path of the driver, and it is instantiated.
     *
     * @param browser
     */
    public MyDriver(String browser) {
        switch (browser) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\driver\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\driver\\chromedriver.exe");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-notifications");
                driver = new ChromeDriver(chromeOptions);
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", "src\\main\\resources\\driver\\msedgedriver.exe");
                driver = new EdgeDriver();
                break;
            default:
                break;
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
