package tests.day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;
/*
xpath is a type of locator that is used in Selenium to find elements. Xpath was originally create for XML documents, nut it also supports HTML documents. Since every single web application consists of HTML, we can use Xpath with HTML documents as well.


We have 2 types of xpath: relative and absolute


absolute xpath must start from root element.
In HTML it's a <html> tag

<!DOCTYPE html>
<html>
	<head>
		<title>My personal page</title>
	</head>
	<body>
		<h1>Welcome to my page!</h1>
		<h4>Please subscribe for updates</h4>
		<form>
			<span>Enter your email:</span>
			<input type="text" name="email">
		</form>
	</body>
</html>

How to get to the input box? /html/body/form/input

html has 2 children: head and body, then body has 3 children: h1 , h4 and form, then form has 2 children: span and input.

Example 2:

<!DOCTYPE html>
<html>
	<head>
		<title>My personal page</title>
	</head>
	<body>
		<h1>Welcome to my page!</h1>
		<h4>Please enter your info</h4>
		<form>
			<span>Enter your name:</span>
			<input type="text" name="name">
			<br>
			<span>Enter your phone number:</span>
			<input type="tel" name="phone">
		</form>
	</body>
</html>

How to create a locator for phone number?
/html/body/form/input[2]


Bitrix warning message:
/html/body/table/tbody/tr[2]/td/div/div/div[2]

Vytrack warning message:
/html/body/div[1]/div/div/div/div[1]/form/fieldset/div[1]/div


Relative xpath can start from anywhere.
It must start with // and then you can use tag name, attributes, text, to create a locator:

For example, for bitrix warning message:

//div[@class='errortext'] either '' or "", better '' because "" in java used for strings.

//tagName[@attribute='value']

* - any tag name (a,input,button, div, body, etc.)

//input[@value='Log In']

What if we don't have exact value, only beginning part?

then we can use starts-with:

syntax: //tag[starts-with(@attribute, 'value')]

//input[starts-with(@onclick, 'BX')]

//input[starts-with(@value, 'Log')]

It works, only if it's beginning of value/text



If value has '', then use "" in the xpath:

//input[@onclick="BX.addClass(this, 'wait');"]


To find element based on text, use text(), instead of @attribute.


//a[starts-with(text(), 'Forgot')] - equals to beginning of the phrase.

//*[text()='Text'] - equals to exact text


How about partial text???


we can use contains. Contains will help us to find element based on partial text/value regardless of location.

//*[contains(text(),'Incorrect')]


//*[contains(@title,'Activity Stream')]




(//button)[3] - nth element of matching

//button[3] - 3rd child

*/
public class BitrixLogin {

    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://login1.nextbasecrm.com/stream/?login=yes");

        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("helpdesk57@cybertekschool.com");

        driver.findElement(By.xpath("//input[@name='USER_PASSWORD']")).sendKeys("UserUser");
                      // OR we can use this ("//*[@placeholder='Password']")  "*" we can put * instead of any tag name

        driver.findElement(By.xpath("//input[starts-with(@value, 'Log')]")).click();

        BrowserUtils.wait(3);

        //driver.close();
    }
}
