package com.orlando.dao;

import com.orlando.domain.Client;
import java.util.List;

public interface ClientDao {

    void enregistrer(Client client);
    List<Client> recuperer();
    Client recupererParID(long id);

}