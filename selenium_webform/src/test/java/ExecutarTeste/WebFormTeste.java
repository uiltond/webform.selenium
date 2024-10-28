package ExecutarTeste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import drivers.DriversFactory;
import page.WebFormPage;

public class WebFormTeste{
	
	WebFormPage page = new WebFormPage();
	
	@BeforeEach
	public void iniciarWebFormTeste() {
		DriversFactory.iniciarDriver("https://www.selenium.dev/selenium/web/web-form.html");
	}
	
	@AfterEach
	public void encerrarWebFormTeste() {
		DriversFactory.encerrarDriver();
	}

	@Test
	public void formulario () {
		
		assertEquals("Web form", page.validarTitle());
		page.preencherNome("Nome");
		page.preencherSenha("Segura");
		page.preencherTextArea("Área de texto.");
		assertEquals("Disabled input", page.obterPlaceholderCampoDesativado("placeholder"));
		assertEquals("Readonly input", page.obterValorCampoSomenteLeitura("value"));
	
		page.selecionarDropdown("One");
		page.preencherDatalist("San Francisco");
		
		page.fazerUploadArquivo();
		
		page.marcarCheckbox();
		page.desMarcarCheckbox();
		
		page.selecionarRadioButton();
		page.desSelecionarRadioButton();
		
		page.selecionarCor("#3d7b52");
		page.selecionarData("2024-12-31");
		
		page.ajustarSlider(8);
		
		page.enviarFormulario();
	
		assertEquals("Received!", page.validarMensagemAposEnviado());
		
	}

}
