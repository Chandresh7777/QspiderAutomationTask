package Web_Table;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TablePagination {

	String given_url = "https://demoapps.qspiders.com/ui/alert?sublist=0";
	String table_pagination_givenurl ="https://demoapps.qspiders.com/ui/table/tablePagination";
	@Test
	public void ExecuteWebTable()  { 
		// open the browser
				WebDriver driver = new ChromeDriver();
		// maximize
				driver.manage().window().maximize();
		// waiting condition
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		// enter the url
				driver.navigate().to(given_url);
				driver.findElement(By.xpath("//section[text()='Web Table']")).click();
		//Verify the WebTable
				driver.findElement(By.xpath("//a[text()='Table Pagination']")).click();
				String table_pagination_currenturl = driver.getCurrentUrl();
				assertEquals(table_pagination_givenurl,table_pagination_currenturl);
				System.out.println("table_pagination page is opened"); 
		
		
			//get the data of the cell from 3rd page 
				List<WebElement> page=driver.findElements(By.xpath("//li[text()='1']/../li"));
			for (WebElement web : page) {
				web.click();
			}
				String data = driver.findElement(By.xpath("//th[text()='Denim']")).getText();
			System.out.println(data);
		// Get all the rows in the table body
				List<WebElement> rows = driver.findElements(By.xpath("//tr/../tr"));
					
				    for (WebElement row : rows) {
				       
				        System.out.println(row.getText());
				    }
				    
		        

		        driver.close();
				
	}
}
