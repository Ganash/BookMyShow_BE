package com.scaler.BookMyShow.models;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment extends BaseModel{

    private int refNo;

    private int amount;

    //payment will have single paymentstatus
    //one payment cannot have multiple payment status
    //so elementcollection not required.
    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;


    @Enumerated(EnumType.ORDINAL)
    private PaymentType paymentType;


}
