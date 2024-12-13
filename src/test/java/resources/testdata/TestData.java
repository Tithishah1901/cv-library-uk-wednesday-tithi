package resources.testdata;

import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "jobs")
    public Object[][] getData(){
        Object[][] data = new Object[][]{
                {"Tester","Harrow","up to 5 miles","30000","500000","per annum","Permanent","Permanent Tester jobs in Harrow on the Hill"}
        };
        return data;
    }
}
