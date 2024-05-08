package com.henriqueassis.eventsmicroservice.dtos;

public record EmailRequestDTO(String to, String subject, String body) {
}
