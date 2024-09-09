package com.deezer.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deezer.demo.model.Artist;
import com.deezer.demo.repository.ArtistRepository;

@Service
public class ArtistService {
    @Autowired
    private ArtistRepository artistRepository;

    public Artist insertArtist(Artist artist) {
        return artistRepository.save(artist);
    }

    public List<Artist> returnAllArtists() {
        return artistRepository.findAll();
    }

    public List<Artist> getArtistByName(String name) {
        return artistRepository.findArtistByName(name);
    }

    public Optional<Artist> getArtistById(Long id) {
        return artistRepository.findById(id);
    }

    public void deleteArtistById(Long id){
        artistRepository.deleteById(id);
    }

    public Artist updateArtistName(Long id, String newName) {
        Artist artist = artistRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Artista não encontrado com o id: " + id));
        artist.setName(newName);
        return artistRepository.save(artist);
    }

}
