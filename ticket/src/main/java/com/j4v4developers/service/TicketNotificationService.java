package com.j4v4developers.service;

import com.j4v4developers.db_model.entity.Ticket;
import com.j4v4developers.messaging.TicketNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(Source.class)
public class TicketNotificationService {

    private final Source source;

    @Autowired
    public TicketNotificationService(Source source) {
        this.source = source;
    }

    public void sendToQueue(Ticket ticket) {
        TicketNotification ticketNotification = TicketNotification
                .builder()
                .accountId(ticket.getAssignee())
                .ticketId(ticket.getId())
                .ticketDescription(ticket.getDescription()).build();
        source.output().send(MessageBuilder.withPayload(ticketNotification).build());
    }
}
