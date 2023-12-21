package Think.ihk_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Think.ihk_testcomponent.BaseTest;
import Think.ihk_testcomponent.Retry;

@Test(retryAnalyzer = Think.ihk_testcomponent.Retry.class )

public class displayBannerCreativePreview extends BaseTest {
	
	
	@Test(description = "Verify that 300*600 image should visible", retryAnalyzer = Retry.class)

	public void checkPreviewOfAds() throws InterruptedException {

		WebElement[] bannerSize = { displayBanner.iframe300_600, displayBanner.iframe250_250,displayBanner.iframe300_250, displayBanner.iframe160_600, displayBanner.iframe728_90,displayBanner.iframe800_250 };
		String[] replaceText = { "_300x600", "_250x250", "_300x250", "_160x600", "_728x90", "_800x250" };

		for (int i = 0; i < bannerSize.length ; i++) {
			System.out.println("banner : " + bannerSize[i]);
			displayBanner.diffResoAds(bannerSize[i], replaceText[i]);
		}

	}

	
	@Test(description ="Verify that selected option from the configuration should visible in the preview screen", retryAnalyzer = Retry.class )

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

	
	@Test(description ="Verify that  same creative preview should visible which i edited by content setting", retryAnalyzer = Retry.class )

	public void checkPreviewAfterEdit() throws InterruptedException {

		displayBanner.checkPreviewAfterEdit();
		

	}

}
