package pl.jaskot.turistportal.backend.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name, imgFlag, imgPhoto, textOffer;
    private int price;

    public Country() {}

    public Country(String name, String imgFlag, String imgPhoto, String textOffer, int price) {
        this.name = name;
        this.imgFlag = imgFlag;
        this.imgPhoto = imgPhoto;
        this.textOffer = textOffer;
        this.price = price;
    }
}