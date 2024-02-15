package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.PaginaInicial;
import utils.Elemento;
import utils.Screenshot;
import utils.WebDriverFabrica;

public class ValidarFecharBarraPesquisa {
    PaginaInicial paginaInicial = new PaginaInicial();
    Elemento elemento = new Elemento();

    @Dado("Que estou na pagina inicial do blog agi")
    public void queEstouNaPaginaInicialDoBlogAgi() {
        paginaInicial.abrirNavegadorPaginalIncialBlog();
    }

    @Quando("clicar  na lupa a barra de pesquisa sera aberta")
    public void clicarNaLupaABarraDePesquisaSeraAberta() {
       // elemento.clicar(By.id("search-open"));
        elemento.clicar(By.cssSelector(".icon-search:nth-child(2) > svg"));
    }

    @Quando("clicar novamente na lupa")
    public void clicarNovamenteNaLupa() {
        // elemento.clicar(By.id("search-open"));
        elemento.clicar(By.cssSelector(".icon-search:nth-child(2) > svg"));
    }

    @Entao("a barra de pesquisa devera ser fechada")
    public void aBarraDePesquisaDeveraSerFechada() {
        new WebDriverWait(WebDriverFabrica.driver, 10).until
                (ExpectedConditions.attributeContains(By.className("desktop-search"), "style", "display: none"));
    }

    @Entao("gravar a evidencia")
    public void gravarEvidencia() {
        Screenshot.tirarScreenshot(WebDriverFabrica.driver, "ValidarFecharBarraPesquisa");
    }

    @Entao("fechar a navegador")
    public void fecharNavegador() {
        WebDriverFabrica.fecharDriver();
    }
}
