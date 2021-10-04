package pl.jaskot.turistportal.frontend.logic.configs;

import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class BasicLayoutConfigurations {

    public static void setBasicConfigForLayout(VerticalLayout layout, String className){
        layout.setSizeFull();
        layout.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);
        layout.addClassName(className);
    }

}
