package OpenBrowser;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Open {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\2282058\\Downloads\\eclipse-java-2023-03-R-win32-x86_64 (1)\\eclipse\\MiniProject\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://openlibrary.org/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		/*
		 * Not working
		 * problem with getting the next catergories which are not visible
		 * side button class name is same for all other side buttons
		 */
		
		List<WebElement> lweb = driver.findElements(By.id("categories_carousel"));
		String s1 = "";
		for(WebElement w:lweb) {
			s1 += w.getText();
		}
		s1 = s1.replace("Previous", "");
		s1 = s1.replace("Next", "");
		System.out.println(s1);
		

	}

}
