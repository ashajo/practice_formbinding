package se.lexicon.practice_formbinding.data;

import org.springframework.stereotype.Component;
import se.lexicon.practice_formbinding.entity.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CustomerDaoImpl implements CustomerDao {
    private List<Customer> customerList = new ArrayList<>();

    @Override
    public Optional<Customer> findById(String customerId) {
        return customerList.stream().filter(customer -> customer.getCustomerId().equals(customerId))
                .findFirst();
    }

    @Override
    public Optional<Customer> findByEmail(String email) {
        return customerList.stream()
                .filter(customer -> customer.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }

    @Override
    public Customer save(Customer customer) {
        if (customerList.contains(customer)){
            throw new IllegalArgumentException("User already exists");
        }
        customerList.add(customer);
        return findById(customer.getCustomerId()).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public boolean delete(final String customerId) {
        Optional<Customer>optionalCustomer=findById(customerId);
        return optionalCustomer.map(customer -> customerList.remove(customer)).orElse(false);
    }

    @Override
    public List<Customer> findAll() {
        return customerList;
    }
}

