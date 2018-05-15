import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Elements {
    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @Test
    public void elmentsTest(){
        driver.get("https://www.google.com/");
       // driver.findElement(By.id("gsr")).click();
        driver.findElement(By.xpath("//*[@id='gsr']")).click();


        driver.findElement(By.cssSelector("[placeholder=search]"));

        driver.findElement(By.cssSelector("[type=button]"));


        driver.findElement(By.cssSelector("[title *=Name]")); // contain text
        driver.findElement(By.cssSelector("[src ^=http]")); //start with text
        driver.findElement(By.cssSelector("[src $=.pdf]"));//text in the end
        driver.findElement(By.cssSelector("[type=button]"));
        driver.findElement(By.cssSelector("[type=button]"));
        driver.findElement(By.cssSelector("[type=button]"));




        driver.navigate().refresh();
        driver.findElement(By.id("gsr")).click();
        driver.switchTo().alert().accept();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
