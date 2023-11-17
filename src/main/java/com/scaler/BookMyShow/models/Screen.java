package com.scaler.BookMyShow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Screen extends BaseModel {

    private String name;

    @OneToMany
    private List<Seat> seats;

    // one screen can have many features that's why we
    // took elementcollection for collection of features
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection // this will create a mapping table for screen to features
    private List<Feature> features;



}
