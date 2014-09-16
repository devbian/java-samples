package com.devbian.test;

import com.devbian.domain.Event;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

import java.util.Date;
import java.util.Properties;

/**
 * Created by phnix on 2014/9/10.
 */
public class HBTest {

    @Test
    public void test01() {
        Configuration cfg = new Configuration().configure();
        Properties properties = cfg.getProperties();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(properties).buildServiceRegistry();
        SessionFactory sessionFactory = cfg.buildSessionFactory(serviceRegistry);
        Session session = null;
        try {
            session = sessionFactory.openSession();

            // open tx
            session.beginTransaction();
            Event event = new Event();
            event.setId((long) 111);
            event.setDate(new Date());
            event.setTitle("tian kong");
            session.save(event);
            // end tx
            session.getTransaction().commit();
        } catch (HibernateException be) {
            be.printStackTrace();
            if (session != null) session.getTransaction().rollback();
        } finally {
            if (session != null) session.close();
        }

    }


}
