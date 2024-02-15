package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Elemento {
//    Encapsula as ações de clicar, digitar e extrair os elementos da tela
    WebDriver driver = WebDriverFabrica.criarChormeDrive();

    public void clicar(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement elemento = wait.until(ExpectedConditions.elementToBeClickable(locator));
        elemento.click();
    }

    public void digitar(By locator, String texto) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        elemento.clear();
        elemento.sendKeys(texto);
    }

    public String ExtrairTexto(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return elemento.getText();
    }
}
