package pl.jaskot.turistportal.frontend.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.progressbar.ProgressBar;
import pl.jaskot.turistportal.backend.entity.Country;
import pl.jaskot.turistportal.backend.entity.CountryRepo;
import pl.jaskot.turistportal.backend.entity.Question;
import pl.jaskot.turistportal.backend.entity.QuestionRepo;

public class AssistantView extends VerticalLayout {

    private CountryRepo countryRepo;
    private QuestionRepo questionRepo;
    private Label lbWelcome;
    private Button btReset;
    private ProgressBar progressBar;
    private Image image;

    public AssistantView(CountryRepo countryRepo, QuestionRepo questionRepo){
        this.countryRepo = countryRepo;
        this.questionRepo = questionRepo;
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        lbWelcome = new Label("Asystent Saszka pomoże Ci dobrać właściwą wycieczkę:");
        btReset = new Button("Reset");
        image = new Image("https://www.fototapety24.net/img/wlasne_foto/d/fototapeta_wschod_slonca_nad_polem_lawendy.jpg","Foto");
        image.setHeight("70px");
        image.setHeightFull();
        image.setWidthFull();
        progressBar = new ProgressBar();
        progressBar.setValue(0.000);
        btReset.addClickListener(e-> resetOption());
        cQ(1);
    }

    private void resetOption(){
        cQ(1);
        progressBar.setValue(0.000);
        lbWelcome.setText("Asystent Saszka pomoże Ci dobrać właściwą wycieczkę");
    }

    private void cQ(int i){
        createQuestion(questionRepo.findByNumber(i));
    }
    private void pB(int i){
        if(i==1){
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

    private void createQuestion(Question question){
        removeAll();
        Label lbQuestion = new Label();
        Div divButtons = new Div();
        Button trueAnswer = new Button("Tak");
        Button falseAnswer = new Button("Nie");
        divButtons.add(trueAnswer , falseAnswer);
        lbQuestion.setText(question.getQuestionText());

        trueAnswer.addClickListener(e-> trueOption(question));
        falseAnswer.addClickListener(e-> falseOption(question));

        add(image, lbWelcome,progressBar, lbQuestion, divButtons);
    }

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
        Button btBuyTravel = new Button("Kup wycieczkę!");
        Notification notification = new Notification(
                "Gratulujemy kupna wspaniałej wycieczki do "+name+"!", 3000, Notification.Position.BOTTOM_CENTER);
        btBuyTravel.addClickListener(e->notification.open());
        add(btBuyTravel ,btReset);
    }

    private void trueOption(Question question) {
        switch (question.getNumber()){
            case 1:{
                cQ(2);
                pB(1);
                break;
            }
            case 2:{
                cQ(4);
                pB(2);
                break;
            }
            case 3:{
                cQ(6);
                pB(2);
                break;
            }
            case 4:{
                cQ(8);
                pB(3);
                break;
            }
            case 5:{
                cQ(10);
                pB(3);
                break;
            }
            case 6:{
                cQ(12);
                pB(3);
                break;
            }
            case 7:{
                cQ(14);
                pB(3);
                break;
            }
            case 8:{
                showCountry("Meksyk");
                pB(4);
                break;
            }
            case 9:{
                showCountry("Brazylia");
                pB(4);
                break;
            }
            case 10:{
                showCountry("Indie");
                pB(4);
                break;
            }
            case 11:{
                showCountry("Maroko");
                pB(4);
                break;
            }
            case 12:{
                showCountry("Norwegia");
                pB(4);
                break;
            }
            case 13:{
                showCountry("Dania");
                pB(4);
                break;
            }
            case 14:{
                showCountry("Islandia");
                pB(4);
                break;
            }
            case 15:{
                showCountry("Kanada");
                pB(4);
                break;
            }
        }
    }

    private void falseOption(Question question) {
        switch (question.getNumber()){
            case 1:{
                cQ(3);
                pB(1);
                break;
            }
            case 2:{
                cQ(5);
                pB(2);
                break;
            }
            case 3:{
                cQ(7);
                pB(2);
                break;
            }
            case 4:{
                cQ(9);
                pB(3);
                break;
            }
            case 5:{
                cQ(11);
                pB(3);
                break;
            }
            case 6:{
                cQ(13);
                pB(3);
                break;
            }
            case 7:{
                cQ(15);
                pB(3);
                break;
            }
            case 8:{
                showCountry("Peru");
                pB(4);
                break;
            }
            case 9:{
                showCountry("Hiszpania");
                pB(4);
                break;
            }
            case 10:{
                showCountry("Egipt");
                pB(4);
                break;
            }
            case 11:{
                showCountry("RPA");
                pB(4);
                break;
            }
            case 12:{
                showCountry("Szwecja");
                pB(4);
                break;
            }
            case 13:{
                showCountry("Finlandia");
                pB(4);
                break;
            }
            case 14:{
                showCountry("Wyspy Owcze");
                pB(4);
                break;
            }
            case 15:{
                showCountry("Rosja");
                pB(4);
                break;
            }
        }
    }

}
