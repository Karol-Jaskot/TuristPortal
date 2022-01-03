package pl.jaskot.turistportal.backend.generators;

import lombok.extern.java.Log;
import pl.jaskot.turistportal.backend.entity.Country;
import pl.jaskot.turistportal.backend.repo.CountryRepo;

@Log
public class CountryGenerator {

    private CountryRepo countryRepo;

    public CountryGenerator(CountryRepo countryRepo) {

        this.countryRepo = countryRepo;

        if (countryRepo.count() == 0 ) {
            log.info("Start generate countries for application");


            saveCountry("Indie", "IndiePhoto.img", "Text o Indie", 1000);
            saveCountry("Egipt", "EgiptFlag.img",  "Text o Egipt", 1000);
            saveCountry("Maroko", "MarokoPhoto.img", "Text o Maroko", 1000);
            saveCountry("RPA", "RPAPhoto.img", "Text o RPA", 1000);

            saveCountry("Islandia", "IslandiaFlag.img", "Text o Islandia", 1000);
            saveCountry("Wyspy Owcze","WowczePhoto.img", "Text o Wowcze", 1000);
            saveCountry("Kanada","KanadaPhoto.img", "Text o Kanada", 1000);
            saveCountry("Rosja","RosjaPhoto.img", "Text o Rosja", 1000);

            saveCountry("Meksyk","MeksykPhoto.img", "Text o Meksyk", 1000);
            saveCountry("Peru", "PeruPhoto.img", "Text o Peru", 1000);
            saveCountry("Brazylia","BrazyliaPhoto.img", "Text o Brazylia", 1000);
            saveCountry("Hiszpania","HiszpaniaPhoto.img", "Text o Hiszpania", 1000);

            saveCountry("Norwegia", "NorwegiaFlag.img", "Text o Norwegia", 1000);
            saveCountry("Szwecja","SzwecjaPhoto.img", "Text o Szwecja", 1000);
            saveCountry("Dania", "DaniaPhoto.img", "Text o Dania", 1000);
            saveCountry("Finlandia", "FinlandiaPhoto.img", "Text o Finlandia", 1000);


            log.info("Finish generate countries for application");
        }else {
            log.warning("Countries already exist in application, generated will be stopped");
        }
    }

    private void saveCountry(String name, String img, String desc, int price){
        countryRepo.save(Country.builder()
                .name(name)
                .price(price)
                .textOffer(desc)
                .imgFlag(img)
                .imgPhoto(img)
                .build()
        );
    }
}