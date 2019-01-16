package MavenPackage;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropDownList {
@Test		// Create a new instance of the FireFox driver

public void test() throws InterruptedException{
		WebDriver driver = new ChromeDriver();
		 System.setProperty("webdriver.chrome.driver","E:\\JAVA_Experiments_Interview\\JAVA_EXPERIMENT\\chromedriver.exe");
		// Put an Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
		// Launch the URL
		driver.get("http://toolsqa.wpengine.com/automation-practice-form");
 
		System.out.println(Thread.currentThread().getId());
		// Step 3: Select 'Selenium Commands' Multiple select box ( Use Name locator to identify the element )
		Select oSelect = new Select(driver.findElement(By.name("selenium_commands")));
 
		// Step 4: Select option 'Browser Commands' and then deselect it (Use selectByIndex and deselectByIndex)
		oSelect.selectByIndex(0); 
 
		// Step 5: Select option 'Navigation Commands'  and then deselect it (Use selectByVisibleText and deselectByVisibleText)
		oSelect.selectByVisibleText("Navigation Commands");
 
		// Step 6: Print and select all the options for the selected Multiple selection list.
		List<WebElement> oSize = oSelect.getOptions();
		int iListSize = oSize.size();
 
		List<WebElement> selectedOptions = oSelect.getAllSelectedOptions();
		for (WebElement option : selectedOptions){
		        System.out.println(option.getText());
		}
		// Setting up the loop to print all the options
		for(int i =0; i < iListSize ; i++){
			// Storing the value of the option	
			String sValue = oSelect.getOptions().get(i).getText();
           
			System.out.println(sValue);
 
			// Selecting all the elements one by one
			oSelect.selectByIndex(i);
			Thread.sleep(2000);
			}
 
		// Step 7: Deselect all
		oSelect.deselectAll();
 
		// Kill the browser
		driver.close();
		}
}
