package model;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
   private static SessionFactory factory;
   private static ServiceRegistry serviceRegistry;
   
    public static  SessionFactory getFactory(){
        if (factory==null){
        Configuration config = new Configuration();
        config.configure();
        serviceRegistry=new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        factory=config.buildSessionFactory(serviceRegistry);
        }
        return factory;
    }

    public static void close() {
        StandardServiceRegistryBuilder.destroy(serviceRegistry);
    }
    
}