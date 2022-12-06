package com.example.techrequests.requests.service;

import com.example.techrequests.requests.domain.Request;
import com.example.techrequests.requests.dto.CreateRequest;
import com.example.techrequests.requests.repository.RequestsRepository;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RequestsService {
    RequestsRepository repository;

    public RequestsService(RequestsRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<List<Request>> getRequests() {
        return new ResponseEntity<>(repository.findAll(Sort.by(Sort.Direction.ASC, "id")), HttpStatus.OK);
    }

    public ResponseEntity<Request> createRequest(CreateRequest request) {
        return new ResponseEntity<>(repository.saveAndFlush(new Request(request)), HttpStatus.OK);
    }

    public ResponseEntity<Request> deleteRequest(Long id) {
        Request request = repository.findById(id).orElse(null);
        if (request == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Request not found");
        }
        repository.deleteById(id);
        return new ResponseEntity<>(request, HttpStatus.OK);
    }

    public ResponseEntity<Request> changeRequestStatus(Long id, String status) {
        Request request = repository.findById(id).orElse(null);
        if (request == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Request not found");
        }
        request.setStatus(status);
        return new ResponseEntity<>(repository.saveAndFlush(request), HttpStatus.OK);
    }
}
