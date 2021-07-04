package com.j4v4developers.dao;

import com.j4v4developers.db_model.entity.Ticket;
import com.j4v4developers.exception.TicketNotFoundException;
import com.j4v4developers.mapper.TicketMapper;
import com.j4v4developers.dto.TicketDto;
import com.j4v4developers.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TicketDao {

    private final TicketRepository ticketRepository;
    private final TicketMapper ticketMapper;

    @Autowired
    public TicketDao(TicketRepository ticketRepository, TicketMapper ticketMapper) {
        this.ticketRepository = ticketRepository;
        this.ticketMapper = ticketMapper;
    }

    public TicketDto save(TicketDto ticketDto) {
        if (ticketDto.getDescription() == null) {
            throw new IllegalArgumentException("Description cannot be null !");
        }
        Ticket ticket = ticketMapper.fromTicketDtoToTicket(ticketDto);
        ticket = ticketRepository.save(ticket);
        return ticketMapper.fromTicketToTicketDto(ticket);
    }

    public TicketDto getById(String id) {
        Ticket ticket = ticketRepository.getTicketById(id);
        if (ticket == null) {
            throw new TicketNotFoundException();
        }
        return ticketMapper.fromTicketToTicketDto(ticket);
    }


}
