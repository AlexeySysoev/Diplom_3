import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private WebDriver driver;
    Urls urls = new Urls();
    final By personalAccountLink = By.xpath(".//a[@href = '/account']");
    private final By enterAccountButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By mainLogo = By.xpath(".//div[contains(@class, 'logo')]/a[@href='/']");
    private final By constructorButton = By.xpath(".//p[text()='Конструктор']/parent::a");
    final By[] ingredientsTabs = {
            By.xpath(".//span[text()='Соусы']/parent::div"),
            By.xpath(".//span[text()='Начинки']/parent::div"),
            By.xpath(".//span[text()='Булки']/parent::div")
    };
    final By[] ingredients = {
            By.xpath(".//img[@alt='Соус Spicy-X']/parent::a"),
            By.xpath(".//img[@alt='Мясо бессмертных моллюсков Protostomia']/parent::a"),
            By.xpath(".//img[@alt='Флюоресцентная булка R2-D3']/parent::a")
    };
    final By fluBun = By.xpath(".//a[@href='/ingredient/61c0c5a71d1f82001bdaaa6d']");

    public MainPage() {
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открытие главной страницы")
    public void open() {
        driver.get(urls.baseUrl);
    }

    @Step("Нажатие кнопки 'Личный кабинет'")
    public void personalAccountLinkClick() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(personalAccountLink));
        driver.findElement(personalAccountLink).click();
    }

    @Step("Нажатие кнопки 'Войти в аккаунт'")
    public void enterAccountButtonClick() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(enterAccountButton));
        driver.findElement(enterAccountButton).click();
    }

    @Step("Ожидание загрузки элемента")
    public void waitElement(By element) {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    @Step("Нажатие кнопки 'Конструктор'")
    public void constructorButtonClick() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(constructorButton));
        driver.findElement(constructorButton).click();
    }

    @Step("Нажатие на логотип 'stellar&burgers'")
    public void logoClick() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(mainLogo));
        driver.findElement(mainLogo).click();
    }

    @Step("Нажите таба переключения ингредиентов")
    public void tabClick(By element) {
        String attributeText = driver.findElement(element).getAttribute("class");
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(element));
        if (!attributeText.contains("current")) {
            driver.findElement(element).click();
        }
    }

    @Step("Проверка отображения ингредиента")
    public boolean checkIngredient(By element, String ingredientText) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).click();
        return driver.findElement(By.xpath(".//p[text()='" + ingredientText + "']")).isDisplayed();
    }
}
