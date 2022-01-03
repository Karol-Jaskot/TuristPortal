package pl.jaskot.turistportal.backend.generators;

import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.jaskot.turistportal.backend.entity.Question;
import pl.jaskot.turistportal.backend.repo.QuestionRepo;

@Log
public class QuestionGenerator {

    private QuestionRepo questionRepo;

    public QuestionGenerator(QuestionRepo questionRepo){
        this.questionRepo = questionRepo;

        if (questionRepo.count() == 0 ) {
            log.info("Start generate questions for application");

            saveQuestion(1, "Czy lubisz ciepłe kraje?");

            saveQuestion(2, "Czy lubisz latynoskie klimaty?");
            saveQuestion(3, "Czy lubisz skandynawskie klimaty?");

            saveQuestion(4, "Czy lubisz góry?");
            saveQuestion(5, "Czy lubisz zwiedzać zabytkowe miejsca?");
            saveQuestion(6, "Czy lubisz góry?");
            saveQuestion(7, "Czy lubisz morze?");

            saveQuestion(8, "Czy lubisz odpoczywać na plaży?");
            saveQuestion(9, "Czy chciałbyś zobaczyć lasy tropikalne?");
            saveQuestion(10, "Czy lubisz tereny zielone?");
            saveQuestion(11, "Czy lubisz kulturę arabską?");
            saveQuestion(12, "Czy lubisz fiordy?");
            saveQuestion(13, "Czy lubisz leśne spacery?");
            saveQuestion(14, "Czy lubisz góry?");
            saveQuestion(15, "Czy jesteś osobą tolerancyjną?");

            log.info("Finish generate questions for application");
        }else {
            log.warning("Questions already exist in application, generated will be stopped");
        }
    }

    private void saveQuestion(int questNr, String questText){
        questionRepo.save(Question.builder()
                .number(questNr)
                .questionText(questText)
                .build());
    }
}