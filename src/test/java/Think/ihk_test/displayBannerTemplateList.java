package Think.ihk_test;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Think.ihk_testcomponent.BaseTest;
import Think.ihk_testcomponent.Retry;



public class displayBannerTemplateList extends BaseTest {
	SoftAssert softAssert = new SoftAssert();

	@Test(description ="Verify that user should able to navigate to the display banner screen ", retryAnalyzer = Retry.class )
	public void navigateDisplayBannerModule() throws InterruptedException {

		module.clickToolBox(); //Click on the toolbox
		displayBanner.clickOnDisplayBanner(); //click on the display banner
		Assert.assertEquals(displayBanner.displayCampheader.getText(), "Display Banner"); //Verify that header of the display banner 

	}

	@Test(description ="Verify type of the display banner", retryAnalyzer = Retry.class )

	public void verifyTypOfDisplayBanner() throws InterruptedException {

		module.clickToolBox();  //Click on the toolbox
		displayBanner.clickOnDisplayBanner(); //click on the display banner
		List<WebElement> typList = displayBanner.typ; //Listing of the typ from the display banner screen
		String[] typListArray = new String[typList.size()]; // Initialize or resize the motiveImgListDashArray
		String[] actualTypListArray = { null, "Mit Motiv", "Mit Störer" };
		for (int i = 1; i < typList.size(); i++) {
			typListArray[i] = typList.get(i).getText();
			softAssert.assertTrue(typList.get(i).isDisplayed(),  "Element '" + typList.get(i).getText() + "' is not visible on the screen.");
		}
		softAssert.assertEquals(Arrays.toString(typListArray), Arrays.toString(actualTypListArray)); // Compare typelist 
		softAssert.assertEquals(typListArray.length, actualTypListArray.length); // Compare count of typ list
		softAssert.assertAll();
	}

	
	
}
