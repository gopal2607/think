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
		module.clickToolBox();  //Click on the tool box module
		displayBanner.clickOnDisplayBanner();	  //Click on the display banner 
		displayBanner.zuDenButton.get(1).click(); //Click on the mit storer type from the display banner screen 
		landingpage.waitForListOfWebElementToAppear(displayBanner.ceativeListing); //waiting to  creative listing appear
		Assert.assertEquals(displayBanner.creativeListHeader.getText(), "Übersicht Ihrer erstellten Werbemittel für: Mit Störer"); //verify that header of the creative listing is visible and correct.
	}

	@Test(description ="Verify that image should be visible in the creative listing.", retryAnalyzer = Retry.class )
	public void compareImageList() throws InterruptedException {

		module.clickToolBox(); //Click on the tool box module
		displayBanner.clickOnDisplayBanner(); //Click on the display banner 
		displayBanner.zuDenButton.get(0).click();  //Click on the mit motive type from the display banner screen 

		landingpage.waitForListOfWebElementToAppear(displayBanner.ceativeListing); //waiting to  creative listing appear
		
		List<WebElement> creativeListImg = displayBanner.ceativeListImg; // Listing of the image from the creative listing

//		for(WebElement creativeImage : creativeListImg ) {
//			System.out.println("test1 :" + creativeImage.getAttribute("src"));
//			softAssert.assertTrue(creativeImage.isDisplayed(),
//					"Element '" + creativeImage.getAttribute("src") + "' is not visible on the screen."); //verify that image url is displayed
//		}
//			
		for (int i = 1; i < creativeListImg.size(); i++) {
			System.out.println("test2 :" + creativeListImg.get(i).getAttribute("src"));

			softAssert.assertTrue(creativeListImg.get(i).isDisplayed(),
					"Element '" + creativeListImg.get(i).getAttribute("src") + "' is not visible on the screen."); //verify that image url is displayed

		}

		softAssert.assertTrue(creativeListImg.size() == 10, "Listing count found '" + creativeListImg.size());  //verify that image url count is 10 
		softAssert.assertAll();
	}

	@Test(description ="Verify that head line should be visible in the creative listing.", retryAnalyzer = Retry.class )
	public void compareHeadlineList() throws InterruptedException {

		module.clickToolBox(); //Click on the tool box module
		displayBanner.clickOnDisplayBanner(); //Click on the display banner 
		displayBanner.zuDenButton.get(0).click(); //Click on the mit motive type from the display banner screen 
		landingpage.waitForElementToDisappear(By.xpath("//p[text()='Bitte warten Sie, Kampagnen-Daten werden geladen...']")); //waiting to loader to disappear
		List<WebElement> creativeListHeadline = displayBanner.ceativeListHeadline;  // Listing of the headlines from the creative listing
		
		for (int i = 1; i < creativeListHeadline.size(); i++) {
			softAssert.assertTrue(creativeListHeadline.get(i).isDisplayed(),
					"Element '" + creativeListHeadline.get(i).getText() + "' is not visible on the screen."); //verify that headlines is displayed
		}
		softAssert.assertTrue(creativeListHeadline.size() == 10, "Listing count found '" + creativeListHeadline.size());  //verify that headlines count is 10 
		softAssert.assertAll();
	}

	@Test(description ="Verify that search should working in the creative listing.", retryAnalyzer = Retry.class )
	public void compareSearchCreativeListing() throws InterruptedException {
		module.clickToolBox(); //Click on the tool box module
		displayBanner.clickOnDisplayBanner();//Click on the display banner 
		displayBanner.zuDenButton.get(0).click(); //Click on the mit motive type from the display banner screen 
		landingpage.waitForListOfWebElementToAppear(displayBanner.ceativeListing); //waiting to  creative listing appear
		displayBanner.creativeListSearch.sendKeys("jetzt_kostenlos_anmelden"); //search the cta
		Thread.sleep(2000); 
		String actualHeadline = displayBanner.ceativeListCta.get(0).getText(); //get the first cta text from the listing
		Assert.assertEquals(actualHeadline, "jetzt_kostenlos_anmelden"); // Verify that first cta text is matched with the searched cta
	}

	
	@Test(description ="Verify that No found should be visible if no record available after search", retryAnalyzer = Retry.class )

	public void searchCreativeListingMessage() throws InterruptedException {

		module.clickToolBox(); //Click on the tool box module
		displayBanner.clickOnDisplayBanner(); //Click on the display banner 
		displayBanner.zuDenButton.get(0).click(); //Click on the mit motive type from the display banner screen 
		landingpage.waitForListOfWebElementToAppear(displayBanner.ceativeListing); //waiting to  creative listing appear
		displayBanner.creativeListSearch.sendKeys("sss");  //search the text which is not present in screen
		String actualMessage = driver.findElement(By.xpath("//div[text()='Keine Ergebnisse gefunden.']")).getText();
		Assert.assertEquals(actualMessage, "Keine Ergebnisse gefunden.");  // Verify that 'Keine Ergebnisse gefunden.' message visible after search 
	}


	@Test(description ="Verify that Filter By Region should works", retryAnalyzer = Retry.class )

	public void filterRegionCreativeListing() throws InterruptedException {

		module.clickToolBox(); //Click on the tool box module
		displayBanner.clickOnDisplayBanner(); //Click on the display banner 
		displayBanner.zuDenButton.get(0).click(); //Click on the mit motive type from the display banner screen 
		landingpage.waitForListOfWebElementToAppear(displayBanner.ceativeListing);  //waiting to  creative listing appear
		displayBanner.ceativeListDropdownBtn.click();  //Click on the region dropdow 
		driver.findElement(By.xpath("//li[text()='Handelskammer Hamburg']")).click(); // select 'Handelskammer Hamburg' 
		Assert.assertEquals(displayBanner.ceativeListRegion.get(0).getText(), "Handelskammer Hamburg");  // Verify that 'Handelskammer Hamburg' is available on the first data from the list
	}

	@Test(description ="Verify that campaign should added successfully", retryAnalyzer = Retry.class )

	public void addNewCampaign() throws InterruptedException {	
		displayBanner.addNewCampaign(); //Add a new campaign in the mit motiv 

		landingpage.waitForElementToAppear(By.xpath("//div[text()='Editier-Modus ist aktiv.']")); //Waiting for 'Editier-Modus ist aktiv.' toast after campaign added
		
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

	}

	@Test(description ="Verify that duplicate campaign should works", retryAnalyzer = Retry.class )

	public void duplicateList() throws InterruptedException {

		module.clickToolBox(); //Click on the tool box module
		displayBanner.clickOnDisplayBanner(); //Click on the display banner
		displayBanner.zuDenButton.get(0).click(); //Click on the mit motive type from the display banner screen 
		landingpage.waitForListOfWebElementToAppear(displayBanner.ceativeListing);  //waiting to  creative listing appear

		String expectedDuplicate = displayBanner.ceativeListHeadline.get(0).getText(); //store the first headline of listing
		
		displayBanner.ceativeListMenuBtn.click();  //Click on hamburger menu
		displayBanner.ceativeListDupBtn.click(); //Click on duplicate button

		landingpage.waitForWebElementToAppear(displayBanner.submitPreviewBtn); //waiting to preview button to appear
		displayBanner.submitPreviewBtn.click(); //Click on the preview button

		landingpage.scrollPage();  
		landingpage.waitForWebElementToAppear(displayBanner.editCreativeSaveBtn); //waiting for save button to appear

		displayBanner.editCreativeSaveBtn.click(); //Click on the save button

		WebElement element1 = driver.findElement(By.xpath("//*[text() = 'creative preview']")); // click on the creative preview 
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element1);

		driver.switchTo().alert().accept(); //accept the save alert if the content is not saved and go back 
		String actualDuplicate = displayBanner.ceativeListHeadline.get(0).getText();
		Assert.assertEquals(actualDuplicate, expectedDuplicate); //verify that duplicate should be on top

	}

	@Test(description ="Verify that delete campaign should works", retryAnalyzer = Retry.class )

	public void deleteList() throws InterruptedException {


		module.clickToolBox(); //Click on the tool box module
		displayBanner.clickOnDisplayBanner(); //Click on the display banner
		displayBanner.zuDenButton.get(0).click(); //Click on the mit motive type from the display banner screen 
		landingpage.waitForListOfWebElementToAppear(displayBanner.ceativeListing); //waiting to  creative listing appear

		displayBanner.ceativeListMenuBtn.click();  //Click on hamburger menu
		displayBanner.ceativeListDeleteBtn.click(); //Click on delete button

		String headline = driver.findElement(By.xpath("//h6[contains(text(),'Diese Zeile wirklich löschen')]")).getText();
		String[] deletedIdSplit = headline.split("\\(id: |\\)");
		String deletedId = deletedIdSplit[1]; //store the id of the deleted campaign
		
		landingpage.waitForWebElementToAppear(displayBanner.ceativeListDeleteConfText); // waiting to delete popup to appear 
		displayBanner.ceativeListDeleteConfText.sendKeys("Wirklich löschen"); //Enter the 'Wirklich löschen'
		displayBanner.ceativeListDeleteConfBtn.click(); //click on the delete

		landingpage.waitForListOfWebElementToAppear(displayBanner.ceativeListing); //waiting to  creative listing appear
		landingpage.scrollPage();

		displayBanner.ceativeListVorschauBtn.get(0).click();  //Click on the mit motive type from the display banner screen 
		landingpage.waitForWebElementToAppear(displayBanner.creativePreviewDropdownBtn); //Waiting to  configuration dropdown to appear
			
		displayBanner.creativePreviewDropdownBtn.click();  //Click on the configuration dropdown
		displayBanner.creativePreviewDropdownBtn.sendKeys(deletedId);	//Enter the id of the deleted campaign		
		
		String noOptMessage =  driver.findElement(By.xpath("//div[text()='No options']")).getText(); 
		Assert.assertEquals(noOptMessage, "No options");//verify that 'No options' should visible 
	

	}

}
