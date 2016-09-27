package niit.foodgro.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import niit.foodgro.dao.*;
import niit.foodgro.model.*;


@Configuration
@ComponentScan("niit")
@EnableTransactionManagement
public class ApplicationContextConfig {
	

    
    @Bean(name = "dataSource")
    public DataSource getDataSource() {
    	BasicDataSource dataSource = new BasicDataSource();
    	dataSource.setDriverClassName("org.h2.Driver");
    	dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
    	dataSource.setUsername("sa");
    	dataSource.setPassword("");
    	
    	return dataSource;
    }
    
    
    private Properties getHibernateProperties() {
    	Properties properties = new Properties();
    	properties.setProperty("hibernate.hbm2ddl.auto","update");
    	properties.put("hibernate.show_sql", "true");
    	properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
    	return properties;
    }
    
    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) {
    	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
    	sessionBuilder.addProperties(getHibernateProperties());
    	//sessionBuilder.addAnnotatedClasses(User.class);
    	sessionBuilder.addAnnotatedClasses(Category.class);
    	sessionBuilder.addAnnotatedClasses(Supplier.class);
    	sessionBuilder.addAnnotatedClasses(Product.class);
        	return sessionBuilder.buildSessionFactory();
    }
    
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(
			SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(
				sessionFactory);

		return transactionManager;
	}
	//@Autowired
	//@Bean(name = "categoryDao")
	//public CategoryDAO getCategorydao(SessionFactory sessionFactory) {
	//return new Categorydao(sessionFactory);
	//}

	//@Autowired
	//@Bean(name = "supplierDao")
	//public Supplierdao getSupplierdao(SessionFactory sessionFactory) {
	//return new SupplierdaoImpl(sessionFactory);
	//}
	//@Autowired
	//@Bean(name = "productDao")
	//public Productdao getProductdao(SessionFactory sessionFactory) {
	//return new ProductdaoImpl(sessionFactory);
	//}

    
}
