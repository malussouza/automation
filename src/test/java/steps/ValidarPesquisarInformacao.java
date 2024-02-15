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

    @Entao("na tela de resultado da pequisa devera retornar a mensagem: {string}")
    public void naTelaDeResultadoDaPequisaDeveraRetornarAMensagem(String mensagemRetornada) {
        String mensagem1 = elemento.ExtrairTexto(By.xpath("//p[contains(text(),'Lamentamos, mas nada foi encontrado para sua pesqu')]"));
        String mensagem2 = elemento.ExtrairTexto(By.xpath("//a[normalize-space()='Comece sua carreira em tecnologia com o Agi!']"));

        // Verifica se a mensagem retornada é para o primeiro cenário
        if (mensagem1.equals(mensagemRetornada)) {
            Assert.assertEquals(mensagemRetornada, mensagem1);
        }
        // Verifica se a mensagem retornada é para o segundo cenário
        else if (mensagem2.equals(mensagemRetornada)) {
            Assert.assertEquals(mensagemRetornada, mensagem2);
        }
        // Se nenhuma das mensagens corresponder, falha o teste
        else {
            Assert.fail("A mensagem retornada não corresponde a nenhum dos cenários esperados.");
        }
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
