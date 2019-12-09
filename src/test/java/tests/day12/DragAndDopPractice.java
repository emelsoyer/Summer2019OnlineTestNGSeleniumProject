package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class DragAndDopPractice {

    private WebDriver driver;


    @Test(description = "Drag and drop example")
    public void test1() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        Actions actions=new Actions(driver);

        //moon -it is a dragable object(small ball)
        //earth- it is a drop target (big circle)
        WebElement moon=driver.findElement(By.id("draggable"));
        WebElement earth=driver.findElement(By.id("droptarget"));

        BrowserUtils.wait(3);
        actions.dragAndDrop(moon, earth).perform();
        BrowserUtils.wait(10);

        driver.quit();
    }
}
