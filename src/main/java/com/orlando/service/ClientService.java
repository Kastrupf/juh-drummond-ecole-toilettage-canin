package com.orlando.service;

import com.orlando.domain.Client;

import java.util.List;

public interface ClientService {

    void enregistrer(Client client);
    List<Client> recuperer();
    Client recupererParID(long id);
}
