package com.j4v4developers.service;

import com.j4v4developers.client.AccountServiceClient;
import com.j4v4developers.dto.AccountDto;
import com.j4v4developers.dto.TicketDto;
import com.j4v4developers.response.BaseResponse;
import com.j4v4developers.dao.TicketDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class TicketService {

    private final TicketDao ticketDao;

    @Autowired
    private AccountServiceClient accountServiceClient;

    @Autowired
    public TicketService(TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    public TicketDto getById(String id) {
        return ticketDao.getById(id);
    }

    @Transactional
    public TicketDto saveTicket(TicketDto ticketDto) {
        ResponseEntity<BaseResponse<AccountDto>> response = accountServiceClient.getAccountById(ticketDto.getAssignee());
        if (response != null && response.hasBody()) {
            BaseResponse<AccountDto> responseBody = response.getBody();
            if (responseBody != null && responseBody.getData() != null) {
                ticketDto.setAssignee(responseBody.getData().getId());
            }
        }
        return ticketDao.save(ticketDto);
    }
}
