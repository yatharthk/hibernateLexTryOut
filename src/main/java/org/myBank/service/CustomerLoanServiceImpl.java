package org.myBank.service;

import org.myBank.entity.CustomerLoan;
import org.myBank.repository.CustomerLoanDao;

public class CustomerLoanServiceImpl implements CustomerLoanService{

    private final CustomerLoanDao customerLoanDao;

    public CustomerLoanServiceImpl(CustomerLoanDao dao){
        this.customerLoanDao=dao;
    }

    @Override
    public void addCustomerLoanDetails(CustomerLoan custLoan) {
        this.customerLoanDao.addCustomerLoanDetails(custLoan);
    }

    @Override
    public CustomerLoan getCustomerLoanDetails(Integer cid, String lid) {
        return this.customerLoanDao.getCustomerLoanDetails(cid,lid);
    }
}
