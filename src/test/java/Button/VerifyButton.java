package Button;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class VerifyButton {
	String given_url = "https://demoapps.qspiders.com/ui/alert?sublist=0";
	String button_givenurl = "https://demoapps.qspiders.com/ui/button";
	String rightclick_givenurl = "https://demoapps.qspiders.com/ui/button/buttonRight?sublist=1";
	String doubleclick_givenurl = "https://demoapps.qspiders.com/ui/button/buttonDouble?sublist=2";
	String submitClick_givenurl = "https://demoapps.qspiders.com/ui/button/buttonSubmit?sublist=3";
	String disabled_givenurl = "https://demoapps.qspiders.com/ui/button/buttonDisabled?sublist=4";

	@Test
	public void executeButton() {
// open the browser
		WebDriver driver = new ChromeDriver();
// maximize
		driver.manage().window().maximize();
// waiting condition
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
// enter the url
		driver.navigate().to(given_url);
		driver.findElement(By.xpath("//section[text()='Button']")).click();
// verify the button  is clicked
		String button_currenturl = driver.getCurrentUrl();
		assertEquals(button_givenurl, button_currenturl);
		System.out.println("button is clicked");
// verify the right click button
		driver.findElement(By.xpath("//a[text()='Right Click']")).click();
		String rightclick_currenturl = driver.getCurrentUrl();
		System.out.println(rightclick_currenturl);
		assertEquals(rightclick_givenurl, rightclick_currenturl);
		System.out.println("rightclick button page is displayed");
// Verify the double click button
		driver.findElement(By.xpath("//a[text()='Double Click']")).click();
		String doubleclick_currenturl = driver.getCurrentUrl();
		System.out.println(doubleclick_currenturl);
		assertEquals(doubleclick_givenurl, doubleclick_currenturl);
		System.out.println("double click button is clicked");
// Verify the disabled button
		driver.findElement(By.xpath("//a[text()='Disabled']")).click();
		String disabled_currenturl = driver.getCurrentUrl();
		System.out.println(disabled_currenturl);
		assertEquals(disabled_givenurl, disabled_currenturl);
		System.out.println("disabled button is clicked");
// verify the buttons (checkbox and submit button) are disable
		WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
		assertFalse(checkbox.isEnabled());
		System.out.println("checkbox is disabled");
		WebElement submit = driver.findElement(By.id("submitButton"));
		assertFalse(submit.isEnabled());
		System.out.println("submit is disabled");
// click on "submit click" button
		driver.findElement(By.xpath("//a[text()='Submit Click']")).click();
	String 	submitclick_currenturl=driver.getCurrentUrl();
	System.out.println(submitclick_currenturl);
// verify the button is enable
		driver.findElement(By.id("r5")).click();
		WebElement submitbutton = driver.findElement(By.xpath("//button[@type='submit']"));
	   System.out.println(submitbutton);
			assertTrue(submitbutton.isEnabled());
		System.out.println("button is enabled");
		submitbutton.click();
		driver.close();
	}

}
