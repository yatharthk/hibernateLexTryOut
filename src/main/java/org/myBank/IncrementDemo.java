package org.myBank;


import org.myBank.entity.Customer;
import org.myBank.repository.CustomerRepository;
import org.myBank.repository.CustomerRepositoryImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Logger;


public class IncrementDemo {


    static Logger LOG = Logger.getLogger(IncrementDemo.class.getName());
    public static void main(String[] args) {
        CustomerRepository customerDao = new CustomerRepositoryImpl();
        try {
            LOG.info("Enter the Customer details");
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the Customer name");
            String name = sc.next();
            System.out.println("Enter the Customer date of birth in MM/dd/yyyy format");
            String dateStr = sc.next();
            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
            Date dob = formatter.parse(dateStr);
            System.out.println("Enter the Customer address");
            String address = sc.next();
            System.out.println("Enter the Customer phoneNo");
            Long phone = sc.nextLong();
            Customer customer = new Customer(name, dob, address, phone);
            customerDao.addCustomer(customer);
            LOG.info("One record created");
            sc.close();
        } catch (Exception e) {
            LOG.severe(e.getMessage());
        }
    }
}

