package com.scaler.BookMyShow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class User extends BaseModel {

    private String name;

    private String email;

    private String password;

    // one user can book many tickets
    @OneToMany
    private List<Ticket> tickets;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
