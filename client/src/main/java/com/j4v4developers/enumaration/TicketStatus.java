package com.j4v4developers.enumaration;

import lombok.Getter;

@Getter
public enum TicketStatus {
    OPEN("Açık"),
    IN_PROGRESS("Üzerinde Çalışılıyor"),
    RESOLVED("Çözüldü"),
    CLOSED("Kapatıldı");

    private String label;

    TicketStatus(String label) {
        this.label = label;
    }

    }
