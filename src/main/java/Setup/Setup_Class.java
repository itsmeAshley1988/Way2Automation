package Setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Setup_Class {

    public static String dir = System.getProperty("user.dir");

    public static final String Chromedriver = dir + ".\\src\\main\\java\\Drivers\\chromedriver.exe";
    public static final String Firefoxdriver= dir + "";
    public static WebDriver driver;
    public Setup_Class(){
    }

    public static WebDriver startBrowserofChoice(String URL, String BrowserChoice){

        if (BrowserChoice.equalsIgnoreCase("chrome")){

            System.setProperty("webdriver.chrome.driver", Chromedriver);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            //options.setExperimentalOption("useAutomationExtention", false);
            driver = new ChromeDriver(options);
        } else if (BrowserChoice.equalsIgnoreCase("Firefox")){
            //System.setProperty("", Firefoxdriver);
            // driver = new FirefoxDriver();
        }
        driver.get(URL);
        return driver;
    }
}
