package tests.day6;

import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;

public class Practice {

    public static void main(String[] args) {
         WebDriver driver=BrowserFactory.getDriver("chrome");
         driver.get("https://www.ebay.com/");

    }

}
