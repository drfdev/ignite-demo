package dev.drf.ignite.demo;

import dev.drf.ignite.demo.entity.MyEntity;
import dev.drf.ignite.demo.ignite.IgniteService;
import dev.drf.ignite.demo.service.MyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/test-context.xml"})
public class MainTest {
    @Autowired
    private MyService myService;

    @Autowired
    private IgniteService igniteService;

    @Test
    public void test() {
        System.out.println("ignite-demo-test");

        final int length = 30;
        List<MyEntity> entities = new ArrayList<>(length);

        // attempt 1
        for (int i = 0; i < length; i++) {
            entities.add(myService.nextRandomEntity());
        }

        entities.forEach(
                val -> assertNotNull(igniteService.get(val.getId()))
        );
        entities.forEach(
                val -> assertTrue(igniteService.remove(val.getId()))
        );
        entities.forEach(
                val -> assertNull(igniteService.get(val.getId()))
        );
        entities.clear();

        // attempt 2
        for (int i = 0; i < length; i++) {
            entities.add(myService.nextRandomEntity());
        }
        entities.forEach(
                val -> assertNotNull(igniteService.get(val.getId()))
        );
        igniteService.clear();
        entities.forEach(
                val -> assertNull(igniteService.get(val.getId()))
        );
    }
}
