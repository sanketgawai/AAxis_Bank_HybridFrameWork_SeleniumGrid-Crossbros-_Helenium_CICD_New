package temp;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class Temp2 {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://selectorshub.com/xpath-practice-page/");

		
//		#kils → table inside the room
		WebElement host = driver.findElement(By.id("userName"));
		SearchContext shadowRoot = host.getShadowRoot();
		//locate input inside shadow DOM
		WebElement username = shadowRoot.findElement(By.cssSelector("#kils"));//***Always use CSS selector inside shadow DOM
		//WebElement username = shadowRoot.findElement(By.xpath("input[@id='kils']"));//this will not work
		// send data
		username.sendKeys("Amit");
		
		WebElement car = driver.findElement(By.xpath("//select[@id='cars']"));
		Select s = new Select(car);
		s.selectByVisibleText("Audi");
		
		WebElement iframePage = driver.findElement(By.xpath("//span[contains(text(),'practice iframe and nested iframe scenarios.')]/ancestor::a"));
		iframePage.click();
		
	
		ArrayList<String> addr = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(1));
		
		wait.until(ExpectedConditions.urlContains("https://selectorshub.com/iframe-scenario/"));
		
		WebElement iframe = driver.findElement(By.xpath("//iframe[@id='pact1']"));
		driver.switchTo().frame(iframe);
		
		WebElement firstCrush = driver.findElement(By.xpath("//button[@id='lost']/preceding-sibling::input"));
		firstCrush.sendKeys("ada");
		
	}
	
}

