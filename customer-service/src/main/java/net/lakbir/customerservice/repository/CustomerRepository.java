package net.lakbir.customerservice.repository;


import net.lakbir.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by lakbir.abderrahim on 03/02/2026
 */

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
