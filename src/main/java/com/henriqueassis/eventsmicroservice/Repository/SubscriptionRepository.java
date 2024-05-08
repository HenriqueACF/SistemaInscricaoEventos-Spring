package com.henriqueassis.eventsmicroservice.Repository;

import com.henriqueassis.eventsmicroservice.Domain.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
}
