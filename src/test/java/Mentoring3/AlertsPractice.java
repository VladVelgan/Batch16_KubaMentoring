package Mentoring3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertsPractice {

    @Test
    public void alertPractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.lambdatest.com/selenium-playground");
        WebElement jsAlertButton = driver.findElement(By.linkText("Javascript Alerts"));
        jsAlertButton.click();
        Thread.sleep(500);
        WebElement jsAlertClick = driver.findElement(By.xpath("//button[contains(@class, 'btn btn-dark my-30')]"));
        jsAlertClick.click();
        Thread.sleep(500);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Thread.sleep(500);
        WebElement confirmClick = driver.findElement(By.xpath("//p[contains(text(), 'Prompt box:')]//button"));
        confirmClick.click();
        Thread.sleep(500);
        alert.dismiss();
        WebElement confirmMessage = driver.findElement(By.cssSelector("#confirm-demo"));
        Assert.assertEquals(confirmMessage.getText().trim(), "You pressed Cancel!");
        WebElement promptClick = driver.findElement(By.xpath("//p[contains(text(), 'Prompt box:')]//button"));
        promptClick.click();
        alert.sendKeys("Vlad Velgan");
        Thread.sleep(500);
        alert.accept();
        Thread.sleep(500);
        Assert.assertTrue(confirmMessage.getText().trim().contains("Vlad Velgan"));
        Thread.sleep(1000);
        driver.quit();



    }
}
