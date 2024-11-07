package org.crews.model;

public enum MemberRole {
    LEADER("모임장"), MEMBER("모임원");
    private final String type;

    MemberRole(String type) {
        this.type = type;
    }
}
