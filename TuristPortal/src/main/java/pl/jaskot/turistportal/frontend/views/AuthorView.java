package pl.jaskot.turistportal.frontend.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.progressbar.ProgressBar;
import com.vaadin.flow.router.Route;


public class AuthorView extends VerticalLayout {

    public AuthorView() {
        getStyle().set("backgroundColor", "white");
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        // Jaskot
        createImage("https://www.traktorpool.pl/media/hhp/Jaskot_Grzegorz_101164.jpg?force=1&text=");

        createProgressBar();
        createProgressBar();

        // Spring
        createImage("https://camo.githubusercontent.com/12136cf9daa20a57168a9bdee376f2e83e13c5b1/68747470733a2f2f7069636f636c692e696e666f2f696d616765732f737072696e672d626f6f742e706e67");
        // Hibernate
        createImage("https://miro.medium.com/max/1200/1*GI9m2zoDYsNNU59q20nMsg.jpeg");
        // Vaadin
        createImage("https://vaadin.com/images/trademark/PNG/VaadinLogo_RGB_1000x310.png");

    }

    private void createProgressBar(){
        ProgressBar progressBar = new ProgressBar();
        progressBar.setIndeterminate(true);
        add(progressBar);}

    private void createImage(String link){
        Image image = new Image(link,"Foto");
        image.setMaxHeight("400px");
        image.setMaxWidth("600px");
        image.setWidthFull();
        image.setHeightFull();
        add(image);
    }
}
