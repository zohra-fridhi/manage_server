package com.itfridhi.server.emum;

public enum Status {
    SERVER_UP("SERVER_UP"), SERVER_DOWN("SERVER_UP");
    private final String status;

    Status(String status) {
        this.status=status;

    }

    public String getStatus() {
        return status;
    }
}
