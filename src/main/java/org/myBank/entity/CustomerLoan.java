package org.myBank.entity;

import jakarta.persistence.*;
import lombok.Data;


// to declare composite keys we have 2 ways: 1. using @Id +@Idclass & 2.@EmbeddedId
//way 1:
@Data
@Entity
@Table(name = "CUSTOMER_LOAN")
@IdClass(CustomerLoanPK.class)
public class  CustomerLoan {
        @Id
        @Column(name = "customer_id")
        private Integer customerId;
        @Id    // to make 2 #@Id work together. we need another class to map the values here.
//        to do that we use @IdClass which has these both ids in one class file.
        @Column(name = "loan_id")
        private String loanId;

        @Column(name = "eligible_amount")
        private double eligibleAmount;

        @Column(name = "availed_amount")
        private double availedAmount;

        @Column(name = "tenure_in_years")
        private float tenureInYears;
}
