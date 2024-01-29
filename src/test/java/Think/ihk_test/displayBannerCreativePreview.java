package Think.ihk_test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Think.ihk_testcomponent.BaseTest;
import Think.ihk_testcomponent.Retry;


public class displayBannerCreativePreview extends BaseTest {
	
	
	@Test(description = "Verify that all the ads banner should visible", retryAnalyzer = Retry.class, priority=0) 

	public void checkPreviewOfAds() throws InterruptedException {

		displayBanner.diffResoAds();
	
	}

	
	@Test(description ="Verify that selected option from the configuration should visible in the preview screen", retryAnalyzer = Retry.class,  priority=1 )

	public void configurationChangeByDropdown() throws InterruptedException {

		module.clickToolBox();
		displayBanner.clickOnDisplayBanner();
		displayBanner.zuDenButton.get(0).click();
		displayBanner.ceativeListVorschauBtn.get(1).click(); // view the first item from the list

		landingpage.waitForElementToAppear(By.xpath("(//input[@role='combobox'])[1]"));

		displayBanner.creativePreviewDropdownBtn.click();
		displayBanner.selectOption.get(2).click();

		String actualSelectedOption = driver
				.findElement(By.xpath("(//div[@class='MuiBox-root css-175ha26'])//input[@role='combobox']"))
				.getAttribute("value");

		String expectedHeader = displayBanner.creativePreviewSubheader.getText();

		String[] expectedHeaderSplit = expectedHeader.split("\\|"); // split text
		String expectedUid = expectedHeaderSplit[0].trim(); // take the first part

		String[] actualSelectedOptionSplit = actualSelectedOption.split("\\s+"); // split text
		String actualSelectedOptionUid = actualSelectedOptionSplit[0].trim(); // take the first part
		Assert.assertEquals(expectedUid, actualSelectedOptionUid);
		
		
		

	}

	
	@Test(description ="Verify that  same creative preview should visible which i edited by content setting", retryAnalyzer = Retry.class,  priority=2 )

	public void checkPreviewAfterEdit() throws InterruptedException {

		System.out.println("afteredit ++++++++++");
		displayBanner.checkPreviewAfterEdit();
		System.out.println("afteredit -------");
		

	}
	
	
	
}