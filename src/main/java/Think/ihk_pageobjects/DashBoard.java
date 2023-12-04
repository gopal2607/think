package Think.ihk_pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Think.ihk_abstract.Abstract;


public class DashBoard extends Abstract {

	 WebDriver driver;
	

	public DashBoard(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath  = "(//div[@class='MuiImageListItemBar-title css-1w4d4gp'])")
	public List <WebElement> motiveNameList;

	
	@FindBy(xpath = "(//li[contains(@class,'MuiImageListItem-root MuiImageListItem-standard')])/img")
	public List<WebElement> motiveImg;
}


