package pl.jaskot.turistportal.backend;

import pl.jaskot.turistportal.backend.entity.Question;
import pl.jaskot.turistportal.backend.entity.QuestionRepo;

public class QuestionGenerator {

    public QuestionGenerator(QuestionRepo questionRepo){

        Question q1 = new Question(1,"Czy lubisz ciepłe kraje?");
        questionRepo.save(q1);

        Question q2 = new Question(2,"Czy lubisz latynoskie klimaty?");
        Question q3 = new Question(3,"Czy lubisz skandynawskie klimaty?");
        questionRepo.save(q2);
        questionRepo.save(q3);

        Question q4 = new Question(4,"Czy lubisz góry?");
        Question q5 = new Question(5,"Czy lubisz zwiedzać zabytkowe miejsca?");
        Question q6 = new Question(6,"Czy lubisz góry?");
        Question q7 = new Question(7,"Czy lubisz morze?");
        questionRepo.save(q4);
        questionRepo.save(q5);
        questionRepo.save(q6);
        questionRepo.save(q7);

        Question q8 = new Question(8,"Czy lubisz odpoczywać na plaży?");
        Question q9 = new Question(9,"Czy chciałbyś zobaczyć lasy tropikalne?");
        Question q10 = new Question(10,"Czy lubisz tereny zielone?");
        Question q11 = new Question(11,"Czy lubisz kulturę arabską?");
        Question q12 = new Question(12,"Czy lubisz fiordy?");
        Question q13 = new Question(13,"Czy lubisz leśne spacery?");
        Question q14 = new Question(14,"Czy lubisz góry?");
        Question q15 = new Question(15,"Czy jesteś osobą tolerancyjną?");
        questionRepo.save(q8);
        questionRepo.save(q9);
        questionRepo.save(q10);
        questionRepo.save(q11);
        questionRepo.save(q12);
        questionRepo.save(q13);
        questionRepo.save(q14);
        questionRepo.save(q15);
    }

}
