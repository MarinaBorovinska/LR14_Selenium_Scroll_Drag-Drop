import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteSubtask {

    By subtaskToDelete = By.xpath(".//a[.='test3Marina']");
    By subtaskActionsMore = By.xpath(".//*[@id='opsbar-operations_more']");
    By subtaskActionDelete = By.xpath(".//*[@id='delete-issue']");
    By deleteIssueSubmit = By.xpath(".//*[@id='delete-issue-submit']");

    private final WebDriver driver;

    public DeleteSubtask(WebDriver driver){
        this.driver = driver;
    }

    public DeleteSubtask openSubtaskDelete() {

        Actions actionsDelete = new Actions(driver);
        actionsDelete.moveToElement(driver.findElement(subtaskToDelete));
        actionsDelete.perform();
        driver.findElement(subtaskToDelete).click();
        return this;
    }

    public DeleteSubtask clickActionsMore() {

        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-150 )", "");
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.presenceOfElementLocated(subtaskActionsMore));
        driver.findElement(subtaskActionsMore).click();
        return this;
    }

    public DeleteSubtask submitSubtaskDelete(){

        driver.findElement(subtaskActionsMore).click();

        (new WebDriverWait(driver, 3)).until(ExpectedConditions.presenceOfElementLocated(subtaskActionDelete));

 //    (new WebDriverWait(driver, 5, 100)).until(ExpectedConditions.visibilityOfElementLocated(subtaskActionDelete));
        driver.findElement(subtaskActionDelete).click();

        (new WebDriverWait(driver, 5, 100)).until(ExpectedConditions.visibilityOfElementLocated(deleteIssueSubmit));
        driver.findElement(deleteIssueSubmit).submit();
        return this;
    }

    public DeleteSubtask open(){
        driver.get("http://soft.it-hillel.com.ua:8080/browse/QAAUT-224");
        driver.manage().window().maximize();
        return this;
    }
}

