package br.edu.unijuazeiro.carshop.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.unijuazeiro.carshop.dao.util.ConnectionFactory;
import br.edu.unijuazeiro.carshop.model.DVD.DVD;

public class CARRODAO {

    public void save(CAR car) {
        EntityManager em = ConnectionFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(car);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    public void update(CAR car) {
        EntityManager em = ConnectionFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(car);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    public void remove(Car car) {
        EntityManager em = ConnectionFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            CAR c = em.find(CAR.class, car.getCode());
            em.remove(d);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    public CAR findById(Integer code) {
        EntityManager em = ConnectionFactory.getEntityManager();
        CAR c = em.find(CAR.class, code);
        if (em.isOpen()) {
            em.close();
        }
        return d;
    }

    public List<CAR> list() {
        EntityManager em = ConnectionFactory.getEntityManager();
        List<CAR> cars = em.createQuery("from CAR", CAR.class).getResultList();
        if (em.isOpen()) {
            em.close();
        }
        return cars;
    }

}
