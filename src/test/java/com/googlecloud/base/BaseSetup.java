package com.googlecloud.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseSetup {

    private WebDriver driver;

    static String driverPath = "/Users/tongthanhtai/Documents/Selenium/Edge_WebDriver/";

    public WebDriver getDriver() {
        return driver;
    }

    private void setDriver(String browserType, String appURL) {
        switch (browserType) {
            case "edge":
                driver = initEdgeDriver(appURL);
                break;
            case "chrome":
                driver = initChromeDriver(appURL);
                break;
            case "firefox":
                driver = initFirefoxDriver(appURL);
                break;
            default:
                System.out.println("Browser: " + browserType + " is invalid, Launching Chrome as browser of choice...");
                driver = initChromeDriver(appURL);
        }
    }


    private static WebDriver initChromeDriver(String appURL) {
        System.out.println("Launching Chrome browser...");
        System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(appURL);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }

    private static WebDriver initFirefoxDriver(String appURL) {
        System.out.println("Launching Firefox browser...");
        System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to(appURL);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }

    private static WebDriver initEdgeDriver(String appURL) {
        System.out.println("Launching Edge browser...");
        System.setProperty("webdriver.edge.driver", driverPath + "msedgedriver");
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(appURL);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        return driver;
    }


    @Parameters({ "browserType", "appURL" })
    @BeforeClass
    public void initializeTestBaseSetup(@Optional("edge")String browserType, @Optional("https://cloud.google.com/?hl=en") String appURL) {
        try {
            setDriver(browserType, appURL);
        } catch (Exception e) {
            System.out.println("Error..." + e.getStackTrace());
        }
    }

    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}
