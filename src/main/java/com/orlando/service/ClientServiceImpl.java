package com.orlando.service;

import com.orlando.domain.Client;
import com.orlando.dao.ClientDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDao clientDao;

    @Override
    public void enregistrer(Client client) {
        clientDao.enregistrer(client);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Client> recuperer() {
        return clientDao.recuperer();
    }

    @Override
    @Transactional(readOnly = true)
    public Client recupererParID(long id) {
        return clientDao.recupererParID(id);
    }
}
