package MiniProject.BookSearchAutomation;

//import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CountTamilBooks {
	
	public static void countTamilBooks(WebDriver driver, String url) {
		try {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
//		Click on Browse button
		WebElement browse = driver.findElement(By.className("browse-component"));
//		Highlight the component
		js.executeScript("arguments[0].style.border='2px solid red'", browse);
		browse.click();
		
		TakeScreenShot.takeScreenShot(driver);

		/*
		 * There is select tag to handle it by using Select class
		 * First tired by storing into a list of webElement, but each elements are not accessible because there is no common property in between the list elements and list is required a common property
		 * There is no class, id, linkText and partialText
		 * We can also not use by tag name because there are many li tags.
		 */
		WebElement clkSubject = driver.findElement(By.xpath("//div[@class='browse-component header-dropdown']/details/div/ul/li[1]/a[1]"));
//		Highlight the component
		js.executeScript("arguments[0].style.border='2px solid red'", clkSubject);
		clkSubject.click();

		
		// Learn about WebElement and JavaScriptExecutor
		WebElement m = driver.findElement(By.linkText("See more..."));
//		Scroll down to See More component
		js.executeScript("arguments[0].scrollIntoView(true);", m);
//		highlight the component
		js.executeScript("arguments[0].style.background='yellow'", m);
	    
		Thread.sleep(2000);

		TakeScreenShot.takeScreenShot(driver);
//		Go to see more
		WebElement seeMore = driver.findElement(By.linkText("See more..."));
		seeMore.click();
		
//		Gather all the languages
		List<WebElement> listBody = driver.findElements(By.className("subjectList"));
		
		m = driver.findElement(By.linkText("Tamil"));
//		highlight the component
		js.executeScript("arguments[0].style.background='yellow'", m);
//		scroll to the component
		js.executeScript("arguments[0].scrollIntoView(true);", m);

		TakeScreenShot.takeScreenShot(driver);
		
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
			System.out.println("Yes the count of Tamil Book is more than 1000");
		else {
			System.out.println("No the count of Tamil Book is not more than 1000");
		}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
