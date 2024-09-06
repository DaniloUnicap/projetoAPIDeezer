package com.deezer.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deezer.demo.model.Music;
import com.deezer.demo.service.MusicService;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(value="/api/music/")
@AllArgsConstructor
public class MusicController {

    @Autowired
    MusicService musicService;

    @GetMapping("all")
    public List<Music> getMusic(){
        return musicService.getAll();
    }

    @GetMapping("{id}/")
    public Music getMusicById(@PathVariable("id") Long id) throws Exception {
        try{
            return musicService.getMusicById(id);
        } catch(Exception e) {
            return null;
        }
    }

    @PostMapping("add/")
    public void insertMusic(@RequestBody Music music){
        musicService.insertMusic(music);
    }
    @PutMapping("updateTitle/{id}")
    public boolean updadeMusicById(@PathVariable Long id, @RequestParam String newName) throws Exception {
        try {
            return musicService.updadeMusicById(id, newName);
        } catch (Exception e) {
            return false;
        }
    }
    
    @DeleteMapping("music/{is}/")
    public void deleteMusicById(@PathVariable("id") Long id) throws Exception {
        try {
            musicService.deleteMusicById(id);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}