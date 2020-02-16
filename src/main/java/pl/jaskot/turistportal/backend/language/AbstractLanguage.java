package pl.jaskot.turistportal.backend.language;

import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.tabs.Tab;

public abstract class AbstractLanguage {

    private String langName;
    private String tabOneText;
    private String tabTwoText;
    private String tabThreeText;
    private String tabFourText;
    private String selectText;
    private String notificationText;


    public void setTabsText(Tab tab1, Tab tab2, Tab tab3, Tab tab4, Select select){
        try {
            setTabsTextToStart(tab1, tab2, tab3, tab4, select);
            createNotification();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setTabsTextToStart(Tab tab1, Tab tab2, Tab tab3, Tab tab4, Select select){
            setTabOneName(tab1);
            setTabTwoName(tab2);
            setTabThreeName(tab3);
            setTabFourName(tab4);
            setSelectName(select);
    }

    private void setTabOneName(Tab tab) {
        createTab(tab, 1, tabOneText);
    }

    private void setTabTwoName(Tab tab) {
        createTab(tab, 2, tabTwoText);
    }

    private void setTabThreeName(Tab tab) {
        createTab(tab, 3, tabThreeText);
    }

    private void setTabFourName(Tab tab) {
        createTab(tab, 4, tabFourText);
    }

    private void setSelectName(Select select) {
        select.setLabel(selectText);
    }

    private void createTab(Tab tab, int i, String text){
        tab.removeAll();
        if(i==1){
            tab.add(new Icon(VaadinIcon.DIAMOND));
        }
        else if(i==2){
            tab.add(new Icon(VaadinIcon.SUITCASE));
        }
        else if(i==3){
            tab.add(new Icon(VaadinIcon.USER_STAR));
        }
        else if(i==4){
            tab.add(new Icon(VaadinIcon.USER_CARD));
        }
        tab.add(text);
    }

    private void createNotification(){
        Notification notification = new Notification();
        notification.setDuration(3000);
        notification.setText(notificationText);
        notification.setPosition(Notification.Position.BOTTOM_CENTER);
        notification.open();
    }

    public String getLangName() {
        return langName;
    }

    public void setLangName(String langName) {
        this.langName = langName;
    }

    public String getTabOneText() {
        return tabOneText;
    }

    public void setTabOneText(String tabOneText) {
        this.tabOneText = tabOneText;
    }

    public String getTabTwoText() {
        return tabTwoText;
    }

    public void setTabTwoText(String tabTwoText) {
        this.tabTwoText = tabTwoText;
    }

    public String getTabThreeText() {
        return tabThreeText;
    }

    public void setTabThreeText(String tabThreeText) {
        this.tabThreeText = tabThreeText;
    }

    public String getTabFourText() {
        return tabFourText;
    }

    public void setTabFourText(String tabFourText) {
        this.tabFourText = tabFourText;
    }

    public String getSelectText() {
        return selectText;
    }

    public void setSelectText(String selectText) {
        this.selectText = selectText;
    }

    public String getNotificationText() {
        return notificationText;
    }

    public void setNotificationText(String notificationText) {
        this.notificationText = notificationText;
    }
}
