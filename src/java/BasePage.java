import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created with IntelliJ IDEA.
 * User: nrybchak
 * Date: 5/27/15
 * Time: 5:03 AM
 * To change this template use File | Settings | File Templates.
 */
public class BasePage {

    private final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(how = How.XPATH, using = "//a[@href = '/ru/']")
    private WebElement russianLangLink;

    public WebElement getRussianLangLink() {
        return russianLangLink;
    }

    @FindBy(how = How.LINK_TEXT, using = "Поиск")
    private WebElement russianSearchButton;

    public WebElement getRussianSearchButton() {
        return russianSearchButton;
    }
}
