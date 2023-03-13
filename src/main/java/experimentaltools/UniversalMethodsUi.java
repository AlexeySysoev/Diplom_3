package experimentaltools;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UniversalMethodsUi {
    private WebDriver driver;

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
    public void clickOnObj(By element){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).click();
    }
    public void clickOnObj(By element, String url){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlContains(url));
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).click();
    }
    public void setInputValue(By element, String value){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).sendKeys(value);
    }
    public void setInputValue(By element, String url, String value){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlContains(url));
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).sendKeys(value);
    }
}
