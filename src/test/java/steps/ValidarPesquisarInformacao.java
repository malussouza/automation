package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.PaginaInicial;
import utils.Elemento;
import utils.Screenshot;
import utils.WebDriverFabrica;

public class ValidarPesquisarInformacao {
    PaginaInicial paginaInicial = new PaginaInicial();
    Elemento elemento = new Elemento();

    @Dado("Que estou na pagina inical do blog do agi")
    public void queEstouNaPaginaInicalDoBlogDoAgi() {
        paginaInicial.abrirNavegadorPaginalIncialBlog();
    }

    @Quando("clicar na lupa")
    public void clicarNaLupa() {
        elemento.clicar(By.cssSelector(".icon-search:nth-child(2) > svg"));
    }

    @Quando("Na barra de pesquisa informar: {string}")
    public void naBarraDePesquisaInformar(String informacaoBuscada) {
        elemento.digitar(By.className("search-field"), informacaoBuscada);
    }

    @Quando("clicar no botão pesquisar")
    public void clicarNoBotaoPesquisar() {
        elemento.clicar(By.cssSelector(".icon-search:nth-child(2) > svg"));
    }

    @Entao("na tela de resultado da pequisa devera retornar a mensagem válida: {string}")
    public void naTelaDeResultadoDaPequisaDeveraRetornarAMensagemAcerto(String mensagemRetornada) {
        Assert.assertEquals(mensagemRetornada,  elemento.ExtrairTexto(By.xpath("//a[normalize-space()='Comece sua carreira em tecnologia com o Agi!']")));
    }

    @Entao("na tela de resultado da pequisa devera retornar a mensagem inválida: {string}")
    public void naTelaDeResultadoDaPequisaDeveraRetornarAMensagemErro(String mensagemRetornada) {
        Assert.assertEquals(mensagemRetornada,  elemento.ExtrairTexto(By.xpath("//p[contains(text(),'Lamentamos, mas nada foi encontrado para sua pesqu')]")));
    }

    @Entao("gravar evidencia")
    public void gravarEvidencia() {
        Screenshot.tirarScreenshot(WebDriverFabrica.driver, "ValidarPesquisarInformacao");
    }

    @Entao("fechar navegador")
    public void fecharNavegador() {
        WebDriverFabrica.fecharDriver();
    }
}
