package tests.day3;

import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class NavigationPractice {

    public static void main(String[] args) {
      /*getTilte() - to get page title
getCurrentUrl() - to get URL of the current website
close() - to close current tab. it's it's a last tab - it will also shutdown a browser and session.
quit() - to close all tabs that were opened by webdriver.
navigate().to(URL) - to jump to other website. It will not open a new tab/browser.
navigate().back() - comeback to previous website
navigate().forward() - to move forward in the browser history. Usually, used after navigate().back().
navigate().refresh() - to refresh a website.
manage().window().maximize() - to maximize window
manage().window().fullscreen() - to run browser in the fullscreeen mode

*/  WebDriver driver= BrowserFactory.getDriver("chrome");//create a webdriver object, to work with a browser

        driver.manage().window().maximize();//to maximize browser window

        driver.get("http://google.com");

        BrowserUtils.wait(3);//wait for 3 seconds
                                    //this is out custom method
                                   //since method is static, we use class name to call the method
                                  //as a parameter, we provide number of seconds(time in seconds)



        driver.navigate().to("http://amazon.com");//go to amazon page

        driver.navigate().back();// navigate back to google(previous URL)

        driver.navigate().forward();//move forward to amazon again

        driver.navigate().refresh();//to refresh/reload a webpage/website

        driver.quit();//shutdown browser

    }















}
