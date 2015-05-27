import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: nrybchak
 * Date: 5/27/15
 * Time: 5:29 AM
 * To change this template use File | Settings | File Templates.
 */
public class MainPageTest extends BaseTest {

    private static final Logger logger = Logger.getLogger(BaseTest.class.getName());

    @Test
    public void testLanguageChange() {
        driver.get(urlString);

        MainCatalogPage mainCatalogPage = new MainCatalogPage(driver);
        PageFactory.initElements(driver, mainCatalogPage);

        mainCatalogPage.getRussianLangLink().click();
        try {
            Assert.assertTrue(mainCatalogPage.getElectronicsLink().getText().contains("Электротехника"));
            logger.info("Language changing to Russian test - passed");
        } catch (AssertionError error) {
            logger.log(Level.SEVERE, "Link text is not in Russian, current text: {0}",
                    mainCatalogPage.getElectronicsLink().getText());
        }
    }

    @Test
    public void testElectronicsSearch() {
        MainCatalogPage mainCatalogPage = new MainCatalogPage(driver);
        PageFactory.initElements(driver, mainCatalogPage);
        mainCatalogPage.getElectronicsLink().click();
        try {
            Assert.assertTrue(driver.findElement(By.xpath(
                    "//a[@href = '/ru/electronics/phones/mobile-phones/']")).isDisplayed());
            logger.info("Electronics page opening test - passed");
        } catch (AssertionError error) {
            logger.log(Level.SEVERE,
                    "Electronics hasn't opened: mobile Phones section is not displayed on the page");
        }

        SearchPage searchPage = new SearchPage(driver);
        PageFactory.initElements(driver, searchPage);
        searchPage.getRussianSearchButton().click();

        searchPage.getSearchPhraseField().sendKeys("куплю");
        (new Select(searchPage.getSubheadingSelect())).selectByVisibleText("Покупают");
        (new Select(searchPage.getPeriodSelect())).selectByVisibleText("За последнюю неделю");
        //scroll to Search button - click method doesn't work by default
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + searchPage.getSearchButton().getLocation().y + ")");
        searchPage.getSearchButton().click();

        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        PageFactory.initElements(driver, searchResultsPage);
        try {
            Assert.assertTrue(searchResultsPage.getResultsLinks().get(0).getText().contains("куплю"));
            logger.info("Electronics search test - passed");
        } catch (AssertionError error) {
            logger.log(Level.SEVERE,
                    "Electronics search is performed incorrectly: Search result doesn't contain search phrase");
        }

        (new Select(searchResultsPage.getSortFilterSelect())).selectByVisibleText("Цена");
        (new Select(searchResultsPage.getTransactionFilterSelect())).selectByVisibleText("Продажа");

        searchResultsPage.getExtendedSearchLink().click();
        searchPage.getMinPriceField().sendKeys("0");
        searchPage.getMaxPriceField().sendKeys("300");
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + searchPage.getSearchButton().getLocation().y + ")");
        searchPage.getSearchButton().click();
    }
}
