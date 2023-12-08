package Think.ihk_test;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Think.ihk_testcomponent.BaseTest;

public class displayBannerTemplateList extends BaseTest {
	SoftAssert softAssert = new SoftAssert();

	@Test
	public void navigateDisplayBannerModule() throws InterruptedException {
//		landingpage.LoginApplication("ruchi@scaletech.xyz", "Scaletech@123");
		module.clickToolBox();
		displayBanner.clickOnDisplayBanner();
		Assert.assertEquals(displayBanner.displayCampheader.getText(), "Display Banner");

	}

	@Test
	public void verifyTypOfDisplayBanner() throws InterruptedException {
//		landingpage.LoginApplication("ruchi@scaletech.xyz", "Scaletech@123");
		module.clickToolBox();
		displayBanner.clickOnDisplayBanner();
		List<WebElement> typList = displayBanner.typ;
		String[] typListArray = new String[typList.size()]; // Initialize or resize the motiveImgListDashArray
		String[] actualTypListArray = { null, "Mit Motiv", "Mit Störer" };
		for (int i = 1; i < typList.size(); i++) {
			typListArray[i] = typList.get(i).getText();
			softAssert.assertTrue(typList.get(i).isDisplayed(),  "Element '" + typList.get(i).getText() + "' is not visible on the screen.");
		}
		softAssert.assertEquals(Arrays.toString(typListArray), Arrays.toString(actualTypListArray));
		softAssert.assertEquals(typListArray.length, actualTypListArray.length);
		softAssert.assertAll();
	}

	
	
}
