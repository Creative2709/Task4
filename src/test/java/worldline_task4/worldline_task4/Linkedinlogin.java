package worldline_task4.worldline_task4;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Linkedinlogin {
	WebDriver driver;
	
	@Given("User is on login page with valid credentials from Excel")
	public void user_is_on_login_page_with_valid_credentials_from_excel() throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\WORLDLINE\\Testing\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        
        driver.manage().window().maximize();
        driver.get("https://www.linkedin.com");
		Thread.sleep(4000);


	}
	
	
	@When("User enters username and password")
	public void user_enters_username_and_password() throws IOException, InterruptedException {
		Object[][] data = Readexceldata.readData("D:\\WORLDLINE\\logindata.xlsx", "Sheet1");
        String username = (String) data[0][0];
        String password = (String) data[0][1];

        driver.findElement(By.id("session_key")).sendKeys(username);
		driver.findElement(By.id("session_password")).sendKeys(password);
		Thread.sleep(10000);

	}
	
	@Then("User clicks the login button")
	public void user_clicks_the_login_button() {
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/section[1]/div/div/form/div[2]/button")).click();
	}
	
	@Then("User logged in")
	public void user_logged_in() throws InterruptedException {
		Thread.sleep(10000);
		String expected_url= "https://www.linkedin.com/feed/?trk=homepage-basic_sign-in-submit";
		String actual_url = driver.getCurrentUrl();
		
		Assert.assertEquals(expected_url, actual_url);
		
	}
	
	@Then("browser close")
	public void browser_close() {
		driver.quit();
	}

}
