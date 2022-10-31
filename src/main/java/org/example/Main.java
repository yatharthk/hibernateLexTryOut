package org.example;

import org.myBank.dao.CustomerDaoImpl;
import org.myBank.dao.MCustomerDao;
import org.myBank.entity.Customer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
   static Logger LOG = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        MCustomerDao customerDao = new CustomerDaoImpl();
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
