package petz;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import pages.Home;
import pages.Lista;

import static org.junit.Assert.assertEquals;

public class ComprarProduto {
	
	// 3.1 - Atributos (caracter?sticas)
	String url; 		//endere?o do site alvo
	WebDriver driver; 	//objeto do Selenium WebDriver
	
	Home home; 			//objeto "home" herdado a classe "Home"
	Lista lista;		//objeto "lista" herdado da classe Lista
	
	// 3.2 - M?todos ou Fun??es
	@Before
	public void iniciar() {
		url = "https://www.petz.com.br"; //endere?o da Petz
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize(); //maximizar a janela do browser
		driver.manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS); //espera implicita de 30 segundos
		
		home = new Home(driver);	//instanciar a classe Home
		lista = new Lista(driver);	//instanciar a classe Lista
	}
	
	@After
	public void finalizar() {
		driver.quit();
	}
	
	@Dado("^que acesso o site Petz$")
	public void que_acesso_o_site_Petz() {
		driver.get(url);	 //abre o site da Petz
		System.out.println("Passo 1");
	}

	@Quando("^busco por \"([^\"]*)\" e pressiono Enter$")
	public void busco_por_e_pressiono_Enter(String produto) {
		home.buscarProdutoComEnter(produto);
		System.out.println("Passo 2");
	    
	}

	@Entao("^exibe uma lista de produtos relacionado com \"([^\"]*)\"$")
	public void exibe_uma_lista_de_produtos_relacionado_com(String produto)  {
		assertEquals("RESULTADOS PARA \"" + produto.toUpperCase() + "\"", lista.lerCabecalhoResultado());
	    System.out.println("Passo 3");
	}

	@Quando("^escolho \"([^\"]*)\"$")
	public void escolho(String produto)  {
		lista.clicarNoProduto(produto);
		System.out.println("Passo 4");
	}

	@Entao("^exibe para o \"([^\"]*)\" o preco de \"([^\"]*)\"$")
	public void exibe_para_o_o_preco_de(String arg1, String arg2) {
		System.out.println("Passo 5");
	}


}
