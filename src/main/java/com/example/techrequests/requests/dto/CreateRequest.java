package com.example.techrequests.requests.dto;


public class CreateRequest {
    private String device;
    private String parameters;
    private String reason;
    private String status;

    public CreateRequest(String device, String parameters, String reason, String status) {
        this.device = device;
        this.parameters = parameters;
        this.reason = reason;
        this.status = status;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
