package com.j4v4developers.db_model.entity;

import com.j4v4developers.enumaration.PriorityType;
import com.j4v4developers.enumaration.TicketStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = false, of = "id")
@Entity
@Data
@Table(name = "ticket")
@NoArgsConstructor
public class Ticket extends BaseEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "description", length = 600)
    private String description;

    @Column(name = "notes", length = 4000)
    private String notes;

    @Column(name = "assignee")
    private String assignee;

    @Column(name = "ticket_date")
    private LocalDate ticketDate;

    @Enumerated
    @Column(name = "priority_type")
    private PriorityType priorityType;

    @Enumerated
    @Column(name = "ticket_status")
    private TicketStatus ticketStatus;

}
