package org.test.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PanelInfoPage {
  public WebDriver driver;
  public PanelInfoPage(WebDriver driver){
    PageFactory.initElements(driver,this);
    this.driver = driver;
  }

  @FindBy(xpath = "//span[@class='mb-0 text-sm font-weight-bold']")
  private WebElement userMenu;

  @FindBy(xpath = "(//span[contains(.,'Выйти')])[2]")
  private WebElement logoutBtn;

  @FindBy(xpath = "//span[contains(@class,'mb-0 text-sm font-weight-bold')]")
  private WebElement userInfo;

  @FindBy(xpath = "//a[@class='nav-link active'][contains(.,'Мой профиль')]")
  private WebElement linkProfile;

  @FindBy(xpath = "(//span[contains(.,'Мой профиль')])[2]")
  private WebElement myProfileLink;
  public void linkMyProfile(){
    myProfileLink.click();
  }

  public String getUserName(){
    String userName = userMenu.getText();
    return userName;
  }
  public void entryMenu(){
    userMenu.click();
  }
  public void userLogout() {
    logoutBtn.click();
  }
  public void linkProfileInfo(){
    linkProfile.click();

  }

}
