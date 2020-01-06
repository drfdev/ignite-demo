package dev.drf.ignite.demo.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Component
public class IdGenerator {
    private final AtomicLong nextId = new AtomicLong(0);
    public IdGenerator() {
    }

    public long nextId() {
        return nextId.incrementAndGet();
    }
}
