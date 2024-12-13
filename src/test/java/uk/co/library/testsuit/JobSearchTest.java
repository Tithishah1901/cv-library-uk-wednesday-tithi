package uk.co.library.testsuit;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;
import uk.co.library.basetest.BaseTest;
import uk.co.library.customlisteners.CustomListeners;
import uk.co.library.pages.HomePage;
import uk.co.library.pages.ResultPage;


@Listeners(CustomListeners.class)
public class JobSearchTest extends BaseTest {

    HomePage homePage;
    ResultPage resultPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        resultPage = new ResultPage();
    }

    @Test(groups = {"smoke"}, dataProvider = "jobs", dataProviderClass = TestData.class)
    public void verifyJobSearchResultUsingDifferentDataSet
            (String jobTitle, String location, String distance, String salaryMin, String salaryMax, String salaryType, String jobType, String result){
       homePage.setEnterJobTitle(jobTitle);
       homePage.setEnterLocation(location);
       homePage.setEnterDistance("5 miles");
       homePage.setClickOnMoreSearchOptionLink();
       homePage.setEnterMinSalary(salaryMin);
       homePage.setEnterMaxSalary(salaryMax);
       homePage.setEnterSalaryType(salaryType);
       homePage.setEnterJobType(jobType);
       homePage.setClickOnFindJob();
       resultPage.setVerifyResult(result);
    }
}
