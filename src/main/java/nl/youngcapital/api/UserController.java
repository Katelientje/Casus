package nl.youngcapital.api;

import nl.youngcapital.domain.User;
import nl.youngcapital.domain.UserWeight;
import nl.youngcapital.repository.UserRepository;
import nl.youngcapital.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<User> getUsers() {
        return (List<User>) userService.findAll();
    }


    @GetMapping(path = "/name/{name}")
    public Iterable<User> findByName(@PathVariable String name) {
        return userService.findByName(name);
    }

    @GetMapping (path ="/{id}")
    public ResponseEntity<Optional<User>> apiGetById(
            @PathVariable long id) {
        Optional<User> user = userService.findById(id);
        return new ResponseEntity<>(
                user,
                user.isPresent()
                        ? HttpStatus.OK
                        : HttpStatus.NOT_FOUND);
    }

    @PostMapping
    void addUser(@RequestBody User user) {
        userService.save(user);
    }

    @PutMapping(path="/{id}")		// Update
    public ResponseEntity<User> apiUpdate(
            @PathVariable("users/id") long id,
            @RequestBody User user) {
        if (user == null || user.getId() != id)
            return new ResponseEntity<>(
                    HttpStatus.BAD_REQUEST);

        Optional<User> oldUser = userService.findById(user.getId());
        if (!oldUser.isPresent()) {
            return new ResponseEntity<>(
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                userService.save(user),
                HttpStatus.OK);
    }

    @DeleteMapping(path="/{userId}")
    public void delete(@PathVariable Long userId) {
        userService.delete(userId);
    }

}
