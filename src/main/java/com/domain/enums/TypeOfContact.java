package com.domain.enums;

public enum TypeOfContact {
    VIBER("Viber"),
    WHATS_APP("WhatsApp"),
    HOME_PHONE("Home phone"),
    CELL_PHONE("Cell phone");

    private String communication;

    TypeOfContact(String communicationType) {
        this.communication = communicationType;
    }

}
