package pl.jaskot.turistportal.frontend.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.progressbar.ProgressBar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.jaskot.turistportal.backend.entity.Country;
import pl.jaskot.turistportal.backend.repo.CountryRepo;
import pl.jaskot.turistportal.backend.entity.Question;
import pl.jaskot.turistportal.backend.repo.QuestionRepo;
import pl.jaskot.turistportal.frontend.logic.AssistantMethods;
import pl.jaskot.turistportal.frontend.logic.assistantButtonsOptions.ButtonFalseCountry;
import pl.jaskot.turistportal.frontend.logic.assistantButtonsOptions.ButtonFalseQuestion;
import pl.jaskot.turistportal.frontend.logic.assistantButtonsOptions.ButtonTrueCountry;
import pl.jaskot.turistportal.frontend.logic.assistantButtonsOptions.ButtonTrueQuestion;

/**
 * Page with assistant
 */
public class AssistantView extends VerticalLayout {

    Logger logger = LoggerFactory.getLogger(AssistantView.class);
    private CountryRepo countryRepo;
    private QuestionRepo questionRepo;

    private Label lbWelcome;
    private Button btReset;
    private ProgressBar progressBar;
    private Image image;

    public AssistantView(CountryRepo countryRepo, QuestionRepo questionRepo){
        this.countryRepo = countryRepo;
        this.questionRepo = questionRepo;

        logger.debug("AssistantView will be creating");
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        createComponents();
        cQ(1);
    }

    private void createComponents() {
        lbWelcome = new Label("Nasz asystent pomoże Ci dobrać właściwą wycieczkę:");
        image = AssistantMethods.createImage("https://www.fototapety24.net/img/wlasne_foto/d/fototapeta_wschod_slonca_nad_polem_lawendy.jpg");

        progressBar = new ProgressBar();
        AssistantMethods.setProgressBarValue(progressBar, 0);

        btReset = AssistantMethods.createButton("Reset");
        btReset.addClickListener(e-> resetAssistant());
    }

    private void resetAssistant(){
        cQ(1);
        AssistantMethods.setProgressBarValue(progressBar, 0);
        lbWelcome.setText("Nasz asystent pomoże Ci dobrać właściwą wycieczkę");
    }

    private void cQ(int i){
        createQuestion(questionRepo.findByNumber(i));
    }

    private void createQuestion(Question question){
        if (question != null){
            removeAll();
            Label lbQuestion = new Label();
            lbQuestion.setText(question.getQuestionText());

            Div divButtons = new Div();
            Button trueAnswer = AssistantMethods.createButton("Tak");
            trueAnswer.getStyle().set("margin","12px");
            trueAnswer.addClickListener(e-> trueOption(question));
            Button falseAnswer = AssistantMethods.createButton("Nie");
            falseAnswer.addClickListener(e-> falseOption(question));

            divButtons.add(trueAnswer , falseAnswer);
            add(image, lbWelcome,progressBar, lbQuestion, divButtons);
        } else {
            logger.error("createQuestion - > question = null");
        }
    }

    private void showCountry(String name){
        removeAll();
        lbWelcome.setText("Nasz asystent znalazł najlepszą wycieczkę!");
        add(image,lbWelcome, progressBar);
        try {
            Country country = countryRepo.findByName(name);
            add(    new Label(country.getName()),
                    new Label(country.getTextOffer()),
                    new Label("Cena: "+country.getPrice()));
        }finally {}
        Button btBuyTravel = AssistantMethods.createButton("Kup wyciczkę");
        btBuyTravel.addClickListener(e->AssistantMethods.showNotification(name));
        add(btBuyTravel ,btReset);
    }

    private void trueOption(Question question) {
        int number = question.getNumber();
        if(number<8){
            int nextNumber = ButtonTrueQuestion.option(number, progressBar);
            cQ(nextNumber);
        }
        else {
            String countryName = ButtonTrueCountry.option(number, progressBar);
            showCountry(countryName);
        }
    }

    private void falseOption(Question question) {
        int number = question.getNumber();
        if(number<8){
            int nextNumber = ButtonFalseQuestion.option(number, progressBar);
            cQ(nextNumber);
        }
        else {
            String countryName = ButtonFalseCountry.option(number, progressBar);
            showCountry(countryName);
        }
    }
}