package org.jfcmc.records;

import java.time.LocalDateTime;

public record User(String username,
                   boolean active,
                   LocalDateTime lastLogin) {
}
