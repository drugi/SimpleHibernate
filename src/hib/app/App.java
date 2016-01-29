package hib.app;

import java.util.List;

import org.hibernate.Session;

import hib.config.HibernateConfiguration;
import hib.dto.User;

public class App {
	
	public static void main(String[] args) {
		Session session = HibernateConfiguration.getSessionFactory().openSession();
		session.beginTransaction();
//		for(int i = 1; i <= 100; i++) {
//			
//			User user = new User();
//			user.setUsername("novo"+i);
//			user.setPassword("novo"+i);
//			
//			Note note1 = new Note();
//			note1.setTitle("Note " + i + " title");
//			note1.setText("Note " + i +" some long text.");
//			note1.setUser(user);
//			
//			Note note2 = new Note();
//			note2.setTitle("Note " + (i + 3 *2) + " title");
//			note2.setText("Note " + (i + 3 *2) + " some long text.");
//			note2.setUser(user);
//			
//			user.getNotes().add(note1);
//			user.getNotes().add(note2);
//			
//			session.save(user);
//		}
	
//		User user = session.get(User.class, 1L);
		

		@SuppressWarnings("unchecked")
		List<User> users = session.createCriteria(User.class).list();
		
		print(users);
//		System.out.println(user);
		
		
		session.getTransaction().commit();
		HibernateConfiguration.closeSessionFactory();
	}
	
	public static void print(List<User> list) {
		for(User u : list) {
			System.out.println(u);
		}
	}
}
