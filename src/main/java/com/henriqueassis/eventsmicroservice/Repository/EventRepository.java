package com.henriqueassis.eventsmicroservice.Repository;

import com.henriqueassis.eventsmicroservice.Domain.Event;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, String> {
    @Query(value = "SELECT * FROM events e WHERE parsedatetime(e.date, 'dd/MM/yyyy') > :currentDate", nativeQuery = true)
    List<Event> findUpCommingEvents(@Param("currentDate")LocalDateTime currentDate);

    @NonNull
    Optional<Event> findById(@NonNull String id);
}
