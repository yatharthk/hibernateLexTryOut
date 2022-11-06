package org.example.repository;

import org.example.entity.Customer;
import org.example.entity.Locker;

public interface CustomerRepository {
    void addCustomerNoLocker(Customer c);
    void addCustomerWithLocker(Customer c, Locker l);

    Customer getCustomer(int id);

    void updateCustomer(int id,Customer c);

    void deleteCustomer(int id);
}
