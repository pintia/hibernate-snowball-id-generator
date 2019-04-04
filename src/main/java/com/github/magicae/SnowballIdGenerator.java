package com.github.magicae;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

public class SnowballIdGenerator implements IdentifierGenerator {

  // Shared generator worker.
  private static SnowballIdWorker worker = new SnowballIdWorker();

  @Override
  public Serializable generate(SharedSessionContractImplementor session, Object o) throws HibernateException {
    return worker.nextId();
  }

}
