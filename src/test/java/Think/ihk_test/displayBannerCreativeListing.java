package Think.ihk_test;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Think.ihk_testcomponent.BaseTest;
import Think.ihk_testcomponent.Retry;



public class displayBannerCreativeListing extends BaseTest {
	SoftAssert softAssert = new SoftAssert();

	@Test(description ="Verify that user should able to navigate to the creative list screen", retryAnalyzer = Retry.class )
	public void navigateToTemplateList() throws InterruptedException {

		module.clickToolBox();
		displayBanner.clickOnDisplayBanner();		
		displayBanner.zuDenButton.get(1).click();
		landingpage.waitForListOfWebElementToAppear(displayBanner.ceativeListing);
		Assert.assertEquals(displayBanner.creativeListHeader.getText(), "Übersicht Ihrer erstellten Werbemittel für: Mit Störer");
	}

	@Test(description ="Verify that image should be visible in the creative listing.", retryAnalyzer = Retry.class )
	public void compareImageList() throws InterruptedException {

		module.clickToolBox();
		displayBanner.clickOnDisplayBanner();
		displayBanner.zuDenButton.get(0).click();

		landingpage.waitForListOfWebElementToAppear(displayBanner.ceativeListing);
		List<WebElement> creativeListImg = displayBanner.ceativeListImg;

		for (int i = 1; i < creativeListImg.size(); i++) {
			softAssert.assertTrue(creativeListImg.get(i).isDisplayed(),
					"Element '" + creativeListImg.get(i).getAttribute("src") + "' is not visible on the screen.");

		}

		softAssert.assertTrue(creativeListImg.size() == 10, "Listing count found '" + creativeListImg.size());
		softAssert.assertAll();
	}

	@Test(description ="Verify that head line should be visible in the creative listing.", retryAnalyzer = Retry.class )
	public void compareHeadlineList() throws InterruptedException {

		module.clickToolBox();
		displayBanner.clickOnDisplayBanner();
		displayBanner.zuDenButton.get(0).click();
		landingpage.waitForElementToDisappear(By.xpath("//p[text()='Bitte warten Sie, Kampagnen-Daten werden geladen...']"));
		List<WebElement> creativeListHeadline = displayBanner.ceativeListHeadline;
		for (int i = 1; i < creativeListHeadline.size(); i++) {
			softAssert.assertTrue(creativeListHeadline.get(i).isDisplayed(),
					"Element '" + creativeListHeadline.get(i).getText() + "' is not visible on the screen.");
		}
		softAssert.assertTrue(creativeListHeadline.size() == 10, "Listing count found '" + creativeListHeadline.size());
		softAssert.assertAll();
	}

	@Test(description ="Verify that search should working in the creative listing.", retryAnalyzer = Retry.class )
	public void compareSearchCreativeListing() throws InterruptedException {
		module.clickToolBox();
		displayBanner.clickOnDisplayBanner();
		displayBanner.zuDenButton.get(0).click();
		landingpage.waitForListOfWebElementToAppear(displayBanner.ceativeListing);
		displayBanner.creativeListSearch.sendKeys("jetzt_kostenlos_anmelden");
		Thread.sleep(2000);
		String actualHeadline = displayBanner.ceativeListCta.get(0).getText();
		Assert.assertEquals(actualHeadline, "jetzt_kostenlos_anmelden");
	}

	
	@Test(description ="Verify that No found should be visible if no record available after search", retryAnalyzer = Retry.class )

	public void searchCreativeListingMessage() throws InterruptedException {

		module.clickToolBox();
		displayBanner.clickOnDisplayBanner();
		displayBanner.zuDenButton.get(0).click();
		landingpage.waitForListOfWebElementToAppear(displayBanner.ceativeListing);
		displayBanner.creativeListSearch.sendKeys("sss");
		String actualMessage = driver.findElement(By.xpath("//div[text()='Keine Ergebnisse gefunden.']")).getText();
		Assert.assertEquals(actualMessage, "Keine Ergebnisse gefunden.");
	}


	@Test(description ="Verify that Filter By Region should works", retryAnalyzer = Retry.class )

	public void filterRegionCreativeListing() throws InterruptedException {

		module.clickToolBox();
		displayBanner.clickOnDisplayBanner();
		displayBanner.zuDenButton.get(0).click();
		landingpage.waitForListOfWebElementToAppear(displayBanner.ceativeListing);
		displayBanner.ceativeListDropdownBtn.click();
		driver.findElement(By.xpath("//li[text()='Handelskammer Hamburg']")).click();
		Assert.assertEquals(displayBanner.ceativeListRegion.get(0).getText(), "Handelskammer Hamburg");
	}

	@Test(description ="Verify that campaign should added successfully", retryAnalyzer = Retry.class )

	public void addNewCampaign() throws InterruptedException {

		
		displayBanner.addNewCampaign();

		landingpage.waitForElementToAppear(By.xpath("//div[text()='Editier-Modus ist aktiv.']"));
		String successMessage1 = driver.findElement(By.xpath("//div[text()='Editier-Modus ist aktiv.']")).getText();
		String successMessage2 = driver.findElement(By.xpath("//div[text()='Ein neues Asset wird erstellt.']"))
				.getText();
		String successMessage3 = driver
				.findElement(By.xpath("//div[text()='Einstellungen als neues Werbemittel gespeichert.']")).getText();

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(successMessage1, "Editier-Modus ist aktiv.");
		softAssert.assertEquals(successMessage2, "Ein neues Asset wird erstellt.");
		softAssert.assertEquals(successMessage3, "Einstellungen als neues Werbemittel gespeichert.");

		String creativePreviewHeader = displayBanner.creativePreviewHeader.getText();
		softAssert.assertEquals(creativePreviewHeader, "Vorschau Ihrer erstellen Werbemittel für: MIT MOTIV");

		softAssert.assertAll();

	}

	@Test(description ="Verify that duplicate campaign should works", retryAnalyzer = Retry.class )

	public void duplicateList() throws InterruptedException {


		module.clickToolBox();
		displayBanner.clickOnDisplayBanner();
		displayBanner.zuDenButton.get(0).click();
		landingpage.waitForListOfWebElementToAppear(displayBanner.ceativeListing);

		String expectedDuplicate = displayBanner.ceativeListHeadline.get(0).getText();
		
		displayBanner.ceativeListMenuBtn.click();
		displayBanner.ceativeListDupBtn.click();

		landingpage.waitForWebElementToAppear(displayBanner.submitPreviewBtn);
		displayBanner.submitPreviewBtn.click();

		landingpage.scrollPage();
		landingpage.waitForWebElementToAppear(displayBanner.editCreativeSaveBtn);

		displayBanner.editCreativeSaveBtn.click();

		WebElement element1 = driver.findElement(By.xpath("//*[text() = 'creative preview']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element1);

		driver.switchTo().alert().accept();
		String actualDuplicate = displayBanner.ceativeListHeadline.get(0).getText();
		Assert.assertEquals(actualDuplicate, expectedDuplicate);

	}

	@Test(description ="Verify that delete campaign should works", retryAnalyzer = Retry.class )

	public void deleteList() throws InterruptedException {


		module.clickToolBox();
		displayBanner.clickOnDisplayBanner();
		displayBanner.zuDenButton.get(0).click();
		landingpage.waitForListOfWebElementToAppear(displayBanner.ceativeListing);

		displayBanner.ceativeListMenuBtn.click();
		displayBanner.ceativeListDeleteBtn.click();

		String headline = driver.findElement(By.xpath("//h6[contains(text(),'Diese Zeile wirklich löschen')]"))
				.getText();
		
		String[] deletedIdSplit = headline.split("\\(id: |\\)");
		String deletedId = deletedIdSplit[1];
		
		landingpage.waitForWebElementToAppear(displayBanner.ceativeListDeleteConfText);
		displayBanner.ceativeListDeleteConfText.sendKeys("Wirklich löschen");
		displayBanner.ceativeListDeleteConfBtn.click();

		landingpage.waitForListOfWebElementToAppear(displayBanner.ceativeListing);
		landingpage.scrollPage();

		displayBanner.ceativeListVorschauBtn.get(0).click();
		landingpage.waitForElementToAppear(By.xpath("(//input[@role='combobox'])[1]"));
			
		displayBanner.creativePreviewDropdownBtn.click();
		displayBanner.creativePreviewDropdownBtn.sendKeys(deletedId);			
		
		String noOptMessage =  driver.findElement(By.xpath("//div[text()='No options']")).getText();
		Assert.assertEquals(noOptMessage, "No options");
	

	}

}
