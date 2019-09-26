package com.github.magicae;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Properties;

public class SnowballIdGenerator implements IdentifierGenerator, Configurable {

    public static HashMap<String, SnowballIdGenerator> InstanceMap = new HashMap<>();

    private SnowballIdWorker worker;

    public Serializable generate(SharedSessionContractImplementor session, Object o) throws HibernateException {
        return worker.nextId();
    }

    public Long generate() throws RuntimeException {
        return worker.nextId();
    }

    /**
     * if the generator is configured with "name", we put it into the map, then we can access the instance from other place.
     * else we reuse the cache generator
     * */
    @Override
    public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
        String name = params.getProperty("name", "");
        if (name.isEmpty()) {
            worker = new SnowballIdWorker();
            InstanceMap.put(name, this);
        } else {
            worker = InstanceMap.get(name).worker;
        }
    }
}
