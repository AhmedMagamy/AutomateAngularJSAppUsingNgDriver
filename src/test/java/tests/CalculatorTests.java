package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CalculatorPage;

import java.util.concurrent.TimeUnit;

public class CalculatorTests {
    //This class has all setup and closing actions that any test class will need
    public WebDriver driver;
    private CalculatorPage calculatorPage;

    //setup method that calls the browser driver and open base url
    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void callPages() {

        calculatorPage= new CalculatorPage(driver);
    }

    @Test
    public void seleniumTest(){
    driver.get("http://juliemr.github.io/protractor-demo/");
    String result = calculatorPage.automateSumUsingSelenium("10","20");
        System.out.println(result);
        //Expected to fail
        Assert.assertTrue(result.contains("30"));
    }
    @Test
    public void ngDriverTest(){
        driver.get("http://juliemr.github.io/protractor-demo/");
        String result = calculatorPage.automateSumUsingNgDriver("10","20");
        System.out.println(result);
        //Expected to pass
        Assert.assertTrue(result.contains("30"));

    }



    //responsible for closing
    @AfterClass
    public void tearDown() throws InterruptedException {
    }
}
