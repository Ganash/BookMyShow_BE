package com.scaler.BookMyShow.models;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel {

    private int rowVal;

    private int colVal;

    private String seatNumber;

    @ManyToOne
    private SeatType seatType;

}

// 100 seats
// VIP, Gold, Silver
// VIP - 20 seats
// Gold - 50 seats
// Silver - 30 seats
// so one seatype can have many seats (seatype:seat = 1:m )
// so (seat to seattype = m:1 )