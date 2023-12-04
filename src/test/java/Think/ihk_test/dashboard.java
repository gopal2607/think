package Think.ihk_test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Arrays;

import Think.ihk_testcomponent.BaseTest;

public class dashboard extends BaseTest {

	@Test
	public void motifsNameVisible() throws InterruptedException {
		landingpage.LoginApplication("ruchi@scaletech.xyz", "Scaletech@123"); //Login
 
			List<WebElement> dashMotiveName =	dashboard.motiveNameList; //Store the listing of motive name from the dashboard
							
			String[] dashMotiveListArray = new String[dashMotiveName.size()]; // Initialize or resize the motifNameArray
			
			System.out.println("dashMotiveNameSize : " + dashMotiveName.size()); //Print size of motiveListing of dashboard
			
			for (int i = 0; i < dashMotiveName.size(); i++) {
				dashMotiveListArray[i] = dashMotiveName.get(i).getText();
				System.out.println("dashMotiveListArray : " + dashMotiveListArray[i]);  //Print name of motiveListing of dashboard
			}
			
			module.clickMotifMan(); //Click on the motifMan module

			do {
				List<WebElement> manMotifNameList = motifMan.motifList; // Get the current motif names on the motifManagement page

				String[] manMotifNameArray = new String[manMotifNameList.size()]; // Initialize or resize the motifNameArray

				System.out.println("dashMotiveNameSize : " + manMotifNameList.size()); //Print size of motiveListing of dashboard

				// Populate motifNameArray with motif names from the current page
				for (int i = 0; i < manMotifNameList.size(); i++) {
					manMotifNameArray[i] = manMotifNameList.get(i).getText();
					System.out.println("manMotifNameArray : " + manMotifNameArray[i]);
				}				
		        
			
				WebElement nextPageButton = driver.findElement(By.xpath("//button[@title='Zur nächsten Seite']"));
				
				// Check if there's a next page and navigate to it
				if (nextPageButton.isEnabled()) {
					landingpage.scrollPage(); // Scroll directly to the bottom of the page
					nextPageButton.click();
					landingpage.waitForElementToAppear(	By.xpath("//div[@class='MuiDataGrid-virtualScrollerContent css-0']//div[@data-field='motif']"));
					
					 // Assert that each element in motifNameArray is equal to the corresponding element in motiveListDash
					System.out.println("dashMotiveListArray.length : " + dashMotiveListArray.length);
					
			        for (int i = 0; i < manMotifNameArray.length; i++) {
			            Assert.assertEquals(manMotifNameArray[i], dashMotiveListArray[i]);
			        }
				}

				
				else {
					break;
				}

			} while (true); // You can adjust the condition to stop when necessary
			
		}
	

	@Test
	public void motifsImageVisible() throws InterruptedException {
		landingpage.LoginApplication("ruchi@scaletech.xyz", "Scaletech@123");

		do {	
			List<WebElement> dashMotiveImag = dashboard.motiveImg;
			String[] dashMotiveImgArray = new String[dashMotiveImag.size()]; // Initialize or resize the motiveImgListDashArray
			
			List<String> dashMotiveImgUrls = new ArrayList<>();

			System.out.println("dashMotiveImagSize : " + dashMotiveImag.size());
			for (int j = 0; j < dashMotiveImag.size(); j++) {
				
				dashMotiveImgArray[j] = dashMotiveImag.get(j).getAttribute("src"); // get url

				String[] dashMotiveImgUrlSplit = dashMotiveImgArray[j].split("\\?"); // split url

				String dashMotiveImgUrl = dashMotiveImgUrlSplit[0]; // take the first part
				
				dashMotiveImgUrls.add(dashMotiveImgUrl);
				
			}
			System.out.println("dashMotiveImgUrl[0] : " + dashMotiveImgUrls);
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			module.clickMotifMan(); // Click on the MotifManagement
			Thread.sleep(2000);
			List<WebElement> motifManMotifImgList = motifMan.motifImgList; // Store the list of motive from the motif-management
																			

			System.out.println("motifImgListMotifMan.size() : " + motifManMotifImgList.size());
			String[] motifManImgArray = new String[motifManMotifImgList.size()]; // Initialize or resize the motifNameArray
			List<String> motifManImgUrls = new ArrayList<>();
			
			// Populate motifNameArray with motif names from the current page
			for (int i = 0; i < motifManMotifImgList.size(); i++) {
				motifManImgArray[i] = motifManMotifImgList.get(i).getAttribute("src"); // get url
				motifManImgUrls.add(motifManImgArray[i]);
				
			}
			System.out.println("motifManMotifImgList : " + motifManImgUrls);
			WebElement nextPageButton = driver.findElement(By.xpath("//button[@title='Zur nächsten Seite']"));

			// Check if there's a next page and navigate to it
			if (nextPageButton.isEnabled()) {
				landingpage.scrollPage();
				nextPageButton.click();
				landingpage.waitForListOfWebElementToAppear(motifManMotifImgList);
			}

			else {
				
				break;
			}
			
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("dashMotiveImgArray : " +  dashMotiveImgUrls);
			
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("motifManImgArray : " + Arrays.toString(motifManImgArray));

			Assert.assertEquals(motifManImgUrls,  dashMotiveImgUrls);
		} while (false); // You can adjust the condition to stop when necessary

	}
}
