package pl.jaskot.turistportal.backend.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int number;
    private String questionText;

    public Question() { }

    public Question(int number, String questionText) {
        this.number = number;
        this.questionText = questionText;
    }
}