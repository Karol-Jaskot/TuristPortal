package pl.jaskot.turistportal.backend.entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepo extends CrudRepository<Country, Long> {
    Country findByName(String name);
}
