package com.example.musicvalidate.service;


import com.example.musicvalidate.model.Song;

public interface SongService {
    void saveSong(Song song);
    Song findById(Long id);
    void updateSong(Song song);
}