package pl.jaskot.turistportal.backend.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.jaskot.turistportal.backend.entity.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {}
