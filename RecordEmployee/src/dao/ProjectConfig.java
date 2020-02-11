package dao;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan({"dao", "service"})
@EnableTransactionManagement
public class ProjectConfig {
	
	
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://127.0.0.1:5433/myDB");
		dataSource.setUsername("admin");
		dataSource.setPassword("4321");
		
		return dataSource;
	}
	
	
	@Bean
	public Properties HibernateProperties(){
		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		hibernateProperties.put("hibernate.hbm2ddl.auto", "update");
		hibernateProperties.put("hibernate.show_sql","true");
		return hibernateProperties;
		
	}
	
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
		LocalContainerEntityManagerFactoryBean factoryBean = 
				new LocalContainerEntityManagerFactoryBean();
		
		factoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		factoryBean.setDataSource(dataSource());
		factoryBean.setPackagesToScan("entity");
		factoryBean.setJpaProperties(HibernateProperties());
		return factoryBean;
		
	}
	
	
	 @Bean
	    @Autowired
	    public PlatformTransactionManager transactionManager(
	        EntityManagerFactory entityManagerFactory) {
	        JpaTransactionManager transactionManager = new JpaTransactionManager();
	        transactionManager.setEntityManagerFactory(entityManagerFactory);
	        return transactionManager;
	    }

}

