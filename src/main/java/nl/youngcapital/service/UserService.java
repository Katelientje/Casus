package nl.youngcapital.service;

import nl.youngcapital.domain.User;
import nl.youngcapital.repository.UserRepository;
import nl.youngcapital.repository.UserWeightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private  UserRepository userRepository;

    @Autowired
    private UserWeightRepository userWeightRepository;

    public User save(User user){
        return userRepository.save(user);
    }

    public Iterable<User> findAll(){
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public Iterable<User> findByName(String name) {
        return userRepository.findByName(name);
    }

    public void delete(Long userId) {
        userRepository.deleteById(userId);
    }

}
