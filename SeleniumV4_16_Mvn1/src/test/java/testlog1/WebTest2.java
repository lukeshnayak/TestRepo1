package testlog1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class WebTest2 {
	
WebDriver driver ;
	
	
	@AfterMethod
	public void browserTerminate() {
		driver.close();
	}
	
	@Test(invocationCount = 200)
	public void urlLoad1() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//img[contains(@alt,'profile')]/parent::span")).click();
		driver.findElement(By.linkText("Logout")).click();
	}
	
	/*
	@Test(dependsOnMethods = "urlLoad1")
	public void loginActions() {
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	@Test(dependsOnMethods = "loginActions")
	public void logoutActions() {
		driver.findElement(By.xpath("//img[contains(@alt,'profile')]/parent::span")).click();
		driver.findElement(By.linkText("Logout")).click();
	}
	
	*/
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
