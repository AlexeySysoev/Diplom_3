import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverSet {
    private WebDriver driver;
    public WebDriver getWebDriver() {
        String browser = System.getProperties().getProperty("browser");
        if ((browser == null) || (browser.equals("chrome")) || (browser.length() != 0)) {
            System.setProperty("webdriver.chrome.driver", "C:/WebDriver/bin/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equals("yandex")) {
            System.setProperty("webdriver.chrome.driver", "C:/WebDriver/bin/chromedriverya106.exe");
            ChromeOptions options = new ChromeOptions();
            options.setBinary("C:/Users/Alexoid/AppData/Local/Yandex/YandexBrowser/Application/browser.exe");
            driver = new ChromeDriver(options);
        }
        return driver;
        /*String browser = System.getProperties().getProperty("browser");
        System.out.println(browser);
        if (browser.equals("yandex")) {
            System.setProperty("webdriver.chrome.driver", "C:/WebDriver/bin/chromedriverya106.exe");
            ChromeOptions options = new ChromeOptions();
            options.setBinary("C:/Users/Alexoid/AppData/Local/Yandex/YandexBrowser/Application/browser.exe");
            driver = new ChromeDriver(options);
        }
        else {
            System.setProperty("webdriver.chrome.driver", "C:/WebDriver/bin/chromedriver.exe");
            driver = new ChromeDriver();
        }
        return driver;*/
    }
}

