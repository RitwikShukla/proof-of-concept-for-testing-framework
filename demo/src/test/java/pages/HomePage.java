package pages;

import uistore.Locaters;
import utils.Base;
import utils.Reporter;
import utils.WebDriverHelper;

public class HomePage {

    WebDriverHelper webDriverHelper = new WebDriverHelper(Base.driver);

    Locaters locaters = new Locaters();
    Reporter reporter;

    public HomePage(Reporter reporter) {
        this.reporter = reporter;
    }

    public void enterSearchText (String searchText) {
       webDriverHelper.sendKeysToElement(locaters.getSearchBox(), searchText);
    }

}
