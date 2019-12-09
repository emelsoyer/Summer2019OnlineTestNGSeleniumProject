package tests.day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;

public class RadioButtons {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        //to go to Radio Buttons page
        driver.findElement(By.linkText("Radio Buttons")).click();

    }

    @Test(description = "Verify that blue button is selected")
    public void test1() {


        WebElement blueButton = driver.findElement(By.id("blue"));
        //let's verify that radio button is selected
        boolean isSelected = blueButton.isSelected();

        Assert.assertTrue((isSelected));
    }

    @Test(description = "Verify that blue button is not selected")
    public void test2() {
        WebElement redButton = driver.findElement(By.id("red"));
        //let's verify that radio button is selected
        Assert.assertFalse(redButton.isSelected());

    }

    @Test(description = "verify that green button is not clickable")
    public void test3() {
        WebElement greenButton = driver.findElement(By.id("green"));
        Assert.assertFalse(greenButton.isEnabled());
    }

    @Test(description = "Click on all radio buttons")
    public void test4() {
        //how to find all radio buttons?
        //find all radio buttons
        //any radio button will have type='radio' and input as a element type
        List<WebElement> radioButtons = driver.findElements(By.cssSelector("input[type='radio']"));
//        let's click only if button is not clicked and is available for clicking
        for (WebElement button : radioButtons) {
//            if button is available for clicking and not clicked yet
            if (button.isEnabled() && !button.isSelected()) {
//                then click on it
                button.click();
//                in this case, id attribute represents a name of the color
//                also, there is no text in this element
//                that's why I print attribute value
//                <input type="radio" id="green" name="color" disabled=""> attribute: type, id, name, disabled
                System.out.println("Button clicked: " + button.getAttribute("id"));
            } else {
                System.out.println("Button was not clicked: " + button.getAttribute("id"));
            }
            BrowserUtils.wait(1); // for demo
        }
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
