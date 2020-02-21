package com.orlando.service;

import com.orlando.domain.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    @Autowired
    private ClientService clientService;

    @Override
    public void checkLogin(Utilisateur utilisateur) {
        if(utilisateur.getLogin().equals("admin")&&utilisateur.getPassword().equals("admin"))
        {
            clientService.recuperer();
        }
    }

}
