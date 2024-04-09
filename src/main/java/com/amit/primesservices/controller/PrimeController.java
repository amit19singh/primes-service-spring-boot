package com.amit.primesservices.controller;

import com.amit.primesservices.rabbitmq.MQSender;
import com.amit.primesservices.services.IPrimeService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/primes")
@AllArgsConstructor
public class PrimeController {

    IPrimeService primeService;

    private final MQSender mqSender;

    @GetMapping("/{n}")
    public boolean isPrime(@PathVariable int n) {
        boolean result = primeService.isPrime(n);
        Object principle = SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        String username = ((Jwt) principle).getSubject();
        System.out.println("username: " + username);
        mqSender.sendMessage(username, n, result);
        return result;
    }

}
