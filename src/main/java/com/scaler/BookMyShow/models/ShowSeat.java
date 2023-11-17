package com.scaler.BookMyShow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel {
    @ManyToOne
    private Show show;

    @Enumerated(EnumType.ORDINAL)
    // one showseat can have one showseatstatus
    // one showseat cannot have multiple showseatstatus
    // so we don't need @ElementCollection
    private ShowSeatStatus showSeatStatus;

    @ManyToOne
    private Seat seat;

    private double price;


}
