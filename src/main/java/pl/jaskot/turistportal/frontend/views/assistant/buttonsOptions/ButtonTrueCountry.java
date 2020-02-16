package pl.jaskot.turistportal.frontend.views.assistant.buttonsOptions;

import com.vaadin.flow.component.progressbar.ProgressBar;
import pl.jaskot.turistportal.frontend.views.assistant.AssistantMethods;

public abstract class ButtonTrueCountry {
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
                return "Meksyk";
            }
            case 9: {
                AssistantMethods.progressBarToFull(progressBar);
                return "Brazylia";
            }
            case 10: {
                AssistantMethods.progressBarToFull(progressBar);
                return "Indie";
            }
            case 11: {
                AssistantMethods.progressBarToFull(progressBar);
                return "Maroko";
            }
            case 12: {
                AssistantMethods.progressBarToFull(progressBar);
                return "Norwegia";
            }
            case 13: {
                AssistantMethods.progressBarToFull(progressBar);
                return "Dania";
            }
            case 14: {
                AssistantMethods.progressBarToFull(progressBar);
                return "Islandia";
            }
            case 15: {
                AssistantMethods.progressBarToFull(progressBar);
                return "Kanada";
            }
            default: return null;
        }
    }
}