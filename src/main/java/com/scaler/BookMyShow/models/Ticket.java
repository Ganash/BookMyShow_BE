package com.scaler.BookMyShow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Ticket extends BaseModel{

    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;

    // 1 show will have many tickets
    // we can't book 1 ticket for many shows
    // so many tickets will have for one show.
    @ManyToOne
    private Show show;

    // one ticket can be paid via multiple payments like upi, cash etc
    // 1 ticket can have multiple payments
    @OneToMany
    private List<Payment> payments;

    // one user can book many tickets
    // user has tickets and tickets has payments
    @ManyToOne
    private User user;

    // can 1 ticket have many showseats

    @ManyToMany
    private List<ShowSeat> showSeats;

    private Date bookedAt;

    private int amount;
}

/*

For
@ManyToMany
private List<ShowSeat> showSeats;

*  Suppose Ticket1 bought Seat1
*  then Ticket1 was cancelled
*  Ticket2 bought Seat1
*  then Ticket2 was cancelled
*  Ticket3 bought Seat1
*  Seat1 belongs to 3 tickets, 2 cancelled and 1 active
*  Ticket4 bought Seat2, Seat3, Seat4
*
*  1 Ticket can have many ShowSeats and Seat1 belongs to many tickets
*  So Many to Many
*
* */