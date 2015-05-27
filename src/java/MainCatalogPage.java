import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created with IntelliJ IDEA.
 * User: nrybchak
 * Date: 5/27/15
 * Time: 5:21 AM
 * To change this template use File | Settings | File Templates.
 */
public class MainCatalogPage extends BasePage {

    public MainCatalogPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//h2/a[@href = '/ru/electronics/']")
    private WebElement electronicsLink;

    public WebElement getElectronicsLink() {
        return electronicsLink;
    }
}
