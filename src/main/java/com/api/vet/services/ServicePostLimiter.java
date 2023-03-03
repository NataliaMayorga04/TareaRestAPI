package com.api.vet.services;

public class ServicePostLimiter {
    private static int count = 0;

    public static synchronized boolean increment() {
        if (count >= 20) {
            return false;
        }
        count++;
        return true;
    }
}
