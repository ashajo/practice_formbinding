package se.lexicon.practice_formbinding.data;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.practice_formbinding.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDao {
    Optional<Customer>findById(String customerId);
    Optional<Customer>findByEmail(String email);
    Customer save(Customer customer);
    boolean delete(String customerId);
    List<Customer>findAll();
}
