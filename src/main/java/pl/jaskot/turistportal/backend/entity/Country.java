package pl.jaskot.turistportal.backend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String imgFlag;
    private String imgPhoto;
    private String textOffer;
    private int price;

    public Country() {}

    public Country(String name, String imgFlag, String imgPhoto, String textOffer, int price) {
        this.name = name;
        this.imgFlag = imgFlag;
        this.imgPhoto = imgPhoto;
        this.textOffer = textOffer;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTextOffer() {
        return textOffer;
    }

    public void setTextOffer(String textOffer) {
        this.textOffer = textOffer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImgFlag() {
        return imgFlag;
    }

    public void setImgFlag(String imgFlag) {
        this.imgFlag = imgFlag;
    }

    public String getImgPhoto() {
        return imgPhoto;
    }

    public void setImgPhoto(String imgPhoto) {
        this.imgPhoto = imgPhoto;
    }
}
