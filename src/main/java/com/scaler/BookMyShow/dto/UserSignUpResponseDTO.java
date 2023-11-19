package com.scaler.BookMyShow.dto;

import com.scaler.BookMyShow.models.Ticket;

import java.util.List;

public class UserSignUpResponseDTO {

    private Long id;

    private String name;

    private String email;

    /*
    * if any user signing up or logging in, they can view their ticket details and
    * booking done previously, so instead of straight forward tickets we can respond back with
    * TicketResponseDTO
    *
    * */
    private List<Ticket> tickets; // TODO: change ticket to TicketResponseDTO


}
