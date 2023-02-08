package dao;

import entities.Person;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class PersonDaoImpl implements PersonDao {

    private SessionFactory factory = HibernateUtil.getFactory();
    private Session session;
    @Override
    public Person addPerson(Person p) throws Exception {
        try{
            if(session.isOpen())
                session = factory.getCurrentSession();
            else
                session = factory.openSession();

            session.beginTransaction();
            session.save(p);
            session.getTransaction().commit();
            return p;

        }catch (Exception exception){
            //save error in database
            //save in log file
            session.getTransaction().rollback();
            throw new Exception(p.getId()+ "Cannot be registered");

        }finally {
            session.close();
        }
    }

    @Override
    public Person updatePerson(Person p) throws Exception {
        try{
            if(session.isOpen())
                session = factory.getCurrentSession();
            else
                session = factory.openSession();

            session.beginTransaction();
            session.update(p);
            session.getTransaction().commit();
            return p;

        }catch (Exception exception){
            //save error in database
            //save in log file
            session.getTransaction().rollback();
            throw new Exception(p.getId()+ "Cannot be updates");

        }finally {
            session.close();
        }
    }

    @Override
    public Person deletePerson(Person p) throws Exception {
        try{
            if(session.isOpen())
                session = factory.getCurrentSession();
            else
                session = factory.openSession();

            session.beginTransaction();
            session.delete(p);
            session.getTransaction().commit();
            return p;

        }catch (Exception exception){
            //save error in database
            //save in log file
            session.getTransaction().rollback();
            throw new Exception(p.getId()+ "Cannot be deleted");

        }finally {
            session.close();
        }
    }

    @Override
    public Person getPerson(long id) throws Exception {
        Person p = null;
        try{
            if(session.isOpen())
                session = factory.getCurrentSession();
            else
                session = factory.openSession();

            session.beginTransaction();
            p = session.get(Person.class, id);
            session.getTransaction().commit();
            return p;

        }catch (Exception exception){
            //save error in database
            //save in log file
            session.getTransaction().rollback();
            throw new Exception(p.getId()+ "Cannot find user");

        }finally {
            session.close();
        }

    }

    @Override
    public List<Person> getAll() throws Exception {
        List<Person> people = new ArrayList<>();
        try{
            if(session.isOpen())
                session = factory.getCurrentSession();
            else
                session = factory.openSession();

            session.beginTransaction();
            people = session.createQuery("from Person p",Person.class).getResultList();
            session.getTransaction().commit();
            return people;
        }catch (Exception exception){
            //save error in database
            //save in log file
            session.getTransaction().rollback();
            throw new Exception("Cannot be registered");

        }finally {
            session.close();
        }
    }
}
