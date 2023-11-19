package com.scaler.BookMyShow.dto;

import com.scaler.BookMyShow.models.Ticket;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class UserSignUpResponseDTO {

    private Long id;

    private String name;

    private String email;

    private int responseCode;

    private String responseMessage;

    /*
    * if any user signing up or logging in, they can view their ticket details and
    * booking done previously, so instead of straight forward tickets we can respond back with
    * TicketResponseDTO
    *
    * */
    private List<Ticket> tickets; // TODO: change ticket to TicketResponseDTO



}
