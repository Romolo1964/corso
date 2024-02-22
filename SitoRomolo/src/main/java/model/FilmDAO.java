package model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FilmDAO {

    private final SessionFactory sessionFactory;

    public FilmDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveOrUpdate(Film film) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(film);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void delete(Film film) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.delete(film);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Film findById(Short filmId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Film.class, filmId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Film> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Film", Film.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static SessionFactory getFactory() {
    	SessionFactory sf=null;
    	Configuration cf=new Configuration();
    	cf.configure();
    	sf=cf.buildSessionFactory();


		return sf;





    }
}
