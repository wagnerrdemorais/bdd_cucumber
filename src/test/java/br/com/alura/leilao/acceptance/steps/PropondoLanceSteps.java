package br.com.alura.leilao.acceptance.steps;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.math.BigDecimal;
import java.util.ArrayList;

public class PropondoLanceSteps {

    private Lance lance;
    private Leilao leilao;
    private ArrayList<Lance> lanceList;

    @Given("dado um lance valido")
    public void dado_um_lance_valido() {
        Usuario usuario = new Usuario("fulano");
        lance = new Lance(usuario, BigDecimal.TEN);
        leilao = new Leilao("Tablet Tal");
    }

    @When("Quando propoe ao leilao")
    public void quando_propoe_o_lance() {
        leilao.propoe(lance);
    }

    @Then("Entao o lance eh aceito")
    public void entao_o_lance_eh_aceito() {
        Assert.assertEquals(1, leilao.getLances().size());
        Assert.assertEquals(BigDecimal.TEN, leilao.getLances().get(0).getValor());
    }

    @Before
    public void setup() {
        this.lanceList = new ArrayList<>();
        leilao = new Leilao("Tablet Tal");
    }

    @Given("um lance de {double} reais do usuario {string}")
    public void umLanceDeReaisDoUsuarioFulano(Double valor, String nomeUsuario) {
        Lance lance = new Lance(new Usuario(nomeUsuario), new BigDecimal(valor));
        lanceList.add(lance);

    }

    @When("propoe varios lances ao leilao")
    public void propoeVariosLancesAoLeilao() {
        this.lanceList.forEach(lance -> leilao.propoe(lance));
    }

    @Then("os lances sao aceitos")
    public void osLancesSaoAceitos() {
        Assert.assertEquals(this.lanceList.size(), leilao.getLances().size());
        Assert.assertEquals(this.lanceList.get(0).getValor(), leilao.getLances().get(0).getValor());
        Assert.assertEquals(this.lanceList.get(1).getValor(), leilao.getLances().get(1).getValor());
    }

}
