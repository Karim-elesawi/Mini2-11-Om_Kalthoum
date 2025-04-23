package com.example.mini2.services;

import com.example.mini2.models.Customer;
import com.example.mini2.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }
    public Customer updateCustomer(Long id, Customer customer) {
        Customer existing = customerRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(customer.getName());
            existing.setEmail(customer.getEmail());
            existing.setPhoneNumber(customer.getPhoneNumber());
            return customerRepository.save(existing);
        }
        return null;
    }
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
    public List<Customer> findCustomersByEmailDomain(String domain) {
        return customerRepository.findCustomersByEmailDomain(domain);
    }
    public List<Customer> findCustomersByPhonePrefix(String prefix) {
        return customerRepository.findCustomersByPhonePrefix(prefix);
    }
}
