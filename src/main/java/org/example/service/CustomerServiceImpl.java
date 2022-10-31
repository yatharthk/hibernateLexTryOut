package org.example.service;

import org.example.entity.Customer;
import org.example.repository.CustomerRepository;

public class CustomerServiceImpl implements CustomerService{

    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository repo){
        this.customerRepository = repo;
    }
    @Override
    public void addCustomer(Customer c) {
        this.customerRepository.addCustomer(c);
    }

    @Override
    public Customer getCustomer(int id) {
        return this.customerRepository.getCustomer(id);
    }

    @Override
    public void updateCustomer(int id, Customer c) {
        this.customerRepository.updateCustomer(id,c);
    }

    @Override
    public void deleteCustomer(int id) {
        this.customerRepository.deleteCustomer(id);
    }
}
