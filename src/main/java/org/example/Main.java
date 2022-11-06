package org.example;

import org.example.entity.Customer;
import org.example.entity.Locker;
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
        customer.setId(1001);
        customer.setCustomerName("yk1");
        customer.setDateOfBirth(LocalDate.of(1996, 3,4));
        customer.setAddress("Blr");
        customer.setPhoneNo(12345678L);

        Locker locker = new Locker("LOC102","Small",1100);
        System.out.println("Adding a customer");


        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        CustomerService customerService = new CustomerServiceImpl(customerRepository);

        customerService.addCustomerWithLocker(customer,locker);

        System.out.println("customer added with id "+customer.getId());
        System.out.println("Customer details are: ");

        System.out.println(customerService.getCustomer(7000));
        System.out.println(customerService.getCustomer(1001));
//        System.out.println(customerService.getCustomer(1002));
//        System.out.println(customerService.getCustomer(1003));

        Customer customer2 = new Customer();
        customer2.setId(1002);
        customer2.setCustomerName("sk");
        customer2.setDateOfBirth(LocalDate.of(1996,1,14));
        customerService.addCustomerNoLocker(customer2);
        Locker locker2 = new Locker("LOC103","Medium",1100);
        customer2.setLocker(locker2);
        customer2.setAddress("Blr");
        customer2.setPhoneNo(12345678L);
        System.out.println("Updating customer");
        customerService.updateCustomer(1002,customer2);
        System.out.println("Customer updated. Details now are");
        System.out.println(customerService.getCustomer(1002));


        customerService.deleteCustomer(1002);



    }
}