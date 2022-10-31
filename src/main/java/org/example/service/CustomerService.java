package org.example.service;

import org.example.entity.Customer;

public interface CustomerService {
    void addCustomer(Customer c);

    Customer getCustomer(int id);

   void updateCustomer(int id,Customer c);

    void deleteCustomer(int id);
}
