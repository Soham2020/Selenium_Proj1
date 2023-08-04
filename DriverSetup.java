package MiniProject.BookSearchAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverSetup {

	public static WebDriver driverSetup(int option) {
		WebDriver driver = null;
		
		if(option == 1) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\2282058\\Downloads\\eclipse-java-2023-03-R-win32-x86_64 (1)\\eclipse\\BookSearchAutomation\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(option == 2) {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\2282058\\Downloads\\eclipse-java-2023-03-R-win32-x86_64 (1)\\eclipse\\BookSearchAutomation\\driver\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		return driver;		
	}
}
