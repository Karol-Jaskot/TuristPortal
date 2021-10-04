package pl.jaskot.turistportal.frontend.views.assistant;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.progressbar.ProgressBar;

public abstract class AssistantMethods {

    /**
     * Control a number of progressBar
     * @param progressBar to control value
     * @param i min=0, max=4
     */
    public static void controlProgressBar(ProgressBar progressBar, int i){
        if(i==0){
            progressBar.setValue(0.000);
        }
        else if(i==1){
            progressBar.setValue(0.250);
        }
        else if(i==2){
            progressBar.setValue(0.500);
        }
        else if(i==3){
            progressBar.setValue(0.750);
        }
        else{
            progressBar.setValue(1.000);
        }
    }

    /**
     * Method create a buttons
     * @param text to set on button
     * @return this button
     */
    public static Button createButton(String text){
        Button button = new Button(text);
        button.addThemeVariants(ButtonVariant.MATERIAL_CONTAINED);
        button.getStyle().set("border-radius", "1em");
        return button;
    }

    /**
     * Create image for assistant from url and
     * @return this image
     */
    public static Image createImage(String url){
        Image image = new Image(url,"Awaria podczas wyświetlenia zdjęcia");
        image.setHeight("70px");
        image.setHeightFull();
        image.setWidthFull();
        return image;
    }

    /**
     * Show notification to buy travel
     */
    public static void showNotification(String name) {
        Notification notification = new Notification(
                "Gratulujemy kupna wspaniałej wycieczki do "+name+"!", 3000, Notification.Position.BOTTOM_CENTER);
        notification.open();
    }

    public static void progressBarToFull(ProgressBar progressBar){
        progressBar.setValue(1.000);
    }

}
