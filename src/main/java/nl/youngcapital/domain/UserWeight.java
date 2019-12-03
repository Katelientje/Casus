package nl.youngcapital.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import nl.youngcapital.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Optional;

@Entity
public class UserWeight {

   //VARIABLES
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JsonBackReference
    @ManyToOne(fetch=FetchType.EAGER)
    private User user;

    private float BMI;
    private Float value;
    private LocalDate date;

    //CONSTRUCTORS
    public UserWeight() {
        this.date = LocalDate.now();
    }

    public UserWeight(User user, Float value) {
        this.date = LocalDate.now();
        this.value = value;
        this.user = user;

        float userLengthMeter = user.getLength()/100;
        float BMI =value / (userLengthMeter * userLengthMeter);
        this.BMI = Math.round(BMI * 10) / 10.0f;
    }

    public UserWeight(Float value, User user, String date){
        this.value = value;
        this.user = user;
        this.date = LocalDate.parse(date);
        float userLengthMeter = user.getLength()/100;
        float BMI = value / (userLengthMeter * userLengthMeter);
        this.BMI = Math.round(BMI * 10) / 10.0f;
    }

    //GETTERS & SETTERS
    public long getId() {
        return id;
    }
    public Float getValue() {
        return value;
    }
    public void setValue(Float value) {
        this.value = value;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public float getBMI() {
        return BMI;
    }
    public void setBMI(float BMI) {
        this.BMI = BMI;
    }


    @Override
    public String toString(){
        return "weight: +"+value+" date: "+date;
    }
}
