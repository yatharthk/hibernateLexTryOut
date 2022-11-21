package org.myBank.repository;

import org.myBank.entity.CustomerLoan;

public interface CustomerLoanDao {
    void addCustomerLoanDetails(CustomerLoan custLoan);

    CustomerLoan getCustomerLoanDetails(Integer cid, String lid);
}
