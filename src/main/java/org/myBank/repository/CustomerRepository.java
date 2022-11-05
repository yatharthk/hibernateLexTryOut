package org.myBank.repository;

import org.myBank.entity.Customer;

public interface CustomerRepository {
    void addCustomer(Customer c);

    Customer getCustomer(int id);

    void updateCustomer(int id,Customer c);

    void deleteCustomer(int id);
}
