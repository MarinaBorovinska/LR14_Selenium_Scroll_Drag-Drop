import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteSubtask {

    By subtaskToDelete = By.xpath(".//*[@id='issuerow11160']/td[2]/a");
    By subtaskActions = By.xpath(".//*[@id='actions_11160']/span");
    By subtaskActionDelete = By.xpath(".//*[@id='actions_11160_drop']/div/ul[3]/li[20]/a");
    By deleteIssueSubmit = By.xpath(".//*[@id='delete-issue-submit']");

    private final WebDriver driver;

    public DeleteSubtask(WebDriver driver){
        this.driver = driver;
    }

    public DeleteSubtask deleteSubtask(){

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(subtaskToDelete));
        actions.perform();

        driver.findElement(subtaskActions).click();
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.presenceOfElementLocated(subtaskActionDelete));
        driver.findElement(subtaskActionDelete).click();

        (new WebDriverWait(driver, 3, 100)).until(ExpectedConditions.visibilityOfElementLocated(deleteIssueSubmit));
        driver.findElement(deleteIssueSubmit).submit();
        return this;
    }

    public DeleteSubtask open(){
        driver.get("http://soft.it-hillel.com.ua:8080/browse/QAAUT-60");
        driver.manage().window().maximize();
        return this;
    }
}

