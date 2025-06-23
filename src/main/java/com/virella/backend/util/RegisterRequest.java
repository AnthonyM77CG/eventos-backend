package com.virella.backend.util;

import java.time.LocalDateTime;

public record RegisterRequest(
    String username,
    String email,
    String password,
    LocalDateTime createIn
) {

}
