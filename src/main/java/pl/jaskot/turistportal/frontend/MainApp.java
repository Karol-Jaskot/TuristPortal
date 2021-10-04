package pl.jaskot.turistportal.frontend;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.material.Material;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import pl.jaskot.turistportal.backend.generators.CountryGenerator;
import pl.jaskot.turistportal.backend.generators.QuestionGenerator;
import pl.jaskot.turistportal.backend.repo.CountryRepo;
import pl.jaskot.turistportal.backend.repo.QuestionRepo;
import pl.jaskot.turistportal.frontend.views.AssistantView;
import pl.jaskot.turistportal.frontend.views.AuthorView;
import pl.jaskot.turistportal.frontend.views.CountryView;
import pl.jaskot.turistportal.frontend.views.WelcomeView;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static pl.jaskot.turistportal.frontend.logic.components.AdvanceComponents.createDivPageForMenu;

@Route("")
@PWA(name = "TuristApp", shortName = "App")
@Viewport("width=device-width, minimum-scale=1.0, initial-scale=1.0, user-scalable=yes")

@HtmlImport("styles/shared-styles.html")
@Theme(value = Material.class, variant = Material.DARK)
public class MainApp extends AppLayout {

    Logger logger = LoggerFactory.getLogger(MainApp.class);
    private Tab tab1, tab2, tab3, tab4, tab5;
    private Div page1, page2, page3, page4, page5;
    private Map<Tab, Component> tabsToPages;
    private Tabs tabs;
    private Div pages;
    private Set<Component> pagesShown;

    @Autowired
    private CountryRepo countryRepo;
    @Autowired
    private QuestionRepo questionRepo;

    public MainApp(CountryRepo countryRepo, QuestionRepo questionRepo){
        this.countryRepo = countryRepo;
        this.questionRepo = questionRepo;

        addToNavbar(new DrawerToggle(), new Label("Jaskot Travel "));

        // Set basic data to application if all data are empty
        addOferts();
        addQuestions();

        createTabs();
        createDivPages();
        addToDrawer(tabs);
        setContent(page1);
    }

    private void addOferts() { new CountryGenerator(countryRepo);}
    private void addQuestions(){ new QuestionGenerator(questionRepo); }

    // views control
// =============================================================================================================

    private void createViews(){
        tab1 = new Tab("Witamy");
        page1 = createDivPageForMenu(new WelcomeView(), true);
        page1.add();
        tab2 = new Tab("Oferta");
        page2 = createDivPageForMenu(new CountryView(countryRepo), false);
        tab3 = new Tab("Asystent");
        page3 = createDivPageForMenu(new AssistantView(countryRepo, questionRepo), false);
        tab4 = new Tab("Autor");
        page4 = createDivPageForMenu(new AuthorView(), false);
    }

    private void connectingTabsToPages(){
        tabsToPages = new HashMap<>();
        tabsToPages.put(tab1, page1);
        tabsToPages.put(tab2, page2);
        tabsToPages.put(tab3, page3);
        tabsToPages.put(tab4, page4);
    }

    private void createTabs(){
        createViews();
        connectingTabsToPages();
        tabs = new Tabs(tab1, tab2, tab3, tab4);
        tabs.setOrientation(Tabs.Orientation.VERTICAL);
        tabs.addSelectedChangeListener(event -> showSelectedPage());
    }

    private void createDivPages(){
        pages = new Div(page1, page2, page3, page4);
        pagesShown = Stream.of(page1)
                .collect(Collectors.toSet());
    }

    private void showSelectedPage(){
        pagesShown.forEach(page -> page.setVisible(false));
        pagesShown.clear();
        Component selectedPage = tabsToPages.get(tabs.getSelectedTab());
        selectedPage.setVisible(true);
        setContent(selectedPage);
        pagesShown.add(selectedPage);
    }
}