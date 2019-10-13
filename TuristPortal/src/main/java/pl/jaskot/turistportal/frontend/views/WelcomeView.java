package pl.jaskot.turistportal.frontend.views;

import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class WelcomeView extends VerticalLayout {

    public WelcomeView() {
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        Label lbWelcome = new Label(" Witamy w naszym biurze podróży!");

        Image image = new Image("https://www.goforworld.com/wp-content/uploads/2017/01/travel_map.jpg","FajnaFota");
        image.setHeightFull();
        image.setWidthFull();

        add( image);
    }
}
