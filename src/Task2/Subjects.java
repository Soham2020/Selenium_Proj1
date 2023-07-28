package Task2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Subjects {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\2282058\\Downloads\\eclipse-java-2023-03-R-win32-x86_64 (1)\\eclipse\\MiniProject\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://openlibrary.org/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
//		Click on Browse button
		WebElement browse = driver.findElement(By.className("browse-component"));
		browse.click();
		
		/*
		 * There is select tag to handle it by using Select class
		 * First tired by storing into a list of webElement, but each elements are not accessible because there is no common property in between the list elements and list is required a common property
		 * There is no class, id, linkText and partialText
		 * We can also not use by tag name because there are many li tags.
		 */
		WebElement browse1 = driver.findElement(By.xpath("//*[@id=\"header-bar\"]/ul[1]/li[2]/div/details/div/ul/li[1]/a"));
		browse1.click();
		
//		Go to see more
		WebElement seeMore = driver.findElement(By.linkText("See more..."));
		seeMore.click();
		
//		Gather all the languages
		List<WebElement> listBody = driver.findElements(By.className("subjectList"));
		String s = "";
		for(WebElement l:listBody) {
			s += l.getText();
		}
		String[] sarr = s.split("\n");
		String str = "";
		List <String> ls = new ArrayList<String>(Arrays.asList(sarr));
		for(int i=0; i<ls.size(); i++) {
			if(ls.get(i).contains("Tamil")) {
				str += ls.get(i);
			}
		}
		
//		Extracting the count of Tamil books
		String temp = "";
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				temp += str.charAt(i);
			}
		}
		
//		Check whether it is more than 1000
		if(Integer.parseInt(temp) > 1000)
			System.out.println(true);
		else {
			System.out.println(false);
		}
		
		
//		Closing the driver
		driver.close();
		


	}

}