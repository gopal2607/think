package Think.ihk_pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Think.ihk_abstract.Abstract;


public class LandingPage extends Abstract {

	 WebDriver driver;
	

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
//	WebElement email = driver.findElement(By.id("userEmail"));
	@FindBy(name  = "username")
	WebElement Email;

	@FindBy(name = "password")
	WebElement Password;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement Submit;
	
	@FindBy(xpath="//div[@role='alert']")
	WebElement errorMessage;

	public void LoginApplication(String email, String password) {
		Email.sendKeys(email);
		Password.sendKeys(password);
		Submit.click();
	}
	public String getErrorMessage()
	{
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}

	public void GoTo() {
		driver.get("https://stage.ihk.cmp.thjnk-247.de/");
	

	}
}
