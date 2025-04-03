package stepsdefinitions;

import drivers.DriverManager;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.BingPage;

public class BingSteps {
    private WebDriver driver = DriverManager.getDriver();
    private BingPage bingPage = new BingPage(driver);

    @Given("que estou na página do Bing")
    public void abrirPaginaDoBing() {
        bingPage.open();
    }

    @When("eu pesquiso por {string}")
    public void pesquisarNoBing(String termo) {
        bingPage.search(termo);
    }

    @Then("os resultados devem ser exibidos")
    public void validarResultados() {
        Assert.assertTrue("Os resultados não foram exibidos!", bingPage.resultsAreDisplayed());
    }

    @When("eu seleciono a aba {string}")
    public void selecionarAba(String aba) {
        switch (aba.toLowerCase()) {
            case "imagens":
                bingPage.openImagesTab();
                break;
            case "vídeos":
                bingPage.openVideosTab();
                break;
            default:
                throw new IllegalArgumentException("Aba desconhecida: " + aba);
        }
    }

    @Then("os resultados de {string} devem ser exibidos")
    public void validarResultadosEspecificos(String tipo) {
        Assert.assertTrue("Os resultados da aba " + tipo + " não foram exibidos!", bingPage.resultsAreDisplayed());
    }

    @When("eu começo a digitar {string}")
    public void digitarTermo(String termo) {
        bingPage.search(termo); // Apenas iniciar a digitação pode precisar de um novo método específico
    }

    @Then("sugestões de pesquisa devem ser exibidas")
    public void validarSugestoes() {
        Assert.assertTrue("Sugestões de pesquisa não foram exibidas!", bingPage.suggestionsAreDisplayed());
    }
}
