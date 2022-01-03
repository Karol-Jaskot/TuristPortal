package pl.jaskot.turistportal.backend.entity;

import lombok.*;
import javax.persistence.*;

@Entity @Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int number;
    private String questionText;

}