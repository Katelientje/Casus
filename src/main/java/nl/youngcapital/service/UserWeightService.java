package nl.youngcapital.service;

import nl.youngcapital.domain.User;
import nl.youngcapital.domain.UserWeight;
import nl.youngcapital.repository.UserRepository;
import nl.youngcapital.repository.UserWeightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class UserWeightService {

    @Autowired
    private UserWeightRepository userWeightRepository;
    @Autowired
    private UserService userService;

    public UserWeight save(UserWeight userWeight){

        return userWeightRepository.save(userWeight);
    }

    public Iterable<UserWeight> findAll(){
        return userWeightRepository.findAll();
    }

    public Optional<UserWeight> findById(Long id) {
        return userWeightRepository.findById(id);
    }
    public void delete(Long userWeightId) {
        userWeightRepository.deleteById(userWeightId);
    }

}
