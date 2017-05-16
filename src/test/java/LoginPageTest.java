import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPageTest {

    LoginPage loginPage;
    CreateSubtask createSubtask;
    DeleteSubtask deleteSubtask;

    WebDriver driver;

    String login = "marina.borovinska";
    String password = "March62017";
    String summary = "test2Marina";

    @BeforeTest
    public void before() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Марина\\Documents\\geckodriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);

        driver = new FirefoxDriver(capabilities);
        loginPage = new LoginPage(driver);
        createSubtask = new CreateSubtask(driver);
        deleteSubtask = new DeleteSubtask(driver);
    }
    @Test(groups = {"functest", "login"})
    public void login() {
        loginPage.openLoginPage();
        loginPage.inputLogin(login);
        loginPage.inputPassword(password);
        loginPage.clickLogin();
    }

    @Test(enabled = false, groups = {"functest", "createSubtask"}, dependsOnMethods = {"login"})
    public void createSubtask () {
        createSubtask.open();
        createSubtask.createNewSubtask();
        createSubtask.inputSummarySubtask(summary);
        createSubtask.submitSubtask();
    }
   // enabled = false,
    @Test(groups = {"functest", "deleteSubtask"}, dependsOnMethods = {"login"})
    public void deleteSubtask () {
        deleteSubtask.open();
        deleteSubtask.openSubtaskDelete();
        deleteSubtask.clickActionsMore();
        deleteSubtask.submitSubtaskDelete();
    }

    @AfterTest
    public void after(){
        driver.quit();
    }
}