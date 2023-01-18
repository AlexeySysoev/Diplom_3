import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class ProfilePage {
    private WebDriver driver;
    Urls urls = new Urls();
    private final By saveButton = By.xpath(".//button[text()='Сохранить']");
    private final By logoutButton = By.xpath(".//button[text()='Выход']");
    public ProfilePage(){}
    public void setDriver(WebDriver driver){
        this.driver = driver;
    }
    public String getUserLogin(String login){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlContains(urls.profilePoint));
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(saveButton));
        WebElement elem = driver.findElement(By.xpath(".//input[@value='"+ login +"']"));
        return elem.getAttribute("value");
    }
    public void logoutButtonClick(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(logoutButton));
        driver.findElement(logoutButton).click();
    }
}
