package com.orlando.dao;

import com.orlando.domain.Client;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ClientDaoImpl implements ClientDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void enregistrer(Client client) {
        em.persist(client);
    }

    @Override
    public List<Client> recuperer() {
        return em.createQuery("select c from Client c", Client.class).getResultList();
    }

    @Override
    public Client recupererParID(long id) {
        return em.find(Client.class, id);
    }
 }