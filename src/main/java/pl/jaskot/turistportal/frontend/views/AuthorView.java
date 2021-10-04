package pl.jaskot.turistportal.frontend.views;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import static pl.jaskot.turistportal.frontend.logic.components.BasicComponents.*;
import static pl.jaskot.turistportal.frontend.logic.configs.BasicLayoutConfigurations.setBasicConfigForLayout;
import static pl.jaskot.turistportal.frontend.logic.configs.ImagesSources.*;

public class AuthorView extends VerticalLayout {

    public AuthorView() {
        setBasicConfigForLayout(this, "author");
        add(
                createDarkTitle("Autor projektu: Karol Jaskot"),
                createDarkTitle("Wykorzystane technologie:"),
                createImage600x400(springLogo),
                createAutomaticProgressBar(),
                createImage600x400(hibernateLogo),
                createAutomaticProgressBar(),
                createImage600x400(vaadinLogo)
        );
    }
}