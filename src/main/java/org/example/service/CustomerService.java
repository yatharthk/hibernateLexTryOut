package org.example.service;

import org.example.entity.Customer;
import org.example.entity.Locker;

public interface CustomerService {
    void addCustomerNoLocker(Customer c);

    void addCustomerWithLocker(Customer c, Locker l);

    Customer getCustomer(int id);

   void updateCustomer(int id,Customer c);

    void deleteCustomer(int id);
}
