package org.myBank;

import org.myBank.entity.CustomerLoan;
import org.myBank.repository.CustomerLoanDao;
import org.myBank.repository.CustomerLoanDaoImpl;
import org.myBank.service.CustomerLoanService;
import org.myBank.service.CustomerLoanServiceImpl;

import java.util.Scanner;

public class CompositePrimaryKeyDemo {

    public static void main(String[] args) {
        CustomerLoanDao customerDao = new CustomerLoanDaoImpl();
        CustomerLoanService service = new CustomerLoanServiceImpl(customerDao);
        try {
            System.out.println("Enter the Customer Loan details");
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the Customer Id");
            Integer cid = sc.nextInt();
            System.out.println("Enter the Loan Id");
            String lid = sc.next();
            System.out.println("Enter the Eligible Amount");
            double eligibleAmount = sc.nextDouble();
            System.out.println("Enter the Availed Amount");
            double availedAmount = sc.nextDouble();
            System.out.println("Enter the Tenure In Years");
            float tenureInYears = sc.nextFloat();

            CustomerLoan custLoan = new CustomerLoan();
            custLoan.setEligibleAmount(eligibleAmount);
            custLoan.setAvailedAmount(availedAmount);
            custLoan.setTenureInYears(tenureInYears);
            custLoan.setCustomerId(cid);
            custLoan.setLoanId(lid);

            service.addCustomerLoanDetails(custLoan);
            System.out.println("One record created");

            System.out.println("get details");
            System.out.println(service.getCustomerLoanDetails(cid,lid));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}