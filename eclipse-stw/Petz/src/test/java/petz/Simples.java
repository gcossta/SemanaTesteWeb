// 1 - Nome do Pacote
package petz;

// 2 - Bibliotecas Importadas
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;


// 3 - Classe
public class Simples {
	// 3.1 - Atributos (características)
	String url; 		//endereço do site alvo
	WebDriver driver; 	//objeto do Selenium WebDriver
	
	// 3.2 - Métodos ou Funções
	@Before
	public void iniciar() {
		url = "https://www.petz.com.br"; //endereço da Petz
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize(); //maximizar a janela do browser
		driver.manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS); //espera implicita de 30 segundos
	}
	
	@After
	public void finalizar() {
		driver.quit();
	}
	
	@Test
	public void abrirPagina() {
		driver.get(url); //abrir a pagina do site Petz
		assertEquals("Pet Shop: Petz o maior pet shop do Brasil.", driver.getTitle());
	}

}
