package com.j4v4developers.db_model.entity.elasticsearch;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.time.LocalDate;

@Data
@Document(indexName = "ticket_search")
public class TicketModel {

    @Id
    private String id;
    private String description;
    private String notes;
    private String assignee;
    private LocalDate ticketDate;
    private String priorityType;
    private String ticketStatus;
}
