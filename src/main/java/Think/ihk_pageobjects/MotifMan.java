package Think.ihk_pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Think.ihk_abstract.Abstract;


public class MotifMan extends Abstract {

	 WebDriver driver;
	

	public MotifMan(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath  = "//div[@class='MuiDataGrid-virtualScrollerContent css-0']//div[@data-field='motif']")
	public List <WebElement> motifNameList;
	
	@FindBy(xpath  = "//div[@class='MuiDataGrid-virtualScrollerContent css-0']//div[@data-field='image']/img")
	public List <WebElement> motifImgList;


	public void refreshMotifList() {
		motifNameList = driver.findElements(By.xpath("//div[@class='MuiDataGrid-virtualScrollerContent css-0']//div[@data-field='motif']"));
    }
		// TODO Auto-generated method stub
		
	
}
