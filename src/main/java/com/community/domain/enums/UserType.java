package com.community.domain.enums;

public enum UserType {
    user("사용자"),
    admin("관리자");

    private String value;

    UserType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
