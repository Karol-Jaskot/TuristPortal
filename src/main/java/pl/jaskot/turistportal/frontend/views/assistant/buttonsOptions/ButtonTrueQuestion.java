package pl.jaskot.turistportal.frontend.views.assistant.buttonsOptions;

import com.vaadin.flow.component.progressbar.ProgressBar;
import pl.jaskot.turistportal.frontend.views.assistant.AssistantMethods;

public abstract class ButtonTrueQuestion {
    /**
     * True options to next question
     * @param number of last question
     * @param progressBar to control
     * @return number of next question
     */
    public static int option(int number, ProgressBar progressBar) {
        switch (number){
            case 1:{
                AssistantMethods.controlProgressBar(progressBar, 1);
                return 2;
            }
            case 2:{
                AssistantMethods.controlProgressBar(progressBar, 2);
                return 4;
            }
            case 3:{
                AssistantMethods.controlProgressBar(progressBar, 2);
                return 6;
            }
            case 4:{
                AssistantMethods.controlProgressBar(progressBar, 3);
                return 8;
            }
            case 5:{
                AssistantMethods.controlProgressBar(progressBar, 3);
                return 10;
            }
            case 6:{
                AssistantMethods.controlProgressBar(progressBar, 3);
                return 12;
            }
            case 7:{
                AssistantMethods.controlProgressBar(progressBar, 3);
                return 14;
            }
            default:{
                return Integer.parseInt(null);
            }
        }

    }
}