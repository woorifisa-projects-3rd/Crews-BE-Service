package org.crews.dto;

import lombok.Builder;

@Builder
public record CustomerToCore(String identity, String name, String juminNumber) {
}
