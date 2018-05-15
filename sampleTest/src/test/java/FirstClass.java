
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class FirstClass {
  private WebDriver driver;

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test(enabled = false)
  public void searchWebDriverInChrome() throws Exception {
    driver.get("https://www.google.co.il/search?q=webdriver&oq=webdriver&aqs=chrome.0.69i59j69i61j69i65l2j35i39j0.3996j0j8&sourceid=chrome&ie=UTF-8");
    driver.findElement(By.id("lst-ib")).click();
    driver.findElement(By.id("lst-ib")).sendKeys(Keys.ENTER);
    driver.findElement(By.id("lst-ib")).clear();
    driver.findElement(By.id("lst-ib")).sendKeys("webdriver");
  }

  @Test


  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
   }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
}
