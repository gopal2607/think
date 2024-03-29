package Think.ihk_pageobjects;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Think.ihk_abstract.Abstract;

public class DisplayBanner extends Abstract {

	WebDriver driver;

	public DisplayBanner(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	-------------------------------------Display Campaign Page------------------------------------------------------

	@FindBy(xpath = "//div[text()='Display Banner']")
	public WebElement displayCampheader;

	@FindBy(xpath = "(//div[@data-field='name'])")
	public List<WebElement> typ;

	@FindBy(xpath = "(//div[@data-field='description'])")
	public WebElement beschreibung;

	@FindBy(xpath = "//button[text()='Zu den Varianten']")
	public List<WebElement> zuDenButton;

	@FindBy(xpath = "//span[text()='Display Banner']")
	public WebElement displayBanner;

	public void clickOnDisplayBanner() {
		displayBanner.click();
		waitForWebElementToAppear(displayCampheader);

	}

//	-------------------------------------Creative Listing Page------------------------------------------------------

	@FindBy(xpath = "//h5[text()='Übersicht Ihrer erstellten Werbemittel für: ']")
	public WebElement creativeListHeader;

	@FindBy(xpath = "//div[@class='MuiDataGrid-row']")
	public List<WebElement> ceativeListing;

	@FindBy(xpath = "(//div[@data-field='image'])//img")
	public List<WebElement> ceativeListImg;

	@FindBy(xpath = "(//div[@data-field='headline'])//p")
	public List<WebElement> ceativeListHeadline;

	@FindBy(xpath = "(//div[@data-field='cta'])//div[@class='MuiDataGrid-cellContent']")
	public List<WebElement> ceativeListCta;

	@FindBy(xpath = "(//div[@data-field='colorVariant'])//div[@class='MuiDataGrid-cellContent']")
	public List<WebElement> ceativeListFarbvariante;

	@FindBy(xpath = "(//div[@data-field='regionName'])//div[@class='MuiDataGrid-cellContent']")
	public List<WebElement> ceativeListRegion;

	@FindBy(xpath = "//button[text()='Vorschau']")
	public List<WebElement> ceativeListVorschauBtn;

	@FindBy(xpath = "//button[@id='context-menu']")
	public WebElement ceativeListMenuBtn;

	@FindBy(xpath = "//span[text()='Duplizieren']")
	public WebElement ceativeListDupBtn;

	@FindBy(xpath = "//span[text()='Löschen']")
	public WebElement ceativeListDeleteBtn;

	@FindBy(xpath = "//input[@placeholder='Wirklich löschen']")
	public WebElement ceativeListDeleteConfText;

	@FindBy(xpath = "//button[text()='Wirklich löschen']")
	public WebElement ceativeListReallyDeleteBtn;

	@FindBy(xpath = "//button[@aria-label='Aktuelle Einstellungen als neuen Eintrag speichern.']")
	public WebElement editCreativeSaveBtn;

	@FindBy(xpath = "//button[text()='Neu']")
	public WebElement ceativeListNeuBtn;

	@FindBy(xpath = "//button[@title='Open']")
	public WebElement ceativeListDropdownBtn;

	@FindBy(xpath = "//button[@aria-label='Go to next page']")
	public WebElement ceativeListNextPageBtn;

	@FindBy(xpath = "//button[@aria-label='Go to previous page']")
	public WebElement ceativeListPreviousPageBtn;

	@FindBy(xpath = "//input[@type='search']")
	public WebElement creativeListSearch;

//	-------------------------------------Creative Preview Page------------------------------------------------------------------------------

	@FindBy(xpath = "(//div[@class='MuiBox-root css-1woehd0'])//h5")
	public WebElement creativePreviewHeader;

	@FindBy(xpath = "(//div[@class='MuiBox-root css-1woehd0'])//p")
	public WebElement creativePreviewSubheader;

	@FindBy(xpath = "(//input[@role='combobox'])[1]")
	public WebElement creativePreviewDropdownBtn;

	@FindBy(xpath = "//div[@class='MuiBox-root css-peixfx']")
	public WebElement creativePreviewImgListing;

	@FindBy(xpath = "//div[@class='MuiStack-root css-l838jg']")
	public WebElement creativePreviewResolutionText;

	@FindBy(xpath = "//button[@aria-label='Aktuelle Einstellungen als neuen Eintrag speichern.']")
	public WebElement creativePreviewSaveBtn;

	@FindBy(xpath = "//div[@role='option']")
	public List<WebElement> selectOption;

	@FindBy(xpath = "//div[@id='motif']/img")
	public WebElement actualMotif;

	@FindBy(xpath = "//div[@id='headline']")
	public WebElement actualHeadline;

	@FindBy(xpath = "//div[@id='claim']")
	public WebElement actualClaim;

	@FindBy(xpath = "//div[@id='positioning']")
	public WebElement actualPositioning;

	@FindBy(xpath = "//div[@id='cta']/img")
	public WebElement actualCta;

	@FindBy(xpath = "//div[@id='bg']/img")
	public WebElement actualBg;

	@FindBy(xpath = "//div[@id='logo']/img")
	public WebElement actualLogo;

	// ------------------------------------Edit Creative
	// Preview------------------------------------------------------------------------------

	@FindBy(xpath = "(//input[@role='combobox'])[2]")
	public WebElement farb;

	@FindBy(xpath = "(//input[@role='combobox'])[3]")
	public WebElement headline;

	@FindBy(xpath = "(//input[@role='combobox'])[4]")
	public WebElement claim;

	@FindBy(xpath = "(//input[@role='combobox'])[5]")
	public WebElement positioning;

	@FindBy(xpath = "(//input[@role='combobox'])[6]")
	public WebElement motif;

	@FindBy(xpath = "(//input[@role='combobox'])[7]")
	public WebElement cta;

	@FindBy(xpath = "//textarea[@placeholder='exit']")
	public WebElement exit;

	@FindBy(xpath = "//button[@aria-label='Preview aktualisieren']")
	public WebElement submitPreviewBtn;

	@FindBy(xpath = "//button[@aria-label='creative editor schließen']")
	public WebElement closeBtn;

	@FindBy(xpath = "//div[@class='option-dropdown-image_img-preview__O7oC9']/img")
	public WebElement motifUrl;

	@FindBy(xpath = "//button[@aria-label='creative editor öffnen']")
	public WebElement editPreviewBtn;

	@FindBy(xpath = "//button[@aria-label='Geänderte Einstellungen speichern.']")
	public WebElement editPreviewSaveBtn;

	// ------------------------------------Different Resolution
	// Images-------------------------------------------------------------

	@FindBy(xpath = "(//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-auto css-1f3rkw9'][1])//iframe[@class='iframe_iframe__5BHQl']") // --------------300*600---------------------
	public WebElement creativePreview300600Img;

	@FindBy(xpath = "(//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-auto css-1f3rkw9'][2])//iframe[@class='iframe_iframe__5BHQl']") // --------------160*600---------------------
	public WebElement creativePreview160600Img;

	@FindBy(xpath = "(//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-auto css-1f3rkw9'][3])//iframe[@class='iframe_iframe__5BHQl']") // --------------300*250---------------------
	public WebElement creativePreview300250Img;

	@FindBy(xpath = "(//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-auto css-1f3rkw9'][4])//iframe[@class='iframe_iframe__5BHQl']") // --------------800*250---------------------
	public WebElement creativePreview800250Img;

	@FindBy(xpath = "(//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-auto css-1f3rkw9'][5])//iframe[@class='iframe_iframe__5BHQl']") // --------------250*250---------------------
	public WebElement creativePreview250250Img;

	@FindBy(xpath = "(//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-auto css-1f3rkw9'][6])//iframe[@class='iframe_iframe__5BHQl']") // --------------728*90-----------------------
	public WebElement creativePreview72890Img;

	// ---------------------------------------------------iFrames---------------------------------------------------------------

	@FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-auto css-1f3rkw9'][1]//iframe[@class='iframe_iframe__5BHQl']")
	public WebElement iframe300_600; // Iframe of 300*600

	@FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-auto css-1f3rkw9'][2]//iframe[@class='iframe_iframe__5BHQl']")
	public WebElement iframe160_600; // Iframe of 160*600

	@FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-auto css-1f3rkw9'][3]//iframe[@class='iframe_iframe__5BHQl']")
	public WebElement iframe300_250; // Iframe of 300*250

	@FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-auto css-1f3rkw9'][4]//iframe[@class='iframe_iframe__5BHQl']")
	public WebElement iframe800_250; // Iframe of 800*250

	@FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-auto css-1f3rkw9'][5]//iframe[@class='iframe_iframe__5BHQl']")
	public WebElement iframe250_250; // Iframe of 250*250

	@FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-auto css-1f3rkw9'][6]//iframe[@class='iframe_iframe__5BHQl']")
	public WebElement iframe728_90; // Iframe of 728*90

	// ======================================Add new
	// campaign================================================

	public void addNewCampaign() throws InterruptedException {

		LandingPage landingpage = new LandingPage(driver);
		Modules module = new Modules(driver);
		MotifMan motifMan = new MotifMan(driver);
		DashBoard dashboard = new DashBoard(driver);
		DisplayBanner displayBanner = new DisplayBanner(driver);

		module.clickToolBox();
		clickOnDisplayBanner();
		zuDenButton.get(0).click();
		landingpage.waitForListOfWebElementToAppear(ceativeListVorschauBtn);
		ceativeListNeuBtn.click();

		landingpage.waitForElementToAppear(By.xpath("//div[@class='MuiBox-root css-1wf4ekk']"));
		landingpage.scrollPage(); // Scroll directly to the bottom of the page

		driver.findElement(By.xpath("(//input[@role='combobox'])[1]")).click();
		driver.findElement(By.xpath("//li[@role='option'][1]")).click();

		driver.findElement(By.xpath("(//input[@role='combobox'])[2]")).click();
		driver.findElement(By.xpath("//li[@role='option'][1]")).click();

		driver.findElement(By.xpath("(//input[@role='combobox'])[3]")).click();
		driver.findElement(By.xpath("//li[@role='option'][1]")).click();

		driver.findElement(By.xpath("(//input[@role='combobox'])[4]")).click();
		driver.findElement(By.xpath("//li[@role='option'][1]")).click();

		driver.findElement(By.xpath("(//input[@role='combobox'])[5]")).click();
		driver.findElement(By.xpath("//div[@role='option'][1]")).click();

		driver.findElement(By.xpath("(//input[@role='combobox'])[6]")).click();
		driver.findElement(By.xpath("//li[@role='option'][1]")).click();

		driver.findElement(By.xpath("//textarea[@placeholder='exit']")).sendKeys("Test");

		driver.findElement(By.xpath("//button[@aria-label='Preview anzeigen']")).click();

		creativePreviewSaveBtn.click();

	}

	// ================================ Check all the ads ===================================

	SoftAssert softAssert = new SoftAssert();

	static final String sun = "https://s3.eu-central-1.amazonaws.com/ads.ihk-stage/assets/themes/sun.jpg";
	static final String hibiscus = "https://s3.eu-central-1.amazonaws.com/ads.ihk-stage/assets/themes/hibiscus.jpg";
	static final String lime = "https://s3.eu-central-1.amazonaws.com/ads.ihk-stage/assets/themes/lime.jpg";
	static final String mauve = "https://s3.eu-central-1.amazonaws.com/ads.ihk-stage/assets/themes/mauve.jpg";
	static final String mandarin = "https://s3.eu-central-1.amazonaws.com/ads.ihk-stage/assets/themes/mandarin.jpg";

	public static final String[] bgArray = { sun, hibiscus, lime, mauve, mandarin };

	public void diffResoAds() throws InterruptedException {

		WebElement[] bannerSize = { iframe300_600, iframe250_250,iframe300_250,iframe160_600, iframe728_90,iframe800_250 };
		String[] replaceText = { "_300x600", "_250x250", "_300x250", "_160x600", "_728x90", "_800x250" };
	
		LandingPage landingpage = new LandingPage(driver);
		Modules module = new Modules(driver);
		MotifMan motifMan = new MotifMan(driver);
		DashBoard dashboard = new DashBoard(driver);
		DisplayBanner displayBanner = new DisplayBanner(driver);

		module.clickToolBox();
		landingpage.waitForWebElementToAppear(this.displayBanner);
		displayBanner.clickOnDisplayBanner();
		
		landingpage.waitForListOfWebElementToAppear(displayBanner.zuDenButton); // waiting to ceativeListVorschauBtn appear
		displayBanner.zuDenButton.get(0).click();
		landingpage.waitForWebElementToAppear(displayBanner.ceativeListVorschauBtn.get(1)); // waiting to ceativeListVorschauBtn appear

		displayBanner.ceativeListVorschauBtn.get(0).click(); // view the first item from the list

		landingpage.waitForWebElementToAppear(displayBanner.editPreviewBtn);
		displayBanner.editPreviewBtn.click();// click on the edit preview button

		// Step 1: Declare an array
		String[] editPreviewArray = new String[6];
		landingpage.waitForWebElementToAppear(displayBanner.farb);

		String farbValue = displayBanner.farb.getAttribute("value");

		if (farbValue.equals("sun")) {
			editPreviewArray[4] = displayBanner.bgArray[0];

		} else if (farbValue.equals("hibiscus")) {
			editPreviewArray[4] = displayBanner.bgArray[1];

		} else if (farbValue.equals("lime")) {
			editPreviewArray[4] = displayBanner.bgArray[2];

		} else if (farbValue.equals("mauve")) {
			editPreviewArray[4] = displayBanner.bgArray[3];

		} else if (farbValue.equals("mandarin")) {
			editPreviewArray[4] = displayBanner.bgArray[4];

		} else {
			System.out.println("No matching background found.");
		}

		// Step 2: Store values in the array
		editPreviewArray[0] = displayBanner.headline.getAttribute("value");
		editPreviewArray[1] = displayBanner.claim.getAttribute("value");
		editPreviewArray[2] = displayBanner.positioning.getAttribute("value");
		editPreviewArray[3] = displayBanner.motifUrl.getAttribute("src").replace("_preview", "");
		editPreviewArray[5] = "https://s3.eu-central-1.amazonaws.com/ads.ihk-stage/assets/logo/global_v.svg";

		displayBanner.closeBtn.click(); // click on close
			
		for(int i =0 ; i < bannerSize.length; i++) 
		{
					
		driver.switchTo().frame(bannerSize[i]); // Switch to the iframe

		landingpage.waitForElementToAppear(By.xpath("//div[@id='cta']")); // Wait for cta button to appear

		// Declare an array
		String[] actualPreviewArray = new String[6];

		// Step 2: Store values in the array
		actualPreviewArray[0] = displayBanner.actualHeadline.getAttribute("textContent").replaceAll("-", "").trim();
		actualPreviewArray[1] = displayBanner.actualClaim.getAttribute("textContent").trim();
		actualPreviewArray[2] = displayBanner.actualPositioning.getAttribute("textContent").trim();
		actualPreviewArray[3] = displayBanner.actualMotif.getAttribute("src").replace(replaceText[i], "");
		actualPreviewArray[4] = displayBanner.actualBg.getAttribute("src").replace(replaceText[i], "");
		actualPreviewArray[5] = driver.findElement(By.xpath("//div[@id='logo']/img")).getAttribute("src");
		
		softAssert.assertTrue(driver.findElement(By.xpath("//body[@class='ready image']")).isDisplayed()); // Assert image is fully load
																											
		Thread.sleep(2000);

		System.out.println("actualMotif : " +displayBanner.actualMotif.getAttribute("src"));
		System.out.println("actualBg : " +displayBanner.actualBg.getAttribute("src"));

		
		System.out.println("editPreviewArray1 : " + Arrays.toString(editPreviewArray));
		System.out.println("actualPreviewArray1 : " + Arrays.toString(actualPreviewArray));

		System.out.println("==============================================================");

		softAssert.assertEquals(Arrays.toString(editPreviewArray), Arrays.toString(actualPreviewArray));
		softAssert.assertAll();

		driver.switchTo().defaultContent();
		
		}
		
		}
	

	// =========================================Edit the preview ==============================================

	public void checkPreviewAfterEdit() throws InterruptedException {

		LandingPage landingpage = new LandingPage(driver);
		Modules module = new Modules(driver);
		MotifMan motifMan = new MotifMan(driver);
		DashBoard dashboard = new DashBoard(driver);
		DisplayBanner displayBanner = new DisplayBanner(driver);

		module.clickToolBox();
		landingpage.waitForWebElementToAppear(this.displayBanner);

		displayBanner.clickOnDisplayBanner();
		landingpage.waitForListOfWebElementToAppear(displayBanner.zuDenButton); // waiting to ceativeListVorschauBtn appear
		displayBanner.zuDenButton.get(0).click();
		landingpage.waitForListOfWebElementToAppear(displayBanner.ceativeListVorschauBtn); // waiting to ceativeListVorschauBtn appear
																																					 
		displayBanner.ceativeListVorschauBtn.get(1).click(); // view the first item from the list

		landingpage.waitForElementToAppear(By.xpath("(//input[@role='combobox'])[1]"));
		displayBanner.editPreviewBtn.click();// click on the edit preview button

		Thread.sleep(5000);
		displayBanner.farb.click(); // click on farb dropdown
		driver.findElement(By.xpath("//li[@role='option'][2]")).click(); // click on second option

		displayBanner.headline.click(); // click on headline
		driver.findElement(By.xpath("//li[@role='option'][2]")).click(); // click on second option

		displayBanner.motif.click(); // click on motif
		driver.findElement(By.xpath("//div[@role='option'][2]")).click(); // click on second option

		displayBanner.cta.click(); // click on calltoaction
		driver.findElement(By.xpath("//li[@role='option'][2]")).click(); // click on second option
		
		displayBanner.submitPreviewBtn.click(); // click on preview

		// Step 1: Declare an array
		String[] editPreviewArray = new String[6];
		landingpage.waitForWebElementToAppear(displayBanner.farb);
		String farbValue = displayBanner.farb.getAttribute("value");

		if (farbValue.equals("sun")) {
			editPreviewArray[4] = bgArray[0];

		} else if (farbValue.equals("hibiscus")) {
			editPreviewArray[4] = bgArray[1];

		} else if (farbValue.equals("lime")) {
			editPreviewArray[4] = bgArray[2];

		} else if (farbValue.equals("mauve")) {
			editPreviewArray[4] = bgArray[3];

		} else if (farbValue.equals("mandarin")) {
			editPreviewArray[4] = bgArray[4];

		} else {
			System.out.println("No matching background found.");
		}

		// Step 2: Store values in the array
		editPreviewArray[0] = displayBanner.headline.getAttribute("value");
		editPreviewArray[1] = displayBanner.claim.getAttribute("value");
		editPreviewArray[2] = displayBanner.positioning.getAttribute("value");
		editPreviewArray[3] = displayBanner.motifUrl.getAttribute("src").replace("_preview", "");
		editPreviewArray[5] = "https://s3.eu-central-1.amazonaws.com/ads.ihk-stage/assets/logo/global_v.svg";

		displayBanner.editPreviewSaveBtn.click(); // Click on save
		displayBanner.closeBtn.click(); // click on close

		driver.switchTo().frame(displayBanner.iframe300_600); // Switch to the iframe

		landingpage.waitForElementToAppear(By.xpath("//div[@id='cta']")); // Wait for cta button to appear

		// Declare an array
		String[] actualPreviewArray = new String[6];

		// Step 2: Store values in the array
		actualPreviewArray[0] = displayBanner.actualHeadline.getAttribute("textContent").replaceAll("-", "").trim();
		actualPreviewArray[1] = displayBanner.actualClaim.getAttribute("textContent").trim();
		actualPreviewArray[2] = displayBanner.actualPositioning.getAttribute("textContent").trim();
		actualPreviewArray[3] = displayBanner.actualMotif.getAttribute("src").replace("_300x600", "");
		actualPreviewArray[4] = displayBanner.actualBg.getAttribute("src").replace("_300x600", "");
		actualPreviewArray[5] = driver.findElement(By.xpath("//div[@id='logo']/img")).getAttribute("src");
//        actualPreviewArray[6] = displayBanner.actualCta.getText().replaceAll("\\s+", " ").trim(); CTA is not possible because in the cta div, we didn't have text

		driver.switchTo().defaultContent();

		System.out.println("editPreviewArray : " + Arrays.toString(editPreviewArray));
		System.out.println("actualPreviewArray : " + Arrays.toString(actualPreviewArray));

		Thread.sleep(2000);

		Assert.assertEquals(actualPreviewArray, editPreviewArray);

	}


}
