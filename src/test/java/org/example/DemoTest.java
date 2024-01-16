package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class DemoTest {
    @Test (priority = 1,timeOut = 500000,enabled = true)
    public void verifyLogo() throws InterruptedException {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        WebDriverManager.chromedriver().clearResolutionCache().setup();
        // Initialize the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Open a website
        driver.get("https://www.automationanywhere.com");
        Thread.sleep(5000);

        // Accept Cookies
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        Thread.sleep(2000);

        // Logo element
        WebElement logo= driver.findElement(By.xpath("//a[@class='coh-link header-logo']"));

        // Check if the logo element is present
        Assert.assertTrue(logo.isDisplayed(), "The element is not displayed on the page.");

        // Request Demo element
        WebElement Request_demo= driver.findElement(By.xpath("//a[@title='Request demo']"));

        // Check if  Request Demo button is present
        Assert.assertTrue(Request_demo.isDisplayed(), "The element is not displayed on the page.");

        //Check if Request Demo is Clickable
        Assert.assertTrue(Request_demo.isEnabled(), "The element is not displayed on the page.");

        // Close the browser
        driver.quit();
    }

    @Test (priority = 0, timeOut = 100000, enabled = true)
    public void webElementList() throws InterruptedException {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        WebDriverManager.chromedriver().clearResolutionCache().setup();
        // Initialize the ChromeDriver
        WebDriver driver = new ChromeDriver();
        List<String> linkTexts = new ArrayList<>();
        List<String> places = Arrays.asList("Products", "Solutions", "Resources","Company");

        // Open a website
        driver.get("https://www.automationanywhere.com");
        Thread.sleep(5000);

        // Accepts Cookies
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();

        // List of webelements
        List<WebElement> elements  = driver.findElements(By.xpath("(//a[@href='/products'])[1]/parent::li/parent::ul//li[contains(@class,'nav-head')]"));
        Thread.sleep(2000);
        for (WebElement element : elements) {
            System.out.println("Text of the link: " + element.getText());
            String text = element.getText();
            linkTexts.add(text);

        }
        // Verify list present on the home page contains elements
        assert linkTexts.containsAll(places);

        // Navigate to product
        driver.findElement(By.xpath("(//a[@href='/products'])[1]")).click();

        // Get the current URL after the navigation
        String currentUrl_pr = driver.getCurrentUrl();

        // Define the expected URL
        String expectedUrl_pr = "https://www.automationanywhere.com/products";

        // Verify URL is navigating to the correct page
        Assert.assertEquals(currentUrl_pr,expectedUrl_pr);

        // GOTO home page
        driver.navigate().back();
        Thread.sleep(5000);

        // navigate to resource
        driver.findElement(By.xpath("(//a[@href='/resources'])[1]")).click();
        // Get the current URL after the navigation
        String currentUrl_res = driver.getCurrentUrl();
        // Define the expected URL
        String expectedUrl_res = "https://www.automationanywhere.com/resources";

        // Verify URL is navigating to the correct page
        Assert.assertEquals(currentUrl_res,expectedUrl_res);

        // GOTO home page
        driver.navigate().back();
        Thread.sleep(5000);

        // Navigate to Solutions
        driver.findElement(By.xpath("(//a[@href='/solutions'])[1]")).click();
        // Get the current URL after the navigation
        String currentUrl_sol = driver.getCurrentUrl();
        // Define the expected URL
        String expectedUrl_sol = "https://www.automationanywhere.com/solutions";

        // Verify URL is navigating to the correct page
        Assert.assertEquals(currentUrl_sol,expectedUrl_sol);

        // GOTO home page
        driver.navigate().back();
        Thread.sleep(5000);


        // Navigate to company
        driver.findElement(By.xpath("(//a[@href='/company/about-us'])[1]")).click();

        // Get the current URL after the navigation
        String currentUrl_company = driver.getCurrentUrl();

        // Define the expected URL
        String expectedUrl_company = "https://www.automationanywhere.com/company/about-us";

        // Verify URL is navigating to the correct page
        Assert.assertEquals(currentUrl_company,expectedUrl_company);

        // Close the browser
        driver.quit();
    }
}
