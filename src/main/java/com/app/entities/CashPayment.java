package com.app.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PAYMENT_DETAILS")
@DiscriminatorValue("CASH")
public class CashPayment  extends PaymentDetails{

}
