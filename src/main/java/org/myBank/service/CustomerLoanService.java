package org.myBank.service;

import org.myBank.entity.CustomerLoan;

public interface CustomerLoanService {

    void addCustomerLoanDetails(CustomerLoan custLoan);
    CustomerLoan getCustomerLoanDetails(Integer cid, String lid);
}
