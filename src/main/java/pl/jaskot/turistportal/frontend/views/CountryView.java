package pl.jaskot.turistportal.frontend.views;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import pl.jaskot.turistportal.backend.entity.Country;
import pl.jaskot.turistportal.backend.repo.CountryRepo;

import java.util.List;

import static pl.jaskot.turistportal.frontend.logic.components.AdvanceComponents.createCountryAccordion;
import static pl.jaskot.turistportal.frontend.logic.components.BasicComponents.createDarkTitle;
import static pl.jaskot.turistportal.frontend.logic.configs.BasicLayoutConfigurations.setBasicConfigForLayout;

public class CountryView extends VerticalLayout {

    public CountryView(CountryRepo countryRepo) {
        setBasicConfigForLayout(this, "country-view");
        add(createDarkTitle("Oferta podróży"), createCountryAccordion((List<Country>) countryRepo.findAll()));
    }
}