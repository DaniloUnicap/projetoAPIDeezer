package com.deezer.demo.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.deezer.demo.model.Music;

@Repository
public interface MusicRespository extends JpaRepository<Music, Long> {
}
