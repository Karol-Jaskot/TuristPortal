package pl.jaskot.turistportal.frontend.views;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import static pl.jaskot.turistportal.frontend.logic.components.BasicComponents.createImageMax;
import static pl.jaskot.turistportal.frontend.logic.configs.BasicLayoutConfigurations.setBasicConfigForLayout;
import static pl.jaskot.turistportal.frontend.logic.configs.ImagesSources.menuLogo;

public class WelcomeView extends VerticalLayout {

    public WelcomeView() {
        setBasicConfigForLayout(this, "welcome-view");
        add( createImageMax(menuLogo));
    }
}