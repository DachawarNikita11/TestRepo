package MavenPackage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Rightclick {

WebDriver driver;
	
	String URL = "http://medialize.github.io/jQuery-contextMenu/demo.html";
	
	@BeforeClass
	public void Setup() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void rightClickTest() {
		driver.navigate().to(URL);
		By locator = By.cssSelector(".context-menu-one.box");
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator)); 
		WebElement element=driver.findElement(locator);
		Actions action = new Actions(driver);
				action	.contextClick(element);
		
		
		action.build().perform();
		WebElement elementEdit =driver.findElement(By.cssSelector(".context-menu-item.icon.icon-edit>span"));
		elementEdit.click();
		Alert alert=driver.switchTo().alert();
		String textEdit = alert.getText();
		Assert.assertEquals(textEdit, "clicked: edit", "Failed to click on Edit link");
	}
}
