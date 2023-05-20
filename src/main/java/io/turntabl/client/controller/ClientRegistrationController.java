package io.turntabl.client.controller;

import io.turntabl.client.models.Client;
import io.turntabl.client.models.ClientDTO;
import io.turntabl.client.service.ClientRegistrationService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registration")
public class ClientRegistrationController {

    @Autowired
    private ClientRegistrationService registrationService;

    @PostMapping("/client")
    public Client createClient(@RequestBody Client client) {
        Client newClient = registrationService.createClient(client);
        return newClient;
    }

    @PutMapping("/client")
    public Client updateClient(@RequestBody Client client) {
        Client newClient = registrationService.updateClient(client);
        return newClient;
    }

    @GetMapping("/clients")
    public List<ClientDTO> findAllClients() {
        return registrationService.findAllClient();
    }

    @GetMapping("/client/{clientId}")
    public ClientDTO findClientById(@PathVariable("clientId") String clientId) {
        ClientDTO newClient = registrationService.getClientByID(clientId);
        //ResponseBody( ,HttpStatus.FOUND);
        return newClient;
    }

    @GetMapping("/client/{email}")
    public ClientDTO findClientByEmail(@PathVariable("email") String email) {
        ClientDTO newClient = registrationService.getClientByEmail(email);
        return newClient;
    }

    @GetMapping("/client/{id}")
    public boolean deleteClientById(@PathVariable("clientId") String clientId) {
        boolean status = registrationService.deleteClient(clientId);
        return status;
    }
}
