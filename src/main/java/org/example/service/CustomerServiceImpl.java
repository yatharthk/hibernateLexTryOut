package org.example.service;

import org.example.entity.Customer;
import org.example.entity.Locker;
import org.example.repository.CustomerRepository;

public class CustomerServiceImpl implements CustomerService{

    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository repo){
        this.customerRepository = repo;
    }
    @Override
    public void addCustomerNoLocker(Customer c) {
        this.customerRepository.addCustomerNoLocker(c);
    }
    public void addCustomerWithLocker(Customer c, Locker l) {
        this.customerRepository.addCustomerWithLocker(c,l);
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
