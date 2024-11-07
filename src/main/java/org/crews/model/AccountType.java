package org.crews.model;

public enum AccountType {
    PERSONAL("개인"), CREW("모임");
    private final String type;

    AccountType(String type) {
        this.type = type;
    }
}
