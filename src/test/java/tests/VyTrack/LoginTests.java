package tests.VyTrack;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import tests.TestBase;
import utils.Driver;

public class LoginTests extends TestBase {
    @Test(description = "Verify that page title is a 'Dashboard'")
    public void test1(){
        //create page object
        LoginPage loginPage = new LoginPage();
        //call login method
        //provide username and password
        loginPage.login("storemanager85", "UserUser123");
        //verification stage
        WebDriverWait wait=new WebDriverWait(Driver.get(),10);
        wait.until(ExpectedConditions.titleIs("Dashboard"));
        Assert.assertEquals(Driver.get().getTitle(), "Dashboard");

    }
}
