package org.crews.model;

public enum AddressType {
    COMPANY("회사"), HOME("집"), OTHER("관심지역");
    private final String type;

    AddressType(String type) {
        this.type = type;
    }
}
