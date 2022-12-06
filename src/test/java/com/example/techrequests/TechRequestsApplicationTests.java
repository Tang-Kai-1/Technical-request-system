package com.example.techrequests;

import com.example.techrequests.requests.domain.Request;
import com.example.techrequests.requests.dto.CreateRequest;
import com.example.techrequests.requests.service.RequestsService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class TechRequestsApplicationTests {
    @Autowired
    RequestsService service;

    @Test
    @Transactional
    @DisplayName("Spēj pievienot pieprasījumu")
    void addRequest(){
        Request request = service.createRequest(new CreateRequest("Dators", "Darba", "vajag darbam", "izskata")).getBody();
        assertTrue(request!=null);
    }

    @Test
    @Transactional
    @DisplayName("Spēj dzēst pieprasījumu")
    void removeRequest(){
        Request request = service.createRequest(new CreateRequest("Dators", "Darba", "vajag darbam", "izskata")).getBody();
        Request requestDeleted = service.deleteRequest(request.getId()).getBody();
        assertEquals(request,requestDeleted);
    }

    @Test
    @Transactional
    @DisplayName("Spēj mainīt pieprasījuma statusu")
    void updateRequest(){
        Request request = service.createRequest(new CreateRequest("Dators", "Darba", "vajag darbam", "izskata")).getBody();
        String originalStatus = request.getStatus();
        Request requestUpdated = service.changeRequestStatus(request.getId(),"noraidīts").getBody();
        assertTrue(originalStatus!=requestUpdated.getStatus());
    }

    @Test
    @Transactional
    @DisplayName("Spēj izgūt visus pieprasījumus")
    void getAllRequests(){
        List<Request> requests = new ArrayList<>();
        requests.add(service.createRequest(new CreateRequest("Dators", "Darba", "vajag darbam", "izskata")).getBody());
        requests.add(service.createRequest(new CreateRequest("Pele", "ergonomiskā", "vajag darbam", "izskata")).getBody());
        requests.add(service.createRequest(new CreateRequest("Klaviatūra", "mehāniskā", "vajag darbam", "izskata")).getBody());
        assertEquals(requests,service.getRequests().getBody());
    }
}
