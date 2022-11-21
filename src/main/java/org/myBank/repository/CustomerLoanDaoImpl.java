package org.myBank.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.myBank.entity.CustomerLoan;
import org.myBank.entity.CustomerLoanPK;
import org.myBank.util.HibernateUtil;

public class CustomerLoanDaoImpl implements CustomerLoanDao{

    @Override
    public void addCustomerLoanDetails(CustomerLoan custLoan) {
        Session session = HibernateUtil.getSession().openSession();
        Transaction tx = session.beginTransaction();
        session.persist(custLoan);
        tx.commit();
        session.close();
    }

    @Override
    public CustomerLoan getCustomerLoanDetails(Integer cid, String lid) {
        Session session = HibernateUtil.getSession().openSession();
        //set the composite key in object
        CustomerLoanPK customerLoanPK = new CustomerLoanPK();
        customerLoanPK.setCustomerId(cid);
        customerLoanPK.setLoanId(lid);

        //get the object using customerLoanPk class now.

        CustomerLoan customerLoan = session.get(CustomerLoan.class,customerLoanPK);
        session.close();
        return customerLoan;
    }
}
