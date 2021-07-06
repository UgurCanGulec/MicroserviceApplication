package com.j4v4developers.messaging;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class TicketNotification implements Serializable {

    private String ticketId;
    private String accountId;
    private String ticketDescription;
}
