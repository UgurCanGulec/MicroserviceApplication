package com.j4v4developers.rabbitmq.event;

import org.springframework.context.ApplicationEvent;

public class TicketCreatedEvent extends ApplicationEvent {

    public TicketCreatedEvent(Object source) {
        super(source);
    }
}
