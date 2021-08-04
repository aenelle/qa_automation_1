import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.test.web.ConfProperties;
import org.test.web.LoginPage;
import org.test.web.PanelInfoPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTest {
  public static LoginPage loginPage;
  public static PanelInfoPage panelInfoPage;
  public static WebDriver driver;

  @BeforeMethod
  public static void setUp(){
    System.setProperty("webdriwer.chrome.driver", ConfProperties.getProperty("chromedriver"));
    WebDriver driver =  new ChromeDriver();
    loginPage = new LoginPage(driver);
    panelInfoPage = new PanelInfoPage(driver);
    driver.manage().window().maximize();
    driver.get(ConfProperties.getProperty("loginpage"));
  }
  @Test
  public void testLogin(){
    loginPage.init();
    String user = panelInfoPage.getUserName();
    Assert.assertEquals(ConfProperties.getProperty("name"), user);
    panelInfoPage.entryMenu();
    panelInfoPage.userLogout();
  }
  @AfterMethod
  public static void tearDown(){
    if(driver != null)
      driver.quit();
  }
}
