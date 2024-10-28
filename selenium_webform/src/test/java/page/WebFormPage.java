package page;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import drivers.DriversFactory;

public class WebFormPage extends DriversFactory {

	public String validarTitle() {
		return driver.getTitle();
	}

	public void preencherNome(String value) {
		driver.findElement(By.name("my-text")).sendKeys(value);
	}

	public void preencherSenha(String value) {
		driver.findElement(By.name("my-password")).sendKeys(value);
	}

	public void preencherTextArea(String value) {
		driver.findElement(By.name("my-textarea")).sendKeys(value);
	}

	public String obterPlaceholderCampoDesativado(String value) {
		return driver.findElement(By.cssSelector("input[type='text'][disabled]")).getAttribute(value);
		// return disabledInput.getAttribute("placeholder");
	}

	public String obterValorCampoSomenteLeitura(String value) {
		return driver.findElement(By.cssSelector("input[readonly]")).getAttribute(value);
	}

	public void selecionarDropdown(String opcao) {
		Select dropdown = new Select(driver.findElement(By.name("my-select")));
		dropdown.selectByVisibleText(opcao);
	}

	public void preencherDatalist(String valor) {
		driver.findElement(By.name("my-datalist")).sendKeys(valor);
	}

	public void fazerUploadArquivo() {
		URL resource = getClass().getResource("/imagem/selenium.png"); // Obtém o caminho do arquivo da imagem no
																		// diretório de resources

		if (resource == null) {
			throw new IllegalArgumentException("Arquivo não encontrado no diretório de resources!");
		}

		String filePath = new File(resource.getFile()).getAbsolutePath();

		driver.findElement(By.name("my-file")).sendKeys(filePath); // Faz o upload do arquivo usando o caminho obtido

	}

	public void marcarCheckbox() {
		driver.findElement(By.id("my-check-1")).click();
	}

	public void desMarcarCheckbox() {
		driver.findElement(By.id("my-check-2")).click();
	}

	public void selecionarRadioButton() {
		driver.findElement(By.id("my-radio-1")).click();
	}

	public void desSelecionarRadioButton() {
		driver.findElement(By.id("my-radio-2")).click();
	}

	public void selecionarCor(String corHex) {
		driver.findElement(By.name("my-colors")).sendKeys(corHex);
	}

	public void selecionarData(String data) {
		driver.findElement(By.name("my-date")).sendKeys(data);
		driver.findElement(By.name("my-date")).sendKeys(Keys.TAB);
	}

	public void ajustarSlider(int valor) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementsByName('my-range')[0].value = " + valor + ";");
	}

	public void enviarFormulario() {
		driver.findElement(By.cssSelector("button[type='submit']")).click();

	}

	public String validarMensagemAposEnviado() {
		return driver.findElement(By.id("message")).getText();

	}
}
