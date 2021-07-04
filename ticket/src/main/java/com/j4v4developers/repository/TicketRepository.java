package com.j4v4developers.repository;

import com.j4v4developers.db_model.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, String> {

    Ticket getTicketById(String id);

}
