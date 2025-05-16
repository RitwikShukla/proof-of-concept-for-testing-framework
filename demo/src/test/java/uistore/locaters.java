package uistore;

import org.openqa.selenium.By;

public class locaters {

    private By searchBox = By.xpath("//input[@id='search']");
    private By searchButton = By.xpath("//button[@id='search-icon-legacy']");
    private By firstVideo = By.xpath("(//a[@id='video-title'])[1]");
    private By videoQualityButton = By.xpath("//button[@class='ytp-button ytp-settings-button']");
    private By videoQuality1080p = By.xpath("//div[@class='ytp-menuitem' and contains(text(),'1080p')]");
    private By subtitlesButton = By.xpath("//button[@class='ytp-subtitles-button ytp-button']");
    private By pauseButton = By.xpath("//button[@class='ytp-play-button ytp-button ytp-large-play-button ytp-button-play-pause']");
    private By playButton = By.xpath("//button[@class='ytp-play-button ytp-button ytp-large-play-button ytp-button-pause']");
    private By videoTitle = By.xpath("//h1[@class='title style-scope ytd-video-primary-info-renderer']");
    private By videoDescription = By.xpath("//yt-formatted-string[@class='content style-scope ytd-video-secondary-info-renderer']");

    
    public By getSearchBox() {
        return searchBox;
    }
    public By getSearchButton() {
        return searchButton;
    }
    public By getFirstVideo() {
        return firstVideo;
    }
    public By getVideoQualityButton() {
        return videoQualityButton;
    }
    public By getVideoQuality1080p() {
        return videoQuality1080p;
    }
    public By getSubtitlesButton() {
        return subtitlesButton;
    }
    public By getPauseButton() {
        return pauseButton;
    }
    public By getPlayButton() {
        return playButton;
    }
    public By getVideoTitle() {
        return videoTitle;
    }
    public By getVideoDescription() {
        return videoDescription;
    }

}
