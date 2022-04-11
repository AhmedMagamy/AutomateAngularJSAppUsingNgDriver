package pages;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.ByAngularButtonText;
import com.paulhammant.ngwebdriver.ByAngularModel;
import com.paulhammant.ngwebdriver.NgWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculatorPage {

    private WebDriver driver;
    NgWebDriver ngDriver;
    By firstSeleniumLocator = By.xpath("//input[@ng-model='first']");
    By secondSeleniumLocator = By.xpath("//input[@ng-model='second']");
    By operatorSeleniumLocator = By.xpath("//Select[@ng-model='operator']");
    By buttonSeleniumLocator = By.xpath("//button[@id='gobutton']");
    By resultSeleniumLocator = By.tagName("h2");

    //NgDriver locators
    ByAngularModel firstAngularLocator = ByAngular.model("first");
    ByAngularModel secondAngularLocator = ByAngular.model("second");
    ByAngularButtonText buttonAngularLocator = ByAngular.buttonText("Go!");







    public CalculatorPage(WebDriver driver) {
        this.driver = driver;
    }

    public String automateSumUsingSelenium(String num1 , String num2){
        WebDriverWait wait = new WebDriverWait(driver, 60);
       wait.until(ExpectedConditions.visibilityOfElementLocated(firstSeleniumLocator));
        driver.findElement(firstSeleniumLocator).sendKeys(num1);
        wait.until(ExpectedConditions.visibilityOfElementLocated(secondSeleniumLocator));
        driver.findElement(secondSeleniumLocator).sendKeys(num2);
        wait.until(ExpectedConditions.elementToBeClickable(buttonSeleniumLocator));
        driver.findElement(buttonSeleniumLocator).click();
       wait.until(ExpectedConditions.visibilityOfElementLocated(resultSeleniumLocator));
        return driver.findElement(resultSeleniumLocator).getText();

    }
    public String automateSumUsingNgDriver(String num1 , String num2){

        ngDriver = new NgWebDriver((JavascriptExecutor) driver);
        ngDriver.waitForAngularRequestsToFinish();
        driver.findElement(firstAngularLocator).sendKeys(num1);
        driver.findElement(secondAngularLocator).sendKeys(num2);
        driver.findElement(buttonAngularLocator).click();
        ngDriver.waitForAngularRequestsToFinish();
        return driver.findElement(resultSeleniumLocator).getText();
    }
}
