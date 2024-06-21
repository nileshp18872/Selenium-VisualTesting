import com.applitools.eyes.selenium.Eyes;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloWorldTest {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        //System.setProperty("webdriver.chrome.driver", "path_to_chromedriver.exe");

        // Instantiate a new WebDriver instance (in this case, ChromeDriver)
        //WebDriver driver = new ChromeDriver();

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        
        // Initialize the Eyes SDK
        Eyes eyes = new Eyes();
        eyes.setApiKey("X22mstxb4OhvBz5EaxPwCnLV32cKx11197UJe6zxW5xQXg110"); // Replace with your Applitools API key

        try {
            // Start the test
            eyes.open(driver, "Hello World!", "Hello World Test");
            	

            // first 2 times we will run our test with below url
            driver.get("https://applitools.com/helloworld/");
            
            // 3rd time we will run our test will below url, then will get the changes in eye.applitools.com
            //driver.get("https://applitools.com/helloworld/?diff1");
            
           // 4th time we will run our test will below url, then will get the changes in eye.applitools.com
            //driver.get("https://applitools.com/helloworld/?diff2");
            
            // Optional: Maximize the browser window
            driver.manage().window().maximize();

            // Perform your tests here
            // Example: eyes.checkWindow("Hello World Page");
            
            // checkpoint 1
            eyes.checkWindow("Hello!");
            
            // click the button
            driver.findElement(By.tagName("button")).click();
            
            // checkpoint 2
            eyes.checkWindow("Click!");
            
            // End the test
            eyes.close();
        } finally {
            // Abort the test in case of an unexpected error
            eyes.abortIfNotClosed();
        }

        // Close the browser
        driver.quit();
    }
}
