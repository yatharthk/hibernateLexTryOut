package org.myBank.repository;

import org.myBank.entity.CustomerLoan;

public interface CustomerLoanDao {
    public void addCustomerLoanDetails(CustomerLoan custLoan);

    public CustomerLoan getCustomerLoanDetails(Integer cid, String lid);
}
