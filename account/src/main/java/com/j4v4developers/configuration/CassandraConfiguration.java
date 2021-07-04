package com.j4v4developers.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CqlSessionFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories
public class CassandraConfiguration extends AbstractCassandraConfiguration {

    @Value("${j4v4developers.cassandra.keyspace.name}")
    private String keyspaceName;

    @Value("${j4v4developers.cassandra.keyspace.username}")
    private String username;

    @Value("${j4v4developers.cassandra.keyspace.password}")
    private String password;

    @Value("${j4v4developers.cassandra.port}")
    private int port;

    @Value("${j4v4developers.contact.point}")
    private String contactPoint;

    @Override
    protected String getKeyspaceName() {
        return keyspaceName;
    }

    @Override
    protected int getPort() {
        return port;
    }

    @Override
    protected String getContactPoints() {
        return contactPoint;
    }

    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    @Override
    public CqlSessionFactoryBean cassandraSession() {
        CqlSessionFactoryBean cqlSessionFactoryBean = super.cassandraSession();
        cqlSessionFactoryBean.setUsername(username);
        cqlSessionFactoryBean.setPassword(password);
        return cqlSessionFactoryBean;
    }
}
