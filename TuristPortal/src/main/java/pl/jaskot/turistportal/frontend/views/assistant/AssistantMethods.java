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
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        return button;
    }

    public static Image createImage(){
        Image image = new Image("https://www.fototapety24.net/img/wlasne_foto/d/fototapeta_wschod_slonca_nad_polem_lawendy.jpg","Foto");
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

    /**
     * True options to next question
     * @param number of last question
     * @param progressBar to control
     * @return number of next question
     */
    public static int trueOptionsToQuestions(int number, ProgressBar progressBar) {
        switch (number){
            case 1:{
                controlProgressBar(progressBar, 1);
                return 2;
            }
            case 2:{
                controlProgressBar(progressBar, 2);
                return 4;
            }
            case 3:{
                controlProgressBar(progressBar, 2);
                return 6;
            }
            case 4:{
                controlProgressBar(progressBar, 3);
                return 8;
            }
            case 5:{
                controlProgressBar(progressBar, 3);
                return 10;
            }
            case 6:{
                controlProgressBar(progressBar, 3);
                return 12;
            }
            case 7:{
                controlProgressBar(progressBar, 3);
                return 14;
            }
            default:{
                return Integer.parseInt(null);
            }
        }

    }

    /**
     * True options to country, end of assistant
     * @param number of last question
     * @param progressBar to control
     * @return nuber of next question
     */
    public static String trueOptionsToCountry(int number, ProgressBar progressBar) {
        switch (number) {
            case 8: {
                progressBarToFull(progressBar);
                return "Meksyk";
            }
            case 9: {
                progressBarToFull(progressBar);
                return "Brazylia";
            }
            case 10: {
                progressBarToFull(progressBar);
                return "Indie";
            }
            case 11: {
                progressBarToFull(progressBar);
                return "Maroko";
            }
            case 12: {
                progressBarToFull(progressBar);
                return "Norwegia";
            }
            case 13: {
                progressBarToFull(progressBar);
                return "Dania";
            }
            case 14: {
                progressBarToFull(progressBar);
                return "Islandia";
            }
            case 15: {
                progressBarToFull(progressBar);
                return "Kanada";
            }
            default: return null;
        }
    }

    /**
     * False options to next question
     * @param number of last question
     * @param progressBar to control
     * @return number of next question
     */
    public static int falseOptionsToQuestions(int number, ProgressBar progressBar) {
        switch (number){
            case 1:{
                controlProgressBar(progressBar, 1);
                return 3;
            }
            case 2:{
                controlProgressBar(progressBar, 2);
                return 5;
            }
            case 3:{
                controlProgressBar(progressBar, 2);
                return 7;
            }
            case 4:{
                controlProgressBar(progressBar, 3);
                return 9;
            }
            case 5:{
                controlProgressBar(progressBar, 3);
                return 11;
            }
            case 6:{
                controlProgressBar(progressBar, 3);
                return 13;
            }
            case 7:{
                controlProgressBar(progressBar, 3);
                return 15;
            }
            default:{
                return Integer.parseInt(null);
            }
        }
    }

    /**
     * True options to country, end of assistant
     * @param number of last question
     * @param progressBar to control
     * @return nuber of next question
     */
    public static String falseOptionsToCountry(int number, ProgressBar progressBar) {
        switch (number) {
            case 8: {
                progressBarToFull(progressBar);
                return "Peru";
            }
            case 9: {
                progressBarToFull(progressBar);
                return "Hiszpania";
            }
            case 10: {
                progressBarToFull(progressBar);
                return "Egipt";
            }
            case 11: {
                progressBarToFull(progressBar);
                return "RPA";
            }
            case 12: {
                progressBarToFull(progressBar);
                return "Szwecja";
            }
            case 13: {
                progressBarToFull(progressBar);
                return "Finlandia";
            }
            case 14: {
                progressBarToFull(progressBar);
                return "Wyspy Owcze";
            }
            case 15: {
                progressBarToFull(progressBar);
                return "Rosja";
            }
            default: return null;
        }
    }

    private static void progressBarToFull(ProgressBar progressBar){
        progressBar.setValue(1.000);
    }

}
