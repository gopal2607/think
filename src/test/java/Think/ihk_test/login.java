package Think.ihk_test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Think.ihk_testcomponent.BaseTest;
import Think.ihk_testcomponent.Retry;


public class login extends BaseTest {

	@Test(description ="Verify that motif name should same as we have added in the motif management", retryAnalyzer = Retry.class )
	public void Login() {

		
		WebElement headerName = driver.findElement(By.tagName("header"));
		System.out.println(headerName.getText());
		Assert.assertTrue(headerName.getText().contains("Dashboard"));	
	}

	@Test(description ="Verify that motif name should same as we have added in the motif management", retryAnalyzer = Retry.class )
	public void drawerVisible() throws InterruptedException {


		List<WebElement> actualDrawerName = driver
				.findElements(By.xpath("(//span[contains(@class,'MuiTypography-root MuiTypography-body1')])"));

		String[] expectedDrawerName = { "Toolbox", "Export", "Approvals", "Motif-Management", "Rollen-Management",
				"Texte & Assets" };

		for (int i = 0; i < actualDrawerName.size(); i++) {
			Assert.assertEquals(expectedDrawerName[i], actualDrawerName.get(i).getText());
		}
	}
}
