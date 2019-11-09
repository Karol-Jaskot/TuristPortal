package pl.jaskot.turistportal.frontend;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.material.Material;
import org.springframework.beans.factory.annotation.Autowired;
import pl.jaskot.turistportal.backend.CountryGenerator;
import pl.jaskot.turistportal.backend.QuestionGenerator;
import pl.jaskot.turistportal.backend.entity.CountryRepo;
import pl.jaskot.turistportal.backend.entity.QuestionRepo;
import pl.jaskot.turistportal.backend.language.AbstractLanguage;
import pl.jaskot.turistportal.backend.language.allLanguage.EnglishLanguage;
import pl.jaskot.turistportal.backend.language.allLanguage.GermanLanguage;
import pl.jaskot.turistportal.backend.language.allLanguage.ItalianLanguage;
import pl.jaskot.turistportal.backend.language.allLanguage.PolishLanguage;
import pl.jaskot.turistportal.frontend.views.assistant.AssistantView;
import pl.jaskot.turistportal.frontend.views.AuthorView;
import pl.jaskot.turistportal.frontend.views.CountryView;
import pl.jaskot.turistportal.frontend.views.WelcomeView;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Route("")
@PWA(name = "TuristApp", shortName = "App")
@Viewport("width=device-width, minimum-scale=1.0, initial-scale=1.0, user-scalable=yes")

@HtmlImport("styles/shared-styles.html")
@Theme(value = Material.class, variant = Material.DARK)
public class MainApp extends AppLayout {


    // dane aplikacji
    private Tab tab1, tab2, tab3, tab4;
    private Div page1, page2, page3, page4;
    private Map<Tab, Component> tabsToPages;
    private Tabs tabs;
    private Div pages;
    private Set<Component> pagesShown;
    private Select<String> selectLanguage;
    private AbstractLanguage language;
    private List<AbstractLanguage> languageList;
    private List<String> languagesName;
    private Iterator<AbstractLanguage> langIterator;

    // bazy danych
    @Autowired
    private CountryRepo countryRepo;
    @Autowired
    private QuestionRepo questionRepo;

    public MainApp(CountryRepo countryRepo, QuestionRepo questionRepo){
        this.countryRepo = countryRepo;
        this.questionRepo = questionRepo;

        // pasek górny
        Label lbName = new Label("Jaskot & Bury Travel ");
        addToNavbar(new DrawerToggle(), lbName);

        // tworzenie baz danych
        //addOferts();
        //addQuestions();

        // kontrola widoków
        createTabs();
        createDivPages();
        addToDrawer(tabs);
        setContent(page1);
        creareSelesctLanguage();
    }

    private void creareSelesctLanguage() {
        languageList = new ArrayList();
        // trzeba tutaj dodać język do listy
        languageList.add(new PolishLanguage());
        languageList.add(new EnglishLanguage());
        languageList.add(new GermanLanguage());
        languageList.add(new ItalianLanguage());

        languagesName = new ArrayList<>();
        langIterator = languageList.iterator();
        while(langIterator.hasNext()) {
            AbstractLanguage thisLanguage = langIterator.next();
            languagesName.add(thisLanguage.getLangName());
        }
        selectLanguage = new Select<>();
        selectLanguage.setItems(languagesName);
        selectLanguage.setSizeFull();
        selectLanguage.setValue(languageList.get(0).getLangName());
        selectLanguage.addValueChangeListener(e->setTabsName(selectLanguage.getValue()));
        language = languageList.get(0);
        language.setTabsTextToStart(tab1, tab2, tab3, tab4, selectLanguage);
        addToDrawer(selectLanguage);
    }

    private void addOferts() {
        CountryGenerator countryGenerator = new CountryGenerator(countryRepo);
    }
    private void addQuestions(){ QuestionGenerator questionGenerator = new QuestionGenerator(questionRepo); }

    // poniżej metody kontroli widoków aplikacji, nic nie zmieniać
// =============================================================================================================

    private void createViews(){

        tab1 = new Tab();
        page1 = new Div();
        WelcomeView welcomeView = new WelcomeView();
        page1.add(welcomeView);
        page1.add();

        tab2 = new Tab();
        page2 = new Div();
        CountryView countryView = new CountryView(countryRepo);
        page2.add(countryView);
        page2.setVisible(false);

        tab3 = new Tab();
        page3 = new Div();
        AssistantView  assistantView = new AssistantView(countryRepo, questionRepo);
        page3.add(assistantView);
        page3.setVisible(false);

        tab4 = new Tab();
        page4 = new Div();
        AuthorView authorView = new AuthorView();
        page4.add(authorView);
        page4.setVisible(false);
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

    private void setTabsName(String value){
        for(AbstractLanguage abstractLanguage: languageList){
            if(abstractLanguage.getLangName().equals(value)){
                language = abstractLanguage;
            }
        }
        language.setTabsText(tab1, tab2, tab3, tab4, selectLanguage);
    }
}