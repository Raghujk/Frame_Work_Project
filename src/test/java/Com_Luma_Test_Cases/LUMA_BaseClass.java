package Com_Luma_Test_Cases;


import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

public class LUMA_BaseClass {
	public static WebDriver driver;
	public ResourceBundle rb;
	public  Logger log;
	@BeforeSuite
	@Parameters({"Browser","URL"})
	public void OpenApplication(String br,String url) {
		if(br.equals("Chrome")) {
			driver =new ChromeDriver();
			
		}
		else if(br.equals("Edge")){
			driver=new EdgeDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		rb = ResourceBundle.getBundle("Data");
		log = Logger.getLogger("Frame_Work_Project");
		PropertyConfigurator.configure("log4j.properties");
	}
		
		public String CaptureScreenShots(String tname) {
			String timestamp = new SimpleDateFormat("yyyy.MM.DD.HH.mm.ss").format(new Date());
			
			TakesScreenshot sc = (TakesScreenshot)driver;
			File Source = sc.getScreenshotAs(OutputType.FILE);
			String Target = System.getProperty("user.dir") + "\\Luma_ScreenShot\\"+ tname + "_"+timestamp+".png";
			try {
			FileUtils.copyFile(Source, new File(Target));
			}
			catch(Exception e) {
				e.getMessage();
			}
			return Target;
		}
		
	@AfterSuite
	public void ColsingApplication() {
		driver.close();
		
	}

}
