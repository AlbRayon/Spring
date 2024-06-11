package rayon.inombrable.hibernate;

import static org.hibernate.cfg.AvailableSettings.C3P0_ACQUIRE_INCREMENT;
import static org.hibernate.cfg.AvailableSettings.C3P0_MAX_SIZE;
import static org.hibernate.cfg.AvailableSettings.C3P0_MAX_STATEMENTS;
import static org.hibernate.cfg.AvailableSettings.C3P0_MIN_SIZE;
import static org.hibernate.cfg.AvailableSettings.C3P0_TIMEOUT;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@ComponentScan({ "rayon.inombrable.hibernate" })
@PropertySource(value = { "classpath:application.properties" })
public class HibernateConfiguration {
	@Autowired
    private Environment environment;
 
    @Bean
    @Primary
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[] { "rayon.inombrable.entity" });
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
     }

    @Bean
    @Primary
    public HibernateTransactionManager gettransactionManager() {
       HibernateTransactionManager txManager = new HibernateTransactionManager();
       txManager.setSessionFactory(sessionFactory().getObject());
       return txManager;
    }
    
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
        /////ADD HIBERNATE PROPERTY CODE IN HibConfCode AND ADJUST "application.properties" FILE AS REQUIRED
        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
        ////
        return dataSource;
    }
     
    private Properties hibernateProperties() {
        Properties properties = new Properties();
		///////////
		properties.put(AvailableSettings.SHOW_SQL, environment.getRequiredProperty("hibernate.show_sql"));
		properties.put(AvailableSettings.FORMAT_SQL, environment.getRequiredProperty("hibernate.format_sql"));
		///////////
		properties.put(AvailableSettings.DIALECT, environment.getRequiredProperty("hibernate.dialect"));
		properties.put(AvailableSettings.HBM2DDL_AUTO, environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
		//System.out.print("AS: "+environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
		/////////// C3P0 PROPERTIES
		properties.put(AvailableSettings.C3P0_MIN_SIZE, environment.getRequiredProperty("C3P0_MIN_SIZE"));
		properties.put(AvailableSettings.C3P0_MAX_SIZE, environment.getRequiredProperty("C3P0_MAX_SIZE"));
		properties.put(AvailableSettings.C3P0_ACQUIRE_INCREMENT, environment.getRequiredProperty("C3P0_ACQUIRE_INCREMENT"));
		properties.put(AvailableSettings.C3P0_TIMEOUT, environment.getRequiredProperty("C3P0_TIMEOUT"));
		properties.put(AvailableSettings.C3P0_MAX_STATEMENTS, environment.getRequiredProperty("C3P0_MAX_STATEMENTS"));
		//////////
        return properties;        
    }

}
