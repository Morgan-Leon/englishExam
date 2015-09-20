package com.sexylion.englishExam.config;

import com.jolbox.bonecp.BoneCPDataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;

import java.util.Properties;

/**
 * @author Petri Kainulainen
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.sexylion.englishExam.todo.repository","com.sexylion.englishExam.repository"})
public class PersistenceContext {

    protected static final String PROPERTY_NAME_DATABASE_DRIVER = "db.driver";
    protected static final String PROPERTY_NAME_DATABASE_PASSWORD = "db.password";
    protected static final String PROPERTY_NAME_DATABASE_URL = "db.url";
    protected static final String PROPERTY_NAME_DATABASE_USERNAME = "db.username";

    protected static final String IDLE_CONNECTION_TEST_PERIOD_IN_MINUTES = "bonecp.idle_connection_test_period_in_minutes";
    protected static final String PARTITION_COUNT = "bonecp.partition_count";
    protected static final String ACQUIRE_INCREMENT = "bonecp.acquire_increment";
    protected static final String MAX_CONNECTIONS_PER_PARTITION = "bonecp.max_connections_per_partition";
    protected static final String MIN_CONNECTIONS_PER_PARTITION = "bonecp.min_connections_per_partition";
    protected static final String STATEMENTS_CACHE_SIZE = "bonecp.statements_cache_size";
    protected static final String RELEASE_HELPER_THREADS = "bonecp.release_helper_threads";
    
    private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
    private static final String PROPERTY_NAME_HIBERNATE_FORMAT_SQL = "hibernate.format_sql";
    private static final String PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";
    private static final String PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY = "hibernate.ejb.naming_strategy";
    private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";

    private static final String[] PROPERTY_PACKAGES_TO_SCAN = {"com.sexylion.englishExam.todo.model","com.sexylion.englishExam.model"};

    @Resource
    private Environment environment;

    @Bean
    public DataSource dataSource() {
        BoneCPDataSource dataSource = new BoneCPDataSource();

        dataSource.setDriverClass(environment.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
        dataSource.setJdbcUrl(environment.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
        dataSource.setUsername(environment.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
        dataSource.setPassword(environment.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));
        
        dataSource.setIdleConnectionTestPeriodInMinutes(Long.parseLong(environment.getRequiredProperty(IDLE_CONNECTION_TEST_PERIOD_IN_MINUTES)));
        dataSource.setPartitionCount(Integer.parseInt(environment.getRequiredProperty(PARTITION_COUNT)));
        dataSource.setAcquireIncrement(Integer.parseInt(environment.getRequiredProperty(ACQUIRE_INCREMENT)));
        dataSource.setMaxConnectionsPerPartition(Integer.parseInt(environment.getRequiredProperty(MAX_CONNECTIONS_PER_PARTITION)));
        dataSource.setMinConnectionsPerPartition(Integer.parseInt(environment.getRequiredProperty(MIN_CONNECTIONS_PER_PARTITION)));
        dataSource.setStatementsCacheSize(Integer.parseInt(environment.getRequiredProperty(STATEMENTS_CACHE_SIZE)));
        dataSource.setReleaseHelperThreads(Integer.parseInt(environment.getRequiredProperty(RELEASE_HELPER_THREADS)));


        return dataSource;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();

        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

        return transactionManager;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan(PROPERTY_PACKAGES_TO_SCAN);

        Properties jpaProperties = new Properties();
        jpaProperties.put(PROPERTY_NAME_HIBERNATE_DIALECT, environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
        jpaProperties.put(PROPERTY_NAME_HIBERNATE_FORMAT_SQL, environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_FORMAT_SQL));
        jpaProperties.put(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO, environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO));
        jpaProperties.put(PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY, environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY));
        jpaProperties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));

        entityManagerFactoryBean.setJpaProperties(jpaProperties);

        return entityManagerFactoryBean;
    }
}
