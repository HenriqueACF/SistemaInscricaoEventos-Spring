package com.henriqueassis.eventsmicroservice.Domain;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "event")
@Table(name = "event")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private int maxParticipants;
    private int registeredPArticipants;
    private String date;
    private String title;
    private String description;
}