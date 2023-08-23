package com.example.spring_test.services;

import com.example.spring_test.models.Client;
import com.example.spring_test.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    // //// CREATE NEW CLIENT ////
    public Client createClient(Client client){
        return clientRepository.save(client);
    }

    // //// UPDATE CLIENT ////
    public Client updateClient(Client editUser) {
        return clientRepository.save(editUser);
    }

    // //// GET ALL CLIENTS ////
    public List<Client> findAllClients(){
        return clientRepository.findAll();
    }

    // //// GET ALL CLIENTS ////
    public Client findById(long id){
        Optional<Client> optClient = clientRepository.findById(id);
        if ( optClient.isPresent() ) {
            return optClient.get();
        } else {
            return null;
        }
    }

    public  Client updateById(Client client, long id){
        Client oldClient = findById(id);
        oldClient.setName(client.getName());
        oldClient.setSex(client.getSex());
        oldClient.setTelefone(client.getTelefone());

        return createClient(oldClient);
    }

    public String deleteClient(long id) {
        clientRepository.deleteById(id);
        return "deleted";
    }
}
