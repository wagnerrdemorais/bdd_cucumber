package br.com.alura.leilao.acceptance.steps;

import br.com.alura.leilao.e2e.pages.Browser;
import br.com.alura.leilao.e2e.pages.LeiloesPage;
import br.com.alura.leilao.e2e.pages.LoginPage;
import br.com.alura.leilao.e2e.pages.NovoLeilaoPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LeilaoSteps {


    private Browser browser;
    private LoginPage loginPage;
    private LeiloesPage leiloesPage;
    private NovoLeilaoPage novoLeilaoPage;

    @Given("um usuario logado")
    public void um_usuario_logado() {
        this.browser = new Browser();
        this.browser.seed();
        this.loginPage = browser.getLoginPage();
        this.leiloesPage = this.loginPage.realizaLoginComoFulano();
    }

    @When("acessa a pagina de novo leilao")
    public void acessa_a_pagina_de_novo_leilao() {
        this.novoLeilaoPage = this.leiloesPage.visitaPaginaParaCriarUmNovoLeilao();
    }

    @When("preenche o formulario com dados validos")
    public void preenche_o_formulario_com_dados_validos() {
        this.leiloesPage = this.novoLeilaoPage.preencheForm("Tablet", "1500.00", "01/11/1999");
    }

    @Then("volta para a pagina de leiloes")
    public void volta_para_a_pagina_de_leiloes() {
        Assert.assertTrue(this.leiloesPage.estaNaPaginaDeLeiloes());
    }

    @Then("o novo leilao aparece na tabela")
    public void o_novo_leilao_aparece_na_tabela() {
        this.leiloesPage.existe ("Tablet", "1500.00", "01/11/1999", "fulano");
        browser.clean();
    }
}
