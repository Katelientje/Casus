package nl.youngcapital.api;

import nl.youngcapital.domain.User;
import nl.youngcapital.domain.UserWeight;
import nl.youngcapital.service.UserWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping (path = "weights")
public class UserWeightController {

    @Autowired
    UserWeightService userWeightService;

    @GetMapping
    public ResponseEntity<Iterable<UserWeight>> apiGetAll() {
        return new ResponseEntity<Iterable<UserWeight>>(
                userWeightService.findAll(),
                HttpStatus.OK);
    }

    @PostMapping
    void addUserWeight(@RequestBody UserWeight u) {
        UserWeight userWeight = new UserWeight(u.getUser() , u.getValue());
        userWeightService.save(userWeight);
    }

//    @GetMapping(path = "/users/{id}/weights")
//    public Iterable<UserWeight> findByUserId(@PathVariable long id){return userWeightService.findByUserId(id);}



    @GetMapping (path = "/{id}")
    public ResponseEntity<Optional<UserWeight>> apiGetById(
            @PathVariable long id) {
        Optional<UserWeight> userWeight = userWeightService.findById(id);
        return new ResponseEntity<>(
                userWeight,
                userWeight.isPresent()
                        ? HttpStatus.OK
                        : HttpStatus.NOT_FOUND);
    }

    @PutMapping(path = "/{id}")		// Update
    public ResponseEntity<UserWeight> apiUpdate(
            @PathVariable("weights/id") long id,
            @RequestBody UserWeight userWeight) {
        if (userWeight == null || userWeight.getId() != id)
            return new ResponseEntity<>(
                    HttpStatus.BAD_REQUEST);

        Optional<UserWeight> oldUserWeight = userWeightService.findById(userWeight.getId());
        if (!oldUserWeight.isPresent()) {
            return new ResponseEntity<>(
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                userWeightService.save(userWeight),
                HttpStatus.OK);
    }
    @DeleteMapping(path="/{userWeightId}")
    public void delete(@PathVariable Long userWeightId) {
        userWeightService.delete(userWeightId);
    }

}
