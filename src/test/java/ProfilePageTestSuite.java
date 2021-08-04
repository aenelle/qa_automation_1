import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.test.web.ConfProperties;
import org.test.web.LoginPage;
import org.test.web.PanelInfoPage;
import org.test.web.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProfilePageTestSuite {
  public static LoginPage loginPage;
  public static PanelInfoPage panelInfoPage;
  public static ProfilePage profilePage;
  public static WebDriver driver;

  @BeforeMethod
  public static void setUp(){
    System.setProperty("webdriwer.chrome.driver", ConfProperties.getProperty("chromedriver"));
    WebDriver driver =  new ChromeDriver();
    loginPage = new LoginPage(driver);
    panelInfoPage = new PanelInfoPage(driver);
    profilePage = new ProfilePage(driver);
    driver.manage().window().maximize();
    driver.get(ConfProperties.getProperty("loginpage"));
  }

  @Test
  public void tLoginValidData(){
    loginPage.init();
    panelInfoPage.entryMenu();
    panelInfoPage.linkMyProfile();
    profilePage.clickEdit();
    profilePage.editLogin(ConfProperties.getProperty("fakeLogin"));
    profilePage.editEmail(ConfProperties.getProperty("fakeEmail"));
    profilePage.editFirstName(ConfProperties.getProperty("fakeFirstName"));
    //profilePage.editLastName(ConfProperties.getProperty("fakeLastName")); todo поле last name не работает
    profilePage.editAddress(ConfProperties.getProperty("fakeAddress"));
    profilePage.editCity(ConfProperties.getProperty("fakeCity"));
    profilePage.editCountry(ConfProperties.getProperty("fakeCountry"));
    profilePage.editPostCode(ConfProperties.getProperty("fakePostCode"));
    profilePage.editAboutMe(ConfProperties.getProperty("fakeAboutMe"));
    profilePage.clickSave();
  }

  @Test //проверяем валидность email по такому же принципу проверяем другие предупреждения и валидность данных
  public void emailFail(){
    loginPage.init();
    panelInfoPage.entryMenu();
    panelInfoPage.linkMyProfile();
    profilePage.clickEdit();
    profilePage.editEmail(ConfProperties.getProperty("inValidEmail"));
    profilePage.clickSave();
    profilePage.alertEmailFailed();
  }

  @Test //проверяем отображение имени, по такому же принципу во всех местах с Именем
  public void nameHeaderValid(){
    loginPage.init();
    panelInfoPage.entryMenu();
    panelInfoPage.linkMyProfile();
    profilePage.clickEdit();
    profilePage.editFirstName(ConfProperties.getProperty("fakeFirstName"));
    profilePage.clickSave();
    String headerName = profilePage.getHeaderName();
    Assert.assertEquals(("Здравствуй, " + (ConfProperties.getProperty("fakeFirstName") +"!")), headerName); //todo временно переделать
  }

  @AfterMethod
  public static void tearDown() {
    panelInfoPage.entryMenu();
    panelInfoPage.userLogout();
    if (driver != null)
      driver.quit();
  }

}

