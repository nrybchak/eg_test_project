import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created with IntelliJ IDEA.
 * User: nrybchak
 * Date: 5/27/15
 * Time: 6:32 AM
 * To change this template use File | Settings | File Templates.
 */
public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "ptxt")
    private WebElement searchPhraseField;

    public WebElement getSearchPhraseField() {
        return searchPhraseField;
    }

    @FindBy(name = "topt[8][min]")
    private WebElement minPriceField;

    public WebElement getMinPriceField() {
        return minPriceField;
    }

    @FindBy(name = "topt[8][max]")
    private WebElement maxPriceField;

    public WebElement getMaxPriceField() {
        return maxPriceField;
    }

    @FindBy(name = "sid")
    private WebElement subheadingSelect;

    public WebElement getSubheadingSelect() {
        return subheadingSelect;
    }

    @FindBy(id = "s_region_select")
    private WebElement regionSelect;

    public WebElement getRegionSelect() {
        return regionSelect;
    }

    @FindBy(name = "pr")
    private WebElement periodSelect;

    public WebElement getPeriodSelect() {
        return periodSelect;
    }

    @FindBy(name = "sort")
    private WebElement sortSelect;

    public WebElement getSortSelect() {
        return sortSelect;
    }

    @FindBy(id = "sbtn")
    private WebElement searchButton;

    public WebElement getSearchButton() {
        return searchButton;
    }
}
