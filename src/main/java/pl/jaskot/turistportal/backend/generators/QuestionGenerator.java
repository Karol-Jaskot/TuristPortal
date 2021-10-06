package pl.jaskot.turistportal.backend.generators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.jaskot.turistportal.backend.entity.Question;
import pl.jaskot.turistportal.backend.repo.QuestionRepo;

public class QuestionGenerator {

    Logger logger = LoggerFactory.getLogger(QuestionGenerator.class);

    public QuestionGenerator(QuestionRepo questionRepo){

        if (questionRepo.count() == 0 ) {
            logger.info("Start generate questions for application");

            questionRepo.save(new Question(1, "Czy lubisz ciepłe kraje?"));

            questionRepo.save(new Question(2, "Czy lubisz latynoskie klimaty?"));
            questionRepo.save(new Question(3, "Czy lubisz skandynawskie klimaty?"));

            questionRepo.save(new Question(4, "Czy lubisz góry?"));
            questionRepo.save(new Question(5, "Czy lubisz zwiedzać zabytkowe miejsca?"));
            questionRepo.save(new Question(6, "Czy lubisz góry?"));
            questionRepo.save(new Question(7, "Czy lubisz morze?"));

            questionRepo.save(new Question(8, "Czy lubisz odpoczywać na plaży?"));
            questionRepo.save(new Question(9, "Czy chciałbyś zobaczyć lasy tropikalne?"));
            questionRepo.save(new Question(10, "Czy lubisz tereny zielone?"));
            questionRepo.save(new Question(11, "Czy lubisz kulturę arabską?"));
            questionRepo.save(new Question(12, "Czy lubisz fiordy?"));
            questionRepo.save(new Question(13, "Czy lubisz leśne spacery?"));
            questionRepo.save(new Question(14, "Czy lubisz góry?"));
            questionRepo.save(new Question(15, "Czy jesteś osobą tolerancyjną?"));

            logger.info("Finish generate questions for application");
        }else {
            logger.debug("Questions already exist in application, generated will be stopped");
        }
    }
}