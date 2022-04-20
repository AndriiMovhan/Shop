package com.example.shop.repository;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentityGenerator;

import java.io.Serializable;

import static java.util.Objects.nonNull;

public class CustomIdentityGenerator extends IdentityGenerator {

    public static final String CUSTOM_IDENTITY_GENERATOR = "CustomIdentityGenerator";
    public static final String CUSTOM_IDENTITY_GENERATOR_FULLY_QUALIFIED_NAME = "com.example.shop.repository.CustomIdentityGenerator";

    @Override
    @SuppressWarnings("argument")
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        Serializable id =
                session
                        .getEntityPersister(null, object)
                        .getClassMetadata().getIdentifier(object, session);

        return nonNull(id)
                ? id : super.generate(session, object);
    }
}
