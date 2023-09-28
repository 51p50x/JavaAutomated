package com.p50.automated;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class App {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\51p50x\\Desktop\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.google.com/");
        // identify element
        WebElement p=driver.findElement(By.name("q"));
        //enter text with sendKeys() then apply submit()
        p.sendKeys("Selenium Java");
        // Explicit wait condition for search results
        WebDriverWait w = new WebDriverWait(driver, 5);
        w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul")));
        p.submit();

        // Esperar 5 segundos antes de cerrar el navegador
        try {
            Thread.sleep(15000); // espera 5 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.close();
    }
}