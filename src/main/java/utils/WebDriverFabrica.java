package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFabrica {
//    Instaciar o chormedriver para conseguir acessar o navegador

    public static WebDriver driver;

    public  WebDriverFabrica () {
    }

    public static WebDriver criarChormeDrive(){
        if(driver == null){
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-default-browser-check");
            options.addArguments("--disable-default-apps");

            driver = new ChromeDriver(options);

        }
        return driver;
    }
    public static void fecharDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
