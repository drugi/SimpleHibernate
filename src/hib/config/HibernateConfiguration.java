package hib.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfiguration {
	
	private static HibernateConfiguration instance;
	private static SessionFactory sessionFactory;
	
	private HibernateConfiguration() {
		Configuration configuration = new Configuration();
		configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		configuration.setProperty("hibernate.connection.driver", "com.mysql.jdbc.Driver");
		configuration.setProperty("hibernate.connection.url", "jdbc:mysql://192.168.1.101:3306/hibremote");
		configuration.setProperty("hibernate.connection.username", "novo");
		configuration.setProperty("hibernate.connection.password", "novo");
		configuration.setProperty("hibernate.hbm2ddl.auto", "update");
		configuration.setProperty("hibernate.show_sql", "true");
		
		configuration.addAnnotatedClass(hib.dto.User.class);
		configuration.addAnnotatedClass(hib.dto.Note.class);
		
		sessionFactory = configuration.buildSessionFactory();
		
	}
	
	public static SessionFactory getSessionFactory() {
		if(instance == null) {
			instance = new HibernateConfiguration();
		}
		
		return sessionFactory;
	}
	
	public static void closeSessionFactory() {
		if(instance != null) {
			sessionFactory.close();
		}
	}

}
