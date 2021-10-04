package pl.jaskot.turistportal.frontend.logic;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.progressbar.ProgressBar;

public abstract class AssistantMethods {

    public static void setProgressBarValue(ProgressBar progressBar, int i){
        switch (i){
            case 0:{ progressBar.setValue(0.000); break;}
            case 1:{ progressBar.setValue(0.250); break;}
            case 2:{ progressBar.setValue(0.500); break;}
            case 3:{ progressBar.setValue(0.750); break;}
            default:{ progressBar.setValue(1.000); break;}
        }
    }

    public static Button createButton(String text){
        Button button = new Button(text);
        button.addThemeVariants(ButtonVariant.MATERIAL_CONTAINED);
        button.getStyle().set("border-radius", "1em");
        return button;
    }

    public static Image createImage(String url){
        Image image = new Image(url,"Awaria podczas wyświetlenia zdjęcia");
        image.setHeight("70px");
        image.setHeightFull();
        image.setWidthFull();
        return image;
    }


    public static void showNotification(String name) {
        Notification notification = new Notification(
                "Gratulujemy kupna wspaniałej wycieczki do "+name+"!", 3000, Notification.Position.BOTTOM_CENTER);
        notification.open();
    }

    public static void progressBarToFull(ProgressBar progressBar){
        progressBar.setValue(1.000);
    }

}