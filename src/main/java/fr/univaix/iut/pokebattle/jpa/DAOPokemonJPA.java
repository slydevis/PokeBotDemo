package fr.univaix.iut.pokebattle.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import fr.univaix.iut.pokebattle.jpa.Pokemon.Type;

import java.util.List;

public class DAOPokemonJPA implements DAOPokemon {

    private EntityManager entityManager;

    public DAOPokemonJPA(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Pokemon> findByType(Type type) {
        TypedQuery<Pokemon> query = entityManager.createNamedQuery(Pokemon.FIND_BY_TYPE, Pokemon.class);
        query.setParameter("ftype", type);
        return query.getResultList();
    }

    @Override
    public boolean delete(Pokemon obj) {
            EntityTransaction tx = entityManager.getTransaction();
            tx.begin();
            entityManager.remove(obj);
            tx.commit();
            return true;
    }

    @Override
    public List<Pokemon> findAll() {
        TypedQuery<Pokemon> query = entityManager.createNamedQuery(Pokemon.FIND_ALL, Pokemon.class);
        return query.getResultList();
    }

    @Override
    public Pokemon getById(String id) {
        return entityManager.find(Pokemon.class, id);
    }

    @Override
    public Pokemon insert(Pokemon obj) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(obj);
        tx.commit();
        return entityManager.find(Pokemon.class, obj.getName());
    }

    @Override
    public boolean update(Pokemon obj) {
            EntityTransaction tx = entityManager.getTransaction();
            tx.begin();
            entityManager.merge(obj);
            tx.commit();
            return true;
    }
}