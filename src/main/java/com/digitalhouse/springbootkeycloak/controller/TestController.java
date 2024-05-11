package com.digitalhouse.springbootkeycloak.controller;


import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
//@RequestMapping("/tests")
public class TestController {


        @GetMapping("/anonymous")
        public ResponseEntity<String> getAnonymous() {
            return ResponseEntity.ok("Hello Anonymous");
        }
        @PreAuthorize("hasAnyAuthority('ROLE_admin')")
        @GetMapping("/admin")
        public ResponseEntity<String> getAdmin() {
            return ResponseEntity.ok("Hello Admin");
        }

    @PreAuthorize("hasAnyAuthority('ROLE_user', 'ROLE_admin')")
        @GetMapping("/user")
        public ResponseEntity<String> getUser(Principal principal) {
            return ResponseEntity.ok("Hello User ");

        }

}
