package testlog1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class WebTest1 {
WebDriver driver ;
	
	@AfterMethod
	public void browserTerminate() {
		driver.close();
	}
	
	
	@Test
	public void urlLoad1() {
		driver.get("https://www.selenium.dev/");
	}
	
	@BeforeMethod
	public void browserLoad1() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	
	@BeforeSuite
	public void suitStartUp() {
		System.out.println("Bootup AutoTask 1");
	}
	
	@AfterSuite
	public void suitTermniate() {
		System.out.println("BootDown AutoTask 2");
	}
}
