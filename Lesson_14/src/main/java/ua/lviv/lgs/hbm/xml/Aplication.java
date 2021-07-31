package ua.lviv.lgs.hbm.xml;

import java.util.Arrays;
import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Aplication {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		SessionFactory factory = configuration.buildSessionFactory();
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Cart cart = new Cart(2, "Fast");
		Item item1 = new Item(41);
		Item item2= new Item(31);
		Item item3 = new Item(241);
		Item item4= new Item(51);
		cart.setItems(new HashSet<>(Arrays.asList(item1, item2, item3, item4)));
		session.persist(cart);
		
		transaction.commit();
		session.close();
		
	}
	
}
