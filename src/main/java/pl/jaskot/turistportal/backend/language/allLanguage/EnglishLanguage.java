package pl.jaskot.turistportal.backend.language.allLanguage;

import pl.jaskot.turistportal.backend.language.AbstractLanguage;

public class EnglishLanguage extends AbstractLanguage{
    public EnglishLanguage(){
        setLangName("English");
        setTabOneText("Welcome");
        setTabTwoText("Offer");
        setTabThreeText("Assistant");
        setTabFourText("Author");
        setSelectText("Language");
        setNotificationText("The language has been changed to English");
    }
}
