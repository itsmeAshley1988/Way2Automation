package Pages;

import com.sun.jdi.Value;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Random;

public class Add_User_Class {

    //We creating a instance of a driver with WebDriver type
    private WebDriver driver;

    //The Constructor to pass driver information to another class
    public Add_User_Class(WebDriver driver)
    {
     this.driver=driver;
    }

    public static void main(String[] args){

        System.setProperty("webdriver.chrome.driver", "Dependencies//chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.way2automation.com/angularjs-protractor/webtables/");
        WebElement RadioBtn1 = driver.findElement(By.xpath("//input[contains(@value,'15')]"));
        RadioBtn1.click();
    }

    //We Locating all the Elements on the Add User page
    @FindBy(xpath = "//button[@class='btn btn-link pull-right'][contains(.,'Add User')]")
    WebElement Add_User_Button;

    @FindBy(xpath = "//input[contains(@name,'FirstName')]")
    WebElement First_Name;

    @FindBy(xpath = "//input[contains(@name,'LastName')]")
    WebElement Last_Name;

    @FindBy(xpath = "//input[contains(@name,'UserName')]")
    WebElement User_Name;

    @FindBy(xpath = "//input[contains(@type,'password')]")
    WebElement Password;

    @FindBy(xpath = "//input[contains(@value,'15')]")
    WebElement Radio_Company_AAA;


    @FindBy(xpath = "//input[contains(@value,'16')]")
    WebElement Radio_Company_BBB;

    @FindBy(xpath = "//select[contains(@name,'RoleId')]")
    WebElement Role;

    @FindBy(xpath = "//input[contains(@type,'email')]")
    WebElement Email;

    @FindBy(xpath = "//input[contains(@name,'Mobilephone')]")
    WebElement Mobile_Number;

    @FindBy(xpath = "//button[@ng-click='save(user)'][contains(.,'Save')]")
    WebElement Save_Button;

    @FindBy(xpath = "//td[@ng-repeat='column in columns'][contains(.,'@test.com')]")
    WebElement User_Verification;

    //We create a method to click on the Add User button
    public void Click_Add_User_Button()
    {
        //We wait 10 seconds for the WebElement to be visible after we click on the Add User Button
        WebDriverWait addUser=new WebDriverWait(driver, 10);
        addUser.until(ExpectedConditions.visibilityOf(Add_User_Button));
        Add_User_Button.click();
    }

    //We creating a method to enter the First Name
    public void FirstName(String firstName) throws InterruptedException {
        Thread.sleep(3000);
        First_Name.sendKeys(firstName);
    }

    //We creating a method to enter the Last Name
    public void LastName(String lastName) throws InterruptedException {
        Thread.sleep(3000);
        Last_Name.sendKeys(lastName);
    }

    //We creating a method to enter the UserName
    public void UserName(String userName) throws InterruptedException
    {
        Thread.sleep(3000);
        User_Name.click();
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        User_Name.sendKeys(userName + randomInt);

    }

    //We creating a method to enter the Password
    public void PassWord(String password) throws InterruptedException
    {
        Thread.sleep(3000);
        Password.sendKeys(password);
    }

    public void Radio_Button1(String radioButton1) throws InterruptedException
    {
        Thread.sleep(3000);
        Radio_Company_BBB.click();
    }

    public void Radio_Button2(String radioButton2)
    {
        Radio_Company_BBB.click();
    }

    public void RoLe(String role) throws InterruptedException
    {
        Thread.sleep(3000);
        Role.sendKeys(role);
        //Select _roleDrp=new Select(Role);
        //_roleDrp.selectByVisibleText(role);
    }

    public void eMail(String email) throws InterruptedException
    {
        Thread.sleep(3000);
        Email.click();
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        Email.sendKeys("test" + randomInt + "@test.com");
    }

    public void moBile(String mobile) throws InterruptedException
    {
        Thread.sleep(3000);
        Mobile_Number.sendKeys(mobile);
    }

    public void Click_Save_Button()
    {
        Save_Button.click();
    }

    public void Verify_User_added()
    {

        Assert.assertTrue(User_Verification.isDisplayed());

    }





}
