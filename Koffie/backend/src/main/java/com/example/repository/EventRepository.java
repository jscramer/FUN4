package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.entity.Event;
import java.util.List;


@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findByActive(long active);


}
