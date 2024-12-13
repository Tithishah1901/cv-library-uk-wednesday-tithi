package uk.co.library.pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import uk.co.library.customlisteners.CustomListeners;
import uk.co.library.utility.Utility;

public class HomePage extends Utility {

    @CacheLookup
    @FindBy(id = "keywords")
    WebElement enterJobTitle;

    @CacheLookup
    @FindBy(id = "location")
    WebElement enterLocation;

    @CacheLookup
    @FindBy(id = "distance")
    WebElement enterDistance;

    @CacheLookup
    @FindBy(id = "toggle-hp-search")
    WebElement clickOnMoreSearchOptionLink;

    @CacheLookup
    @FindBy(id = "salarymin")
    WebElement enterMinSalary;

    @CacheLookup
    @FindBy(id = "salarymax")
    WebElement enterMaxSalary;

    @CacheLookup
    @FindBy(id = "salarytype")
    WebElement enterSalaryType;

    @CacheLookup
    @FindBy(id = "tempperm")
    WebElement enterJobType;

    @CacheLookup
    @FindBy(id = "hp-search-btn")
    WebElement clickOnFindJob;


   public void setEnterJobTitle(String jobTitle){
       sendTextToElement(enterJobTitle,jobTitle);
       CustomListeners.test.log(Status.PASS,"entering job title");
   }
    public void setEnterLocation(String location){
        sendTextToElement(enterLocation,location);
        CustomListeners.test.log(Status.PASS,"entering the location");
    }
    public void setEnterDistance(String distance){
       selectByVisibleTextFromDropDown(enterDistance,distance);
       CustomListeners.test.log(Status.PASS,"entering distance");
    }
    public void setClickOnMoreSearchOptionLink(){
       clickOnElement(clickOnMoreSearchOptionLink);
       CustomListeners.test.log(Status.PASS,"clicking on search more option link");
    }
    public void setEnterMinSalary(String salaryMin){
       sendTextToElement(enterMinSalary,salaryMin);
       CustomListeners.test.log(Status.PASS, "enter minimum salary");
    }
    public void setEnterMaxSalary(String salaryMax){
        sendTextToElement(enterMaxSalary,salaryMax);
        CustomListeners.test.log(Status.PASS, "enter maximum salary");
    }
    public void setEnterSalaryType(String salaryType){
        sendTextToElement(enterSalaryType,salaryType);
        CustomListeners.test.log(Status.PASS, "enter salary type");
    }

    public void setEnterJobType(String jobType){
        sendTextToElement(enterJobType,jobType);
        CustomListeners.test.log(Status.PASS, "enter job type");
    }
    public void setClickOnFindJob(){
        clickOnElement(clickOnFindJob);
        CustomListeners.test.log(Status.PASS,"clicking on find job button");
    }

}

