package pl.jaskot.turistportal.frontend.logic.components;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import pl.jaskot.turistportal.backend.entity.Country;

import java.util.List;

public class AdvanceComponents {

    public static Accordion createCountryAccordion(List<Country> countryList) {
        Accordion accordion = new Accordion();
        for(Country country: countryList){
            VerticalLayout thisCountry = new VerticalLayout();
            thisCountry.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);
            thisCountry.add(
                    new Label(country.getName()),
                    new Label(country.getTextOffer()),
                    new Label("Cena: "+country.getPrice())
            );
            accordion.add(country.getName(), thisCountry);
        }
        accordion.setWidthFull();
        return accordion;
    }

    public static Div createDivPageForMenu(VerticalLayout layout, Boolean visible){
        Div div = new Div();
        div.add(layout);
        div.setVisible(visible);
        return div;
    }

}