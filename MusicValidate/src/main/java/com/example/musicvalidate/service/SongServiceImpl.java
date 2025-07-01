package com.example.musicvalidate.service;


import com.example.musicvalidate.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Transactional
public class SongServiceImpl implements SongService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveSong(Song song) {
        entityManager.persist(song);
    }

    @Override
    public Song findById(Long id) {
        return entityManager.find(Song.class, id);
    }

    @Override
    public void updateSong(Song song) {
        entityManager.merge(song);
    }
}