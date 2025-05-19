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
       webDriverHelper.pressEnter(locaters.getSearchBox());
    }
    public void clickFirstResult() {
        webDriverHelper.clickElement(locaters.getContent());
    }
    public void clickPauseButton() {
        webDriverHelper.clickElement(locaters.getPauseButton());
    }
    public void clickSubtitlesButton() {
        webDriverHelper.clickElement(locaters.getSubtitlesButton());
    }
    public void clickSettingsButton() {
        webDriverHelper.clickElement(locaters.getSettingsButton());
    }
    public void clickQualityButton() {
        webDriverHelper.clickElement(locaters.getQualityButton());
    }
    public void clickQuality1080p() {
        webDriverHelper.clickElement(locaters.getQuality1080p());
    }

}
