package io.turntabl.client.service;

import io.turntabl.client.models.Client;
import io.turntabl.client.models.ClientDTO;
import io.turntabl.client.repository.ClientMockRepo;
import io.turntabl.client.repository.ClientRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientRegistrationService {

    @Autowired
    private ClientRegistrationRepository registrationRepository;

    private ClientMockRepo clientMockRepo = new ClientMockRepo();

    // POST
    public Client createClient(Client client) {
        Client newClient = registrationRepository.save(client);
        return newClient;
    }

    // PUT
    public Client updateClient(Client client) {
        Client newClient = registrationRepository.save(client);
        return newClient;
    }

    public List<ClientDTO> findAllClient() {
        List<Client> ourClients = clientMockRepo.getAllClients();
        List<ClientDTO> ourClientsDTO = new ArrayList<>();
        for (Client client : ourClients) {
            ClientDTO clientDTO = new ClientDTO();
            clientDTO.setEmail(client.getEmail());
            clientDTO.setFirstName(client.getFirstName());
            clientDTO.setLastName(client.getLastName());
            clientDTO.setDateRegistered(client.getDateRegistered());
            ourClientsDTO.add(clientDTO);
        }
        return ourClientsDTO;
    }

    // GET
    public ClientDTO getClientByID(String clientID) {
        Optional<Client> seenClient = registrationRepository.findById(clientID);
        if (seenClient.isPresent()) {
            Client foundClient = seenClient.get();
            ClientDTO client = new ClientDTO();
            client.setEmail(foundClient.getEmail());
            client.setFirstName(foundClient.getFirstName());
            client.setLastName(foundClient.getLastName());
            client.setDateRegistered(foundClient.getDateRegistered());
            return client;
        }
        return null;
    }

    // GET
    public ClientDTO getClientByEmail(String clientEmail) {
//        Optional<Client> seenClient = registrationRepository.findById(clientEmail);
//        if (seenClient.isPresent()) {
//            Client foundClient = seenClient.get();
//            ClientDTO client = new ClientDTO();
//            client.setEmail(foundClient.getEmail());
//            client.setFirstName(foundClient.getFirstName());
//            client.setLastName(foundClient.getLastName());
//            client.setDateRegistered(foundClient.getDateRegistered());
//            return client;
//        }
//        return null;

        List<Client> ourClients = clientMockRepo.getAllClients();

        Optional<Client> seenClient = ourClients.stream().filter(cl -> cl.getEmail().equals(clientEmail)).findFirst();
        if (seenClient.isPresent()) {
            ClientDTO clientDto = new ClientDTO();
            clientDto.setEmail(seenClient.get().getEmail());
            clientDto.setFirstName(seenClient.get().getFirstName());
            clientDto.setLastName(seenClient.get().getLastName());
            clientDto.setDateRegistered(seenClient.get().getDateRegistered());
            return clientDto;
        }
        return null;
    }

    // DELETE
    public boolean deleteClient(String clientId) {
        Optional<Client> clientele = registrationRepository.findById(clientId);
        if (clientele.isPresent()) {
            registrationRepository.delete(clientele.get());
            return true;
        }
        return false;
    }
}
