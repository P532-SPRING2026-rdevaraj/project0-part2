package edu.iu.habahram.ducksservice.model;
import jakarta.persistence.*;

@Entity
@Table(name = "customer", schema = "ducks")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    // EMPTY constructor (Required by JPA)
    public Customer() {
    }

    // Constructor
    public Customer(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}