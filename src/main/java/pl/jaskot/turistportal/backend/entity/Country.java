package pl.jaskot.turistportal.backend.entity;

import lombok.*;
import javax.persistence.*;

@Entity @Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name, imgFlag, imgPhoto, textOffer;
    private int price;

}