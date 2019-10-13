package pl.jaskot.turistportal.frontend.views;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import pl.jaskot.turistportal.backend.entity.Country;
import pl.jaskot.turistportal.backend.entity.CountryRepo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CountryView extends VerticalLayout {

    private CountryRepo countryRepo;

    public CountryView(CountryRepo countryRepo) {
        this.countryRepo = countryRepo;
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("backgroundColor", "GhostWhite");

        Label welcomeText = new Label("Poznaj naszą ofertę:");
        Accordion accordion = new Accordion();
        List<Country> countryList = new ArrayList();
        countryList.addAll((Collection<? extends Country>) countryRepo.findAll());

        //tworzenie listy elementów
        for(Country country: countryList){
            VerticalLayout thisCountry = new VerticalLayout();
            thisCountry.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
            thisCountry.add(
                    new Label(country.getName()),
                    new Label(country.getTextOffer()),
                    new Label("Cena: "+country.getPrice())
            );
            accordion.add(country.getName(), thisCountry);
        }
        accordion.setWidthFull();
        add( welcomeText ,accordion);
    }
}
