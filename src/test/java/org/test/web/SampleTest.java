package org.test.web;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class SampleTest {
  private WebDriver wd;

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testLoginSample() throws Exception {
    wd.get("https://ab-cisco.github.io/qa-testing/");
    wd.findElement(By.xpath("//input[@type='email']")).click();
    wd.findElement(By.xpath("//input[@type='email']")).clear();
    wd.findElement(By.xpath("//input[@type='email']")).sendKeys("email@email.com");
    wd.findElement(By.xpath("//input[@type='password']")).click();
    wd.findElement(By.xpath("//input[@type='password']")).clear();
    wd.findElement(By.xpath("//input[@type='password']")).sendKeys("password");
    wd.findElement(By.xpath("//label[contains(@for,' customCheckLogin')]")).click();
    wd.findElement(By.xpath("//*[@type='submit']")).click();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    wd.quit();
  }

  private boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
}

