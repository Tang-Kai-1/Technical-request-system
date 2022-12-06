package com.example.techrequests.requests.controller;

import com.example.techrequests.requests.domain.Request;
import com.example.techrequests.requests.dto.CreateRequest;
import com.example.techrequests.requests.service.RequestsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RequestsController {

    private RequestsService service;

    public RequestsController(RequestsService service) {
        this.service = service;
    }

    @GetMapping("/requests")
    public ResponseEntity<List<Request>> getRequests() {
        return service.getRequests();
    }

    @PostMapping("/requests")
    public ResponseEntity<Request> createRequest(@RequestBody CreateRequest request) {
        return service.createRequest(request);
    }

    @DeleteMapping("/requests/{id}")
    public ResponseEntity<Request> deleteRequest(@PathVariable("id") Long id) {
        return service.deleteRequest(id);
    }

    @PutMapping("/requests/{id}")
    public ResponseEntity<Request> changeRequestStatus(@PathVariable("id") Long id, @RequestBody String status) {
        return service.changeRequestStatus(id, status);
    }
}
