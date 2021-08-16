package Tests;

import Helpers.Report_Class;
import Helpers.Screenshot_Class;
import Pages.Add_User_Class;
import Setup.Setup_Class;
import com.aventstack.extentreports.Status;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

//Extend the report Class so you can log the steps on the report
//extends the Report Class (Class names must match)

public class Add_User_Test extends Report_Class {

    private WebDriver driver = Setup_Class.startBrowserofChoice("http://www.way2automation.com/angularjs-protractor/webtables/", "chrome");
    Add_User_Class add_user = PageFactory.initElements(driver, Add_User_Class.class);
    Screenshot_Class screenshot = new Screenshot_Class();
    //Read data from Excel file
    private static final String excel = ".\\src\\main\\java\\Test_Data\\Add_User_Data.xlsx";
    FileInputStream fis = new FileInputStream(excel);
    XSSFWorkbook workbook = new XSSFWorkbook(fis);
    XSSFSheet Add_User_Data = workbook.getSheetAt(0);

    String FirstName  = Add_User_Data.getRow(1).getCell(0).getStringCellValue();
    String LastName  = Add_User_Data.getRow(1).getCell(1).getStringCellValue();
    String UserName  = Add_User_Data.getRow(1).getCell(2).getStringCellValue();
    String Password  = Add_User_Data.getRow(1).getCell(3).getStringCellValue();
    String Customer  = Add_User_Data.getRow(1).getCell(4).getStringCellValue();
    String Role = Add_User_Data.getRow(1).getCell(5).getStringCellValue();
    String Email  = Add_User_Data.getRow(1).getCell(6).getStringCellValue();
    String Mobile  = Add_User_Data.getRow(1).getCell(7).getStringCellValue();

    public Add_User_Test() throws IOException{

    }


    @Test (priority = 1)
    public void Add_User_Test() throws Exception{
        test = extent.createTest("Add User Test", "Add a new User");
        test.log(Status.PASS, "Click Add User Button");
        add_user.Click_Add_User_Button();
        test.log(Status.PASS,"Enter First Name");
        add_user.FirstName(FirstName);
        test.log(Status.PASS, "Enter Last Name");
        add_user.LastName(LastName);
        test.log(Status.PASS, "Enter Username");
        add_user.UserName(UserName);
        test.log(Status.PASS, "Enter Password");
        add_user.PassWord(Password);
        test.log(Status.PASS, "Select Customer Type");
        add_user.Radio_Button1(Customer);
        test.log(Status.PASS, "Select Role");
        add_user.RoLe(Role);
        test.log(Status.PASS, "Enter email");
        add_user.eMail(Email);
        test.log(Status.PASS, "Enter Mobile");
        add_user.moBile(Mobile);
        test.log(Status.PASS, "Click the Save Button");

        screenshot.takeSnapShot(driver, "Add user details");
        add_user.Click_Save_Button();

        test.log(Status.PASS, "Very user added successfully");

        screenshot.takeSnapShot(driver, "User Added");
        add_user.Verify_User_added();

    }

    //This is to close the Browser
    @AfterSuite
    public void Quit()
    {
       driver.quit();
   }



}
