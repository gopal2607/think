package Think.ihk_abstract;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Think.ihk_pageobjects.DashBoard;
import Think.ihk_pageobjects.DisplayBanner;
import Think.ihk_pageobjects.LandingPage;
import Think.ihk_pageobjects.Modules;
import Think.ihk_pageobjects.MotifMan;


public class Abstract {

	WebDriver driver;
	
	public Abstract(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}



	public void waitForElementToAppear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

	
	public void waitForElementToDisappear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
	}
	
	public void waitForWebElementToAppear(WebElement findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(findBy));

	}
	
	public void waitForWebElementToDisappear(WebElement findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(findBy));

	}
	
	public void waitForListOfWebElementToAppear(List<WebElement> findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(findBy));

	}
	
	public void waitForListOfWebElementToDiappear(List<WebElement> findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfAllElements(findBy));

	}
	
	
	
	public void scrollPage() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scroll directly to the bottom of the page
		js.executeScript("window.scrollTo(0, 5000);");
		Thread.sleep(2000);
	}
	
	

}
