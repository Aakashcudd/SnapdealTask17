package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task17 {
	
    public static void main(String[] args) throws Exception {
	      
        // Setup WebDriverManager
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

 
            //Open the browser and navigate to Snapdeal website
            driver.navigate().to("http://www.snapdeal.com");

            // Maximize the browser window
            driver.manage().window().maximize();

            // Step 2: Move the cursor to the Sign In button and hold it
            WebElement loginhover = driver.findElement(By.xpath("//div[@class='accountInner']"));
            Actions actions = new Actions(driver);
            actions.moveToElement(loginhover).perform();
            
            Thread.sleep(5000);
            // Step 3: Click on the Sign In button
            driver.findElement((By.linkText("Your Account"))).click();
            Thread.sleep(5000);
            
            // Step 4: Enter a valid Email Id in the Email Id field
            driver.findElement(By.id("userName")).sendKeys("sundarselvamuthu@gmail.com");

            // Cannot automate snap deal with dummy account. Need to create account
            //Need to enter OTP
            //Instead written code for steps mentioned in task
            
            // Step 5: Click on the Continue button
            driver.findElement(By.id("checkUser")).click();

            // Step 6: Enter the valid password in the Password field
           
            Thread.sleep(2000);
            driver.findElement(By.id("j_password_login_uc")).sendKeys("Aakash@1512");

            // Step 7: Click on the Login button
           driver.findElement(By.id("submitLoginUC")).click();

            // Step 8: Verify that the user is logged in successfully
            // Pause to allow time for the login process to complete
            Thread.sleep(3000);
            
            WebElement accountName = driver.findElement(By.cssSelector("span.accountUserName"));
            if (accountName.getText().contains("Test User")) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Login failed!");
            }

            // Close the browser
            driver.quit();
        }
    }