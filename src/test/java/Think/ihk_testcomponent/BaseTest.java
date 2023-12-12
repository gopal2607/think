package Think.ihk_testcomponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Think.ihk_pageobjects.DashBoard;
import Think.ihk_pageobjects.DisplayBanner;
import Think.ihk_pageobjects.LandingPage;
import Think.ihk_pageobjects.Modules;
import Think.ihk_pageobjects.MotifMan;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.HashMap;

public class BaseTest {

	public WebDriver driver;
	public LandingPage landingpage;
	public Modules module;
	public DashBoard dashboard;
	public MotifMan motifMan;
	public DisplayBanner displayBanner;

	public WebDriver initializeDriver() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
//			"D:\\User\\gopal\\eclipse-workspace\\Think-Automation\\ihk\\ihk\\src\\main\\java\\Think\\ihk_resources\\GlobalData.properties");

				System.getProperty("user.dir") + "//src//main//java//Think//ihk_resources//GlobalData.properties");
		prop.load(fis);
		String browserName = System.getProperty("browser") != null ? System.getProperty("browser")
				: prop.getProperty("browser");
		System.out.println(browserName);
		if (browserName.contains("chrome")) {
			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
			options.addArguments("user-data-dir=/path/to/folder/profile");
		} else if (browserName.equalsIgnoreCase("firefox")) {
//			System.setProperty("webdriver.gecko.driver", "C:\\Users\\mehul\\Downloads\\geckodriver\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else {
			driver = new EdgeDriver();
		}
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}

	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
		// read json to string
		String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);

		// String to Hashmap Jackson Databind
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}

	public String getScreenshot(String testcasename, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);
		File File = new File(System.getProperty("user.dir") + "//reports//" + testcasename + ".png");
		FileUtils.copyFile(Source, File);
		return System.getProperty("user.dir") + "//reports//" + testcasename + ".png";
	}

	@BeforeClass(alwaysRun = true)
	public LandingPage launchApplication() throws IOException, InterruptedException {
		driver = initializeDriver();
		landingpage = new LandingPage(driver);
		module = new Modules(driver);
		motifMan = new MotifMan(driver);
		dashboard = new DashBoard(driver);
		displayBanner =  new DisplayBanner(driver);
		landingpage.GoTo();
		return landingpage;
		

	}

	@AfterClass(alwaysRun = true)
	public void TearDown() {
		driver.close();
		
	}

}
