package com.example.kigalicleaniliness.serviceImplementation;

import com.example.kigalicleaniliness.model.ClientModel;
import com.example.kigalicleaniliness.repository.ClientRepository;
import com.example.kigalicleaniliness.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientServiceImplementation implements ClientService {
    @Autowired
    ClientRepository repo;
    @Override
    public ClientModel saveClient(ClientModel client) {
        return repo.save(client);
    }

    @Override
    public List<ClientModel> displayClients() {
        return repo.findAll();
    }

    @Override
    public ClientModel findClientById(int code) {
        return repo.findById(code).orElse(null);
    }

    @Override
    public ClientModel updateClient(ClientModel client) {
        ClientModel savedClient = repo.findById(client.getId()).orElse(null);
        if (savedClient!=null){
            ClientModel updateClient = new ClientModel();
            updateClient.setFirstname(client.getFirstname());
            updateClient.setLastname(client.getLastname());
            updateClient.setEmail(client.getEmail());
            updateClient.setPhone(client.getPhone());
            updateClient.setAddress(client.getAddress());
            updateClient.setNumber_of_house(client.getNumber_of_house());
            updateClient.setAmount_to_be_paid(client.getAmount_to_be_paid());
            //updateClient.paid(client.paid());
            //updateClient.setEnabled(client.Enab);

            return repo.save(updateClient);
        }else {
            return repo.save(client);
        }

    }

    @Override
    public void deleteClient(int code) {
        ClientModel savedClient = repo.findById(code).orElse(null);
        if (savedClient!=null){
            repo.delete(savedClient);
        }
    }
}
