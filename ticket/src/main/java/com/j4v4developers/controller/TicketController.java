package com.j4v4developers.controller;

import com.j4v4developers.dto.TicketDto;
import com.j4v4developers.request.RequestSaveOrUpdateTicket;
import com.j4v4developers.response.BaseResponse;
import com.j4v4developers.service.TicketService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ticket-operations")
@Api(value = "Ticket Micro Service")
public class TicketController {

    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping(value = "/ticket/{id}")
    @ApiOperation(value = "Get article by id")
    public ResponseEntity<BaseResponse<TicketDto>> getArticleById(@PathVariable("id") String id) {
        TicketDto articleDto = ticketService.getById(id);
        return ResponseEntity.ok(new BaseResponse<>(articleDto, null, null, true));
    }

    @PostMapping(value = "/ticket")
    @ApiOperation(value = "Save ticket")
    public ResponseEntity<BaseResponse<TicketDto>> saveTicket(
            @RequestBody RequestSaveOrUpdateTicket request) {
        TicketDto articleDto = ticketService.saveTicket(request.getTicketDto());
        return ResponseEntity.ok(new BaseResponse<>(articleDto, null, null, true));
    }



}
