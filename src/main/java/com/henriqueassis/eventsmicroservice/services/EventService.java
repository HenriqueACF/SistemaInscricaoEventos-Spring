package com.henriqueassis.eventsmicroservice.services;

import com.henriqueassis.eventsmicroservice.Domain.Event;
import com.henriqueassis.eventsmicroservice.Domain.Subscription;
import com.henriqueassis.eventsmicroservice.Repository.EventRepository;
import com.henriqueassis.eventsmicroservice.Repository.SubscriptionRepository;
import com.henriqueassis.eventsmicroservice.dtos.EmailRequestDTO;
import com.henriqueassis.eventsmicroservice.dtos.EventRequestDTO;
import com.henriqueassis.eventsmicroservice.exceptions.EventFullException;
import com.henriqueassis.eventsmicroservice.exceptions.EventNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private EmailServiceClient emailServiceClient;

    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public List<Event> getUpcomingEvents(){
        return eventRepository.findUpCommingEvents(LocalDateTime.now());
    }

    public Event createEvent(EventRequestDTO eventRequestDTO){
        Event newEvent = new Event(eventRequestDTO);
        return eventRepository.save(newEvent);
    }

    private Boolean isEventFull(Event event){
        return event.getRegisteredParticipants() >= event.getMaxParticipants();
    }

    public void registerParticipants(String eventId, String participantEmail){
        Event event = eventRepository.findById(eventId).orElseThrow(EventNotFoundException::new);

        if(isEventFull(event)){
            throw new EventFullException();
        }

        Subscription subscription = new Subscription(event, participantEmail);
        subscriptionRepository.save(subscription);

        event.setRegisteredParticipants(event.getRegisteredParticipants()+1);

        EmailRequestDTO emailRequestDTO = new EmailRequestDTO(participantEmail, "CONFIRMAÇÃO DE INSCRIÇÃO", "VOCÊ FOI INSCRITO COM SUCESSO NO EVENTO");

        emailServiceClient.sendEmail(emailRequestDTO);

    }
}
