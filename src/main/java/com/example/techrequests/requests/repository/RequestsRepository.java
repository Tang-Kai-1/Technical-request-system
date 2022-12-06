package com.example.techrequests.requests.repository;

import com.example.techrequests.requests.domain.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestsRepository extends JpaRepository<Request, Long> {
}
