package pl.jaskot.turistportal.backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.jaskot.turistportal.backend.entity.Country;
import pl.jaskot.turistportal.backend.entity.CountryRepo;
import pl.jaskot.turistportal.frontend.MainApp;

public class CountryGenerator {

    Logger logger = LoggerFactory.getLogger(CountryGenerator.class);

    public CountryGenerator(CountryRepo countryRepo) {

        if (countryRepo.count() == 0 ) {
            logger.info("Start generate countries for application");

            Country Indie = new Country("Indie", "IndieFlag.img", "IndiePhoto.img", "Text o Indie", 1000);
            Country Egipt = new Country("Egipt", "EgiptFlag.img", "EgiptPhoto.img", "Text o Egipt", 1000);
            Country Maroko = new Country("Maroko", "MarokoFlag.img", "MarokoPhoto.img", "Text o Maroko", 1000);
            Country RPA = new Country("RPA", "RPAFlag.img", "RPAPhoto.img", "Text o RPA", 1000);

            countryRepo.save(Indie);
            countryRepo.save(Egipt);
            countryRepo.save(Maroko);
            countryRepo.save(RPA);

            Country Islandia = new Country("Islandia", "IslandiaFlag.img", "IslandiaPhoto.img", "Text o Islandia", 1000);
            Country Wowcze = new Country("Wyspy Owcze", "Wowczelag.img", "WowczePhoto.img", "Text o Wowcze", 1000);
            Country Kanada = new Country("Kanada", "KanadaFlag.img", "KanadaPhoto.img", "Text o Kanada", 1000);
            Country Rosja = new Country("Rosja", "RosjaFlag.img", "RosjaPhoto.img", "Text o Rosja", 1000);

            countryRepo.save(Islandia);
            countryRepo.save(Wowcze);
            countryRepo.save(Kanada);
            countryRepo.save(Rosja);

            Country Meksyk = new Country("Meksyk", "MeksykFlag.img", "MeksykPhoto.img", "Text o Meksyk", 1000);
            Country Peru = new Country("Peru", "PeruFlag.img", "PeruPhoto.img", "Text o Peru", 1000);
            Country Brazylia = new Country("Brazylia", "BrazyliaFlag.img", "BrazyliaPhoto.img", "Text o Brazylia", 1000);
            Country Hiszpania = new Country("Hiszpania", "HiszpaniaFlag.img", "HiszpaniaPhoto.img", "Text o Hiszpania", 1000);

            countryRepo.save(Meksyk);
            countryRepo.save(Peru);
            countryRepo.save(Brazylia);
            countryRepo.save(Hiszpania);

            Country Norwegia = new Country("Norwegia", "NorwegiaFlag.img", "NorwegiaPhoto.img", "Text o Norwegia", 1000);
            Country Szwecja = new Country("Szwecja", "SzwecjaFlag.img", "SzwecjaPhoto.img", "Text o Szwecja", 1000);
            Country Dania = new Country("Dania", "DaniaFlag.img", "DaniaPhoto.img", "Text o Dania", 1000);
            Country Finlandia = new Country("Finlandia", "FinlandiaFlag.img", "FinlandiaPhoto.img", "Text o Finlandia", 1000);

            countryRepo.save(Norwegia);
            countryRepo.save(Szwecja);
            countryRepo.save(Dania);
            countryRepo.save(Finlandia);

            logger.info("Finish generate countries for application");
        }else {
            logger.debug("Countries already exist in application, generated will be stopped");
        }
    }
}