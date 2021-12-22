package com.config;


import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:db.properties")
@EnableJpaRepositories(basePackages = "com.repository")  // to show were the interfaces are located
@EnableWebMvc   // activates Spring mvc, comment it out when testing from console
@ComponentScan(basePackages = {"com.service", "com.controller"})  // to show packages having classes marked as @Component or @Controller,@Service or @Repository(only for DAO)
@EnableAspectJAutoProxy(proxyTargetClass = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ConfigApp implements WebMvcConfigurer {

    @Value("${db.class.driver}")
    String driverName;

    @Value("${db.connection.url}")
    String url;

    @Value("${db.username}")
    String userName;

    @Value("${db.password}")
    String password;

    @Value("${db.hibernate.dialect}")
    String dialect;


    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory factory, DataSource dataSource) {  // for managing transactions creates
        JpaTransactionManager tm = new JpaTransactionManager();
        tm.setEntityManagerFactory(factory);
        tm.setDataSource(dataSource);
        return tm;
    }

    @Bean
    public DataSource dataSource() {   // set of configuration
        DriverManagerDataSource dm = new DriverManagerDataSource();
        dm.setDriverClassName(driverName);
        dm.setUrl(url);
        dm.setUsername(userName);
        dm.setPassword(password);
        return dm;

    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, JpaVendorAdapter jva) {   // configures entity manager factory
        LocalContainerEntityManagerFactoryBean lc = new LocalContainerEntityManagerFactoryBean();
        lc.setDataSource(dataSource);
        lc.setJpaVendorAdapter(jva);
        lc.setPackagesToScan("com.domain");
        return lc;

    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {      // need for entityManagerFactory
        HibernateJpaVendorAdapter hJva = new HibernateJpaVendorAdapter();
        hJva.setDatabase(Database.MYSQL);
        hJva.setShowSql(true);
        hJva.setDatabasePlatform(dialect);
        hJva.setGenerateDdl(true);
        return hJva;
    }




}
