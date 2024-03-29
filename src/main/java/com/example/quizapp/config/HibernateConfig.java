//package com.example.quizapp.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.hibernate5.HibernateTransactionManager;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.sql.DataSource;
//import java.util.Properties;
//
//@Configuration
//@EnableTransactionManagement
//public class HibernateConfig {
//
//    @Value("${db.driver}")
//    private String DRIVER;
//
//    @Value("${db.password}")
//    private String PASSWORD;
//
//    @Value("${db.url}")
//    private String URL;
//
//    @Value("${db.username}")
//    private String USERNAME;
//
//    @Value("${hibernate.dialect}")
//    private String DIALECT;
//
//    @Value("${hibernate.show_sql}")
//    private String SHOW_SQL;
//
//    @Value("${entitymanager.packagesToScan}")
//    private String PACKAGES_TO_SCAN;
//
//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(DRIVER);
//        dataSource.setUrl(URL);
//        dataSource.setUsername(USERNAME);
//        dataSource.setPassword(PASSWORD);
//        return dataSource;
//    }
//
//    //@Bean
//    @Bean(name="entityManagerFactory")
//    public LocalSessionFactoryBean sessionFactory() {
//        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource());
//        sessionFactory.setPackagesToScan(PACKAGES_TO_SCAN);
//        Properties hibernateProperties = new Properties();
//        hibernateProperties.put("hibernate.dialect", DIALECT);
//        hibernateProperties.put("hibernate.show_sql", SHOW_SQL);
//        sessionFactory.setHibernateProperties(hibernateProperties);
//
//        return sessionFactory;
//    }
//
//    @Bean
//    public HibernateTransactionManager hibernateTransactionManager() {
//        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
//        transactionManager.setSessionFactory(sessionFactory().getObject());
//        return transactionManager;
//    }
//
//}