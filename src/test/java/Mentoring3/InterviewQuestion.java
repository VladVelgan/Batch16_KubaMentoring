package Mentoring3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class InterviewQuestion {

    /*
    Navigate to web app
    click login button
    click continue with email button
    provide email, and password (wrong credentials)
    and validate the error message
    driver quit
    !!! probably need to delete cockies !!!
     */

    @Test
    public void InteviewQustionPractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.tumblr.com/");
        WebElement logIn = driver.findElement(By.linkText("Log in"));
        logIn.click();
        WebElement withEmail = driver.findElement(By.xpath("//button[@aria-label='Continue with email']"));
        withEmail.click();
        WebElement emailInput = driver.findElement(By.xpath("//input[@name='email']"));
        emailInput.sendKeys("vlad@gmail.com");
        emailInput.sendKeys(Keys.ENTER);;
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("1234");
        password.sendKeys(Keys.ENTER);
        WebElement errorMessage = driver.findElement(By.xpath("//div[contains(text(),'Your email or password')]"));
        String actualMessage = errorMessage.getText().trim();
        String expectedMessage = "Your email or password were incorrect.";
        Assert.assertEquals(actualMessage, expectedMessage);
        Thread.sleep(500);
        driver.quit();
    }

}
