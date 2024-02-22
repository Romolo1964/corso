package model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ActorDAO {

    private final SessionFactory sessionFactory;

    public ActorDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveOrUpdate(Actor actor) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(actor);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void delete(Actor actor) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.delete(actor);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Actor findById(Short actorId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Actor.class, actorId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Actor> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Actor", Actor.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
