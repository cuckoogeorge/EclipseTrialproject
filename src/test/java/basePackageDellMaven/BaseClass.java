package basePackageDellMaven;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	
	public static WebDriver dr;
	@BeforeClass
	public void beforeTest() {
		dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.get("https://www.dell.com/en-in");
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}


}
