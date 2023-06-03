package lambda_test;

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

public class Test1 {

    @Test
    public void inputFormSubmit() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.lambdatest.com/selenium-playground");
        WebElement formLink = driver.findElement(By.xpath("//a[contains(text(), 'Input Form Submit')]"));
        formLink.click();
        Thread.sleep(300);
        WebElement name = driver.findElement(By.cssSelector("#name"));
        name.sendKeys("Vlad Velgan");
        Thread.sleep(300);
        WebElement email = driver.findElement(By.cssSelector("#inputEmail4"));
        email.sendKeys("vladvelgan@gmail.com");
        Thread.sleep(300);
        WebElement password = driver.findElement(By.cssSelector("#inputPassword4"));
        password.sendKeys("Baden!2023");
        Thread.sleep(300);
        WebElement company = driver.findElement(By.cssSelector("#company"));
        company.sendKeys("CodeFish");
        Thread.sleep(300);
        WebElement website = driver.findElement(By.cssSelector("#websitename"));
        website.sendKeys("lambdatest.com");
        website.sendKeys(Keys.ARROW_DOWN);
        website.sendKeys(Keys.ARROW_DOWN);
        website.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(300);
        WebElement country = driver.findElement(By.xpath("//select[@name='country']"));
        country.sendKeys("United States");
        Thread.sleep(300);
        WebElement city = driver.findElement(By.cssSelector("#inputCity"));
        city.sendKeys("Arlington Heights");
        Thread.sleep(300);
        WebElement address = driver.findElement(By.cssSelector("#inputAddress1"));
        address.sendKeys("123 Main St");
        WebElement address2 = driver.findElement(By.cssSelector("#inputAddress2"));
        address2.sendKeys("Apt 5");
        Thread.sleep(300);
        WebElement state = driver.findElement(By.cssSelector("#inputState"));
        state.sendKeys("IL");
        Thread.sleep(300);
        WebElement zipCode = driver.findElement(By.cssSelector("#inputZip"));
        zipCode.sendKeys("60004");
        Thread.sleep(2000);
        WebElement submit = driver.findElement(By.xpath("//button[.='Submit']"));
        submit.click();
        Thread.sleep(300);
        WebElement massage = driver.findElement(By.cssSelector(".success-msg"));
        Assert.assertTrue(massage.isDisplayed());
        driver.quit();
    }
}
