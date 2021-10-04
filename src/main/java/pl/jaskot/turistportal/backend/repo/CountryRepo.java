package pl.jaskot.turistportal.backend.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.jaskot.turistportal.backend.entity.Country;

@Repository
public interface CountryRepo extends CrudRepository<Country, Long> {
    Country findByName(String name);
}
