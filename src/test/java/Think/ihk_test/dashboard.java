package Think.ihk_test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Think.ihk_testcomponent.BaseTest;
import Think.ihk_testcomponent.Retry;

@Test(retryAnalyzer = Think.ihk_testcomponent.Retry.class )

public class dashboard extends BaseTest {
		
	
	@Test(description ="Verify that motif name should same as we have added in the motif management", retryAnalyzer = Retry.class )
	public void motifsNameVisiblefinal() throws InterruptedException {
		module.dashboard.click();
        List<String> dashMotiveNameListArray = new ArrayList<>();
       
        List<WebElement> dashMotiveNames = dashboard.motiveNameList ; // Store the listing of motive name from the dashboard	
        for (WebElement dashMotiveList : dashMotiveNames) {
        	dashMotiveNameListArray.add(dashMotiveList.getText());
        }

		module.clickMotifMan(); // Click on the motifMan module
		landingpage.waitForListOfWebElementToAppear(motifMan.motifList);
		 // Step 3: Iterate through the pagination
        boolean nextPageAvailable = true;
        
        List<String> manMotifNameArray = new ArrayList<>();

        while (nextPageAvailable) {
            // Step 4: Fetch lists on the current page
            List<WebElement> manMotifList = motifMan.motifList;

            // Step 5: Store lists in the array
            for (WebElement motifList : manMotifList) {
            	manMotifNameArray.add(motifList.getText());
            }

            // Check for the next page and navigate if available
            WebElement nextPageButton = driver.findElement(By.xpath("//button[@title='Zur nächsten Seite']"));

            if (nextPageButton.isEnabled()) {
            	landingpage.scrollPage(); // Scroll directly to the bottom of the page
                nextPageButton.click();
                // You may need to wait for the next page to load
            	landingpage.waitForElementToAppear(
        				By.xpath("//div[@class='MuiDataGrid-virtualScrollerContent css-0']//div[@data-field='motif']"));
            } else {
                nextPageAvailable = false;
            }          
        }
		
        System.out.println("total manMotifNameArray: " + manMotifNameArray)  ;
        System.out.println("===============================") ;
        System.out.println("dashMotiveNameListArray: " + dashMotiveNameListArray ) ;
        Assert.assertEquals(manMotifNameArray,dashMotiveNameListArray);
        
	}
	
	
	
	
	
	
	
	@Test (description ="Verify that motif url should same as we have added in the motif management" , retryAnalyzer = Retry.class)
	public void motifsImageVisibleFinal() throws InterruptedException {

		
		module.dashboard.click();

        List<String> dashMotiveImgListArray = new ArrayList<>();
       
        List<WebElement> dashMotiveImg = dashboard.motiveImg ; // Store the listing of motive name from the dashboard
        
        for (WebElement dashMotiveImgList : dashMotiveImg) {
        	
        	String[] dashMotiveImgUrlSplit =	dashMotiveImgList.getAttribute("src").split("\\?");
        	dashMotiveImgListArray.add(dashMotiveImgUrlSplit[0]);
        }

		module.clickMotifMan(); // Click on the motifMan module
		  landingpage.waitForElementToAppear(
					By.xpath("//div[@class='MuiDataGrid-virtualScrollerContent css-0']//div[@data-field='image']/img"));
		  landingpage.scrollPage();
		  
		 // Step 3: Iterate through the pagination
        boolean nextPageAvailable = true;
         
        List<String> manMotifImgArray = new ArrayList<>();
      

        while (nextPageAvailable) {
            // Step 4: Fetch lists on the current page
            List<WebElement> manMotifImgList = motifMan.motifImgList;

            // Step 5: Store lists in the array
            for (WebElement motifImgList : manMotifImgList) {
            	manMotifImgArray.add(motifImgList.getAttribute("src"));
            }

            // Check for the next page and navigate if available
            WebElement nextPageButton = driver.findElement(By.xpath("//button[@title='Zur nächsten Seite']"));

            if (nextPageButton.isEnabled()) {
            	landingpage.scrollPage(); // Scroll directly to the bottom of the page
                nextPageButton.click();
                // You may need to wait for the next page to load
            	landingpage.waitForElementToAppear(
        				By.xpath("//div[@class='MuiDataGrid-virtualScrollerContent css-0']//div[@data-field='motif']"));
            	landingpage.scrollPage();
            } else {
                nextPageAvailable = false;
            }          
        }
        
		
        System.out.println("total manMotifNameArray: " + manMotifImgArray)  ;
        System.out.println("===============================") ;
        System.out.println("total dash: " + dashMotiveImgListArray ) ;
        Assert.assertEquals(manMotifImgArray,dashMotiveImgListArray);

	}	
	
}








