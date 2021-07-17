package br.com.alura.leilao.acceptance.steps;

import br.com.alura.leilao.e2e.pages.Browser;
import br.com.alura.leilao.e2e.pages.LeiloesPage;
import br.com.alura.leilao.e2e.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps {

    private Browser browser;
    private LoginPage loginPage;
    private LeiloesPage leiloesPage;

    @Given("o usuario valido")
    public void o_usuario_valido() {
        this.browser = new Browser();
        this.browser.seed();
        this.loginPage = browser.getLoginPage();
    }

    @When("realiza login")
    public void realiza_login() {
        leiloesPage = this.loginPage.realizaLoginComo("fulano", "pass");
    }

    @Then("eh redirecionado para a pagina de leiloes")
    public void eh_redirecionado_para_a_pagina_de_leiloes() {
        Assert.assertTrue(this.leiloesPage.estaNaPaginaDeLeiloes());
        browser.clean();
    }

    @Given("o usuario invalido")
    public void o_usuario_invalido() {
        browser = new Browser();
        browser.seed();
        loginPage = browser.getLoginPage();
    }

    @When("tenta se logar")
    public void tenta_se_logar() {
        this.loginPage.realizaLoginComo("fulano", "idk");
    }

    @Then("continua na pagina de login")
    public void continua_na_pagina_de_login() {
        Assert.assertTrue(this.loginPage.estaNaPaginaDeLoginComErro());
        this.browser.clean();
    }
}
