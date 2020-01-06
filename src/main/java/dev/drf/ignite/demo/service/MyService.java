package dev.drf.ignite.demo.service;

import dev.drf.ignite.demo.ignite.IgniteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MyService {
    private final IgniteService igniteService;

    @Autowired
    public MyService(IgniteService igniteService) {
        this.igniteService = igniteService;
    }
}
