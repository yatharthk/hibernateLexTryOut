package org.myBank.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class CustomerLoanPK implements Serializable {
    private Integer customerId;
    private String loanId;
}

