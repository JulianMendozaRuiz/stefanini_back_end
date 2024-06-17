package com.julian_mendoza.stefanini_back_end.controllers;


import com.julian_mendoza.stefanini_back_end.dtos.ClientDTO;
import com.julian_mendoza.stefanini_back_end.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/api/v1/clients")
    public ResponseEntity<List<ClientDTO>> getAllClients() {
        return ResponseEntity.ok(clientService.allClients());
    }

    @GetMapping("/api/v1/clients/{document_number}")
    public ResponseEntity<ClientDTO> getClient(@PathVariable String document_number) throws Exception {
        return ResponseEntity.of(clientService.getClient(document_number));
    }

}
