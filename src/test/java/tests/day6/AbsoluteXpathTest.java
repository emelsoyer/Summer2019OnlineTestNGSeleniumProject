package tests.day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class AbsoluteXpathTest {

    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("https://login1.nextbasecrm.com/stream/?login=yes");

        driver.findElement(By.className("login-btn")).click();
        BrowserUtils.wait(2);
        //We can use two xpath to find the element
        //ABSOLUTE XPATH
        //WebElement warningMessage=driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/div/div/div[2]"));
        //RELATIVE XPATH
        WebElement warningMessage=driver.findElement(By.xpath("//div[@class='errortext']"));
        System.out.println(warningMessage.getText());
        driver.close();
    }
}
