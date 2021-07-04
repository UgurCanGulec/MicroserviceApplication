package com.j4v4developers.request;

import com.j4v4developers.dto.TicketDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Ticket save or update request", description = "It includes saved Ticket")
public class RequestSaveOrUpdateTicket {
    @ApiModelProperty(value = "TicketDto", name = "TicketDto to save", dataType = "TicketDto")
    private TicketDto ticketDto;
}
