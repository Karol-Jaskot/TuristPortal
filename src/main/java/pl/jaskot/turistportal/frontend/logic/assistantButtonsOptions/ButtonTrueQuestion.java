package pl.jaskot.turistportal.frontend.logic.assistantButtonsOptions;

import com.vaadin.flow.component.progressbar.ProgressBar;
import pl.jaskot.turistportal.frontend.logic.AssistantMethods;

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
                AssistantMethods.setProgressBarValue(progressBar, 1);
                return 2;
            }
            case 2:{
                AssistantMethods.setProgressBarValue(progressBar, 2);
                return 4;
            }
            case 3:{
                AssistantMethods.setProgressBarValue(progressBar, 2);
                return 6;
            }
            case 4:{
                AssistantMethods.setProgressBarValue(progressBar, 3);
                return 8;
            }
            case 5:{
                AssistantMethods.setProgressBarValue(progressBar, 3);
                return 10;
            }
            case 6:{
                AssistantMethods.setProgressBarValue(progressBar, 3);
                return 12;
            }
            case 7:{
                AssistantMethods.setProgressBarValue(progressBar, 3);
                return 14;
            }
            default:{
                return Integer.parseInt(null);
            }
        }

    }
}