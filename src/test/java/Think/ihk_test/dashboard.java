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
		module.dashboard.click(); //Click on the dashboard module
		
        List<String> dashMotiveNameListArray = new ArrayList<>(); //Create array of motive name list of the dashboard screen.
       
        List<WebElement> dashMotiveNames = dashboard.motiveNameList ; // Store the listing of motive name from the dashboard	
        for (WebElement dashMotiveList : dashMotiveNames) {
        	dashMotiveNameListArray.add(dashMotiveList.getText()); //Store the name in the dashMotiveNameListArray
        }

		module.clickMotifMan(); // Click on the Motif Management module
		landingpage.waitForListOfWebElementToAppear(motifMan.motifNameList);
		 
        boolean nextPageAvailable = true; //  Iterate through the pagination

        List<String> manMotifNameArray = new ArrayList<>(); //Create array of motive name list of the motif-management screen.

        while (nextPageAvailable) {     
            List<WebElement> manMotifNames = motifMan.motifNameList; // Fetch lists on the current page of the motif-management screen.

            for (WebElement manMotifList : manMotifNames) {
            	manMotifNameArray.add(manMotifList.getText()); //Store the name in the manMotifNameArray
            }
       
            WebElement nextPageButton = driver.findElement(By.xpath("//button[@title='Zur nächsten Seite']"));  // Check for the next page and navigate if available

            if (nextPageButton.isEnabled()) {
            	landingpage.scrollPage(); // Scroll directly to the bottom of the page
                nextPageButton.click();
                
            	landingpage.waitForElementToAppear(
        				By.xpath("//div[@class='MuiDataGrid-virtualScrollerContent css-0']//div[@data-field='motif']"));
            } else {
                nextPageAvailable = false;
            }          
        }
		
        System.out.println("manMotifNameArray: " + manMotifNameArray)  ;
        System.out.println("===============================") ;
        System.out.println("dashMotiveNameListArray: " + dashMotiveNameListArray ) ;
        Assert.assertEquals(manMotifNameArray,dashMotiveNameListArray);
        
	}
	

	
	@Test (description ="Verify that motif url should same as we have added in the motif management" , retryAnalyzer = Retry.class)
	public void motifsImageVisibleFinal() throws InterruptedException {
		
		module.dashboard.click(); //Click on the dashboard module

        List<String> dashMotiveImgUrlListArray = new ArrayList<>(); //Create array of motive image url list of the dashboard screen.
       
        List<WebElement> dashMotiveImgUrl = dashboard.motiveImg ; // Store the listing of motive image url from the dashboard
        
        for (WebElement dashMotiveImgUrlList : dashMotiveImgUrl) {  	      	
        	String[] dashMotiveImgUrlSplit =	dashMotiveImgUrlList.getAttribute("src").split("\\?");
        	dashMotiveImgUrlListArray.add(dashMotiveImgUrlSplit[0]);  //Store the dash motive image url in the dashMotiveImgUrlListArray
        }

		module.clickMotifMan(); // Click on the motifMan module
		  landingpage.waitForElementToAppear(
					By.xpath("//div[@class='MuiDataGrid-virtualScrollerContent css-0']//div[@data-field='image']/img"));
		  landingpage.scrollPage();
		  
		 
        boolean nextPageAvailable = true; // Iterate through the pagination
         
        List<String> manMotifImgUrlArray = new ArrayList<>();  //Create array of motive image url list of the motif-management screen.

        while (nextPageAvailable) {
                   List<WebElement> manMotifImgUrlList = motifMan.motifImgList;   // Store the listing of motive image url from the motif-management

            for (WebElement motifImgUrl : manMotifImgUrlList) {
            	manMotifImgUrlArray.add(motifImgUrl.getAttribute("src")); //Store the motif image url in the manMotifImgArray
            }
 
            WebElement nextPageButton = driver.findElement(By.xpath("//button[@title='Zur nächsten Seite']")); // Check for the next page and navigate if available

            if (nextPageButton.isEnabled()) {
            	landingpage.scrollPage(); // Scroll directly to the bottom of the page
                nextPageButton.click();
            	landingpage.waitForElementToAppear(
        				By.xpath("//div[@class='MuiDataGrid-virtualScrollerContent css-0']//div[@data-field='motif']"));
            	landingpage.scrollPage();
            } else {
                nextPageAvailable = false;
            }          
        }
        
		
        System.out.println("manMotifImgUrlArray: " + manMotifImgUrlArray)  ;
        System.out.println("===============================") ;
        System.out.println("dashMotiveImgUrlListArray: " + dashMotiveImgUrlListArray ) ;
        Assert.assertEquals(manMotifImgUrlArray,dashMotiveImgUrlListArray);

	}	
	
}








