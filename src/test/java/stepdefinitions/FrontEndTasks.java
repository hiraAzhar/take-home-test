package stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FrontEndTasks {
    static WebDriver driver;
    static String chromeDriverPath = "driver/chromedriver";
    static WebDriverWait wait;

    static WebDriver getDriver() {
        if (driver != null) {
            return driver;
        } else {
            throw new IllegalStateException("Driver has not been initialized.");
        }
    }

    public static void init() {
        ChromeOptions op = new ChromeOptions();
        if (driver == null) {

            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
            op.addArguments("--start-maximized");
            driver = new ChromeDriver(op);
        } else {
            throw new IllegalStateException("Driver has already been initialized. Quit it before using this method");
        }

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    public static void end() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    @Given("^I launch Coin Market Website$")
    public void I_Launch_coinmarketcap_website() {
        init();
        driver.get("https://coinmarketcap.com/");
    }

    @When("^Select (\\d+) rows to be viewed from website$")
    public void select_rows_to_be_viewed_from_website(int rowNum) {
        getDriver().findElement(By.className("table-control-page-sizer")).findElement(By.tagName("div")).click();

        wait = new WebDriverWait(getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("tippy-box")));

        List<WebElement> buttonList = getDriver().findElement(By.className("tippy-box")).findElements(By.tagName("button"));
        for (WebElement button : buttonList) {
            if (button.getText().equals(rowNum)) {
                button.click();
                break;
            }
        }
    }

    @Then("^I should see 100 rows displayed on the page$")
    public void verify_that_results_are_displayed() {
        WebElement tableBody = getDriver().findElement(By.className("cmc-table")).findElement(By.tagName("tbody"));
        List<WebElement> tableBodyRows = tableBody.findElements(By.tagName("tr"));
        for (WebElement row : tableBodyRows)
            Assert.assertTrue(row.isDisplayed());
        end();
    }

    @When("^I click on filter button$")
    public void I_click_on_filter_button() {
        getDriver().findElement(By.cssSelector("body.DAY:nth-child(2) div.bywovg-1.sXmSU div.main-content div.sc-57oli2-0.dEqHl.cmc-body-wrapper div.grid div.cmc-homepage div.sc-1hxnufv-7.ckiJwf:nth-child(2) div.sc-16r8icm-0.sc-36mytl-1.nhbuoh-0.glkSgD.scroll-initial div.sc-16r8icm-0.dOJIkS.table-control-area:nth-child(3) div.sc-1hxnufv-5.fmuRvw > button.x0o17e-0.ewuQaX.sc-36mytl-0.bBafzO.table-control-filter:nth-child(1)")).click();
    }

    @And("^I click on Add Filter$")
    public void I_click_on_add_Filter() {
        getDriver().findElement(By.cssSelector("body.DAY:nth-child(2) div.bywovg-1.sXmSU div.main-content div.sc-57oli2-0.dEqHl.cmc-body-wrapper div.grid div.cmc-homepage ul.sc-1erqz0q-0.kSFTVn:nth-child(3) li:nth-child(5) > button.x0o17e-0.ewuQaX.sc-1hxnufv-0.sc-1k1om8k-0.dNBOZt")).click();
    }

    @When("^I filter records by MarketCap and Price$")
    public void I_filter_records_by_MarketCap_and_Price() {
        getDriver().findElement(By.cssSelector("body.DAY:nth-child(2) div.bywovg-1.sXmSU div.main-content div.sc-57oli2-0.dEqHl.cmc-body-wrapper div.grid div.cmc-homepage div.popup-overlay:nth-child(5) div.popup-content div.sc-1ogjh0p-0.eQBMcw div.sc-16r8icm-0.dPPHqL:nth-child(2) div.sc-16r8icm-0.gUBOfc.filter-area:nth-child(1) div.kvv4j3-0.kChfNS:nth-child(2) > button.x0o17e-0.iOedBp.cmc-filter-button")).click();
        getDriver().findElement(By.cssSelector("body.DAY:nth-child(2) div.bywovg-1.sXmSU div.main-content div.sc-57oli2-0.dEqHl.cmc-body-wrapper div.grid div.cmc-homepage div.popup-overlay:nth-child(5) div.popup-content div.sc-1ogjh0p-0.eQBMcw div.sc-16r8icm-0.hVdzfW:nth-child(2) div.sc-16r8icm-0.gUBOfc.filter-area div.sc-1wbb12d-0.jaoXuA:nth-child(3) div.sc-16r8icm-0.eMHrgu:nth-child(1) div.cmc-filter-presets:nth-child(4) > button.x0o17e-0.ewuQaX.cmc-filter-preset-button:nth-child(2)")).click();
        getDriver().findElement(By.cssSelector("body.DAY:nth-child(2) div.bywovg-1.sXmSU div.main-content div.sc-57oli2-0.dEqHl.cmc-body-wrapper div.grid div.cmc-homepage div.popup-overlay:nth-child(5) div.popup-content div.sc-1ogjh0p-0.eQBMcw div.sc-16r8icm-0.hVdzfW:nth-child(2) div.sc-16r8icm-0.gUBOfc.filter-area div.sc-1wbb12d-0.jaoXuA:nth-child(3) div.sc-16r8icm-0.dOJIkS:nth-child(2) div.sc-1wbb12d-2.emkuwC.cmc-input-row > button.x0o17e-0.cEEOTh.cmc-filter-button:nth-child(1)")).click();
//        new WebDriverWait(driver, 5).until(
//                ExpectedConditions.presenceOfElementLocated(By.cssSelector("body.DAY:nth-child(2) div.bywovg-1.sXmSU div.main-content div.sc-57oli2-0.dEqHl.cmc-body-wrapper div.grid div.cmc-homepage div.popup-overlay:nth-child(5) div.popup-content div.sc-1ogjh0p-0.eQBMcw div.sc-16r8icm-0.hVdzfW:nth-child(2) div.sc-16r8icm-0.gUBOfc.filter-area div.sc-1wbb12d-0.jaoXuA:nth-child(3) div.sc-16r8icm-0.dOJIkS:nth-child(2) div.sc-1wbb12d-2.emkuwC.cmc-input-row > button.x0o17e-0.cEEOTh.cmc-filter-button:nth-child(1)"))).click();


        getDriver().findElement(By.xpath("//body/div[@id='__next']/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[3]/button[1]")).click();
        getDriver().findElement(By.cssSelector("body.DAY:nth-child(2) div.bywovg-1.sXmSU div.main-content div.sc-57oli2-0.dEqHl.cmc-body-wrapper div.grid div.cmc-homepage div.popup-overlay:nth-child(5) div.popup-content div.sc-1ogjh0p-0.eQBMcw div.sc-16r8icm-0.hVdzfW:nth-child(2) div.sc-16r8icm-0.gUBOfc.filter-area div.sc-1wbb12d-0.jaoXuA:nth-child(4) div.sc-16r8icm-0.eMHrgu:nth-child(1) div.cmc-filter-presets:nth-child(4) > button.x0o17e-0.ewuQaX.cmc-filter-preset-button:nth-child(3)")).click();
        getDriver().findElement(By.cssSelector("body.DAY:nth-child(2) div.bywovg-1.sXmSU div.main-content div.sc-57oli2-0.dEqHl.cmc-body-wrapper div.grid div.cmc-homepage div.popup-overlay:nth-child(5) div.popup-content div.sc-1ogjh0p-0.eQBMcw div.sc-16r8icm-0.hVdzfW:nth-child(2) div.sc-16r8icm-0.gUBOfc.filter-area div.sc-1wbb12d-0.jaoXuA:nth-child(4) div.sc-16r8icm-0.dOJIkS:nth-child(2) div.sc-1wbb12d-2.emkuwC.cmc-input-row > button.x0o17e-0.cEEOTh.cmc-filter-button:nth-child(1)")).click();
        getDriver().findElement(By.cssSelector("body.DAY:nth-child(2) div.bywovg-1.sXmSU div.main-content div.sc-57oli2-0.dEqHl.cmc-body-wrapper div.grid div.cmc-homepage div.popup-overlay:nth-child(5) div.popup-content div.sc-1ogjh0p-0.eQBMcw div.sc-16r8icm-0.crXQjZ:nth-child(2) div.sc-16r8icm-0.sc-1o74f6b-0.fvGVzY:nth-child(2) > button.x0o17e-0.lgnbfA.cmc-filter-button:nth-child(1)")).click();
        end();
    }


}
