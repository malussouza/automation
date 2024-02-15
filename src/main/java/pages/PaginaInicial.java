package pages;

import org.openqa.selenium.WebDriver;
import utils.WebDriverFabrica;

public class PaginaInicial {

    WebDriver driver = WebDriverFabrica.criarChormeDrive();

    public void abrirNavegadorPaginalIncialBlog(){
        driver.get("https://blogdoagi.com.br/");
    }
}

