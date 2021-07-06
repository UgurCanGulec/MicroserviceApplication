package com.j4v4developers.aspect;

import com.j4v4developers.db_model.entity.Ticket;
import com.j4v4developers.dto.TicketDto;
import com.j4v4developers.mapper.TicketMapper;
import com.j4v4developers.rabbitmq.event.TicketCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class TicketDaoAspect {

    private final ApplicationEventPublisher applicationEventPublisher;

    public TicketDaoAspect(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @After("execution(* com.j4v4developers.dao.TicketDao.save(..))")
    public void afterTicketInserted(JoinPoint joinPoint) {
        TicketDto ticketDto = (TicketDto) joinPoint.getArgs()[0];
        this.publishTicketCreatedEvent(ticketDto);
        log.info("Ticket has been inserted successfully --> " + ticketDto.getDescription());
    }

    private void publishTicketCreatedEvent(TicketDto ticketDto) {
        applicationEventPublisher.publishEvent(new TicketCreatedEvent(ticketDto));
    }
}
