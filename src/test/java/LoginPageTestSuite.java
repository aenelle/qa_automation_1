import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.test.web.ConfProperties;
import org.test.web.LoginPage;
import org.test.web.PanelInfoPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTestSuite {
  public static LoginPage loginPage;
  public static PanelInfoPage panelInfoPage;
  public static WebDriver driver;

  @BeforeMethod
  public static void setUp() {
    System.setProperty("webdriwer.chrome.driver", ConfProperties.getProperty("chromedriver"));
    WebDriver driver = new ChromeDriver();
    loginPage = new LoginPage(driver);
    panelInfoPage = new PanelInfoPage(driver);
    driver.manage().window().maximize();
    driver.get(ConfProperties.getProperty("loginpage"));
  }
  @Test
  public static void loginFailPasswdFail(){
    loginPage.inputLogin("failLogin@gmail.com");
    loginPage.inputPasswd("12121212");
    loginPage.clickLoginBtn();
    loginPage.alertLoginFailed();

  }
  @Test
  public static void loginFailPasswdCorrect() {
    loginPage.inputLogin("failLogin@gmail.com");
    loginPage.inputPasswd(ConfProperties.getProperty("password"));
    loginPage.clickLoginBtn();
    loginPage.alertLoginFailed();

  }
  @Test
  public static void loginCorrectPasswdFail() {
    loginPage.inputLogin(ConfProperties.getProperty("login"));
    loginPage.inputPasswd("234567qwqr");
    loginPage.clickLoginBtn();
    loginPage.alertLoginFailed();
  }
  @Test
  public static void loginEmptyPasswdEmpty() {
    loginPage.inputLogin("");
    loginPage.inputPasswd("");
    loginPage.clickDisableBtn();
  }
  @Test
  public static void loginCorrectPasswdEmpty() {
    loginPage.inputLogin(ConfProperties.getProperty("login"));
    loginPage.inputPasswd("");
    loginPage.clickDisableBtn();
  }
  @Test
  public static void loginEmptyPasswdCorrect() {
    loginPage.inputLogin("");
    loginPage.inputPasswd(ConfProperties.getProperty("password"));
    loginPage.clickDisableBtn();
  }

  @AfterMethod
  public static void tearDown() {
    if (driver != null)
      driver.quit();
  }
}

