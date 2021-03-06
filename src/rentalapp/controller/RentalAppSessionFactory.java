package rentalapp.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class RentalAppSessionFactory {

    private SessionFactory ourSessionFactory ;

    private static RentalAppSessionFactory rentalAppSessionFactory = new RentalAppSessionFactory();
    private final String hibernateConfigFile = "hibernate.cfg.xml";

    private RentalAppSessionFactory() {
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(new Configuration().addResource(hibernateConfigFile).configure().getProperties()).buildServiceRegistry();

        ourSessionFactory = new Configuration().configure().buildSessionFactory(serviceRegistry);
    }

    public static RentalAppSessionFactory getInstance() {
        return rentalAppSessionFactory;
    }

    public synchronized Session createSession() {
        return ourSessionFactory.openSession();
    }

}
