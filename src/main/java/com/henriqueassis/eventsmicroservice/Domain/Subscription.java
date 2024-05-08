package com.henriqueassis.eventsmicroservice.Domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity(name = "subscription")
@Table(name = "subscription")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    private Event event;

    private String participantEmail;

    public Subscription(Event event, String participantEmail) {
        this.event = event;
        this.participantEmail = participantEmail;
    }
}
