package com.example.controller;

import com.example.repository.EventRepository;
import com.example.entity.Event;
import com.example.entity.request.AddEventRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.lang.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.*;
import java.lang.Object;

import java.time.LocalDateTime;
import javax.validation.Valid;
import java.util.List;
import java.lang.String;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/event")

public class EventController {

    private EventRepository eventRepository;

    @Autowired
    public EventController(EventRepository eventRepository){
        this.eventRepository = eventRepository;
    }




    @GetMapping("/all")
    public ResponseEntity<List<Event>> findAllEvents(){

        List<Event> events = eventRepository.findAll();
        if(events != null){
            return new ResponseEntity<List<Event>>(events, HttpStatus.FOUND);
        }
        else
        {
            return new ResponseEntity<List<Event>>(events, HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping("/active")
    public List<Event> findAllActive(){  return eventRepository.findByActive(1L);

    }

    @GetMapping("/{id}")
    Event ById(@PathVariable long id) throws Exception {
        return eventRepository.findById(id).orElseThrow(
                ()-> new Exception("There was an error getting the Event from the Database.")
        );
    }

    @PutMapping("/bought/{id}")
    public void UpdateEvent(@PathVariable long id){
        Event eventUpdate = eventRepository.getOne(id);
        eventUpdate.setActive(0);
        eventRepository.save(eventUpdate);
    }


    @RequestMapping(value="/add", method = RequestMethod.POST)
    public void AddEvent (@RequestBody AddEventRequest addEventRequest) {
        Event event = new Event();
        event.setName(addEventRequest.getName());
        event.setType(addEventRequest.getType());
        event.setPlace(addEventRequest.getPlace());
        event.setDatetime(LocalDateTime.now());
        event.setDescription(addEventRequest.getDescription());
        event.setActive(1);
        eventRepository.save(event);
    }

}
