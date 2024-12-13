package uk.co.library.browserfactory;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import uk.co.library.propertyreader.PropertyReader;

import java.time.Duration;

/**
 * Created by Jay Vaghani
 */
public class ManageBrowser {

    public WebElement getShadowElement(WebElement shadowHost, String cssSelector) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (WebElement) js.executeScript(
                "return arguments[0].shadowRoot.querySelector(arguments[1])",
                shadowHost, cssSelector
        );

    }

    public static WebDriver driver;
    private String baseUrl = PropertyReader.getInstance().getProperty("baseUrl");
    private int implicitlyWait = Integer.parseInt(PropertyReader.getInstance().getProperty("implicitlyWait"));

    public ManageBrowser(){
        PageFactory.initElements(driver, this);
    }
    public void selectBrowser(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("ie")) {
            driver = new InternetExplorerDriver();
        } else {
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitlyWait));
        driver.get(baseUrl);

        try {
            WebElement shadowHost = driver.findElement(By.cssSelector("div.cf_modal_container"));
            WebElement rejectButton = getShadowElement(shadowHost, "button#cf_consent-buttons__reject-all");
            rejectButton.click();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}