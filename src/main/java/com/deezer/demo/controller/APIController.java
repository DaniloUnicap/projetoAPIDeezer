package com.deezer.demo.controller;

import com.deezer.demo.service.APIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class APIController {

    @Autowired
    private APIService apiService;

    @GetMapping("/data/{artistName}")
    public ResponseEntity<String> getAllData(@PathVariable String artistName) {
        apiService.fetchAndSaveArtist(artistName);
        return ResponseEntity.ok("Artista salvo com sucesso");
    }
}
