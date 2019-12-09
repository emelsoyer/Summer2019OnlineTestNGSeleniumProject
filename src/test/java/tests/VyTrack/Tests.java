package tests.VyTrack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Tests {




        public static WebDriver getDriver(String browser){

            String OS = SystemUtils.OS_NAME; // Mac or windows

            if (OS.equalsIgnoreCase("Mac OS X")){
                switch (browser){
                    case "Safari":
                        System.out.println("Running Safari Tests... ");
                        return new SafariDriver();
                    case "Chrome":
                        WebDriverManager.chromedriver().setup();
                        System.out.println("Running Chrome Tests... ");
                        return new ChromeDriver();
                    case "FireFox":
                        WebDriverManager.firefoxdriver().setup();
                        System.out.println("Running FireFox Tests... ");
                        return new FirefoxDriver();
                    case "Opera":
                        WebDriverManager.operadriver().setup();
                        System.out.println("Running Opera Tests... ");
                        return new OperaDriver();
                    default:
                        return null;
                }

            }
            else if (OS.equalsIgnoreCase("Windows")){
                switch (browser){
                    case "Chrome":
                        return new ChromeDriver();
                    case "FireFox":
                        return new FirefoxDriver();
                    case "Edge":
                        return new EdgeDriver();
                    case "Opera":
                        return new OperaDriver();
                    default:
                        return null;
                }

            }
            else return null;


        }


    }

