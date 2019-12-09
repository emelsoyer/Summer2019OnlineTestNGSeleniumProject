package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class FileUploading {
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
    }
    @Test(description = "Verify that file was uploaded")
    public void test1(){
        driver.findElement(By.linkText("File Upload")).click();
        //provide path to the file
        //insert your path to the file
        driver.findElement(By.id("file-upload")).sendKeys("C:\\temp\\abc.txt");
        //click submit
        driver.findElement(By.id("file-submit")).click();
        BrowserUtils.wait(4);
        String expectedFileName = "abc.txt";
        String actualFileName = driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(actualFileName, expectedFileName);
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}
/*String actualMessage=driver.findElement(By.xpath("//h3")).getText();
        System.out.println(actualMessage);
        String expectedMessage="File Uploaded!";
        Assert.assertEquals(actualMessage, expectedMessage, "Message is wrong");*/