package testcases;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestFindingElements {
	@Test
	public void findElement() {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		// WebDriverWait wait = new WebDriverWait(driver, 10);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2)).withMessage("This is user defined message");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://login.yahoo.com/?.src=ym&.lang=en-US&.intl=us&.done=https%3A%2F%2Fmail.yahoo.com%2Fd");
		driver.manage().window().maximize();
		driver.findElement(By.id("login-username")).sendKeys("naeem27us@yahoo.com");
		driver.findElement(By.name("signin")).click();
		driver.findElement(By.className("password")).sendKeys("Pakistan@1947");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("login-signin"))).click();
		// driver.findElement(By.id("login-signin")).click();

	}

}
