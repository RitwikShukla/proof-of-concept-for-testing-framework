package uistore;
class Locaters
{
    private By searchBox = By.xpath("//input[@name='search_query']");
    private By content = By.id("title-wrapper");
    private By pauseButton = By.className("ytp-play-button ytp-button");
    private By subtitlesButton = By.className("ytp-subtitles-button ytp-button");
    private By settingsButton = By.className("ytp-button ytp-settings-button");
    private By qualityButton = By.xpath("//div[@class='ytp-menuitem-label' and text()='Quality']");
    private By quality1080p = By.xpath("//div[@class='ytp-menuitem-label' and text()='1080p']");
    public By getSearchBox() {
        return searchBox;
    }
    public By getContent() {
        return content;
    }
    public By getPauseButton() {
        return pauseButton;
    }
    public By getSubtitlesButton() {
        return subtitlesButton;
    }

    public By getSettingsButton() {
        return settingsButton;
    }
    public By getQualityButton() {
        return qualityButton;
    }
    public By getQuality1080p() {
        return quality1080p;
    }

}
