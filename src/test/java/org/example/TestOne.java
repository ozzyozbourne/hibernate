package org.example;

import org.example.pojo.Message;
import org.hibernate.Session;
import org.testng.annotations.Test;

import static org.example.hibernate.HibernateORM.factory;

@Test
public class TestOne {

    Session session = factory.openSession();
    public void One()  {
        session.beginTransaction();

        Message message = new Message("Hello world from hibernate");

        session.persist(message);
        session.getTransaction().commit();
        session.close();
    }

    public void Two(){
        var trans = session.getTransaction();
        trans.begin();
        var mess = session.get(Message.class, 2L);
        System.out.println(mess);
        trans.commit();
    }
}
