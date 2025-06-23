package com.virella.backend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo")
public class DemoController {
     @GetMapping("/user")
   //@PreAuthorize("hasRole('USER')")
   public String sayHello() {
       return "USER: Hello from secured endpoint";
   }

   @GetMapping("/admin")
   //@PreAuthorize("hasRole('ADMIN')")
   public String sayHelloAdmin() {
       return "ADMIN: Hello admin from secured endpoint";
   }
}
