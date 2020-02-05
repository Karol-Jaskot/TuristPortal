package pl.jaskot.turistportal.backend.services;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;

public class PageService {

    private Tabs tabs;
    private Div pages;

    public PageService(){}

    public void createTab(Class view){
        Tab tab = new Tab();
        Div page = new Div();
    }

}
