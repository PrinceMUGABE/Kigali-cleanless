package com.example.kigalicleaniliness.service;

import com.example.kigalicleaniliness.model.ClientModel;
import com.example.kigalicleaniliness.model.UserModel;

import java.util.List;

public interface ClientService {
    ClientModel saveClient(ClientModel client);
    List<ClientModel> displayClients();
    ClientModel findClientById(int code);
    ClientModel updateClient(ClientModel client);
    void deleteClient(int code);
}
