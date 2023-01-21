import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

@RunWith(Parameterized.class)
public class ConstructorTest {
    private WebDriver driver;
    WebDriverSet selectDriver = new WebDriverSet();
    MainPage mainPage = new MainPage();

    @Before
    public void preSettings() {
        driver = selectDriver.getWebDriver();
        driver.manage().window().maximize();
        mainPage.setDriver(driver);
        mainPage.open();
    }

    @Parameterized.Parameter()
    public int index;
    @Parameterized.Parameter(1)
    public String ingredientText;

    @Parameterized.Parameters(name = "selectedTab: {0}, ingredientText: {1}")
    public static Object[][] tabs() {
        return new Object[][]{
                {0, "Соус Spicy-X"},
                {1, "Мясо бессмертных моллюсков Protostomia"},
                {2, "Флюоресцентная булка R2-D3"}
        };
    }

    @Test
    @DisplayName("Переключение табов листа ингредиентов")
    @Description("открываем карточку ингредиента его название для проверки работы табов")
    public void checkWorkingTabSelectors() {
        mainPage.tabClick(mainPage.ingredientsTabs[index]);
        boolean result = mainPage.checkIngredient(mainPage.ingredients[index], ingredientText);
        Assert.assertTrue(result);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
