package com.henriqueassis.eventsmicroservice.controllers;

import com.henriqueassis.eventsmicroservice.Domain.Event;
import com.henriqueassis.eventsmicroservice.Domain.Subscription;
import com.henriqueassis.eventsmicroservice.dtos.EventRequestDTO;
import com.henriqueassis.eventsmicroservice.dtos.SubscriptionRequestDTO;
import com.henriqueassis.eventsmicroservice.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/upcoming")
    public List<Event> getUpcomingEvents() {
        return eventService.getUpcomingEvents();
    }

    @PostMapping
    public Event createEvent(@RequestBody EventRequestDTO eventRequestDTO){
        return eventService.createEvent(eventRequestDTO);
    }

    @PostMapping("/{eventId}/register")
    public void registerParticipant(@PathVariable String eventId,
                                    @RequestBody SubscriptionRequestDTO subscriptionRequestDTO){
        eventService.registerParticipants(eventId, subscriptionRequestDTO.participantEmail());
    }
}
