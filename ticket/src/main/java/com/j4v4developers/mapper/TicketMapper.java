package com.j4v4developers.mapper;

import com.j4v4developers.db_model.entity.Ticket;
import com.j4v4developers.dto.TicketDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TicketMapper {

    TicketDto fromTicketToTicketDto(Ticket ticket);

    Ticket fromTicketDtoToTicket(TicketDto ticketDto);

}
