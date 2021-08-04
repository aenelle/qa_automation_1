package org.test.web;

import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
  public WebDriver driver;

  public ProfilePage(WebDriver driver) {
    PageFactory.initElements(driver, this);
    this.driver = driver;
  }

  @FindBy(xpath = "/span[contains(@class,'mb-0 text-sm font-weight-bold')]")
  private WebElement userMenu;

  @FindBy(xpath = "//input[contains(@name,'username')]")
  private WebElement lkLogin;

  public void editLogin(String fakeLogin) {
    lkLogin.clear();
    lkLogin.sendKeys(fakeLogin);
  }

  @FindBy(xpath = "//input[contains(@id,'input-email')]")
  private WebElement lkEmail;

  public void editEmail(String fakeEmail) {
    lkEmail.clear();
    lkEmail.sendKeys(fakeEmail);
  }

  @FindBy(xpath = "//input[@name='firstName']")
  private WebElement firstName;

  public void editFirstName(String fakeFirstName) {
    firstName.clear();
    firstName.sendKeys(fakeFirstName);
  }


  @FindBy(xpath = "//input[@name='lastName']")
  private WebElement lastName;

  public void editLastName(String fakeLastName) {
    lastName.clear();
    lastName.sendKeys(fakeLastName);
  }

  @FindBy(xpath = "//input[@name='address']")
  private WebElement address;

  public void editAddress(String fakeAddress) {
    address.clear();
    address.sendKeys(fakeAddress);
  }

  @FindBy(xpath = "//input[@name='city']")
  private WebElement city;

  public void editCity(String fakeCity) {
    city.clear();
    city.sendKeys(fakeCity);
  }

  @FindBy(xpath = "//input[@name='postCode']")
  private WebElement postCode;

  public void editPostCode(String fakePostCode) {
    postCode.clear();
    postCode.sendKeys(fakePostCode);
  }

  @FindBy(xpath = "//input[@name='country']")
  private WebElement country;

  public void editCountry(String fakeCountry) {
    country.clear();
    country.sendKeys(fakeCountry);
  }

  @FindBy(xpath = "//textarea[contains(@name,'about')]")
  private WebElement aboutMe;

  public void editAboutMe(String fakeAboutMe) {
    aboutMe.clear();
    aboutMe.sendKeys(fakeAboutMe);
  }

  @FindBy(xpath = "//button[@type='submit'][contains(.,'Сохранить')]")
  private WebElement saveBtn;

  public void clickSave() {
    saveBtn.click();
  }


  @FindBy(xpath = "//a[contains(.,'Показать больше')]")
  private WebElement showMore;

  @FindBy(xpath = "(//span[contains(.,'Выйти')])[2]")
  private WebElement logoutBtn;

  @FindBy(xpath = "//h1[contains(@class,'display-2 text-white')]")
  private WebElement headerName;

  @FindBy(xpath = "//img[contains(@class,'rounded-circle')]")
  private WebElement lkPhoto;

  @FindBy(xpath = "(//img[contains(@alt,'...')])[3]")
  private WebElement avaPhoto;

  @FindBy(xpath = "//span[contains(@class,'mb-0 text-sm font-weight-bold')]")
  private WebElement avaName;

  @FindBy(xpath = "//button[contains(.,'Редактировать')]")
  private WebElement editBtn;

  public void clickEdit() {
    editBtn.click();
  }
  @FindBy(xpath = "//small[@class='text-danger'][contains(.,'Поля может содержать только email')]")
  private WebElement emailAlertError;

  public void alertEmailFailed() {
    emailAlertError("Поля может содержать только email"); // todo текст alert содержит ошибку
  }
  private void emailAlertError(String expectedAlert){
    String actualAlert = emailAlertError.getText();
    Assertions.assertNotEmpty(expectedAlert, actualAlert);
  }

  public String getFirstName(){
    String firstNameText = firstName.getText();
    return firstNameText;
  }
  public String getHeaderName(){
    String headerNameText = headerName.getText();
    return headerNameText;
  }

}

