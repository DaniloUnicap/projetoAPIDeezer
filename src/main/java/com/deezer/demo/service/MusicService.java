package com.deezer.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.deezer.demo.exception.MusicNotFoundException;
import com.deezer.demo.model.Music;
import com.deezer.demo.repository.MusicRespository;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class MusicService {

    private MusicRespository musicRespository;

    public List<Music> getAll() {
        return musicRespository.findAll();
    }
    public Music getMusicById (Long id) throws MusicNotFoundException{
        Optional <Music> opMusic = musicRespository.findById(id);

        if(opMusic.isEmpty()){
            throw new MusicNotFoundException("Music " + id + " not found");
        }
        Music music = opMusic.get();
        return music;
    }

    public void insertMusic (Music music) {
        musicRespository.save(music);
    }

    public boolean deleteMusicById(Long id) throws MusicNotFoundException{
        Optional <Music> opMusic = musicRespository.findById(id);

        if (opMusic.isEmpty()){
            return false;
        }

        Music u = opMusic.get();
        musicRespository.delete(u);
        return true;
    }

    public boolean updadeMusicById (Long id, String newName) throws MusicNotFoundException{
        Optional <Music> opMusic = musicRespository.findById(id);

        if(opMusic.isEmpty()){
            throw new MusicNotFoundException("Music " + id + " not found");
        }

        Music u = opMusic.get();
        u.setTitle(newName);
        return true;
    }
}
