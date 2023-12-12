package Think.ihk_test;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Think.ihk_testcomponent.BaseTest;
import Think.ihk_testcomponent.Retry;

@Test(retryAnalyzer = Think.ihk_testcomponent.Retry.class )

public class displayBannerCreativePreview extends BaseTest {
	SoftAssert softAssert = new SoftAssert();

	static final String sun = "https://s3.eu-central-1.amazonaws.com/ads.ihk-stage/assets/themes/sun.jpg";
	static final String hibiscus = "https://s3.eu-central-1.amazonaws.com/ads.ihk-stage/assets/themes/hibiscus.jpg";
	static final String lime = "https://s3.eu-central-1.amazonaws.com/ads.ihk-stage/assets/themes/lime.jpg";
	static final String mauve = "https://s3.eu-central-1.amazonaws.com/ads.ihk-stage/assets/themes/mauve.jpg";
	static final String mandarin = "https://s3.eu-central-1.amazonaws.com/ads.ihk-stage/assets/themes/mandarin.jpg";

	public static final String[] bgArray = { sun, hibiscus, lime, mauve, mandarin };
	

	@Test(description ="Verify that  300*600 image should visible", retryAnalyzer = Retry.class )

	public void checkPreview300_600() throws InterruptedException {

		module.clickToolBox();
		displayBanner.clickOnDisplayBanner();
		displayBanner.zuDenButton.get(0).click();
		displayBanner.ceativeListVorschauBtn.get(0).click(); // view the first item from the list

		landingpage.waitForElementToAppear(By.xpath("(//input[@role='combobox'])[1]"));
		displayBanner.editPreviewBtn.click();// click on the edit preview button
		
		// Step 1: Declare an array
		String[] editPreviewArray = new String[6];
		String farbValue = displayBanner.farb.getAttribute("value");

		if (farbValue.equals("sun")) {
			editPreviewArray[4] = bgArray[0];

		} else if (farbValue.equals("hibiscus")) {
			editPreviewArray[4] = bgArray[1];

		} else if (farbValue.equals("lime")) {
			editPreviewArray[4] = bgArray[2];

		} else if (farbValue.equals("mauve")) {
			editPreviewArray[4] = bgArray[3];

		} else if (farbValue.equals("mandarin")) {
			editPreviewArray[4] = bgArray[4];

		} else {
			System.out.println("No matching background found.");
		}
		
		System.out.println("editPreviewArray[4] : " + editPreviewArray[4]);

		// Step 2: Store values in the array
		editPreviewArray[0] = displayBanner.headline.getAttribute("value");
		editPreviewArray[1] = displayBanner.claim.getAttribute("value");
		editPreviewArray[2] = displayBanner.positioning.getAttribute("value");
		editPreviewArray[3] = displayBanner.motifUrl.getAttribute("src").replace("_preview", "");
		editPreviewArray[5] = "https://s3.eu-central-1.amazonaws.com/ads.ihk-stage/assets/logo/global_v.svg";
//        editPreviewArray[6] = displayBanner.cta.getAttribute("value");  

		displayBanner.closeBtn.click(); // click on close

		driver.switchTo().frame(displayBanner.iframe300_600); // Switch to the iframe

		landingpage.waitForElementToAppear(By.xpath("//div[@id='cta']")); // Wait for cta button to appear

		// Declare an array
		String[] actualPreviewArray = new String[6];

		// Step 2: Store values in the array
		actualPreviewArray[0] = displayBanner.actualHeadline.getAttribute("textContent").replaceAll("-", "").trim();
		actualPreviewArray[1] = displayBanner.actualClaim.getAttribute("textContent").trim();
		actualPreviewArray[2] = displayBanner.actualPositioning.getAttribute("textContent").trim();
		actualPreviewArray[3] = displayBanner.actualMotif.getAttribute("src").replace("_300x600", "");
		actualPreviewArray[4] = displayBanner.actualBg.getAttribute("src").replace("_300x600", "");
		actualPreviewArray[5] = driver.findElement(By.xpath("//div[@id='logo']/img")).getAttribute("src");
//        actualPreviewArray[6] = displayBanner.actualCta.getText().replaceAll("\\s+", " ").trim(); CTA is not possible because in the cta div, we didn't have text
		softAssert.assertTrue(driver.findElement(By.xpath("//body[@class='ready image']")).isDisplayed()); // Assert image is fully loaded

		driver.switchTo().defaultContent();
		System.out.println("editPreviewArray : " + Arrays.toString(editPreviewArray));
		System.out.println("actualPreviewArray : " + Arrays.toString(actualPreviewArray));

		softAssert.assertEquals(actualPreviewArray, editPreviewArray);
		softAssert.assertAll();		
		

	}

	
	@Test(description ="Verify that 160*600 image should visible", retryAnalyzer = Retry.class )

	public void checkPreview160_600() throws InterruptedException {

		module.clickToolBox();
		displayBanner.clickOnDisplayBanner();
		displayBanner.zuDenButton.get(0).click();
		displayBanner.ceativeListVorschauBtn.get(0).click(); // view the first item from the list

		landingpage.waitForElementToAppear(By.xpath("(//input[@role='combobox'])[1]"));
		displayBanner.editPreviewBtn.click();// click on the edit preview button
		
		// Step 1: Declare an array
		String[] editPreviewArray = new String[6];
		String farbValue = displayBanner.farb.getAttribute("value");

		if (farbValue.equals("sun")) {
			editPreviewArray[4] = bgArray[0];

		} else if (farbValue.equals("hibiscus")) {
			editPreviewArray[4] = bgArray[1];

		} else if (farbValue.equals("lime")) {
			editPreviewArray[4] = bgArray[2];

		} else if (farbValue.equals("mauve")) {
			editPreviewArray[4] = bgArray[3];

		} else if (farbValue.equals("mandarin")) {
			editPreviewArray[4] = bgArray[4];

		} else {
			System.out.println("No matching background found.");
		}
		
		System.out.println("editPreviewArray[4] : " + editPreviewArray[4]);

		// Step 2: Store values in the array
		editPreviewArray[0] = displayBanner.headline.getAttribute("value");
		editPreviewArray[1] = displayBanner.claim.getAttribute("value");
		editPreviewArray[2] = displayBanner.positioning.getAttribute("value");
		editPreviewArray[3] = displayBanner.motifUrl.getAttribute("src").replace("_preview", "");
		editPreviewArray[5] = "https://s3.eu-central-1.amazonaws.com/ads.ihk-stage/assets/logo/global_v.svg";
//        editPreviewArray[6] = displayBanner.cta.getAttribute("value");  

		displayBanner.closeBtn.click(); // click on close

		driver.switchTo().frame(displayBanner.iframe160_600); // Switch to the iframe

		landingpage.waitForElementToAppear(By.xpath("//div[@id='cta']")); // Wait for cta button to appear

		// Declare an array
		String[] actualPreviewArray = new String[6];

		// Step 2: Store values in the array
		actualPreviewArray[0] = displayBanner.actualHeadline.getAttribute("textContent").replaceAll("-", "").trim();
		actualPreviewArray[1] = displayBanner.actualClaim.getAttribute("textContent").trim();
		actualPreviewArray[2] = displayBanner.actualPositioning.getAttribute("textContent").trim();
		actualPreviewArray[3] = displayBanner.actualMotif.getAttribute("src").replace("_160x600", "");
		actualPreviewArray[4] = displayBanner.actualBg.getAttribute("src").replace("_160x600", "");
		actualPreviewArray[5] = driver.findElement(By.xpath("//div[@id='logo']/img")).getAttribute("src");
//        actualPreviewArray[6] = displayBanner.actualCta.getText().replaceAll("\\s+", " ").trim(); CTA is not possible because in the cta div, we didn't have text
		softAssert.assertTrue(driver.findElement(By.xpath("//body[@class='ready image']")).isDisplayed()); // Assert image is fully loaded
		driver.switchTo().defaultContent();
		
		System.out.println("editPreviewArray : " + Arrays.toString(editPreviewArray));
		System.out.println("actualPreviewArray : " + Arrays.toString(actualPreviewArray));

		softAssert.assertEquals(actualPreviewArray, editPreviewArray);
	
		softAssert.assertAll();		
		
		


	}
	
	
	@Test(description ="Verify that  300*250 image should visible", retryAnalyzer = Retry.class )

	public void checkPreview300_250() throws InterruptedException {

		module.clickToolBox();
		displayBanner.clickOnDisplayBanner();
		displayBanner.zuDenButton.get(0).click();
		Thread.sleep(2000);
		displayBanner.ceativeListVorschauBtn.get(0).click(); // view the first item from the list

		landingpage.waitForElementToAppear(By.xpath("(//input[@role='combobox'])[1]"));
		displayBanner.editPreviewBtn.click();// click on the edit preview button
		
		// Step 1: Declare an array
		String[] editPreviewArray = new String[6];
		String farbValue = displayBanner.farb.getAttribute("value");

		if (farbValue.equals("sun")) {
			editPreviewArray[4] = bgArray[0];

		} else if (farbValue.equals("hibiscus")) {
			editPreviewArray[4] = bgArray[1];

		} else if (farbValue.equals("lime")) {
			editPreviewArray[4] = bgArray[2];

		} else if (farbValue.equals("mauve")) {
			editPreviewArray[4] = bgArray[3];

		} else if (farbValue.equals("mandarin")) {
			editPreviewArray[4] = bgArray[4];

		} else {
			System.out.println("No matching background found.");
		}
		

		// Step 2: Store values in the array
		editPreviewArray[0] = displayBanner.headline.getAttribute("value");
		editPreviewArray[1] = displayBanner.claim.getAttribute("value");
		editPreviewArray[2] = displayBanner.positioning.getAttribute("value");
		editPreviewArray[3] = displayBanner.motifUrl.getAttribute("src").replace("_preview", "");
		editPreviewArray[5] = "https://s3.eu-central-1.amazonaws.com/ads.ihk-stage/assets/logo/global_v.svg";
//        editPreviewArray[6] = displayBanner.cta.getAttribute("value");  

		displayBanner.closeBtn.click(); // click on close

		driver.switchTo().frame(displayBanner.iframe300_250); // Switch to the iframe

		landingpage.waitForElementToAppear(By.xpath("//div[@id='cta']")); // Wait for cta button to appear

		// Declare an array
		String[] actualPreviewArray = new String[6];

		// Step 2: Store values in the array
		actualPreviewArray[0] = displayBanner.actualHeadline.getAttribute("textContent").replaceAll("-", "").trim();
		actualPreviewArray[1] = displayBanner.actualClaim.getAttribute("textContent").trim();
		actualPreviewArray[2] = displayBanner.actualPositioning.getAttribute("textContent").trim();
		actualPreviewArray[3] = displayBanner.actualMotif.getAttribute("src").replace("_300x250", "");
		actualPreviewArray[4] = displayBanner.actualBg.getAttribute("src").replace("_300x250", "");
		actualPreviewArray[5] = driver.findElement(By.xpath("//div[@id='logo']/img")).getAttribute("src");
//        actualPreviewArray[6] = displayBanner.actualCta.getText().replaceAll("\\s+", " ").trim(); CTA is not possible because in the cta div, we didn't have text
		softAssert.assertTrue(driver.findElement(By.xpath("//body[@class='ready image']")).isDisplayed()); // Assert image is fully loaded

		driver.switchTo().defaultContent();
		System.out.println("editPreviewArray : " + Arrays.toString(editPreviewArray));
		System.out.println("actualPreviewArray : " + Arrays.toString(actualPreviewArray));

		softAssert.assertEquals(actualPreviewArray, editPreviewArray);
		softAssert.assertAll();				
		

	}
	
	
	@Test(description ="Verify that 800*250 image should visible", retryAnalyzer = Retry.class )

	public void checkPreview800_250() throws InterruptedException {

		module.clickToolBox();
		displayBanner.clickOnDisplayBanner();
		displayBanner.zuDenButton.get(0).click();
		displayBanner.ceativeListVorschauBtn.get(0).click(); // view the first item from the list

		landingpage.waitForElementToAppear(By.xpath("(//input[@role='combobox'])[1]"));
		displayBanner.editPreviewBtn.click();// click on the edit preview button
		
		// Step 1: Declare an array
		String[] editPreviewArray = new String[6];
		String farbValue = displayBanner.farb.getAttribute("value");

		if (farbValue.equals("sun")) {
			editPreviewArray[4] = bgArray[0];

		} else if (farbValue.equals("hibiscus")) {
			editPreviewArray[4] = bgArray[1];

		} else if (farbValue.equals("lime")) {
			editPreviewArray[4] = bgArray[2];

		} else if (farbValue.equals("mauve")) {
			editPreviewArray[4] = bgArray[3];

		} else if (farbValue.equals("mandarin")) {
			editPreviewArray[4] = bgArray[4];

		} else {
			System.out.println("No matching background found.");
		}
		
		System.out.println("editPreviewArray[4] : " + editPreviewArray[4]);

		// Step 2: Store values in the array
		editPreviewArray[0] = displayBanner.headline.getAttribute("value");
		editPreviewArray[1] = displayBanner.claim.getAttribute("value");
		editPreviewArray[2] = displayBanner.positioning.getAttribute("value");
		editPreviewArray[3] = displayBanner.motifUrl.getAttribute("src").replace("_preview", "");
		editPreviewArray[5] = "https://s3.eu-central-1.amazonaws.com/ads.ihk-stage/assets/logo/global_v.svg";
//        editPreviewArray[6] = displayBanner.cta.getAttribute("value");  

		displayBanner.closeBtn.click(); // click on close

		driver.switchTo().frame(displayBanner.iframe800_250); // Switch to the iframe

		landingpage.waitForElementToAppear(By.xpath("//div[@id='cta']")); // Wait for cta button to appear

		// Declare an array
		String[] actualPreviewArray = new String[6];

		// Step 2: Store values in the array
		actualPreviewArray[0] = displayBanner.actualHeadline.getAttribute("textContent").replaceAll("-", "").trim();
		actualPreviewArray[1] = displayBanner.actualClaim.getAttribute("textContent").trim();
		actualPreviewArray[2] = displayBanner.actualPositioning.getAttribute("textContent").trim();
		actualPreviewArray[3] = displayBanner.actualMotif.getAttribute("src").replace("_800x250", "");
		actualPreviewArray[4] = displayBanner.actualBg.getAttribute("src").replace("_800x250", "");
		actualPreviewArray[5] = driver.findElement(By.xpath("//div[@id='logo']/img")).getAttribute("src");
//        actualPreviewArray[6] = displayBanner.actualCta.getText().replaceAll("\\s+", " ").trim(); CTA is not possible because in the cta div, we didn't have text
		softAssert.assertTrue(driver.findElement(By.xpath("//body[@class='ready image']")).isDisplayed()); // Assert image is fully loaded

		driver.switchTo().defaultContent();
		System.out.println("editPreviewArray : " + Arrays.toString(editPreviewArray));
		System.out.println("actualPreviewArray : " + Arrays.toString(actualPreviewArray));

		softAssert.assertEquals(actualPreviewArray, editPreviewArray);
		softAssert.assertAll();	
		

	}
	
	

	@Test(description ="Verify that  250*250 image should visible", retryAnalyzer = Retry.class )

	public void checkPreview250_250() throws InterruptedException {

		module.clickToolBox();
		displayBanner.clickOnDisplayBanner();
		displayBanner.zuDenButton.get(0).click();
		displayBanner.ceativeListVorschauBtn.get(0).click(); // view the first item from the list

		landingpage.waitForElementToAppear(By.xpath("(//input[@role='combobox'])[1]"));
		displayBanner.editPreviewBtn.click();// click on the edit preview button
		
		// Step 1: Declare an array
		String[] editPreviewArray = new String[6];
		String farbValue = displayBanner.farb.getAttribute("value");

		if (farbValue.equals("sun")) {
			editPreviewArray[4] = bgArray[0];

		} else if (farbValue.equals("hibiscus")) {
			editPreviewArray[4] = bgArray[1];

		} else if (farbValue.equals("lime")) {
			editPreviewArray[4] = bgArray[2];

		} else if (farbValue.equals("mauve")) {
			editPreviewArray[4] = bgArray[3];

		} else if (farbValue.equals("mandarin")) {
			editPreviewArray[4] = bgArray[4];

		} else {
			System.out.println("No matching background found.");
		}
		
		System.out.println("editPreviewArray[4] : " + editPreviewArray[4]);

		// Step 2: Store values in the array
		editPreviewArray[0] = displayBanner.headline.getAttribute("value");
		editPreviewArray[1] = displayBanner.claim.getAttribute("value");
		editPreviewArray[2] = displayBanner.positioning.getAttribute("value");
		editPreviewArray[3] = displayBanner.motifUrl.getAttribute("src").replace("_preview", "");
		editPreviewArray[5] = "https://s3.eu-central-1.amazonaws.com/ads.ihk-stage/assets/logo/global_v.svg";
//        editPreviewArray[6] = displayBanner.cta.getAttribute("value");  

		displayBanner.closeBtn.click(); // click on close

		driver.switchTo().frame(displayBanner.iframe250_250); // Switch to the iframe

		landingpage.waitForElementToAppear(By.xpath("//div[@id='cta']")); // Wait for cta button to appear

		// Declare an array
		String[] actualPreviewArray = new String[6];

		// Step 2: Store values in the array
		actualPreviewArray[0] = displayBanner.actualHeadline.getAttribute("textContent").replaceAll("-", "").trim();
		actualPreviewArray[1] = displayBanner.actualClaim.getAttribute("textContent").trim();
		actualPreviewArray[2] = displayBanner.actualPositioning.getAttribute("textContent").trim();
		actualPreviewArray[3] = displayBanner.actualMotif.getAttribute("src").replace("_250x250", "");
		actualPreviewArray[4] = displayBanner.actualBg.getAttribute("src").replace("_250x250", "");
		actualPreviewArray[5] = driver.findElement(By.xpath("//div[@id='logo']/img")).getAttribute("src");
//        actualPreviewArray[6] = displayBanner.actualCta.getText().replaceAll("\\s+", " ").trim(); CTA is not possible because in the cta div, we didn't have text

		softAssert.assertTrue(driver.findElement(By.xpath("//body[@class='ready image']")).isDisplayed()); // Assert image is fully loaded

		driver.switchTo().defaultContent();
		System.out.println("editPreviewArray : " + Arrays.toString(editPreviewArray));
		System.out.println("actualPreviewArray : " + Arrays.toString(actualPreviewArray));

		softAssert.assertEquals(actualPreviewArray, editPreviewArray);
		softAssert.assertAll();	
		
		

	}
	
	@Test(description ="Verify that  728*90 image should visible", retryAnalyzer = Retry.class )

	public void checkPreview728_90() throws InterruptedException {

		module.clickToolBox();
		displayBanner.clickOnDisplayBanner();
		displayBanner.zuDenButton.get(0).click();
		displayBanner.ceativeListVorschauBtn.get(0).click(); // view the first item from the list

		landingpage.waitForElementToAppear(By.xpath("(//input[@role='combobox'])[1]"));
		displayBanner.editPreviewBtn.click();// click on the edit preview button
		
		// Step 1: Declare an array
		String[] editPreviewArray = new String[6];
		String farbValue = displayBanner.farb.getAttribute("value");

		if (farbValue.equals("sun")) {
			editPreviewArray[4] = bgArray[0];

		} else if (farbValue.equals("hibiscus")) {
			editPreviewArray[4] = bgArray[1];

		} else if (farbValue.equals("lime")) {
			editPreviewArray[4] = bgArray[2];

		} else if (farbValue.equals("mauve")) {
			editPreviewArray[4] = bgArray[3];

		} else if (farbValue.equals("mandarin")) {
			editPreviewArray[4] = bgArray[4];

		} else {
			System.out.println("No matching background found.");
		}
		
		System.out.println("editPreviewArray[4] : " + editPreviewArray[4]);

		// Step 2: Store values in the array
		editPreviewArray[0] = displayBanner.headline.getAttribute("value");
		editPreviewArray[1] = displayBanner.claim.getAttribute("value");
		editPreviewArray[2] = displayBanner.positioning.getAttribute("value");
		editPreviewArray[3] = displayBanner.motifUrl.getAttribute("src").replace("_preview", "");
		editPreviewArray[5] = "https://s3.eu-central-1.amazonaws.com/ads.ihk-stage/assets/logo/global_v.svg";
//        editPreviewArray[6] = displayBanner.cta.getAttribute("value");  

		displayBanner.closeBtn.click(); // click on close

		driver.switchTo().frame(displayBanner.iframe728_90); // Switch to the iframe

		landingpage.waitForElementToAppear(By.xpath("//div[@id='cta']")); // Wait for cta button to appear

		// Declare an array
		String[] actualPreviewArray = new String[6];

		// Step 2: Store values in the array
		actualPreviewArray[0] = displayBanner.actualHeadline.getAttribute("textContent").replaceAll("-", "").trim();
		actualPreviewArray[1] = displayBanner.actualClaim.getAttribute("textContent").trim();
		actualPreviewArray[2] = displayBanner.actualPositioning.getAttribute("textContent").trim();
		actualPreviewArray[3] = displayBanner.actualMotif.getAttribute("src").replace("_728x90", "");
		actualPreviewArray[4] = displayBanner.actualBg.getAttribute("src").replace("_728x90", "");
		actualPreviewArray[5] = driver.findElement(By.xpath("//div[@id='logo']/img")).getAttribute("src");
//        actualPreviewArray[6] = displayBanner.actualCta.getText().replaceAll("\\s+", " ").trim(); CTA is not possible because in the cta div, we didn't have text
		softAssert.assertTrue(driver.findElement(By.xpath("//body[@class='ready image']")).isDisplayed()); // Assert image is fully loaded

		driver.switchTo().defaultContent();
		System.out.println("editPreviewArray : " + Arrays.toString(editPreviewArray));
		System.out.println("actualPreviewArray : " + Arrays.toString(actualPreviewArray));
		
		softAssert.assertEquals(actualPreviewArray, editPreviewArray);
		softAssert.assertAll();		
		

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

	@Test(description ="Verify that creative preview should visible", retryAnalyzer = Retry.class )

	public void checkPreview() throws InterruptedException {

		module.clickToolBox();
		displayBanner.clickOnDisplayBanner();
		displayBanner.zuDenButton.get(0).click();
		displayBanner.ceativeListVorschauBtn.get(1).click(); // view the first item from the list

		landingpage.waitForElementToAppear(By.xpath("(//input[@role='combobox'])[1]"));
		displayBanner.editPreviewBtn.click();// click on the edit preview button

		// Step 1: Declare an array
		String[] editPreviewArray = new String[6];
		String farbValue = displayBanner.farb.getAttribute("value");

		if (farbValue.equals("sun")) {
			editPreviewArray[4] = bgArray[0];

		} else if (farbValue.equals("hibiscus")) {
			editPreviewArray[4] = bgArray[1];

		} else if (farbValue.equals("lime")) {
			editPreviewArray[4] = bgArray[2];

		} else if (farbValue.equals("mauve")) {
			editPreviewArray[4] = bgArray[3];

		} else if (farbValue.equals("mandarin")) {
			editPreviewArray[4] = bgArray[4];

		} else {
			System.out.println("No matching background found.");
		}
		
		// Step 2: Store values in the array
		editPreviewArray[0] = displayBanner.headline.getAttribute("value");
		editPreviewArray[1] = displayBanner.claim.getAttribute("value");
		editPreviewArray[2] = displayBanner.positioning.getAttribute("value");
		editPreviewArray[3] = displayBanner.motifUrl.getAttribute("src").replace("_preview", "");
		editPreviewArray[5] = "https://s3.eu-central-1.amazonaws.com/ads.ihk-stage/assets/logo/global_v.svg";  

		displayBanner.closeBtn.click(); // click on close
		
		driver.switchTo().frame(displayBanner.iframe300_600); // Switch to the iframe

		landingpage.waitForElementToAppear(By.xpath("//div[@id='cta']")); // Wait for cta button to appear

		// Declare an array
		String[] actualPreviewArray = new String[6];

		// Step 2: Store values in the array
		actualPreviewArray[0] = displayBanner.actualHeadline.getAttribute("textContent").replaceAll("-", "").trim();
		actualPreviewArray[1] = displayBanner.actualClaim.getAttribute("textContent").trim();
		actualPreviewArray[2] = displayBanner.actualPositioning.getAttribute("textContent").trim();
		actualPreviewArray[3] = displayBanner.actualMotif.getAttribute("src").replace("_300x600", "");
		actualPreviewArray[4] = displayBanner.actualBg.getAttribute("src").replace("_300x600", "");
		actualPreviewArray[5] = driver.findElement(By.xpath("//div[@id='logo']/img")).getAttribute("src");
//      actualPreviewArray[6] = displayBanner.actualCta.getText().replaceAll("\\s+", " ").trim(); CTA is not possible because in the cta div, we didn't have text
		
		driver.switchTo().defaultContent();
		System.out.println("editPreviewArray : " + Arrays.toString(editPreviewArray));
		System.out.println("actualPreviewArray : " + Arrays.toString(actualPreviewArray));
		
		Assert.assertEquals(actualPreviewArray, editPreviewArray);
		
		


	}


	@Test(description ="Verify that  same creative preview should visible which i edited by content setting", retryAnalyzer = Retry.class )

	public void checkPreviewAfterEdit() throws InterruptedException {

		module.clickToolBox();
		displayBanner.clickOnDisplayBanner();
		displayBanner.zuDenButton.get(0).click();
		displayBanner.ceativeListVorschauBtn.get(1).click(); // view the first item from the list

		landingpage.waitForElementToAppear(By.xpath("(//input[@role='combobox'])[1]"));
		displayBanner.editPreviewBtn.click();// click on the edit preview button

		displayBanner.farb.click(); // click on farb dropdown
		driver.findElement(By.xpath("//li[@role='option'][2]")).click(); // click on second option

		displayBanner.headline.click(); // click on headline
		driver.findElement(By.xpath("//li[@role='option'][2]")).click(); // click on second option

		displayBanner.motif.click(); // click on motif
		driver.findElement(By.xpath("//div[@role='option'][2]")).click(); // click on second option

		displayBanner.cta.click(); // click on calltoaction
		driver.findElement(By.xpath("//li[@role='option'][2]")).click(); // click on second option

		displayBanner.submitPreviewBtn.click(); // click on preview

		// Step 1: Declare an array
		String[] editPreviewArray = new String[6];
		String farbValue = displayBanner.farb.getAttribute("value");

		if (farbValue.equals("sun")) {
			editPreviewArray[4] = bgArray[0];

		} else if (farbValue.equals("hibiscus")) {
			editPreviewArray[4] = bgArray[1];

		} else if (farbValue.equals("lime")) {
			editPreviewArray[4] = bgArray[2];

		} else if (farbValue.equals("mauve")) {
			editPreviewArray[4] = bgArray[3];

		} else if (farbValue.equals("mandarin")) {
			editPreviewArray[4] = bgArray[4];

		} else {
			System.out.println("No matching background found.");
		}
		
		// Step 2: Store values in the array
		editPreviewArray[0] = displayBanner.headline.getAttribute("value");
		editPreviewArray[1] = displayBanner.claim.getAttribute("value");
		editPreviewArray[2] = displayBanner.positioning.getAttribute("value");
		editPreviewArray[3] = displayBanner.motifUrl.getAttribute("src").replace("_preview", "");
		editPreviewArray[5] = "https://s3.eu-central-1.amazonaws.com/ads.ihk-stage/assets/logo/global_v.svg";  

		displayBanner.closeBtn.click(); // click on close
		
		driver.switchTo().frame(displayBanner.iframe300_600); // Switch to the iframe

		landingpage.waitForElementToAppear(By.xpath("//div[@id='cta']")); // Wait for cta button to appear

		// Declare an array
		String[] actualPreviewArray = new String[6];

		// Step 2: Store values in the array
		actualPreviewArray[0] = displayBanner.actualHeadline.getAttribute("textContent").replaceAll("-", "").trim();
		actualPreviewArray[1] = displayBanner.actualClaim.getAttribute("textContent").trim();
		actualPreviewArray[2] = displayBanner.actualPositioning.getAttribute("textContent").trim();
		actualPreviewArray[3] = displayBanner.actualMotif.getAttribute("src").replace("_300x600", "");
		actualPreviewArray[4] = displayBanner.actualBg.getAttribute("src").replace("_300x600", "");
		actualPreviewArray[5] = driver.findElement(By.xpath("//div[@id='logo']/img")).getAttribute("src");
//        actualPreviewArray[6] = displayBanner.actualCta.getText().replaceAll("\\s+", " ").trim(); CTA is not possible because in the cta div, we didn't have text
		
		driver.switchTo().defaultContent();
		System.out.println("editPreviewArray : " + Arrays.toString(editPreviewArray));
		System.out.println("actualPreviewArray : " + Arrays.toString(actualPreviewArray));

		Assert.assertEquals(actualPreviewArray, editPreviewArray);	
		

	}

}
