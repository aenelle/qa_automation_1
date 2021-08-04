package org.test.web;

import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.test.web.ConfProperties;

public class LoginPage {
  public WebDriver driver;

  public LoginPage(WebDriver driver) {
    PageFactory.initElements(driver, this);
    this.driver = driver;
  }

  @FindBy(xpath = "//input[@type='email']")
  private WebElement loginFiled;

  @FindBy(xpath = "//input[@type='password']")
  private WebElement passwdField;

  @FindBy(xpath = "//label[contains(@for,' customCheckLogin')]")
  private WebElement checkBox;

  @FindBy(xpath = "//*[@type='submit']")
  private WebElement loginBtn;

  @FindBy(xpath = "//small[@class='text-danger'][contains(.,'Email или пароль ввдены неверно.')]")
  private WebElement alertError;

  @FindBy(xpath = "//button[contains(@class,'btn btn-primary disabled')]")
  private WebElement disableLoginBtn;

  public void clickDisableBtn() {
    disableLoginBtn.click();
  }

  public void clickChekBox() {
    checkBox.click();
  }

  public void init() {
    inputLogin(ConfProperties.getProperty("login"));
    inputPasswd(ConfProperties.getProperty("password"));
    clickChekBox();
    clickLoginBtn();
  }

  public void inputLogin(String login) {
    loginFiled.sendKeys(login);
  }

  public void inputPasswd(String passwd) {
    passwdField.sendKeys(passwd);
  }

  public void clickLoginBtn() {
    loginBtn.click();
  }

  public void clearLogin() {
    passwdField.clear();
  }

  public void alertLoginFailed() {
    userAlertError("Email или пароль ввдены неверно.");
  } //todo ошибка в написании alert

  private void userAlertError(String expectedAlert) {
    String actualAlert = alertError.getText();
    Assertions.assertNotEmpty(expectedAlert, actualAlert);
  }
}

