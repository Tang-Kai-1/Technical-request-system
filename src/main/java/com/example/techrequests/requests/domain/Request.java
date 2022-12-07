package com.example.techrequests.requests.domain;

import com.example.techrequests.requests.dto.CreateRequest;
import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Entity
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;
    @NotNull
    private String device;
    @NotNull
    private String parameters;
    @NotNull
    private String reason;
    @NotNull
    private String creationDate;
    @NotNull
    private String status;

    public Request(CreateRequest createRequest) {
        this.device = createRequest.getDevice();
        this.parameters = createRequest.getParameters();
        this.reason = createRequest.getReason();
        this.creationDate = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(LocalDateTime.now(ZoneId.of("UTC+2")));
        this.status = createRequest.getStatus();
    }

    public Request() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
