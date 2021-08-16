package Helpers;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screenshot_Class {

    public void takeSnapShot(WebDriver driver, String screenShotName){

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {

            FileUtils.copyFile(screenshot, new File(".//ScreenShots/"+ screenShotName+".png"));
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

    }

}
