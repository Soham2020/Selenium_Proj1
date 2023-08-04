package MiniProject.BookSearchAutomation;

import java.io.FileReader;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;

/**
 * Hello world!
 *
 */
public class App 
{
	
    public static void main( String[] args ) throws Exception {
    	Scanner sc = new Scanner(System.in);
    	
    	// Read the URL from config.properties
    	FileReader fr = new FileReader("C:\\Users\\2282058\\Downloads\\eclipse-java-2023-03-R-win32-x86_64 (1)\\eclipse\\BookSearchAutomation\\Resources\\config.properties");
    	Properties p = new Properties();
    	p.load(fr);
    	String url = p.getProperty("url");
    	
    	// call the respective driver
    	System.out.println("Press 1 for Chrome Driver and Press 2 for Edge Driver");
    	int option = sc.nextInt();
    	WebDriver driver = DriverSetup.driverSetup(option);
    	if(driver == null) {
    		System.out.println("Please enter the correct option");
    	}
    	else {
    		// Printing the categories of books and the count of the respective book
    		PrintCategories.printCategories(driver, url);
    		
    		Thread.sleep(4000);
    		
    		// Check whether the count of Tamil Books is more than 1000
    		CountTamilBooks.countTamilBooks(driver, url);
    	}
    	driver.close();
    	
    	
    	sc.close();
    }
}
