package uk.co.library.pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import uk.co.library.customlisteners.CustomListeners;
import uk.co.library.utility.Utility;

public class ResultPage extends Utility {

    @CacheLookup
    @FindBy(id = "resultText")
    WebElement verifyResult;

    public void setVerifyResult(String result){
        getTextFromElement(verifyResult);
        CustomListeners.test.log(Status.PASS,"verifying the Permanent Tester jobs in Harrow on the Hill");
    }
}
