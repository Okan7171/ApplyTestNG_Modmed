package com.modmed.pages;

import com.modmed.utilities.BrowserUtils;
import com.modmed.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class CareerPage extends BasePage{

    @FindBy (xpath = "//a[text()='Careers']")
    public WebElement careerButton;

    @FindBy (xpath = "//body[@class='page-template-default page page-id-48383 page-child parent-pageid-9 custom-background wp-schema-pro-2.7.9 et_monarch chrome et_button_custom_icon et_pb_button_helper_class et_fullwidth_nav et_fixed_nav et_show_nav et_primary_nav_dropdown_animation_fade et_secondary_nav_dropdown_animation_fade et_header_style_left et_pb_footer_columns4 et_cover_background et_pb_gutter windows et_pb_gutters3 et_pb_pagebuilder_layout et_smooth_scroll et_no_sidebar et_divi_theme et-db shiftnav-enabled shiftnav-lock shiftnav-disable-shift-body']")
    public WebElement cookieCloseButton;

    @FindBy (xpath = "//a[text()='Software Development Engineer in Test']")
    public WebElement SDETbutton;

    @FindBy (css = "#first_name")
    public WebElement firstNameButton;

    @FindBy (css = "#last_name")
    public WebElement lastNameButton;

    @FindBy (css = "#email")
    public WebElement emailButton;

    @FindBy (css = "#phone")
    public WebElement phoneButton;

    @FindBy (css = "#auto_complete_input")
    public WebElement locationButton;

    //@FindBy (xpath = "(//button[text()='Attach'])[1]")
    @FindBy (xpath = "//div[@class='link-container']/button")
    public WebElement resumeButton;

    @FindBy (xpath = "(//button[text()='Attach'])[2]")
    public WebElement coverLetterButton;


    public void basePageModules(String module){
        WebElement basePageModuleElement = Driver.get().findElement(By.xpath("//a[text()='" + module + "']"));
        BrowserUtils.clickWithJS(basePageModuleElement);
    }

    public void careerPageModules(String module){
        WebElement careerPageElement = Driver.get().findElement(By.xpath("//a[text()='" + module + "']"));
        careerPageElement.click();
    }

    public void privateInformationPage(String name, String lastName, String eMail,
                                       String phone, String location){
        Driver.get().switchTo().frame("grnhse_iframe");

       /*
        Actions actions= new Actions(Driver.get());

        JavascriptExecutor jse = (JavascriptExecutor)Driver.get();
        jse.executeScript("window.scrollBy(0,1500)");
        actions.click(firstNameButton)
                .sendKeys(name + Keys.TAB)
                .sendKeys(lastName + Keys.TAB)
                .sendKeys(eMail + Keys.TAB)
                .sendKeys(phone + Keys.TAB)
                .sendKeys(location + Keys.TAB).perform();

        */
        firstNameButton.sendKeys(name);
        lastNameButton.sendKeys(lastName);
        emailButton.sendKeys(eMail);
        phoneButton.sendKeys(phone);
        locationButton.sendKeys(location);
        Driver.get().findElement(By.xpath("//li[text()='Ankara, Ankara Province, Turkey']")).click();
        Driver.get().switchTo().defaultContent();
    }

    public void addResume(){
        String projectPath= System.getProperty("user.dir");
        String filePath= "src/test/resources/Olcay ER Resume.pdf";
        String fullPath= projectPath + "/" + filePath;
        resumeButton.sendKeys(fullPath);
    }



}
