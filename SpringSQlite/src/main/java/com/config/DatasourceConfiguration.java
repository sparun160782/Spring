package com.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

/*@Configuration
@EnableTransactionManagement // 1
@EnableJpaRepositories(basePackages = "com.guru.repository", 
						entityManagerFactoryRef = "entityManager", transactionManagerRef = "transactionManager") // 2
public class DatasourceConfiguration {

	@Bean(name = "dataSource") // 3
	@Primary
	@ConfigurationProperties(prefix = "primary.datasource.mysql")
	public DataSource mysqlDataSource() {
		return DataSourceBuilder.create().build();
	}

	@PersistenceContext(unitName = "primary")   // 4
    @Primary
    @Bean(name = "entityManager")
	public LocalContainerEntityManagerFactoryBean mySqlEntityManagerFactory(EntityManagerFactoryBuilder builder) {
         return builder.dataSource(mysqlDataSource())
        		 						.persistenceUnit("primary")
        		 						.properties(jpaProperties())
        		 						.packages("com.guru.entity")
        		 						.build();    
    }
	
	@Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager(EntityManagerFactoryBuilder builder) {
           JpaTransactionManager tm = new JpaTransactionManager();
           tm.setEntityManagerFactory(mySqlEntityManagerFactory(builder).getObject());
           tm.setDataSource(mysqlDataSource());
           return tm;
    }

	private Map<String, Object> jpaProperties() {
         Map<String, Object> props = new HashMap<>();
         props.put("spring.jpa.hibernate.naming-strategy", new org.hibernate.cfg.DefaultComponentSafeNamingStrategy());
         props.put("hibernate.dialect", environment.getProperty("hibernate.dialect"));
         props.put("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
         props.put("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
         return props;
     }
	
	 // ------------------------
	  // PRIVATE FIELDS
	  // ------------------------
	  
	  @Autowired
	  private Environment environment;

}
*/


/**
 * Contains database configurations.
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.guru.repository", 
entityManagerFactoryRef = "entityManager", transactionManagerRef = "transactionManager") // 2
public class DatasourceConfiguration {

	  // ------------------------
	  // PUBLIC METHODS
	  // ------------------------

	  /**
	   * DataSource definition for database connection. Settings are read from
	   * the application.properties file (using the env object).
	   */
	@Bean(name = "dataSource") // 3
	  public DataSource dataSource() {
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName(env.getProperty("db.driver"));
	    dataSource.setUrl(env.getProperty("db.url"));
	    dataSource.setUsername(env.getProperty("db.username"));
	    dataSource.setPassword(env.getProperty("db.password"));
	    return dataSource;
	  }

	  /**
	   * Declare the JPA entity manager factory.
	   */
	  @Bean(name = "entityManager")
	  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	    
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
	    
	    entityManagerFactory.setDataSource(dataSource);
	    
	    // Classpath scanning of @Component, @Service, etc annotated class
	    entityManagerFactory.setPackagesToScan(env.getProperty("entitymanager.packagesToScan"));
	    
	    // Vendor adapter
	    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	    entityManagerFactory.setJpaVendorAdapter(vendorAdapter);
	    
	    // Hibernate properties
	    Properties additionalProperties = new Properties();
	    additionalProperties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
	    additionalProperties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
	    additionalProperties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
	    
	    entityManagerFactory.setJpaProperties(additionalProperties);
	    
	    return entityManagerFactory;
	  }

	  /**
	   * Declare the transaction manager.
	   */
	  @Bean(name = "transactionManager")
	  public JpaTransactionManager transactionManager() {
	    JpaTransactionManager transactionManager = new JpaTransactionManager();
	    transactionManager.setEntityManagerFactory(entityManagerFactory.getObject());
	    return transactionManager;
	  }
	  
	  /**
	   * PersistenceExceptionTranslationPostProcessor is a bean post processor
	   * which adds an advisor to any bean annotated with Repository so that any
	   * platform-specific exceptions are caught and then rethrown as one
	   * Spring's unchecked data access exceptions (i.e. a subclass of 
	   * DataAccessException).
	   */
	  @Bean
	  public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
	    return new PersistenceExceptionTranslationPostProcessor();
	  }


	  // ------------------------
	  // PRIVATE FIELDS
	  // ------------------------
	  
	  @Autowired
	  private Environment env;

	  @Autowired
	  private DataSource dataSource;

	  @Autowired
	  private LocalContainerEntityManagerFactoryBean entityManagerFactory;


	} // class DatabaseConfig