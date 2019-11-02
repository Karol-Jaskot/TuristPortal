package pl.jaskot.turistportal.frontend.views.assistant;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.progressbar.ProgressBar;
import pl.jaskot.turistportal.backend.entity.Country;
import pl.jaskot.turistportal.backend.entity.CountryRepo;
import pl.jaskot.turistportal.backend.entity.Question;
import pl.jaskot.turistportal.backend.entity.QuestionRepo;

/**
 * Page with assistant
 */
public class AssistantView extends VerticalLayout {


    private CountryRepo countryRepo;
    private QuestionRepo questionRepo;

    private Label lbWelcome;
    private Button btReset;
    private ProgressBar progressBar;
    private Image image;

    /**
     * Start view this page with first question
     * @param countryRepo
     * @param questionRepo
     */
    public AssistantView(CountryRepo countryRepo, QuestionRepo questionRepo){
        this.countryRepo = countryRepo;
        this.questionRepo = questionRepo;
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        createComponents();
        cQ(1);
    }

    /**
     * Create lbWelcome, image, progressBar and btReset
      */
    private void createComponents() {
        lbWelcome = new Label("Asystent Saszka pomoże Ci dobrać właściwą wycieczkę:");
        image = AssistantMethods.createImage();

        progressBar = new ProgressBar();
        AssistantMethods.controlProgressBar(progressBar, 0);

        btReset = AssistantMethods.createButton("Reset");
        btReset.addClickListener(e-> resetOption());
    }

    /**
     * Reset this page
     */
    private void resetOption(){
        cQ(1);
        AssistantMethods.controlProgressBar(progressBar, 0);
        lbWelcome.setText("Asystent Saszka pomoże Ci dobrać właściwą wycieczkę");
    }

    /**
     * Send a question number to open
     * @param i - number of question
     */
    private void cQ(int i){
        createQuestion(questionRepo.findByNumber(i));
    }

    /**
     * Remove all component on page and create question view
     * @param question to open
     */
    private void createQuestion(Question question){
        removeAll();
        Label lbQuestion = new Label();
        lbQuestion.setText(question.getQuestionText());

        Div divButtons = new Div();
        Button trueAnswer = AssistantMethods.createButton("Tak");
        trueAnswer.addClickListener(e-> trueOption(question));
        Button falseAnswer = AssistantMethods.createButton("Nie");
        falseAnswer.addClickListener(e-> falseOption(question));

        divButtons.add(trueAnswer , falseAnswer);
        add(image, lbWelcome,progressBar, lbQuestion, divButtons);
    }

    /**
     * Show to country to end of assistant
     * @param name of country
     */
    private void showCountry(String name){
        removeAll();
        lbWelcome.setText("Saszka znalazł najlepszą wycieczkę!");
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


    /**
     * True option from buttons
     * @param question actually
     */
    private void trueOption(Question question) {
        int number = question.getNumber();
        if(number<8){
            int nextNumber = AssistantMethods.trueOptionsToQuestions(number, progressBar);
            cQ(nextNumber);
        }
        else {
            String countryName = AssistantMethods.trueOptionsToCountry(number, progressBar);
            showCountry(countryName);
        }
    }

    /**
     * False option from buttons
     * @param question actually
     */
    private void falseOption(Question question) {
        int number = question.getNumber();
        if(number<8){
            int nextNumber = AssistantMethods.falseOptionsToQuestions(number, progressBar);
            cQ(nextNumber);
        }
        else {
            String countryName = AssistantMethods.falseOptionsToCountry(number, progressBar);
            showCountry(countryName);
        }
    }
}