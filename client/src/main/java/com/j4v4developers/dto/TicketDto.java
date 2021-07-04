package com.j4v4developers.dto;

import com.j4v4developers.enumaration.PriorityType;
import com.j4v4developers.enumaration.TicketStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TicketDto {
    private String id;
    private String description;
    private String notes;
    private String assignee;
    private LocalDate ticketDate;
    private PriorityType priorityType;
    private TicketStatus ticketStatus;
}
