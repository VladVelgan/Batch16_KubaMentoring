package Mentoring3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.security.Key;
import java.time.Duration;
import java.util.List;

public class SlidersPractice {

    @Test
    public void alertPractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.lambdatest.com/selenium-playground");
        WebElement slidersLink = driver.findElement(By.linkText("Drag & Drop Sliders"));
        slidersLink.click();
        Thread.sleep(1000);
        List<WebElement> allSliders = driver.findElements(By.xpath("//input[@type='range']"));
        List<WebElement> allOutput = driver.findElements(By.tagName("output"));
        for(int i = 0; i < allSliders.size(); i++){
            while(!allOutput.get(i).getText().equals("50")){
                if(allOutput.get(i).getText().equals("50")){
                    break;
                }else{
                    allSliders.get(i).sendKeys(Keys.ARROW_RIGHT);
                }
            }
        }
        Thread.sleep(2000);
        driver.quit();
    }
}
