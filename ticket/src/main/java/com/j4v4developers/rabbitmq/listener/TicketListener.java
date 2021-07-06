package com.j4v4developers.rabbitmq.listener;

import com.j4v4developers.db_model.entity.Ticket;
import com.j4v4developers.dto.TicketDto;
import com.j4v4developers.mapper.TicketMapper;
import com.j4v4developers.rabbitmq.event.TicketCreatedEvent;
import com.j4v4developers.service.TicketNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class TicketListener {

    private final TicketMapper ticketMapper;
    private final TicketNotificationService ticketNotificationService;

    @Autowired
    public TicketListener(TicketMapper ticketMapper, TicketNotificationService ticketNotificationService) {
        this.ticketMapper = ticketMapper;
        this.ticketNotificationService = ticketNotificationService;
    }

    @EventListener
    public void ticketCreatedEventHandler(TicketCreatedEvent ticketCreatedEvent) {
        Ticket ticket = ticketMapper.fromTicketDtoToTicket((TicketDto) ticketCreatedEvent.getSource());
        System.out.println("Bir ticket oluşturuldu.");
        System.out.println(ticket.getDescription());
        ticketNotificationService.sendToQueue(ticket);
    }
}
