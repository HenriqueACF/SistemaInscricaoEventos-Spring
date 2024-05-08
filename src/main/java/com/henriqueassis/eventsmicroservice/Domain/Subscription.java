package com.henriqueassis.eventsmicroservice.Domain;

import jakarta.persistence.*;
import lombok.*;

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
    private Long id;

    @ManyToOne
    private Event event;

    private String participantEmail;
}
