package pl.jaskot.turistportal.frontend.logic.assistantButtonsOptions;

import com.vaadin.flow.component.progressbar.ProgressBar;
import pl.jaskot.turistportal.frontend.logic.AssistantMethods;

public abstract class ButtonFalseCountry {
    /**
     * True options to country, end of assistant
     * @param number of last question
     * @param progressBar to control
     * @return nuber of next question
     */
    public static String option(int number, ProgressBar progressBar) {
        switch (number) {
            case 8: {
                AssistantMethods.progressBarToFull(progressBar);
                return "Peru";
            }
            case 9: {
                AssistantMethods.progressBarToFull(progressBar);
                return "Hiszpania";
            }
            case 10: {
                AssistantMethods.progressBarToFull(progressBar);
                return "Egipt";
            }
            case 11: {
                AssistantMethods.progressBarToFull(progressBar);
                return "RPA";
            }
            case 12: {
                AssistantMethods.progressBarToFull(progressBar);
                return "Szwecja";
            }
            case 13: {
                AssistantMethods.progressBarToFull(progressBar);
                return "Finlandia";
            }
            case 14: {
                AssistantMethods.progressBarToFull(progressBar);
                return "Wyspy Owcze";
            }
            case 15: {
                AssistantMethods.progressBarToFull(progressBar);
                return "Rosja";
            }
            default: return null;
        }
    }
}