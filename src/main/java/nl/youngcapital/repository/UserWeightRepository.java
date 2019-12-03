package nl.youngcapital.repository;

import nl.youngcapital.domain.User;
import nl.youngcapital.domain.UserWeight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserWeightRepository extends CrudRepository<UserWeight, Long> {

}
