package com.googlecloud.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CloudPage {
    private WebDriver driver;
    public By overview = By.linkText("Overview");
    public By contentOverview = By.xpath("//header/div[2]/div[3]/div[1]/div[1]");
    public By solution = By.linkText("Solutions");
    public By contentSolutions = By.xpath("//header/div[2]/div[4]/div[1]/div[1]");

    public By product = By.linkText("Products");
    public By contentProducts = By.xpath("//header/div[2]/div[5]/div[1]/div[1]");

    public By requestDemo = By.xpath("//a[normalize-space()='Request a demo']");

    public CloudPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openCloudPage() {
        try {
            Thread.sleep(2000);
            String title = driver.getTitle();
            System.out.println(title);
            Assert.assertEquals(title , "Cloud Computing Services | Google Cloud");
            System.out.println("Title is: " + title);
            System.out.println("Open page success");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickOverView() throws InterruptedException {
        WebElement textOverview = driver.findElement(overview);
        Assert.assertTrue(textOverview.isDisplayed());
        textOverview.click();
        WebElement content = driver.findElement(contentOverview);

        Assert.assertTrue(content.isDisplayed());

        System.out.println("Click Overview Success");
        Thread.sleep(2000);
    }

    public void clickSolutions() throws InterruptedException {
        WebElement textSolutions = driver.findElement(solution);
        Assert.assertTrue(textSolutions.isDisplayed());
        textSolutions.click();
        WebElement contentSolution = driver.findElement(contentSolutions);

        Assert.assertTrue(contentSolution.isDisplayed());
        System.out.println("Click Solutions Success");
        Thread.sleep(2000);
    }

    public void clickProducts() throws InterruptedException {
        WebElement textProducts = driver.findElement(product);
        Assert.assertTrue(textProducts.isDisplayed());
        textProducts.click();
        WebElement contentProduct = driver.findElement(contentProducts);

        Assert.assertTrue(contentProduct.isDisplayed());
        System.out.println("Click Products Success");
        Thread.sleep(2000);
    }

    public void clickRequestDemo() throws InterruptedException {
        WebElement element = driver.findElement(requestDemo);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(2000);
        js.executeScript("arguments[0].click();", element);


        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://cloud.google.com/contact?direct=true");
        System.out.println("Click Request Demo and Switch page Success");
    }


}
