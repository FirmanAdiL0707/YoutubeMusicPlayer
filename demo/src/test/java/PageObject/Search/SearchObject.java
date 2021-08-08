package PageObject.Search;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import StepDefinition.Init.Base.BaseClass;

public class SearchObject extends BaseClass {

    private By LOGINBUTTON = By.cssSelector("div[class='search-box style-scope ytmusic-search-box']");
    private By INPUT = By.cssSelector("input[id='input']");
    //Contents
    private By CONTENTS = By.cssSelector("#contents > ytmusic-shelf-renderer:nth-child(1)");
    

    public SearchObject(){
        PageFactory.initElements(driver, this);
    }
    
    public void ClikSearchButton(){
        action.Click(LOGINBUTTON);
    }

    public void InputTextOnSearch(String input){
        action.EnterText(INPUT, input);
        action.PressEnter();
    }

    public String ValidateMusicOnTopResult(){
        By TitleElement = By.cssSelector("#contents > ytmusic-responsive-list-item-renderer > div.flex-columns.style-scope.ytmusic-responsive-list-item-renderer > div.title-column.style-scope.ytmusic-responsive-list-item-renderer > yt-formatted-string > a");
        return action.GetText(TitleElement);
    }

    public void ClickPlayButtonOnMusicSelected(){
        By MusicElement = By.cssSelector("#contents > ytmusic-shelf-renderer:nth-child(1) > #contents > ytmusic-responsive-list-item-renderer > div:nth-child(1) > ytmusic-item-thumbnail-overlay-renderer > #contents > #play-button");
        System.out.println(action.IsElementExists(MusicElement));
    }

    public void ClickPlayMusicOnTopResult(){
        By MusicElement = By.cssSelector("#contents > ytmusic-responsive-list-item-renderer > div.flex-columns.style-scope.ytmusic-responsive-list-item-renderer > div.title-column.style-scope.ytmusic-responsive-list-item-renderer > yt-formatted-string > a");
        action.Click(MusicElement);
    }

}
