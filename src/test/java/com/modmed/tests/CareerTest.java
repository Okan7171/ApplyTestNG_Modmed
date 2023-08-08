package com.modmed.tests;

import com.modmed.pages.CareerPage;
import com.modmed.utilities.BrowserUtils;
import com.modmed.utilities.ConfigurationReader;
import com.modmed.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class CareerTest extends TestBase{
    @Test
    public void applyTest(){
        CareerPage careerPage=new CareerPage();
        extentLogger=report.createTest("Apply Test");
        extentLogger.info("go to the home page");
        driver.get(ConfigurationReader.get("url"));
        extentLogger.info("click career button");
        careerPage.basePageModules("Careers");
        //extentLogger.info("click cookie close button");
        //careerPage.cookieCloseButton.click();
        extentLogger.info("click Software Development Engineer in Test");
        driver.switchTo().frame("grnhse_iframe");
        //careerPage.SDETbutton.click();
        BrowserUtils.clickWithJS(careerPage.SDETbutton);
        driver.switchTo().defaultContent();
        extentLogger.info("go to the SDET private information page");
        careerPage.privateInformationPage("Olcay", "Er", "lcyr8081@gmail.com", "+905056184240", "Ankara");
       driver.switchTo().frame("grnhse_iframe");
       BrowserUtils.clickWithJS(careerPage.resumeButton);
        BrowserUtils.clickWithJS(careerPage.coverLetterButton);
     careerPage.addResume();
    }
}
