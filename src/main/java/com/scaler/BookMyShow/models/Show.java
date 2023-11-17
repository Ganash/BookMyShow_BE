package com.scaler.BookMyShow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Show extends BaseModel{

    @ManyToOne
    private Movie movie;

    private Date startTime;

    private Date endTime;

    @OneToMany
    private List<ShowSeat> showSeats;

    // 1 screen can run many shows.
    // In one screen we can run morning,noon,evening and night shows
    // so we can say, many shows can happen in 1 screen
    @ManyToOne
    private Screen screen;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection // mapping table for screen to features
    private List<Feature> features;
}
