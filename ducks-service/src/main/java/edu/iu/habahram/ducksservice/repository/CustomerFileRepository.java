package edu.iu.habahram.ducksservice.repository;

import edu.iu.habahram.ducksservice.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerFileRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByUsername(String username);

}
