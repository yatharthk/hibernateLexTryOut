package org.example;

import org.example.entity.Customer;
import org.example.repository.CustomerRepository;
import org.example.repository.CustomerRepositoryImpl;
import org.example.service.CustomerService;
import org.example.service.CustomerServiceImpl;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        //new state
        Customer customer = new Customer();
        customer.setCustomerName("yk1");
        customer.setDateOfBirth(LocalDate.of(1996,3,4));

        System.out.println("Adding a customer");
        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        CustomerService customerService = new CustomerServiceImpl(customerRepository);
        System.out.println("Customer details are: ");
        System.out.println(customerService.getCustomer(1));

        System.out.println("Support for 'hilo' generator strategy has been removed in hibernate v6.1.4 ");
    }
}