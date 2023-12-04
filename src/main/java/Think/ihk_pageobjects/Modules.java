package Think.ihk_pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Think.ihk_abstract.Abstract;


public class Modules extends Abstract {

	 WebDriver driver;
	

	public Modules(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
//	WebElement email = driver.findElement(By.id("userEmail"));


	@FindBy(xpath="(//div[@class='MuiBox-root css-1inketk'])[4]")
	public WebElement motifMan;
	
	@FindBy(xpath="(//div[@class='MuiBox-root css-1inketk'])[1]")
	public WebElement toolBox;
	
	@FindBy(xpath="(//div[@class='MuiBox-root css-1inketk'])[2]")
	public	WebElement export;
	
	@FindBy(xpath="(//div[@class='MuiBox-root css-1inketk'])[3]")
	public	WebElement approvals;
	
	@FindBy(xpath="(//div[@class='MuiBox-root css-1inketk'])[5]")
	public WebElement rollMan;
	
	@FindBy(xpath="(//div[@class='MuiBox-root css-1inketk'])[6]")
	public	WebElement textAssets;
	
	
	public void clickMotifMan() {
		motifMan.click();
	}

	public void clickToolBox() {
		toolBox.click();
	}

	public void clickExport() {
		export.click();
	}

	public void clickApprovals() {
		approvals.click();
	}

	public void clickRollMan() {
		rollMan.click();
	}

	public void clickTextAssets() {
		textAssets.click();
	}

	
	
}
