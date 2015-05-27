import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nrybchak
 * Date: 5/27/15
 * Time: 6:55 AM
 * To change this template use File | Settings | File Templates.
 */
public class SearchResultsPage extends BasePage {

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[3]/select")
    private WebElement sortFilterSelect;

    public WebElement getSortFilterSelect() {
        return sortFilterSelect;
    }

    @FindBy(xpath = "//span[4]/select")
    private WebElement transactionFilterSelect;

    public WebElement getTransactionFilterSelect() {
        return transactionFilterSelect;
    }

    @FindBy(linkText = "Расширенный поиск")
    private WebElement extendedSearchLink;

    public WebElement getExtendedSearchLink() {
        return extendedSearchLink;
    }

    @FindBy(how = How.XPATH, using = "//div[@class = 'd1']/a")
    private List<WebElement> resultsLinks;

    public List<WebElement> getResultsLinks() {
        return resultsLinks;
    }
}
