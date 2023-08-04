package MiniProject.BookSearchAutomation;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenShot {
	private static int i = 1;

	public static void takeScreenShot(WebDriver driver) {
		
		TakesScreenshot ss = (TakesScreenshot)driver;
		
		File srcFile = ss.getScreenshotAs(OutputType.FILE);
		String filePath = "C:\\Users\\2282058\\Downloads\\eclipse-java-2023-03-R-win32-x86_64 (1)\\eclipse\\BookSearchAutomation\\ScreenShots\\func1" + i + ".png";
		i++;
		File destFile = new File(filePath);
		
		try {
			FileUtils.copyFile(srcFile, destFile);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
