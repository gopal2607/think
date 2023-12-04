package Think.ihk_test;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Think.ihk_testcomponent.BaseTest;

public class displayBannerCreativePreview extends BaseTest {
	SoftAssert softAssert = new SoftAssert();

	@Test
	public void $300By600() throws InterruptedException {
		landingpage.LoginApplication("ruchi@scaletech.xyz", "Scaletech@123");
		module.clickToolBox();
		displayBanner.clickOnDisplayBanner();
		displayBanner.zuDenButton.get(0).click();
		displayBanner.ceativeListVorschauBtn.get(1).click(); // view the first item from the list
//		Thread.sleep(2000);
//		displayBanner.creativePreviewDropdownBtn.click();
//		Thread.sleep(2000);

		displayBanner.editPreviewBtn.click(); // edit click

		driver.findElement(By.xpath("(//input[@role='combobox'])[2]")).click(); // click on farb dropdown
		driver.findElement(By.xpath("//li[@role='option'][2]")).click(); // click on second option
		System.out.println(
				"value : " + driver.findElement(By.xpath("(//input[@role='combobox'])[2]")).getAttribute("value")); // value

		Thread.sleep(2000);

		driver.findElement(By.xpath("(//input[@role='combobox'])[3]")).click(); // click on headline
		driver.findElement(By.xpath("//li[@role='option'][2]")).click(); // click on second option

		driver.findElement(By.xpath("(//input[@role='combobox'])[4]")).click(); // click on claim
		driver.findElement(By.xpath("//li[@role='option'][1]")).click(); // click on first option

		driver.findElement(By.xpath("(//input[@role='combobox'])[5]")).click(); // click on positioning
		driver.findElement(By.xpath("//li[@role='option'][1]")).click(); // click on first option

		driver.findElement(By.xpath("(//input[@role='combobox'])[6]")).click(); // click on motif
		driver.findElement(By.xpath("//div[@role='option'][2]")).click(); // click on second option

		driver.findElement(By.xpath("(//input[@role='combobox'])[7]")).click(); // click on calltoaction
		driver.findElement(By.xpath("//li[@role='option'][2]")).click(); // click on second option

		driver.findElement(By.xpath("//textarea[@placeholder='exit']")).sendKeys("Test");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[text()='Preview']")).click(); // click on preview
		driver.findElement(By.xpath("//button[@aria-label='creative editor schließen']")).click(); // click on close

		// =========================================================================================================================
		System.out.println("select : " + displayBanner.selectOption.get(2).getText());
		System.out.println(displayBanner.creativePreview160600Img.getAttribute("src")); // get the full img url
		Assert.assertTrue(displayBanner.creativePreview160600Img.isDisplayed());

		WebElement iframeElement = driver.findElement(By.xpath(
				"//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-auto css-1f3rkw9'][1]//iframe[@class='iframe_iframe__5BHQl']")); // Iframe

		driver.switchTo().frame(iframeElement); // Switch to the iframe

		landingpage.waitForElementToAppear(By.xpath("//div[@id='cta']")); // Wait for cta button to appear
		// Now you're inside the iframe, and you can interact with its content
		System.out.println(driver.findElement(By.xpath("//div[@id='bg']/img")).getAttribute("src")); // get bg url
		System.out.println("HeadLinetext : " + driver.findElement(By.xpath("//div[@id='headline']")).getText()); // get
																													// headline
		System.out.println("Claimtext : " + driver.findElement(By.xpath("//div[@id='claim']")).getText()); // get
																											// claimtext
		System.out.println("Positext : " + driver.findElement(By.xpath("//div[@id='positioning']")).getText()); // get
																												// posi
																												// text
		System.out.println("cta : " + driver.findElement(By.xpath("//div[@id='cta']/img")).getAttribute("src")); // get
																													// cta
																													// url
		System.out.println("logo : " + driver.findElement(By.xpath("//div[@id='logo']/img")).getAttribute("src")); // get
																													// logo
																													// url
		System.out.println("motif : " + driver.findElement(By.xpath("//div[@id='motif']/img")).getAttribute("src")); // get
																														// motif
																														// url

		Assert.assertTrue(driver.findElement(By.xpath("//body[@class='ready image']")).isDisplayed()); // Assert that
																										// image is
																										// fully loaded

		driver.switchTo().defaultContent();// Switch back to the default content when done with the iframe

	}
	
	
	

	@DisplayName("verify that selected option details should visible in the preview screen")
	@Test
	public void configurationChangeByDropdown() throws InterruptedException {
		landingpage.LoginApplication("ruchi@scaletech.xyz", "Scaletech@123");
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

		String[] actualSelectedOptionSplit = actualSelectedOption.split("\\s+");; // split text
		String actualSelectedOptionUid = actualSelectedOptionSplit[0].trim(); // take the first part

		Assert.assertEquals(expectedUid, actualSelectedOptionUid);

	}

}
