package com.virella.backend.util;

public record AuthenticationRequest(
    String email,
    String password
) {

}
