package Think.ihk_test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Think.ihk_testcomponent.BaseTest;

public class login extends BaseTest {

	@Test
	public void Login() {

//		landingpage.LoginApplication("ruchi@scaletech.xyz", "Scaletech@123");		
		WebElement headerName = driver.findElement(By.tagName("header"));
		System.out.println(headerName.getText());
		Assert.assertTrue(headerName.getText().contains("Dashboard"));	
	}

	@Test
	public void drawerVisible() throws InterruptedException {
//		landingpage.LoginApplication("ruchi@scaletech.xyz", "Scaletech@123");

		List<WebElement> actualDrawerName = driver
				.findElements(By.xpath("(//span[contains(@class,'MuiTypography-root MuiTypography-body1')])"));

		String[] expectedDrawerName = { "Toolbox", "Export", "Approvals", "Motif-Management", "Rollen-Management",
				"Texte & Assets" };

		for (int i = 0; i < actualDrawerName.size(); i++) {
			Assert.assertEquals(expectedDrawerName[i], actualDrawerName.get(i).getText());
		}

	}

	

}
