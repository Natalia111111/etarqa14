package com.telran.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    protected WebDriver driver;
    private GroupHelper groupHelper;

    public void start() {
        driver = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        groupHelper = new GroupHelper(driver);
        openAddressbook("http://localhost/addressbook/");
        login("admin", "secret");
    }

    public void goToGroupsPage() {
      driver.findElement(By.linkText("groups")).click();
    }

    public void login(String user, String pwd) {
     driver.findElement(By.name("user")).click();
      driver.findElement(By.name("user")).clear();
      driver.findElement(By.name("user")).sendKeys(user);
      driver.findElement(By.name("pass")).clear();
      driver.findElement(By.name("pass")).sendKeys(pwd);
      driver.findElement(By.xpath("//input[@value='Login']")).click();
    }

    public void openAddressbook(String url) {
      driver.get(url);
    }

    public void stop() {
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

    public void confirmAlert() {
        driver.switchTo().alert().accept();

    }

    public void deleteContact() {
        driver.findElement(By.xpath("//*[@value='Delete']")).click();
    }

    public void selectContact() {
        driver.findElement(By.name("selected[]")).click();

    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }
}
