package com.julian_mendoza.stefanini_back_end.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.julian_mendoza.stefanini_back_end.dtos.ClientDTO;
import com.julian_mendoza.stefanini_back_end.exceptions.AppException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private List<ClientDTO> clients = null;

    private void loadClients() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<ClientDTO>> typeReference = new TypeReference<List<ClientDTO>>() {
        };
        InputStream inputStream = TypeReference.class.getResourceAsStream("/JSON/clients.json");
        try {

            this.clients = mapper.readValue(inputStream, typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public ClientService() throws IOException {
        loadClients();
    }

    public List<ClientDTO> allClients() {
        return clients;
    }

    public Optional<ClientDTO> getClient(String documentNumber) throws Exception {
        ClientDTO client = (ClientDTO) clients.stream().filter(c -> c.getNumero_documento().equals(documentNumber)).findFirst().orElseThrow(() -> new AppException("Client not found", HttpStatus.NOT_FOUND));

        if (client == null) {
            throw new Exception("Client not found");
        }

        return Optional.of(client);
    }
}
