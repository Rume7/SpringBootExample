package io.turntabl.client.repository;

import io.turntabl.client.models.Client;

import java.util.*;

public class ClientMockRepo {

    private List<Client> allClients;

    public ClientMockRepo() {
        allClients = new ArrayList<>();
        setAllClients();
    }

    public List<Client> getAllClients() {
        return allClients;
    }

    public void setAllClients() {
        this.allClients = List.of(
                new Client("Mark", "T", "mark@aol.com", "pass1"),
                new Client("Marian", "L", "larbi@aol.com", "pass2"),
                new Client("Rhume", "D", "rhume@aol.com", "pass3"));
    }
}
