package MiniProject.BookSearchAutomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PrintCategories {
	public static void printCategories(WebDriver driver, String url) {
		try {
			driver.navigate().to(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			

			JavascriptExecutor js = (JavascriptExecutor)driver;

			// scroll to the section
			WebElement m = driver.findElement(By.linkText("Browse by Subject"));
			js.executeScript("arguments[0].scrollIntoView(true);", m);
			
			// Highlight the class
			WebElement e = driver.findElement(By.id("categories_carousel"));
			js.executeScript("arguments[0].style.border='2px solid red'", e);

			
			WebElement w;
			for(int i=0; i<=5; i++) {
				w = driver.findElement(By.cssSelector("#slick-slide10" + i));
				System.out.println(w.getText());
			}

			Thread.sleep(2000);	

			TakeScreenShot.takeScreenShot(driver);
			
			// Clicking the side arrow button
			WebElement nextBtn = driver.findElement(By.cssSelector("#categories_carousel > button.slick-next.slick-arrow"));
			// WebElement nextBtn = driver.findElement(By.xpath("//div[@class='carousel-section'][11]/div[@class='carousel-container']/div[1]/button[2]"));
			js.executeScript("arguments[0].style.border='2px solid red'", nextBtn);
			nextBtn.click();
			
			for(int i=6; i<=10; i++) {
				w = driver.findElement(By.cssSelector("#slick-slide10" + i));
				System.out.println(w.getText());			
			}
			
			Thread.sleep(2000);
			
			TakeScreenShot.takeScreenShot(driver);
				
			// Clicking the side arrow button
			js.executeScript("arguments[0].style.border='2px solid red'", nextBtn);
			nextBtn.click();
			
			for(int i=11; i<15; i++) {
				w = driver.findElement(By.cssSelector("#slick-slide10" + i));
				System.out.println(w.getText());
			}
			
			TakeScreenShot.takeScreenShot(driver);

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
