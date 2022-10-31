package org.example;

import org.example.entity.Customer;
import org.example.repository.CustomerRepository;
import org.example.repository.CustomerRepositoryImpl;
import org.example.service.CustomerService;
import org.example.service.CustomerServiceImpl;
import org.example.util.HibernateUtil;
import org.hibernate.Session;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        //new state
//        Customer customer = new Customer();
//        customer.setId(1004);
//        customer.setCustomerName("yk1");
//        customer.setDateOfBirth(LocalDate.of(1996,03,04));

        System.out.println("Adding a customer");

        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        CustomerService customerService = new CustomerServiceImpl(customerRepository);

//        customerService.addCustomer(customer);
//        System.out.println("customer added with id "+customer.getId());
        System.out.println("Customer details are: ");
        System.out.println(customerService.getCustomer(1001));
        System.out.println(customerService.getCustomer(1002));
        System.out.println(customerService.getCustomer(1003));

        Customer customer2 = new Customer();
        customer2.setCustomerName("skundra");
        customer2.setDateOfBirth(LocalDate.of(1996,01,14));
        customerService.updateCustomer(1002,customer2);

        customerService.deleteCustomer(1004);



    }
}