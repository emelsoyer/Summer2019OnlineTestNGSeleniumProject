package tests.VyTrack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
;
public class invalidTest {




        public static void main(String[] args) {
            WebDriver driver= BrowserFactory.getDriver("Chrome");
            driver.manage().window().maximize();
            //load the page
            driver.get("http://qa2.vytrack.com/user/login");
            WebElement username=driver.findElement(By.name("_username"));

            //
            username.sendKeys("user");
            //get
            WebElement password=driver.findElement(By.name("_password"));

            //send keys to password element
            password.sendKeys("User123");
            //
            WebElement button=driver.findElement(By.id("_submit"));
            button.click();
            WebElement invalidMessage=driver.findElement(By.xpath("//div[@class='alert alert-error']"));

            String actualMessage=invalidMessage.getText();

            String expectedMessage="Invalid user name or password.";
            if (actualMessage.equals(expectedMessage)){
                System.out.println("Test passed");
            }else {
                System.out.println("Test failed");
                System.out.println(expectedMessage);
                System.out.println(actualMessage);
            }

            driver.close();
        }

    }
