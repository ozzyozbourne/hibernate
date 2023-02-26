package org.example.hibernate;

import org.example.pojo.Message;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class HibernateORM {

    public final static SessionFactory factory = setUp();


    private static SessionFactory setUp()  {
        Configuration cfg = new Configuration();
        try {
        Properties properties = new Properties();
        properties.load(new FileReader("hibernate.properties"));
        cfg.setProperties(properties);
        cfg.addAnnotatedClass(Message.class);

        }catch (IOException e) {
            e.printStackTrace();
            System.out.println("ERROR");
        }

        return cfg.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build());
    }
}
