package pl.jaskot.turistportal.frontend.logic.components;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.progressbar.ProgressBar;

public class BasicComponents {

    public static H1 createDarkTitle(String text) {
        H1 title = new H1(text);
        title.getElement().getThemeList().add("dark");
        return title;
    }

    public static Image createImage600x400(String link){
        Image image = new Image(link,"Foto");
        image.setMaxHeight("400px");
        image.setMaxWidth("600px");
        image.setWidthFull();
        image.setHeightFull();
        return image;
    }

    public static Image createImageMax(String link){
        Image image = new Image(link,"Foto");
        image.setHeightFull();
        image.setWidthFull();
        return image;
    }

    public static ProgressBar createAutomaticProgressBar(){
        ProgressBar progressBar = new ProgressBar();
        progressBar.setIndeterminate(true);
        return progressBar;
    }

}
