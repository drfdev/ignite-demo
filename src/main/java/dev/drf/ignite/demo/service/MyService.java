package dev.drf.ignite.demo.service;

import dev.drf.ignite.demo.entity.MyEntity;
import dev.drf.ignite.demo.ignite.IgniteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.ThreadLocalRandom;

@Service
@Slf4j
public class MyService {
    private final IgniteService igniteService;
    private final IdGenerator idGenerator;

    @Autowired
    public MyService(IgniteService igniteService,
                     IdGenerator idGenerator) {
        this.igniteService = igniteService;
        this.idGenerator = idGenerator;
    }

    public MyEntity nextEntity(String name, String description, String value) {
        MyEntity entity = new MyEntity(idGenerator.nextId());
        entity.setName(name);
        entity.setDescription(description);
        entity.setValue(value);
        igniteService.put(entity);
        return entity;
    }

    public MyEntity nextRandomEntity() {
        return nextEntity(
                randomString(6),
                randomString(12),
                randomString(8)
        );
    }

    private String randomString(int length) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        byte[] array = new byte[length];
        random.nextBytes(array);
        return new String(array, StandardCharsets.UTF_8);
    }
}
