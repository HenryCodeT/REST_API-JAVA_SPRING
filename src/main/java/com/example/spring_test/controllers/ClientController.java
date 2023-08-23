package com.example.spring_test.controllers;

import com.example.spring_test.models.Client;
import com.example.spring_test.response.ResponseHandler;
import com.example.spring_test.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {
    @Autowired
    ClientService clientService;

    @PostMapping("/create-client")
    public ResponseEntity<Object> Post(@RequestBody Client client) {
        try {
            Client result = clientService.createClient(client);
            return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }
    @GetMapping(value = "/clients")
    public ResponseEntity<Object> Get() {
        try {
            List<Client> result = clientService.findAllClients();
            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    // Get By ID
    @GetMapping(value = "/client/{id}")
    public ResponseEntity<Object> Get(@PathVariable long id) {
        try {
            Client result = clientService.findById(id);
            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    // Update
    @PutMapping(value = "/clients/{id}")
    public ResponseEntity<Object> Update(@PathVariable long id, @RequestBody Client params) {
        try {
            Client result = clientService.updateById(params, id);
            return ResponseHandler.generateResponse("Updated", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    // Delete
    @DeleteMapping(value = "/clients/{id}")
    public ResponseEntity<Object> Delete(@PathVariable long id) {
        try {
            String result = clientService.deleteClient(id);
            return ResponseHandler.generateResponse("Deleted!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }
}
