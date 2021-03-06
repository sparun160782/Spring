package com.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.otr.repository", 
						entityManagerFactoryRef = "secondaryEntityManager", 
						transactionManagerRef = "secondaryTransactionManager")        // 2
public class OTRDSConfig {

	@Bean(name = "secondaryDS") // 3
	@ConfigurationProperties(prefix = "secondary.datasource.mysql")
	public DataSource mysqlDataSource() {
		return DataSourceBuilder.create().build();
	}

	@PersistenceContext(unitName = "secondary")   // 4
    @Primary
    @Bean(name = "secondaryEntityManager")
	public LocalContainerEntityManagerFactoryBean mySqlEntityManagerFactory(EntityManagerFactoryBuilder builder) {
         return builder.dataSource(mysqlDataSource())
        		 						.persistenceUnit("secondary")
        		 						.properties(jpaProperties())
        		 						.packages("com.otr.entity").build();
    }
	
	@Bean(name = "secondaryTransactionManager")
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
