package com.senla.training;

public enum Permission {
    ADMINS_READ("admins:read"),
    ADMINS_WRITE("admins:write");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}