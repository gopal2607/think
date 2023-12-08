package Think.ihk_test;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Think.ihk_testcomponent.BaseTest;

public class displayBannerCreativeListing extends BaseTest {
	SoftAssert softAssert = new SoftAssert();

	@Test
	public void navigateToTemplateList() throws InterruptedException {
//		landingpage.LoginApplication("ruchi@scaletech.xyz", "Scaletech@123");
		module.clickToolBox();
		displayBanner.clickOnDisplayBanner();
		displayBanner.zuDenButton.get(1).click();
		Assert.assertEquals(displayBanner.creativeListHeader.getText(),
				"Übersicht Ihrer erstellten Werbemittel für: Mit Störer");
	}

	@Test
	public void compareImageList() throws InterruptedException {
//		landingpage.LoginApplication("ruchi@scaletech.xyz", "Scaletech@123");
		module.clickToolBox();
		displayBanner.clickOnDisplayBanner();
		displayBanner.zuDenButton.get(0).click();
//		Thread.sleep(5000);
		landingpage.waitForListOfWebElementToAppear(displayBanner.ceativeListImg);
		List<WebElement> creativeListImg = displayBanner.ceativeListImg;

		for (int i = 1; i < creativeListImg.size(); i++) {
			softAssert.assertTrue(creativeListImg.get(i).isDisplayed(),
					"Element '" + creativeListImg.get(i).getAttribute("src") + "' is not visible on the screen.");

		}
		softAssert.assertTrue(creativeListImg.size() == 10, "Listing count found '" + creativeListImg.size());
		softAssert.assertAll();
	}

	@Test
	public void compareHeadlineList() throws InterruptedException {
//		landingpage.LoginApplication("ruchi@scaletech.xyz", "Scaletech@123");
		module.clickToolBox();
		displayBanner.clickOnDisplayBanner();
		displayBanner.zuDenButton.get(0).click();
		landingpage.waitForListOfWebElementToAppear(displayBanner.ceativeListing);
		List<WebElement> creativeListHeadline = displayBanner.ceativeListHeadline;
		for (int i = 1; i < creativeListHeadline.size(); i++) {
			softAssert.assertTrue(creativeListHeadline.get(i).isDisplayed(),
					"Element '" + creativeListHeadline.get(i).getText() + "' is not visible on the screen.");
		}
		softAssert.assertTrue(creativeListHeadline.size() == 10, "Listing count found '" + creativeListHeadline.size());
		softAssert.assertAll();
	}

	@DisplayName("Search Result Comparision")
	@Test
	public void compareSearchCreativeListing() throws InterruptedException {
//		landingpage.LoginApplication("ruchi@scaletech.xyz", "Scaletech@123");
		module.clickToolBox();
		displayBanner.clickOnDisplayBanner();
		displayBanner.zuDenButton.get(0).click();
		landingpage.waitForListOfWebElementToAppear(displayBanner.ceativeListing);
		displayBanner.creativeListSearch.sendKeys("jetzt_kostenlos_anmelden");
		String actualHeadline = displayBanner.ceativeListHeadline.get(1).getText();
		Assert.assertEquals(actualHeadline, "FÜR WAS GUTES AUFSTEHEN.JEDEN TAG.");
	}

	@DisplayName("No found should be visible if no record available after search")
	@Test
	public void searchCreativeListingMessage() throws InterruptedException {
//		landingpage.LoginApplication("ruchi@scaletech.xyz", "Scaletech@123");
		module.clickToolBox();
		displayBanner.clickOnDisplayBanner();
		displayBanner.zuDenButton.get(0).click();
		landingpage.waitForListOfWebElementToAppear(displayBanner.ceativeListing);
		displayBanner.creativeListSearch.sendKeys("sss");
		String actualMessage = driver.findElement(By.xpath("//div[text()='Keine Ergebnisse gefunden.']")).getText();
		Assert.assertEquals(actualMessage, "Keine Ergebnisse gefunden.");
	}

	@DisplayName("Filter By Region")
	@Test
	public void filterRegionCreativeListing() throws InterruptedException {
//		landingpage.LoginApplication("ruchi@scaletech.xyz", "Scaletech@123");
		module.clickToolBox();
		displayBanner.clickOnDisplayBanner();
		displayBanner.zuDenButton.get(0).click();
		landingpage.waitForListOfWebElementToAppear(displayBanner.ceativeListing);
		displayBanner.ceativeListDropdownBtn.click();
		driver.findElement(By.xpath("//li[text()='Handelskammer Hamburg']")).click();
		Assert.assertEquals(displayBanner.ceativeListRegion.get(0).getText(), "Handelskammer Hamburg");
	}

	@Test
	public void addNewCampaign() throws InterruptedException {
//		landingpage.LoginApplication("ruchi@scaletech.xyz", "Scaletech@123");
		displayBanner.addNewCampaign();
		
		landingpage.waitForElementToAppear(By.xpath("//div[text()='Editier-Modus ist aktiv.']"));
		String successMessage1 = driver.findElement(By.xpath("//div[text()='Editier-Modus ist aktiv.']")).getText();
		String successMessage2 = driver.findElement(By.xpath("//div[text()='Ein neues Asset wird erstellt.']")).getText();
		String successMessage3 = driver.findElement(By.xpath("//div[text()='Einstellungen als neues Werbemittel gespeichert.']")).getText();
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(successMessage1, "Editier-Modus ist aktiv.");
		softAssert.assertEquals(successMessage2, "Ein neues Asset wird erstellt.");
		softAssert.assertEquals(successMessage3, "Einstellungen als neues Werbemittel gespeichert.");
		
		String creativePreviewHeader = displayBanner.creativePreviewHeader.getText();
		softAssert.assertEquals(creativePreviewHeader, "Vorschau Ihrer erstellen Werbemittel für: MIT MOTIV");
		
		softAssert.assertAll();
		
//		WebElement element = driver.findElement(By.xpath("//*[text() = 'creative preview']"));
//		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
	}
	
	
	
	@Test
	public void duplicateList() throws InterruptedException {
		
//		landingpage.LoginApplication("ruchi@scaletech.xyz", "Scaletech@123");
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
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element1);
		
		driver.switchTo().alert().accept();
		String actualDuplicate = displayBanner.ceativeListHeadline.get(0).getText();	
		Assert.assertEquals(actualDuplicate, expectedDuplicate);

	}

}
