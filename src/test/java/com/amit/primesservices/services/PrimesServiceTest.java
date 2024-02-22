package com.amit.primesservices.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimesServiceTest {
    PrimesService primesService = new PrimesService();

    @Test
    void _45IsNotPrime() {
        long n = 45;
        boolean expected = false;
        boolean actual = primesService.isPrime(n);
        assertEquals(expected, actual);
    }

    @Test
    void _535549843545IsNotPrime() {
        long n = 535549843545L;
        boolean expected = false;
        boolean actual = primesService.isPrime(n);
        assertEquals(expected, actual);
    }

    @Test
    void _84684684IsNotPrime() {
        long n = 84684684L;
        boolean expected = false;
        boolean actual = primesService.isPrime(n);
        assertEquals(expected, actual);
    }



}