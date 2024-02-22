package com.amit.primesservices.controller;

import com.amit.primesservices.services.IPrimeService;
import org.springframework.stereotype.Service;

@Service
public class PrimeController implements IPrimeService {
    @Override
    public boolean isPrime(int n) {
        if (n == 2)
            return true;
        for (long i = 0; i < n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
