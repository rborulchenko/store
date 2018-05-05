package store.repository;

import org.springframework.data.repository.CrudRepository;

import store.model.Customer;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findByUsername(String username);
}
