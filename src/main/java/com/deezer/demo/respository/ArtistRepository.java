package com.deezer.demo.respository;

import org.springframework.stereotype.Repository;
import com.deezer.demo.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {

    public Artist findByName(String name);
}


