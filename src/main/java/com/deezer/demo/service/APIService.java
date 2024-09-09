package com.deezer.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.deezer.demo.dto.ArtistDTO;
import com.deezer.demo.model.Artist;
import com.deezer.demo.repository.ArtistRepository;

@Service
public class APIService {
    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    private ArtistRepository artistRepository;

    public void fetchAndSaveArtist(String artistName) {
        String apiUrl = "https://api.deezer.com/artist/" + artistName;
        ArtistDTO artistDTO = restTemplate.getForObject(apiUrl, ArtistDTO.class);
    
        if (artistDTO != null) {
            Artist existingArtist = artistRepository.findById(artistDTO.getId()).orElse(null);
            if (existingArtist != null) {
                existingArtist.setName(artistDTO.getName());
                artistRepository.save(existingArtist);
            } else {
                Artist artist = new Artist();
                artist.setId(artistDTO.getId());
                artist.setName(artistDTO.getName());
                artist.setMusicList(new ArrayList<>());
                artistRepository.save(artist);
            }
        }
    }
    

}
