package nl.youngcapital.repository;

import nl.youngcapital.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Iterable<User> findByName(String name);

}
