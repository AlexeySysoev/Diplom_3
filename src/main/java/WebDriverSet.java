import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverSet {
    private WebDriver driver;

    public WebDriver getWebDriver() {
        String browser = System.getProperties().getProperty("browser");
        if ((browser == null) || (browser.equals("chrome"))) {
            //System.setProperty("webdriver.chrome.driver", "C:/WebDriver/bin/chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", "C:/Users/Alexoid/javaprojects/diplom/Diplom_3/src/test/webdriver/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equals("yandex")) {
            //System.setProperty("webdriver.chrome.driver", "C:/WebDriver/bin/chromedriver108forya.exe");
            System.setProperty("webdriver.chrome.driver", "C:/Users/Alexoid/javaprojects/diplom/Diplom_3/src/test/chromedriver108ya.exe");
            ChromeOptions options = new ChromeOptions();
            options.setBinary("C:/Users/Alexoid/AppData/Local/Yandex/YandexBrowser/Application/browser.exe");
            driver = new ChromeDriver(options);
        }
        return driver;
    }
}

