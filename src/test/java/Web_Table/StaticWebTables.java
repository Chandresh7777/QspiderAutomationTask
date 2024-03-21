package Web_Table;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class StaticWebTables {
	String given_url = "https://demoapps.qspiders.com/ui/alert?sublist=0";
	String table_givenurl = "https://demoapps.qspiders.com/ui/table";

	@Test
	public void ExecuteWebTable() {
		// open the browser
		WebDriver driver = new ChromeDriver();
		// maximize
		driver.manage().window().maximize();
		// waiting condition
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		// enter the url
		driver.navigate().to(given_url);
		driver.findElement(By.xpath("//section[text()='Web Table']")).click();
		// Verify the WebTable
		String table_currenturl = driver.getCurrentUrl();
		assertEquals(table_givenurl, table_currenturl);
		System.out.println("web table page is opened");
		// Get the text of the cell
		WebElement cell = driver.findElement(By.xpath("//th[contains(text(),'Levis Shirt')]"));
		String cellValue = cell.getText();
		System.out.println(cellValue);
		// Get All data from the columns
		List<WebElement> rows = driver.findElements(By.xpath("//tr/../tr"));
		for (WebElement row : rows) {
			System.out.println(row.getText());
		}

	}
}
