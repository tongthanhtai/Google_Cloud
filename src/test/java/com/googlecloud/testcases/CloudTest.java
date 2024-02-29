package com.googlecloud.testcases;

import com.googlecloud.base.BaseSetup;
import com.googlecloud.pages.CloudPage;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

public class CloudTest extends BaseSetup {
    private WebDriver driver;
    public CloudPage cloudPage;

    @BeforeClass
    public void setUp() {
        driver = getDriver();
    }

    @Test
    public void openCloudPage() {
        System.out.println(driver);
        cloudPage = new CloudPage(driver);
        cloudPage.openCloudPage();
    }

    @Test
    public void showOverview() throws InterruptedException {
        cloudPage.clickOverView();

    }

    @Test
    public void showSolutions() throws InterruptedException {
        cloudPage.clickSolutions();

    }

    @Test
    public void showProducts() throws InterruptedException {
        cloudPage.clickProducts();
    }
    @Test
    public void clickRequestDemo() throws InterruptedException {
        cloudPage.clickRequestDemo();
    }

};
