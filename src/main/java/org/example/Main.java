package org.example;

import org.example.pojo.Message;

import static org.example.hibernate.HibernateORM.factory;

public class Main {
    public static void main(String[] args) {
        var session = factory.openSession();
        session.beginTransaction();

        Message message = new Message("Hello world from hibernate");

        session.persist(message);
        session.getTransaction().commit();
        session.close();
        System.out.println("Hello world!");
    }
}