package dev.drf.ignite.demo.ignite;

import dev.drf.ignite.demo.entity.MyEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.ipfinder.multicast.TcpDiscoveryMulticastIpFinder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@Slf4j
public class IgniteService implements AutoCloseable {
    private final static String CACHE_NAME = "MyEntityCache";
    private final Ignite ignite;
    private final IgniteCache<Long, MyEntity> cache;

    public IgniteService() {
        TcpDiscoveryMulticastIpFinder tcMp = new TcpDiscoveryMulticastIpFinder();
        tcMp.setAddresses(Collections.singletonList("localhost"));

        TcpDiscoverySpi spi = new TcpDiscoverySpi();
        spi.setIpFinder(tcMp);

        IgniteConfiguration cfg = new IgniteConfiguration();
//        cfg.setClientMode(true);
        cfg.setDiscoverySpi(spi);

        ignite = Ignition.start(cfg);
        cache = ignite.getOrCreateCache(CACHE_NAME);
    }

    public void put(MyEntity value) {
        log.debug("put {}", value);
        cache.put(value.getId(), value);
    }

    public MyEntity get(long id) {
        log.debug("get {}", id);
        return cache.get(id);
    }

    public boolean remove(long id) {
        log.debug("remove {}", id);
        return cache.remove(id);
    }

    public void clear() {
        log.debug("clear");
        cache.clear();
    }

    @Override
    public void close() throws Exception {
        ignite.close();
    }
}
