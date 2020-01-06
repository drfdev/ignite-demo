package dev.drf.ignite.demo;

import dev.drf.ignite.demo.ignite.IgniteService;
import dev.drf.ignite.demo.service.MyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
    }
}
